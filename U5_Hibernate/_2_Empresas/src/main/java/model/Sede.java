package model;

import jakarta.persistence.*;
import utils.dao.Identifiable;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sedes")
public class Sede implements Serializable, Identifiable {

  @Id @GeneratedValue private Long id;

  @Column private String city;

  @Column private String country;

  @ManyToMany(mappedBy = "sedes")
  private Set<Departamento> departamentos = new HashSet<>();

  public Sede() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Set<Departamento> getDepartamentos() {
    return departamentos;
  }

  @Override
  public String toString() {
    return "Sede[" +
            "id=" + id +
            ", city='" + city + '\'' +
            ']';
  }
}
