package models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Debilidad {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "idDebilidad")
  private Long id;

  @Basic
  @Column(name = "nombre")
  private String nombre;

  @ManyToOne private Pokemon pokemon;

  public Long getId() {
    return id;
  }

  public void setId(Long idDebilidad) {
    this.id = idDebilidad;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Pokemon getPokemon() {
    return pokemon;
  }

  public void setPokemon(Pokemon pokemon) {
    this.pokemon = pokemon;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Debilidad debilidad = (Debilidad) o;

    if (!Objects.equals(id, debilidad.id)) return false;
    return Objects.equals(nombre, debilidad.nombre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre);
  }
}
