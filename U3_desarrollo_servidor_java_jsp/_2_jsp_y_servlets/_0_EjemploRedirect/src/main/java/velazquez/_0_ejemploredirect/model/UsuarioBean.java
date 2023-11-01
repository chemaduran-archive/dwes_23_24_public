package velazquez._0_ejemploredirect.model;

import java.io.Serializable;

public class UsuarioBean implements Serializable {

  private String usuario;
  private String password;

  public UsuarioBean() {}

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
