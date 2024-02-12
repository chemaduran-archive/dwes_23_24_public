package velazquez._5_spring_security_jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import velazquez._5_spring_security_jpa.model.Asignatura;
import velazquez._5_spring_security_jpa.repository.AsignaturaRepository;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

  @Autowired AsignaturaRepository asignaturaRepo;

  @Override
  public List<Asignatura> getAllAsignaturas() {

    // Obtengo el resultado a través del repositorio
    List<Asignatura> asignBD = asignaturaRepo.findAll();

    // Verificando que he obtenido algo
    if (asignBD != null && asignBD.size() > 0) {

      return asignBD;
    }

    // No he obtenido nada devuelvo una lista vacía (para no devolver nulo)
    return new ArrayList<Asignatura>();
  }

  @Override
  public Optional<Asignatura> findAsignaturaById(Long id) {

    Optional<Asignatura> asignatura = null;

    if (id != null) {
      asignatura = asignaturaRepo.findById(id);
    }

    return asignatura;
  }
}
