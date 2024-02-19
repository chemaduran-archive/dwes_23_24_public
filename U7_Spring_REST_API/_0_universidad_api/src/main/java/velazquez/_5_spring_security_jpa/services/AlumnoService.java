package velazquez._5_spring_security_jpa.services;

import velazquez._5_spring_security_jpa.model.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {

  public List<Alumno> getAllAlumnos();

  public Optional<Alumno> findAlumnoById(Long id);
}
