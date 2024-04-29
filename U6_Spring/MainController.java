package velazquez._5_spring_security_jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import velazquez._5_spring_security_jpa.dto.UsuarioDTO;
import velazquez._5_spring_security_jpa.model.Usuario;
import velazquez._5_spring_security_jpa.services.UsuarioServiceImpl;

@Controller
public class MainController {

  @Autowired UsuarioServiceImpl usuarioService;

  @RequestMapping("/")
  public String home(Model model) {
    model.addAttribute("contenido", "INICIO");
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      // Si el usuario está logueado, redirigir a la página de inicio
      return "index";
    } else {
      // Si el usuario no está logueado, redirigir a la página de login
      return "login";
    }

  }

  @RequestMapping("/about")
  public String about(Model model) {
    model.addAttribute("contenido", "ABOUT");
    return "about";
  }

  @RequestMapping("/services")
  public String services(Model model) {
    model.addAttribute("contenido", "SERVICIOS");
    return "services";
  }

  @GetMapping("/register")
  public String registerGet(Model model) {

    UsuarioDTO userDTO = new UsuarioDTO();
    model.addAttribute("usuario", userDTO);
    return "register";
  }

  @PostMapping("/register")
  public String registerPost(@ModelAttribute UsuarioDTO usuario) {

    Usuario userBD = new Usuario();
    userBD.setActivo(true);
    userBD.setNombre(usuario.getNombre());
    userBD.setApellidos(usuario.getApellidos());
    userBD.setUserName(usuario.getUsuario());
    userBD.setRole("ROLE_USER");
    userBD.setEmail(usuario.getEmail());
    userBD.setPassword(new BCryptPasswordEncoder(15).encode(usuario.getPassword()));

    userBD = usuarioService.insertUsuario(userBD);

    if (userBD == null) {
      return "redirect:/register";
    }

    return "redirect:/";
  }
}
