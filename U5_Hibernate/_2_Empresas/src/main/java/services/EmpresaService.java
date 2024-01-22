package services;

import model.Empresa;

import java.util.List;

public interface EmpresaService {

  public void insertNewEmpresa(final Empresa empresa);

  public Empresa updateEmpresa(final Empresa empresa);

  public void deleteEmpresa(final Empresa empresa);

  public Empresa searchById(final Long empresaId);

  public List<Empresa> searchAll();

  public Empresa searchByName(final String name);
}
