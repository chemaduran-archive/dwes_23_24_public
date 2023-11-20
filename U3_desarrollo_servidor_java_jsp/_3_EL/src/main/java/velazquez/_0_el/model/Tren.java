package velazquez._0_el.model;

import java.util.ArrayList;

public class Tren {

  private String nombre;
  private Maquinista maquinista;
  private ArrayList<Vagon> vagones;

  public Tren(String nombre, Maquinista maquinista, ArrayList<Vagon> vagones) {
    super();
    this.nombre = nombre;
    this.maquinista = maquinista;
    this.vagones = vagones;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Maquinista getMaquinista() {
    return maquinista;
  }

  public void setMaquinista(Maquinista maquinista) {
    this.maquinista = maquinista;
  }

  public ArrayList<Vagon> getVagones() {
    return vagones;
  }

  public void setVagones(ArrayList<Vagon> vagones) {
    this.vagones = vagones;
  }
}
