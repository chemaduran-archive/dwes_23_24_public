package model;

import jakarta.persistence.*;
import utils.dao.Identifiable;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "empresas")
public class Empresa implements Serializable, Identifiable {

  @Id @GeneratedValue private Long id;

  @Column(name = "name", unique = true, nullable = false)
  private String name;

  @Column() private String country;

  @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Departamento> departamentos = new HashSet<>();

  public Empresa() {}

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

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Empresa other = (Empresa) obj;
    return Objects.equals(name, other.name);
  }

  @Override
  public String toString() {
    return "Empresa [id=" + id + ", name=" + name + ", country=" + country + "]";
  }

  // Helpers
  public void addDepartament(Departamento departamento) {
    this.departamentos.add(departamento);
    departamento.setEmpresa(this);
  }

  public void removeDepartamento(Departamento departamento) {
    this.departamentos.remove(departamento);
    departamento.setEmpresa(null);
  }
}
