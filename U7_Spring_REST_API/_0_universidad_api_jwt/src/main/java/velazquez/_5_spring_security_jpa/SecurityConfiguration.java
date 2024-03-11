package velazquez._5_spring_security_jpa;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import velazquez._5_spring_security_jpa.config.JwtAuthenticationFilter;
//import velazquez._5_spring_security_jpa.services.JPAUserDetailsService;

/*
 * CLASE DONDE ESTABLECEREMOS LA CONFIGURACION DE
 * AUTENTIFICACION - CÓMO ACCEDO
 * AUTORIZACION - A QUÉ PUEDO ACCEDER
 * MÉTODO DE ENCRIPTACIÓN DE LAS CONTRASEÑAS
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  private static final String[] WHITE_LIST_URL = {
    "/api/v1/auth/**",
    "/v3/api-docs/**",
    "/swagger-ui/**",
    "/",
    "/img/*",
    "/logout",
    "/profesor/*"
  };

  private static final String[] ADMIN_URL = {
    "/departments", "/grados", "/asignaturas", "/asignaturas/*", "/departments/*", "/grados/*"
  };

  private static final String[] USER_URL = {"/about", "/services", "/alumnos/*"};

  // Obtengo una refencia al SINGLENTON del userDetailsService
  private final UserDetailsService userDetailsService;

  private final AuthenticationProvider authenticationProvider;

  private final JwtAuthenticationFilter jwtAuthFilter;

  public SecurityConfiguration(
          UserDetailsService userDetailsService,
      AuthenticationProvider authenticationProvider,
      JwtAuthenticationFilter jwtAuthFilter) {
    this.userDetailsService = userDetailsService;
    this.authenticationProvider = authenticationProvider;
    this.jwtAuthFilter = jwtAuthFilter;
  }

  @Bean
  public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder authenticationManagerBuilder =
        http.getSharedObject(AuthenticationManagerBuilder.class);
    authenticationManagerBuilder
        .userDetailsService(userDetailsService)
        .passwordEncoder(getPasswordEncoder());
    return authenticationManagerBuilder.build();
  }

  // MÉTODO PARA ESTABLECER AUTORIZACION - A QUÉ PUEDO ACCEDER
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    // URL con información sobre ANT MATCHERS https://www.baeldung.com/spring-security-expressions
    // ATENCION: Falta por implementar el acceso a los recursos por roles
    http.authorizeHttpRequests(
            authz ->
                authz
                    .requestMatchers(WHITE_LIST_URL)
                    .permitAll()
                    .anyRequest()
                    .authenticated()
//                    .requestMatchers(ADMIN_URL)
//                    .hasRole("ADMIN")
//                    .requestMatchers(USER_URL)
//                    .hasRole("USER")
//                    .requestMatchers("/register")
//                    .anonymous())
            )
        .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        .formLogin(form -> form.loginPage("/login").permitAll())
        .logout(logout -> logout.logoutUrl("/logout").permitAll())
        .httpBasic(withDefaults());
    http.csrf(AbstractHttpConfigurer::disable);
    return http.build();
  }

  // ESTABLECEMOS EL PASSWORD ENCODER. FUERZA 15 (de 4 a 31)
  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return new BCryptPasswordEncoder(15);
  }
}
