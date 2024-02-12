package velazquez._5_spring_security_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import velazquez._5_spring_security_jpa.model.Alumno;
import velazquez._5_spring_security_jpa.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

  @Autowired AlumnoRepository alumnoRepo;

  @Override
  public Optional<Alumno> findAlumnoById(Long id) {

    return alumnoRepo.findById(id);
  }

  @Override
  public List<Alumno> getAllAlumnos() {

    return alumnoRepo.findAll();
  }
}
