public class Main {
  public static void main(String[] args) {
    PersonaDAO personaDAO = new PersonaDAOImpl();

    // Agregar personas
    personaDAO.agregar(new Persona(1, "Pepito", 25));
    personaDAO.agregar(new Persona(2, "Juanita", 23));

    System.out.println("Todas las personas: ");
    System.out.println(personaDAO.obtenerTodos());

    // Obtener y mostrar una persona por ID
    System.out.println("Persona con id=2");
    System.out.println(personaDAO.obtenerPorId(2));

    // Actualizar una persona
    personaDAO.actualizar(new Persona(1, "Pepito", 47));

    // Volvemos a imprimir todas las personas
    System.out.println("Todas las personas después de actualizar: ");
    System.out.println(personaDAO.obtenerTodos());

    // Eliminar una persona por ID
    personaDAO.eliminar(2);

    // Volvemos a imprimir todas las personas
    System.out.println("Todas las personas después de eliminar por ID: ");
    System.out.println(personaDAO.obtenerTodos());
  }
}
