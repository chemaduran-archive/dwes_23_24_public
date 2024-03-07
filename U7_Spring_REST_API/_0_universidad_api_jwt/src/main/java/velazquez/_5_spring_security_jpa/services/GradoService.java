package velazquez._5_spring_security_jpa.services;

import java.util.List;

import velazquez._5_spring_security_jpa.model.Grado;

public interface GradoService {
  List<Grado> getAllGrades();

  Grado findGradoById(Long id);
}
