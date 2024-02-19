package velazquez._5_spring_security_jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velazquez._5_spring_security_jpa.api.dto.ProfesorDTO;
import velazquez._5_spring_security_jpa.model.Profesor;
import velazquez._5_spring_security_jpa.services.ProfesorServiceImpl;

@Controller
public class ProfesorController {
  @Autowired ProfesorServiceImpl profesorService;

  @GetMapping("/profesor/add")
  public String addDepartmentGet(
      @RequestParam(required = false, name = "error") String error,
      @RequestParam(required = false, name = "profesor") String nombre,
      Model model) {

    ProfesorDTO profesor = new ProfesorDTO();

    model.addAttribute("profesor", profesor);
    model.addAttribute("error", error);

    return "addProfesor";
  }

  @PostMapping("/profesor/add")
  public String addDepartmentPost(@ModelAttribute ProfesorDTO profesor) {

    Profesor profesorDB = new Profesor();
    profesorDB.setNombre(profesor.getNombre());
    profesorDB.setApellido1(profesor.getApellido1());
    profesorDB.setApellido2(profesor.getApellido2());
    profesorDB.setCiudad(profesor.getCiudad());
    profesorDB.setDireccion(profesor.getDireccion());
    profesorDB.setNif(profesor.getNif());
    profesorDB.setTelefono(profesor.getTelefono());
    profesorDB.setFechaNacimiento(profesor.getFechaNacimiento());

    if (profesorService.insertProfesor(profesorDB) == null) {
      return "redirect:/profesor/add?error=Existe&dpto=" + profesor.getNombre();
    }

    return "redirect:/profesors";
  }
}
