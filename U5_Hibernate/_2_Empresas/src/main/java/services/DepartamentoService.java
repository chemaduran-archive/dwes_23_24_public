package services;

import model.Departamento;

import java.util.List;

public interface DepartamentoService {

  public void insertNewDepartamento(final Departamento departamento);

  public Departamento updateDepartamento(final Departamento departamento);

  public void deleteDepartamento(final Departamento departamento);

  public Departamento searchById(final Long departamentoId);

  public List<Departamento> searchAll();

  public List<Departamento> searchByName(String name);
}
