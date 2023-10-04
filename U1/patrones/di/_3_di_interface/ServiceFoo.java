package _4_di._3_di_interface;

// Esta clase es un tipo de servicio concreto
// Puedo crear otras clases que implementen el servicio
// o modificarlas, y no tendré que cambiar ni clase main
// (o la que utilice la clase "client") ni tampoco la
// clase "client" en sí.
public class ServiceFoo implements Service {
  private final String name;

  public ServiceFoo(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  public void doFooThings() {
    System.out.println("cosas de Foo");
  }


}
