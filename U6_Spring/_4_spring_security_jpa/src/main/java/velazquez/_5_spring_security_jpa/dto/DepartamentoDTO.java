package velazquez._5_spring_security_jpa.dto;

import java.io.Serializable;

public class DepartamentoDTO implements Serializable {
  private String nombre;

  public DepartamentoDTO() {}

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
