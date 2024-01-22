package services;

import java.util.ArrayList;
import java.util.List;

import dao.EmpleadoDAO;
import dao.EmpleadoDAOImpl;
import model.Empleado;
import org.hibernate.Session;

public class EmpleadoServiceImpl implements EmpleadoService {

  private final EmpleadoDAO empleadoDao;

  public EmpleadoServiceImpl(final Session session) {
    this.empleadoDao = new EmpleadoDAOImpl(session);
  }

  @Override
  public void insertNewEmpleado(Empleado empleado) {

    // Compruebo que no es nulo y que aún no existe
    // es decir no tiene ID
    if (empleado != null && empleado.getId() == null) {
      // Inserción del pedido
      empleadoDao.insert(empleado);
    }
  }

  @Override
  public void updateEmpleado(Empleado empleado) {
    // Compruebo que no es nulo y que ya existe (tiene ID)
    if (empleado != null && empleado.getId() != null) {

      // Actualizo el pedido
      empleadoDao.update(empleado);
    }
  }

  @Override
  public void deleteEmpleado(Empleado empleado) {
    // Compruebo que no es nulo y que ya existe (tiene ID)
    if (empleado != null && empleado.getId() != null) {

      // Actualizo el pedido
      empleadoDao.delete(empleado);
    }
  }

  @Override
  public Empleado searchById(Long empleadoId) {
    Empleado empleado = null;

    if (empleadoId != null) {

      empleado = empleadoDao.searchById(empleadoId);
    }

    return empleado;
  }

  @Override
  public List<Empleado> searchAll() {
    List<Empleado> empleadoList = new ArrayList<Empleado>();

    empleadoList = empleadoDao.searchAll();

    return empleadoList;
  }

  @Override
  public List<Empleado> searchByFullName(String firstName, String lastName) {

    List<Empleado> empleadoList = new ArrayList<Empleado>();

    if (firstName != null && lastName != null) {
      empleadoList = empleadoDao.searchByFullName(firstName, lastName);
    }

    return empleadoList;
  }
}
