package dao.impl;

import dao.EstadisticasPokemonDAO;
import dao.generic.GenericDAOImpl;
import models.EstadisticasPokemon;
import org.hibernate.Session;

public class EstadisticasPokemonDAOImpl extends GenericDAOImpl<EstadisticasPokemon> implements EstadisticasPokemonDAO {

    public EstadisticasPokemonDAOImpl(Session session) {
        super(session);
    }
}
