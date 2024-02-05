package velazquez._5_spring_security_jpa.services;

import velazquez._5_spring_security_jpa.model.Asignatura;

import java.util.List;
import java.util.Optional;

public interface AsignaturaService {

  public List<Asignatura> getAllAsignaturas();

  public Optional<Asignatura> findAsignaturaById(Long id);
}
