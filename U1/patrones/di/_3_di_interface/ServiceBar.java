package _4_di._3_di_interface;

public class ServiceBar implements Service {
    private String name;

    public ServiceBar(String name) {
        this.name = name;
    }

    public void doBarThings() {
    System.out.println("cosas de Bar");
  }

    @Override
    public String getName() {
        return name;
    }
}
