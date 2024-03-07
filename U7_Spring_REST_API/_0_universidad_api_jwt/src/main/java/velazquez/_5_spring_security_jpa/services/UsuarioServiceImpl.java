package velazquez._5_spring_security_jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import velazquez._5_spring_security_jpa.model.Usuario;
import velazquez._5_spring_security_jpa.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

  @Autowired UsuarioRepository userRepo;

  @Override
  public Usuario insertUsuario(Usuario usuario) {

    if (usuario != null) {
      return userRepo.save(usuario);
    }

    return null;
  }
}
