package _4_di._2_di_setter;

public class Client {
    private Service service = null;

    public Client() {
    System.out.println("Creo el cliente sin datos del servicio");
    }

    public Client(Service service) {
        this.service = service;
    }

    // La inyección de dependencias se hace aquí en el setter,
    // por si, por lo que sea, no he podido crear el cliente
    // con la información del servicio.
    // Me permite, por tanto, crear el cliente sin tener la
    // información del servicio. Posteriormente, se podrá inyectar
    // llamando a esta función setter.
    public void setService(Service service) {
        this.service = service;
    }

    public void Saludar() {
    System.out.println("Hola, " + service.getName());
    }

}
