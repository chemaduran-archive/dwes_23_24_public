package velazquez._5_spring_security_jpa.api.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import velazquez._5_spring_security_jpa.model.Departamento;

public class ProfesorDTO implements Serializable {
  DepartamentoDTO departamento;
  private Long id;
  private String nif;
  private String nombre;
  private String apellido1;
  private String apellido2;
  private String ciudad;
  private String direccion;
  private String telefono;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date fechaNacimiento;
  private String sexo;


  public DepartamentoDTO getDepartamento() {
    return departamento;
  }

  public void setDepartamento(DepartamentoDTO departamento) {
    this.departamento = departamento;
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

  @Override
  public String toString() {
    return "{" +
            "id=" + id +
            ", nif='" + nif + '\'' +
            ", nombre='" + nombre + '\'' +
            ", departamento='" + departamento + '\'' +
            '}';
  }
}
