package _4_di._1_di_constructor;

public class main {
  public static void main(String[] args) {
    Service servicio = new Service(1, "servicio 1");
    Client client = new Client(servicio);
    client.Saludar();
  }
}
