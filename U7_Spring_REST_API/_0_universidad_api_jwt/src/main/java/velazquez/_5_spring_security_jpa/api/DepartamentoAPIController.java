package velazquez._5_spring_security_jpa.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import velazquez._5_spring_security_jpa.api.dto.DepartamentoDTO;
import velazquez._5_spring_security_jpa.mappers.Mapper;
import velazquez._5_spring_security_jpa.model.Departamento;
import velazquez._5_spring_security_jpa.services.DepartamentoService;

@RestController
public class DepartamentoAPIController {
  static final Logger logger = LoggerFactory.getLogger(DepartamentoAPIController.class);

  @Autowired private DepartamentoService departamentoService;

  @Autowired private Mapper<Departamento, DepartamentoDTO> departamentoMapper;

  @PostMapping(path = "/api/departamento")
  public ResponseEntity<DepartamentoDTO> createDepartamento(
      @RequestBody DepartamentoDTO departamentoDTO) {
    logger.info("Create departamento: " + departamentoDTO.toString());
    Departamento departamento = departamentoMapper.mapFrom(departamentoDTO);
    logger.info("Create departamento: " + departamento.toString());
    Departamento savedDepartamento = departamentoService.insertarDepartamento(departamento);
    return new ResponseEntity<>(departamentoMapper.mapTo(savedDepartamento), HttpStatus.CREATED);
  }
}
