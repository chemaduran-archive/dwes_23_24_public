package dao;

import model.Empresa;
import utils.dao.GenericDAO;

public interface EmpresaDAO extends GenericDAO<Empresa> {

  public Empresa searchByName(final String name);
}
