package dao;

import models.Categoria;
import dao.generic.GenericDAO;

public interface CategoriaDAO extends GenericDAO<Categoria> {
    Categoria searchByName(String categoria);
}
