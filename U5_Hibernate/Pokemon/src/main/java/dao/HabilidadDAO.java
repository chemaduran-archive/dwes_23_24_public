package dao;

import dao.generic.GenericDAO;
import models.Habilidad;

public interface HabilidadDAO extends GenericDAO<Habilidad> {
    public Habilidad searchByNombre(final String nombre);
}
