package velazquez._5_spring_security_jpa.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import velazquez._5_spring_security_jpa.api.dto.ProfesorDTO;
import velazquez._5_spring_security_jpa.mappers.Mapper;
import velazquez._5_spring_security_jpa.model.Departamento;
import velazquez._5_spring_security_jpa.model.Profesor;
import velazquez._5_spring_security_jpa.services.DepartamentoService;
import velazquez._5_spring_security_jpa.services.ProfesorService;

@RestController
public class ProfesorAPIController {
  static final Logger logger = LoggerFactory.getLogger(ProfesorAPIController.class);

  @Autowired private ProfesorService profesorService;

  @Autowired private DepartamentoService departamentoService;

  @Autowired private Mapper<Profesor, ProfesorDTO> profesorMapper;

  // Obtener un profesor por su id
  @GetMapping(path = "/api/profesor/{id}")
  public ResponseEntity<ProfesorDTO> getProfesor(@PathVariable Long id) {
    logger.info("Get profesor by id: " + id + ")");
    Optional<Profesor> profesor = profesorService.findProfesorById(id);
    if (profesor.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(profesorMapper.mapTo(profesor.get()), HttpStatus.OK);
  }

  // Obtener todos los profesores
  @GetMapping(path = "/api/profesores")
  public ResponseEntity<Iterable<ProfesorDTO>> getProfesores() {
    logger.info("Get all profesores");
    List<Profesor> profesores = profesorService.getProfesores();
    List<ProfesorDTO> profesoresDTO = new ArrayList<>();
    for (Profesor profesor : profesores) {
      ProfesorDTO profesorDTO = profesorMapper.mapTo(profesor);
      logger.info(profesorDTO.toString());
      profesoresDTO.add(profesorDTO);
    }
    return new ResponseEntity<>(profesoresDTO, HttpStatus.OK);
  }

  // Crear un profesor
  @PostMapping(path = "/api/profesor")
  public ResponseEntity<ProfesorDTO> createProfesor(@RequestBody ProfesorDTO profesorDTO) {
    logger.info("Create profesor: " + profesorDTO.toString());
    Profesor profesor = profesorMapper.mapFrom(profesorDTO);
    // Comprobamos que el departamento del profesor existe...
    Departamento departamento =
        departamentoService.findDepartamentoById(profesorDTO.getDepartamento().getId());
    if (departamento == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // ... e insertamos el departamento porque es una entity con estado correcto
    profesor.setDepartamento(departamento);
    Profesor savedProfesor = profesorService.insertProfesor(profesor);
    logger.info("Saved profesor: " + profesor);
    return new ResponseEntity<>(profesorMapper.mapTo(savedProfesor), HttpStatus.CREATED);
  }

  // Actualizar un profesor
  @PutMapping(path = "/api/profesor/{id}")
  public ResponseEntity<ProfesorDTO> updateProfesor(
      @PathVariable("id") Long id, @RequestBody ProfesorDTO profesorDTO) {
    logger.info("Update profesor: " + profesorDTO.toString());

    if (profesorService.findProfesorById(id).isEmpty()) {
      logger.info("Profesor not found");
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    profesorDTO.setId(id);
    Profesor profesor = profesorMapper.mapFrom(profesorDTO);
    Profesor updatedProfesor = profesorService.updateProfesor(profesor);
    logger.info("Updated profesor: " + updatedProfesor);
    return new ResponseEntity<>(profesorMapper.mapTo(updatedProfesor), HttpStatus.OK);
  }

  // Borrar un profesor
  @DeleteMapping(path = "/api/profesor/{id}")
  public ResponseEntity deleteProfesor(@PathVariable("id") Long id) {
    logger.info("Delete profesor: " + id);
    profesorService.deleteProfesor(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
