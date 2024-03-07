package velazquez._5_spring_security_jpa.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import velazquez._5_spring_security_jpa.api.ProfesorAPIController;
import velazquez._5_spring_security_jpa.config.JwtService;
import velazquez._5_spring_security_jpa.controller.AuthenticationRequest;
import velazquez._5_spring_security_jpa.controller.AuthenticationResponse;
import velazquez._5_spring_security_jpa.controller.RegisterRequest;
import velazquez._5_spring_security_jpa.model.JPAUserDetails;
import velazquez._5_spring_security_jpa.model.Usuario;
import velazquez._5_spring_security_jpa.repository.UsuarioRepository;

@Service
public class AuthenticationService {

  static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

  private final UsuarioRepository usuarioRepository;

  private final PasswordEncoder passwordEncoder;

  private final JwtService jwtService;

  private final AuthenticationManager authenticationManager;

  public AuthenticationService(
      UsuarioRepository usuarioRepository,
      PasswordEncoder passwordEncoder,
      JwtService jwtService,
      AuthenticationManager authenticationManager) {
    this.usuarioRepository = usuarioRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
    this.authenticationManager = authenticationManager;
  }

  public AuthenticationResponse register(RegisterRequest request) {
    logger.info("Registering user: {}", request);
    Usuario usuario = new Usuario();
    usuario.setNombre(request.getFirstName());
    usuario.setUserName(request.getFirstName() + "_" + request.getLastName());
    usuario.setApellidos(request.getLastName());
    usuario.setEmail(request.getEmail());
    usuario.setPassword(passwordEncoder.encode(request.getPassword()));
    usuario.setRole("USER"); // Aquí deberíamos obtener el rol de la request
    usuarioRepository.save(usuario);
    JPAUserDetails userDetails = new JPAUserDetails(usuario);
    String jwtToken = jwtService.generateToken(userDetails);
    return new AuthenticationResponse(jwtToken);
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    Usuario usuario = usuarioRepository.findByEmail(request.getEmail()).orElseThrow();
    JPAUserDetails userDetails = new JPAUserDetails(usuario);
    String jwtToken = jwtService.generateToken(userDetails);
    return new AuthenticationResponse(jwtToken);
  }
}
