package models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Habilidad {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "idHabilidad")
  private Long id;

  @Column(name = "nombre")
  private String nombre;

  @ManyToMany(cascade = CascadeType.ALL)
  private Set<Pokemon> pokemons = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long idHabilidad) {
    this.id = idHabilidad;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Habilidad habilidad = (Habilidad) o;

    if (!Objects.equals(id, habilidad.id)) return false;
    return Objects.equals(nombre, habilidad.nombre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre);
  }
}
