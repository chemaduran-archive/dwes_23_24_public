package velazquez._5_spring_security_jpa.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "departamento")
public class Departamento implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String nombre;

  @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Profesor> profesores = new HashSet<>();

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

  public Set<Profesor> getProfesores() {
    return profesores;
  }

  public void setProfesores(Set<Profesor> profesores) {
    this.profesores = profesores;
  }

  // HELPERS
  public void addProfesor(Profesor profesor) {
    this.profesores.add(profesor);
    profesor.setDepartamento(this);
  }

  public void removeProfesor(Profesor profesor) {
    this.profesores.remove(profesor);
    profesor.setDepartamento(null);
  }
}
