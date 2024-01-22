package dao;

import model.Departamento;
import utils.dao.GenericDAO;

import java.util.List;

public interface DepartamentoDAO extends GenericDAO<Departamento> {

  public List<Departamento> searchByName(final String name);
}
