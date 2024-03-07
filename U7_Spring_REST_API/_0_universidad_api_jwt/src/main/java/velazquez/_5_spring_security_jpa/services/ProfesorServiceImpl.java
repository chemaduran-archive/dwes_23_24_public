package velazquez._5_spring_security_jpa.services;

import java.util.List;
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
  public Profesor updateProfesor(Profesor profesor) {
    if (profesor == null || profesor.getId() == null) {
      return null;
    }

    return profRepo.save(profesor);
  }

  @Override
  public Profesor getProfesorByName(String nombre) {
    if (nombre != null) {
        return profRepo.findByNombre(nombre);
    }
    return null;
  }

  @Override
  public Profesor insertProfesor(Profesor profesor) {
    if (profesor != null && getProfesorByName(profesor.getNombre()) == null) {
        return profRepo.save(profesor);
    }
    return null;
  }

  @Override
  public List<Profesor> getProfesores() {
    return profRepo.findAll();
  }

  @Override
  public void deleteProfesor(Long id) {
    profRepo.deleteById(id);
  }


}
