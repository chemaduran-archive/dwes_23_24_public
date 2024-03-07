package velazquez._5_spring_security_jpa.services;

import velazquez._5_spring_security_jpa.model.Departamento;

import java.util.List;

public interface DepartamentoService {

  public List<Departamento> getAllDepartments();

  public Departamento getDepartamentByName(String nombre);

  public Departamento insertarDepartamento(Departamento departamento);

  public Departamento actualizarDepartamento(Departamento departamento);

  public Departamento findDepartamentoById(Long id);
}
