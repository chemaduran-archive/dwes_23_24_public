package models;

import dao.generic.Identifiable;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Tipo implements Identifiable {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "idTipo")
  private Long id;

  @Basic
  @Column(name = "nombre")
  private String nombre;

  @ManyToMany(cascade = {CascadeType.MERGE})
  @JoinTable(name="PokemonTipo", joinColumns={@JoinColumn(name="IdTipo")}, inverseJoinColumns={@JoinColumn(name="IdPokemon")})
  private Set<Pokemon> pokemons = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long idTipo) {
    this.id = idTipo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  // MÉTODOS HELPERS
//  public Set<Pokemon> getPokemons() {
//    return this.pokemons;
//  }
//
//  public void addPokemon(final Pokemon pokemon) {
//    this.pokemons.add(pokemon);
//    pokemon.getTipos().add(this);
//  }
//  public void removePokemon(final Pokemon pokemon) {
//    this.pokemons.remove(pokemon);
//    pokemon.getTipos().remove(this);
//  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Tipo tipo = (Tipo) o;

    if (!Objects.equals(id, tipo.id)) return false;
    return Objects.equals(nombre, tipo.nombre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, pokemons);
  }
}
