package models;

import dao.generic.Identifiable;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class EstadisticasPokemon implements Serializable, Identifiable {
  @Id
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idPokemon")
  private Pokemon pokemon;

  @Override
  public Long getId() {
    return pokemon.getId();
  }

  @Column(name = "peso")
  private double peso;

  @Column(name = "altura")
  private double altura;

  @Column(name = "ps")
  private int ps;

  @Column(name = "ataque")
  private int ataque;

  @Column(name = "defensa")
  private int defensa;

  @Column(name = "at_especial")
  private int at_especial;

  @Column(name = "df_especial")
  private int df_especial;

  @Column(name = "velocidad")
  private int velocidad;

  public Pokemon getPokemon() {
    return pokemon;
  }

  public void setPokemon(Pokemon pokemon) {
    this.pokemon = pokemon;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public double getAltura() {
    return altura;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

  public int getPs() {
    return ps;
  }

  public void setPs(int ps) {
    this.ps = ps;
  }

  public int getAtaque() {
    return ataque;
  }

  public void setAtaque(int ataque) {
    this.ataque = ataque;
  }

  public int getDefensa() {
    return defensa;
  }

  public void setDefensa(int defensa) {
    this.defensa = defensa;
  }

  public int getAt_especial() {
    return at_especial;
  }

  public void setAt_especial(int at_especial) {
    this.at_especial = at_especial;
  }

  public int getDf_especial() {
    return df_especial;
  }

  public void setDf_especial(int df_especial) {
    this.df_especial = df_especial;
  }

  public int getVelocidad() {
    return velocidad;
  }

  public void setVelocidad(int velocidad) {
    this.velocidad = velocidad;
  }

  @Override
  public String toString() {
    return "EstadisticasPokemon{"
        + "id="
        + pokemon.getId()
        + ", peso="
        + peso
        + ", altura="
        + altura
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EstadisticasPokemon that = (EstadisticasPokemon) o;
    return Double.compare(peso, that.peso) == 0
        && Double.compare(altura, that.altura) == 0
        && ps == that.ps
        && ataque == that.ataque
        && defensa == that.defensa
        && at_especial == that.at_especial
        && df_especial == that.df_especial
        && velocidad == that.velocidad
        && Objects.equals(pokemon.getId(), that.pokemon.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        pokemon.getId(), peso, altura, ps, ataque, defensa, at_especial, df_especial, velocidad);
  }


}
