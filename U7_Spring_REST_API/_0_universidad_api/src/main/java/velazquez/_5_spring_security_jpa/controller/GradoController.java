package velazquez._5_spring_security_jpa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velazquez._5_spring_security_jpa.api.dto.GradoDTO;
import velazquez._5_spring_security_jpa.model.Grado;
import velazquez._5_spring_security_jpa.services.GradoServiceImpl;

@Controller
public class GradoController {
  static final Logger logger = LoggerFactory.getLogger(GradoController.class);

  @Autowired GradoServiceImpl gradoService;

  @RequestMapping("/grados")
  public String grados(Model model) {
    List<Grado> grados = gradoService.getAllGrades();

    logger.info("Grados: " + grados);

    model.addAttribute("grados", grados);

    return "grados";
  }

  @GetMapping("/grados/asignaturas")
  public String profesoresDepartamento(
          @RequestParam(required = false, name = "codigo") String codigo, Model model) {
//

    if (codigo == null) {
      return "redirect:/grados";
    }

    Grado gradoEntity = gradoService.findGradoById(Long.parseLong(codigo));
    GradoDTO gradoDTO = new GradoDTO();
    gradoDTO.setAsignaturasGrado(gradoEntity.getAsignaturasGrado());
    gradoDTO.setNombre(gradoEntity.getNombre());
    model.addAttribute("grado", gradoDTO);

    return "asignaturasGrado";
  }
}
