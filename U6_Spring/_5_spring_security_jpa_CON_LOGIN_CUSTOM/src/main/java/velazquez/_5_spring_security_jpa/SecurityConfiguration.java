package velazquez._5_spring_security_jpa;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import velazquez._5_spring_security_jpa.services.JPAUserDetailsService;

/*
 * CLASE DONDE ESTABLECEREMOS LA CONFIGURACION DE
 * AUTENTIFICACION - CÓMO ACCEDO
 * AUTORIZACION - A QUÉ PUEDO ACCEDER
 * MÉTODO DE ENCRIPTACIÓN DE LAS CONTRASEÑAS
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  /* Obtengo una refencia al SINGLENTON del userDetailsService	 *
   */
  @Autowired JPAUserDetailsService userDetailsService;

  @Bean
  public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder authenticationManagerBuilder =
        http.getSharedObject(AuthenticationManagerBuilder.class);
    authenticationManagerBuilder
        .userDetailsService(userDetailsService)
        .passwordEncoder(getPasswordEncoder());
    return authenticationManagerBuilder.build();
  }

  /*
   * MÉTODO PARA ESTABLECER AUTORIZACION - A QUÉ PUEDO ACCEDER
   */
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    /* URL con información sobre ANT MATCHERS
     * https://www.baeldung.com/spring-security-expressions */
    http.authorizeHttpRequests(
            authz ->
                authz
                    .requestMatchers("/", "/img/*", "/logout", "/profesor/*")
                    .permitAll()
                    .requestMatchers("/departments", "/grados", "/asignaturas/*", "/departments/*", "/grados/*")
                    .hasRole("ADMIN")
                    .requestMatchers("/about", "/services", "/alumnos/*")
                    .hasRole("USER")
                    .requestMatchers("/register")
                    .anonymous())
//                .formLogin(withDefaults())
        .formLogin(form -> form.loginPage("/login").permitAll())
        .logout(logout -> logout.logoutUrl("/logout").permitAll())
        .httpBasic(withDefaults());
    return http.build();
  }

  /*
   * ESTABLECEMOS EL PASSWORD ENCODER. FUERZA 15 (de 4 a 31)
   */
  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return new BCryptPasswordEncoder(15);
  }
}
