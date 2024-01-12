package velazquez._examen_trimestral.dao;

import velazquez._examen_trimestral.model.Usuario;

public interface DAOUsuario {

  public boolean registerUsuario(Usuario usuario);

  public Usuario getUsuario(String email);
}
