package model;

import java.io.Serializable;
import java.util.Objects;

public class DptoEmpId implements Serializable {

  private Long departamento;
  private Long empleado;

  public DptoEmpId() {}

  @Override
  public int hashCode() {
    return Objects.hash(departamento, empleado);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    DptoEmpId other = (DptoEmpId) obj;

    if (empleado == null) {
      if (other.empleado != null) return false;
    } else if (!empleado.equals(other.empleado)) return false;

    if (departamento == null) {
        return other.departamento == null;
    } else return departamento.equals(other.departamento);
  }

  public Long getDepartamento() {
    return departamento;
  }

  public void setDepartamento(Long departamento) {
    this.departamento = departamento;
  }

  public Long getEmpleado() {
    return empleado;
  }

  public void setEmpleado(Long empleado) {
    this.empleado = empleado;
  }

  @Override
  public String toString() {
    return "DptoEmpId[" +
            "departamento=" + departamento +
            ", empleado=" + empleado +
            ']';
  }
}
