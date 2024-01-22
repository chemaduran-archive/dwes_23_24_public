package model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(DptoEmpId.class)
public class DptoEmpl implements Serializable {

  @Id
  @ManyToOne
  @JoinColumn(name = "departamento_id", insertable = false, updatable = false)
  private Departamento departamento;

  @Id
  @ManyToOne
  @JoinColumn(name = "empleado_id", insertable = false, updatable = false)
  private Empleado empleado;

  private String puesto;

  public DptoEmpl() {}

  public DptoEmpl(Departamento departamento, Empleado empleado) {
    super();
    this.departamento = departamento;
    this.empleado = empleado;
  }

  public DptoEmpl(Departamento departamento, Empleado empleado, String puesto) {
    super();
    this.departamento = departamento;
    this.empleado = empleado;
    this.puesto = puesto;
  }

  public Departamento getDepartamento() {
    return departamento;
  }

  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }

  public Empleado getEmpleado() {
    return empleado;
  }

  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }

  public String getPuesto() {
    return puesto;
  }

  public void setPuesto(String puesto) {
    this.puesto = puesto;
  }

  @Override
  public int hashCode() {
    return Objects.hash(departamento, empleado);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    DptoEmpl other = (DptoEmpl) obj;
    return Objects.equals(departamento, other.departamento)
        && Objects.equals(empleado, other.empleado);
  }

  @Override
  public String toString() {
    return "DptoEmpl[" +
            "departamento=" + departamento.getId() +
            ", empleado=" + empleado.getId() +
            ']';
  }
}
