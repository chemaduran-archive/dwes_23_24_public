package velazquez._5_spring_security_jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velazquez._5_spring_security_jpa.model.Alumno;
import velazquez._5_spring_security_jpa.services.AlumnoServiceImpl;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

  @Autowired AlumnoServiceImpl alumnoService;

  @GetMapping("/")
  public String alumnos(Model model) {

    List<Alumno> alumnos = alumnoService.getAllAlumnos();

    model.addAttribute("alumnos", alumnos);
    return "alumnos";
  }

  @GetMapping("/asignaturas")
  public String alumnosMatricula(
      @RequestParam(required = false, name = "codigo") String codigo, Model model) {

    // Obtengo el parámetro de la URL (en caso de no esta vuelvo a la lista de
    // asignaturas
    if (codigo == null) {
      return "redirect:/alumnos/";
    }

    Optional<Alumno> alumno = alumnoService.findAlumnoById(Long.parseLong(codigo));
    model.addAttribute("alumno", alumno.get());
    return "alumnosAsignaturas";
  }
}
