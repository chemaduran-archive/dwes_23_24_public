package velazquez._5_spring_security_jpa.services;

import velazquez._5_spring_security_jpa.model.Profesor;

import java.util.Optional;

public interface ProfesorService {

  public Optional<Profesor> findProfesorById(Long id);

  public Profesor actualizarProfesor(Profesor profesor);
}
