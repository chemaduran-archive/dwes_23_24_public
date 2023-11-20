package velazquez._5_registrologin.model;

import java.io.Serializable;

public class Usuario implements Serializable {

  private String usuario;
  private String password;
  private String email;
  private String role;

  public Usuario() {}

  public Usuario(String usuario, String password, String email, String role) {
    this.usuario = usuario;
    this.password = password;
    this.email = email;
    this.role = role;
  }

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}
