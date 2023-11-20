package velazquez._0_el.model;

import java.io.Serializable;

public class Maquinista implements Serializable {

  private String nombre;
  private String apellidos;
  private String dni;

  public Maquinista() {
  }

  public Maquinista(String nombre, String apellidos, String dni) {
    super();
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.dni = dni;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }
}
