package _4_di._4_ejercicio_trenes.maquinaria;

import _4_di._4_ejercicio_trenes.personal.Mecanico;

public class Locomotora {
  // disponen de una matrícula, potencia de su motor y
  // un año de fabricación. Cada locomotora tiene asignado
  // un mecánico que se encarga de su mantenimiento.
  private String matricula;
  private int potencia;
  private int anyo;
  private Mecanico mecanico;

  public Locomotora() {

  }

//  public Locomotora(String matricula, int potencia, int anyo, Mecanico mecanico) {
//    this.matricula = matricula;
//    this.potencia = potencia;
//    this.anyo = anyo;
//    this.mecanico = mecanico;
//  }

  public void muestraMecanico() {
    System.out.println(mecanico.getNombre());
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public int getPotencia() {
    return potencia;
  }

  public void setPotencia(int potencia) {
    this.potencia = potencia;
  }

  public int getAnyo() {
    return anyo;
  }

  public void setAnyo(int anyo) {
    this.anyo = anyo;
  }

  public Mecanico getMecanico() {
    return mecanico;
  }

  public void setMecanico(Mecanico mecanico) {
    this.mecanico = mecanico;
  }

  @Override
  public String toString() {
    return "Locomotora{"
        + "matricula='"
        + matricula
        + '\''
        + ", potencia="
        + potencia
        + ", anyo="
        + anyo
        + ", mecanico="
        + mecanico
        + '}';
  }
}
