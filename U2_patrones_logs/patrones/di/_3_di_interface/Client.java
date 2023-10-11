package _4_di._3_di_interface;

public class Client {
    private Service service = null;

    public Client() {
    System.out.println("Creo el cliente sin datos del servicio");
    }

    public Client(Service service) {
        this.service = service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void Saludar() {
    System.out.println("Hola, " + service.getName());
    }

}
