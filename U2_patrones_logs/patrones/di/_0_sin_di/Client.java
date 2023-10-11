package _4_di._0_sin_di;

public class Client {
  private Service service = null;

  public Client() {
    this.service = new Service(4);
  }

  public void Saludar() {
    System.out.println("Hola, " + service.getName());
  }
}
