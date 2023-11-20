package velazquez._0_el.model;

import java.io.Serializable;

public class Vagon implements Serializable {
  private int capacidad;
  private int longitud;

  public Vagon() {
  }

  public Vagon(int capacidad, int longitud) {
    super();
    this.capacidad = capacidad;
    this.longitud = longitud;
  }

  public int getCapacidad() {
    return capacidad;
  }

  public void setCapacidad(int capacidad) {
    this.capacidad = capacidad;
  }

  public int getLongitud() {
    return longitud;
  }

  public void setLongitud(int longitud) {
    this.longitud = longitud;
  }
}
