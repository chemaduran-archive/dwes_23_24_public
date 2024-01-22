package dao;

import model.Empleado;
import utils.dao.GenericDAO;

import java.util.List;

public interface EmpleadoDAO extends GenericDAO<Empleado> {

  public List<Empleado> searchByFullName(final String firstName, final String lastName);
}
