package _4_di._2_di_setter;

public class Service {
    // ¿Qué pasa si añadimos una propiedad?...
    private int id = 0;
    private String nombre = "";

    public Service() {
        
    }

    // ...tenemos que añadirlo en el constructor.
    // Afecta a todas las clases que utilicen
    // este constructor
    public Service(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getName() {
        return "Soy " + this.nombre;
    }
}
