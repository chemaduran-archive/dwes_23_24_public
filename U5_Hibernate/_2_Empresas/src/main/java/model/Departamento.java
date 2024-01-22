package model;

import jakarta.persistence.*;
import utils.dao.Identifiable;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "departaments")
public class Departamento implements Serializable, Identifiable {

  @Id @GeneratedValue private Long id;

  @Column private String name;

  @ManyToOne private Empresa empresa;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private Set<Sede> sedes = new HashSet<>();

  @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<DptoEmpl> dptoEmpls = new HashSet<>();

  public Departamento() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Departamento other = (Departamento) obj;
    return Objects.equals(id, other.id) && Objects.equals(name, other.name);
  }

  @Override
  public String toString() {
    return "Departamento [id=" + id + ", name=" + name + ", sedes=" + sedes + " employees=" + dptoEmpls + "]";
  }

  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }

  public Set<DptoEmpl> getDptoEmpls() {
    return dptoEmpls;
  }

  public Set<Sede> getSedes() {
    return sedes;
  }

  // MÉTODOS HELPERS CON SEDE
  public void addSede(final Sede sede) {
    this.sedes.add(sede);
    sede.getDepartamentos().add(this);
  }

  public void removeSede(final Sede sede) {
    this.sedes.remove(sede);
    sede.getDepartamentos().remove(this);
  }

  // METODOS HELPER CON EMPLEADOS
  public void addEmpleado(Empleado empleado, String puesto) {
    DptoEmpl dptoEmpl = new DptoEmpl(this, empleado, puesto);
    this.dptoEmpls.add(dptoEmpl);
    empleado.getDptoEmpls().add(dptoEmpl);
  }

  public void removeEmpleado(Empleado empleado) {
    DptoEmpl dptoEmpl = new DptoEmpl(this, empleado);
    this.dptoEmpls.remove(dptoEmpl);
    empleado.getDptoEmpls().remove(dptoEmpl);
  }
}
