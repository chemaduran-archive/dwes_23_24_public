import models.Categoria;
import models.EstadisticasPokemon;
import models.Pokemon;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.CategoriaService;
import services.EstadisticasPokemonService;
import services.PokemonService;
import services.impl.CategoriaServiceImpl;
import services.impl.EstadisticasPokemonServiceImpl;
import services.impl.PokemonServiceImpl;

public class Main {
    static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("prueba de loggin");
        Session session = HibernateUtils.getSessionFactory().openSession();

        CategoriaService categoriaService = new CategoriaServiceImpl(session);
        PokemonService pokemonService = new PokemonServiceImpl(session);

        Categoria categoria = new Categoria();
        categoria.setNombre("salmorejo");

        categoriaService.insertNewCategoria(categoria);

        Pokemon pokemon1 = new Pokemon();
        pokemon1.setNombre("ElectricBeer");
        pokemon1.setDescripcion("Peluche con ganas de cerveza electrizante");
        pokemon1.setImagen("123.png");

        EstadisticasPokemon estadisticasPokemon1 = new EstadisticasPokemon();
        estadisticasPokemon1.setAltura(2);
        estadisticasPokemon1.setAtaque(10);
        estadisticasPokemon1.setDefensa(20);
        estadisticasPokemon1.setAt_especial(12);
        estadisticasPokemon1.setDf_especial(15);
        estadisticasPokemon1.setVelocidad(30);
        estadisticasPokemon1.setPeso(120);
        estadisticasPokemon1.setPs(4);


        // Establecemos las estadísticas al pokemon1
        pokemon1.setEstadisticasPokemon(estadisticasPokemon1);

        pokemonService.insertNewPokemon(pokemon1);

        session.close();

    }
}
