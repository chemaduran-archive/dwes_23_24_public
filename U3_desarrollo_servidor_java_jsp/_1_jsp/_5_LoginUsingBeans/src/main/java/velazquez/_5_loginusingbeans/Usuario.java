package velazquez._5_loginusingbeans;

import java.io.Serializable;

public class Usuario implements Serializable {
  private String usuario;
  private String password;

  public Usuario() {}

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

  public boolean isUsuarioCorrecto() {
    return usuario.equals("admin") && password.equals("admin");
  }
}
