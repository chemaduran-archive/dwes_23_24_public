package velazquez._5_spring_security_jpa.services;

import java.util.List;
import java.util.Optional;
import velazquez._5_spring_security_jpa.model.Profesor;

public interface ProfesorService {

  Optional<Profesor> findProfesorById(Long id);

  Profesor getProfesorByName(String nombre);

  Profesor updateProfesor(Profesor profesor);

  Profesor insertProfesor(Profesor profesor);

  List<Profesor> getProfesores();

  void deleteProfesor(Long id);
}
