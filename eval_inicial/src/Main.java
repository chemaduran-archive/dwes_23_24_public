import dao.dao_empleados;

public class Main {
  public static void main(String[] args) {
    System.out.println("Lista de empleados: ");
    System.out.println(dao_empleados.getEmpleados());
  }
}
