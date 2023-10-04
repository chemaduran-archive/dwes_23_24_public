package _4_di._0_sin_di;

public class Service {
  // ¿Qué pasa si añadimos una propiedad?...
  private int id;

  // ...tenemos que añadirlo en el constructor.
  // Afecta a todas las clases que utilicen
  // este constructor
  public Service(int id) {
    this.id = id;
  }

  public String getName() {
    return "Soy un servicio sin DI";
  }
}
