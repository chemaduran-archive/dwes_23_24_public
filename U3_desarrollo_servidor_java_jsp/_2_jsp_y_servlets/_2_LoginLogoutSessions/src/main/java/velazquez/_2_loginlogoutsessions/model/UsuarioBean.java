package velazquez._2_loginlogoutsessions.model;

import java.io.Serializable;

public class UsuarioBean implements Serializable {

  private String nombre;

  public UsuarioBean() {}

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
