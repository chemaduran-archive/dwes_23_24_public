package velazquez._5_spring_security_jpa.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import velazquez._5_spring_security_jpa.model.Grado;
import velazquez._5_spring_security_jpa.repository.GradoRepository;

@Service
public class GradoServiceImpl implements GradoService {

  @Autowired GradoRepository gradoRepo;

  @Override
  public List<Grado> getAllGrades() {
    List<Grado> gradosBD = gradoRepo.findAll();

    if (!gradosBD.isEmpty()) {
      return gradosBD;
    }

    return new ArrayList<Grado>();
  }

  @Override
  public Grado findGradoById(Long id) {
    return gradoRepo.findById(id).orElse(null);
  }
}
