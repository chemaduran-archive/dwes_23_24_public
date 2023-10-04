package _4_di._3_di_interface;

public class main {
  public static void main(String[] args) {
    // Si modifico la clase "service" (o las implementaciones
    // del mismo), no tengo que modificar absolutamente nada
    // de esta clase ni de la "cliente"
    ServiceInjector inyector = new ServiceInjector();
    Client client = inyector.getClient();
    client.Saludar();
  }
}
