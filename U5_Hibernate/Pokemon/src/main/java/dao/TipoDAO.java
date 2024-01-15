package dao;

import dao.generic.GenericDAO;
import models.Tipo;

public interface TipoDAO extends GenericDAO<Tipo> {
    Tipo searchByName(String tipo);
}
