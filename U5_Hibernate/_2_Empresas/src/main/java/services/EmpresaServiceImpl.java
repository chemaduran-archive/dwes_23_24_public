package services;

import java.util.ArrayList;
import java.util.List;

import dao.EmpresaDAO;
import dao.EmpresaDAOImpl;
import model.Empresa;
import org.hibernate.Session;

public class EmpresaServiceImpl implements EmpresaService {

  private final EmpresaDAO empresaDao;

  public EmpresaServiceImpl(final Session session) {
    this.empresaDao = new EmpresaDAOImpl(session);
  }

  @Override
  public void insertNewEmpresa(Empresa empresa) {

    // Compruebo que no es nulo y que aún no existe
    // es decir no tiene ID
    if (empresa != null && empresa.getId() == null) {
      // Inserción del pedido
      empresaDao.insert(empresa);
    }
  }

  @Override
  public Empresa updateEmpresa(Empresa empresa) {
    Empresa empresaUpdated = null;
    // Compruebo que no es nulo y que ya existe (tiene ID)
    if (empresa != null && empresa.getId() != null) {

      // Actualizo el pedido
      empresaUpdated = empresaDao.update(empresa);
    }
    return empresaUpdated;
  }

  @Override
  public void deleteEmpresa(Empresa empresa) {
    // Compruebo que no es nulo y que ya existe (tiene ID)
    if (empresa != null && empresa.getId() != null) {

      // Actualizo el pedido
      empresaDao.delete(empresa);
    }
  }

  @Override
  public Empresa searchById(Long empresaId) {
    Empresa empresa = null;

    if (empresaId != null) {

      empresa = empresaDao.searchById(empresaId);
    }

    return empresa;
  }

  @Override
  public List<Empresa> searchAll() {

    List<Empresa> empresaList = new ArrayList<Empresa>();

    empresaList = empresaDao.searchAll();

    return empresaList;
  }

  @Override
  public Empresa searchByName(String name) {

    Empresa empresa = null;

    if (name != null) {
      empresa = empresaDao.searchByName(name);
    }

    return empresa;
  }
}
