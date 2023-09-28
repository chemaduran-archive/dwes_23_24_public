import java.util.ArrayList;
import java.util.List;

public class PersonaDAOImpl implements PersonaDAO {
    private List<Persona> personas = new ArrayList<>();

    @Override
    public List<Persona> obtenerTodos() {
        return personas;
    }

    @Override
    public Persona obtenerPorId(int id) {
        Persona encontrada = null;
        for (Persona p : personas ) {
            if (p.getId() == id) {
                encontrada = p;
            }
        }
        return encontrada;
    }

    @Override
    public void agregar(Persona persona) {
        personas.add(persona);
    }

    @Override
    public void actualizar(Persona persona) {
        Persona persona_existente = obtenerPorId(persona.getId());

        if (persona_existente != null) {
            personas.remove(persona_existente);
            personas.add(persona);
        }
    }

    @Override
    public void eliminar(int id) {
        for (Persona p : personas ) {
            if (p.getId() == id) {
                personas.remove(p);
            }
        }
    }













}
