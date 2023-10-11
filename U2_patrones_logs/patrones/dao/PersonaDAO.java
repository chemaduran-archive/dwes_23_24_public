import java.util.List;

public interface PersonaDAO {
    List<Persona> obtenerTodos();

    Persona obtenerPorId(int id);

    void agregar(Persona persona);

    void actualizar(Persona persona);

    void eliminar(int id);
}
