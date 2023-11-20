package velazquez._5_registrologin.dao;

import velazquez._5_registrologin.model.Usuario;

public interface DAOUsuario {

  public Usuario getUsuario(String nombre);

  public boolean registerUsuario(Usuario usuario);
}
