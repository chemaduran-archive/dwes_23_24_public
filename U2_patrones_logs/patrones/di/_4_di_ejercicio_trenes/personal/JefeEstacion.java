package _4_di._4_ejercicio_trenes.personal;

public class JefeEstacion {
  // nombre completo, dni.
  private String nombre;
  private String dni;

  public JefeEstacion(String nombre, String dni) {
    this.nombre = nombre;
    this.dni = dni;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  @Override
  public String toString() {
    return "JefeEstacion{" + "nombre='" + nombre + '\'' + ", dni='" + dni + '\'' + '}';
  }
}
