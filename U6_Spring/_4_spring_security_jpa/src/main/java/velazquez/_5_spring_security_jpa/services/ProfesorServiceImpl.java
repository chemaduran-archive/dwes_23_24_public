package velazquez._5_spring_security_jpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import velazquez._5_spring_security_jpa.model.Profesor;
import velazquez._5_spring_security_jpa.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService {

  @Autowired ProfesorRepository profRepo;

  @Override
  public Optional<Profesor> findProfesorById(Long id) {
    return profRepo.findById(id);
  }

  @Override
  public Profesor actualizarProfesor(Profesor profesor) {
    if (profesor == null || profesor.getId() == null) {
      return null;
    }

    return profRepo.save(profesor);
  }
}
