package velazquez._5_spring_security_jpa.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import velazquez._5_spring_security_jpa.model.Asignatura;

public class GradoDTO implements Serializable {
  private Long id;

  private String nombre;

  private Set<Asignatura> asignaturasGrado = new HashSet<>();

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

  public Set<Asignatura> getAsignaturasGrado() {
    return asignaturasGrado;
  }

  public void setAsignaturasGrado(Set<Asignatura> asignaturasGrado) {
    this.asignaturasGrado = asignaturasGrado;
  }
}
