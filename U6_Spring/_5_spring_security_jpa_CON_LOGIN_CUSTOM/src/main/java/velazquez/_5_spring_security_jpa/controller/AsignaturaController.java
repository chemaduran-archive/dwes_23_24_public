package velazquez._5_spring_security_jpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velazquez._5_spring_security_jpa.model.Asignatura;
import velazquez._5_spring_security_jpa.services.AsignaturaServiceImpl;

@Controller
@RequestMapping("/asignaturas")
public class AsignaturaController {

  @Autowired AsignaturaServiceImpl asignaturaService;

  @GetMapping("/")
  public String asignaturas(Model model) {

    model.addAttribute("asignaturas", asignaturaService.getAllAsignaturas());

    return "asignaturas";
  }

  @GetMapping("/alumnos")
  public String asignaturasAlumnos(
      @RequestParam(required = false, name = "codigo") String codigo, Model model) {

    // Obtengo el parámetro de la URL (en caso de no esta vuelvo a la lista de asignaturas
    if (codigo == null) {
      return "redirect:/asignaturas/";
    }

    Optional<Asignatura> asignatura = asignaturaService.findAsignaturaById(Long.parseLong(codigo));
    model.addAttribute("asignatura", asignatura.get());
    return "asignaturasAlumnos";
  }
}
