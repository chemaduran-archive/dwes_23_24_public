package _4_di._2_di_setter;

public class main {
  public static void main(String[] args) {
    // Con la inyección de dependencias mediante setter,
    // puedo crear el objeto cliente sin conocer el servicio...
    Client client = new Client();
    // ...ahora en esta línea siguiente, creo el servicio porque ya
    // tengo los datos...
    Service servicio = new Service(1, "servicio 1");
    // ... y lo inyecto en el cliente mediante el setter
    client.setService(servicio);
    client.Saludar();
  }
}
