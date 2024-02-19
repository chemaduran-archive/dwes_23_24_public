package velazquez._5_spring_security_jpa.api.dto;

import java.io.Serializable;

public class DepartamentoDTO implements Serializable {
  private Long id;
  private String nombre;

  public DepartamentoDTO() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return "{" +
            "id='" + id + '\'' +
            "nombre='" + nombre + '\'' +
            '}';
  }
}
