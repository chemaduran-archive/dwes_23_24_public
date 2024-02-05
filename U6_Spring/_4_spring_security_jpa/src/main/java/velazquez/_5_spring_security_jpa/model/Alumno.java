package velazquez._5_spring_security_jpa.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, length = 9, nullable = true)
  private String nif;

  @Column(nullable = false)
  private String nombre;

  @Column(nullable = false)
  private String apellido1;

  @Column(nullable = true)
  private String apellido2;

  @Column(nullable = false)
  private String ciudad;

  @Column(nullable = false)
  private String direccion;

  @Column(nullable = true)
  private String telefono;

  @Column(name = "fecha_nacimiento", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaNacimiento;

  @Column(nullable = false, length = 1)
  private String sexo;

  @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<AlumnoAsignatura> alumnoAsignaturas = new HashSet<>();

  public Alumno() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNif() {
    return nif;
  }

  public void setNif(String nif) {
    this.nif = nif;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido1() {
    return apellido1;
  }

  public void setApellido1(String apellido1) {
    this.apellido1 = apellido1;
  }

  public String getApellido2() {
    return apellido2;
  }

  public void setApellido2(String apellido2) {
    this.apellido2 = apellido2;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public Set<AlumnoAsignatura> getAlumnoAsignaturas() {
    return alumnoAsignaturas;
  }

  public void setAlumnoAsignaturas(Set<AlumnoAsignatura> alumnoAsignatura) {
    this.alumnoAsignaturas = alumnoAsignatura;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nif);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Alumno other = (Alumno) obj;
    return Objects.equals(id, other.id) && Objects.equals(nif, other.nif);
  }
}
