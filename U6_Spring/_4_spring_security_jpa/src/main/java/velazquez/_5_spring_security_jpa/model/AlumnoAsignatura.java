package velazquez._5_spring_security_jpa.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "alumno_se_matricula_asignatura")
@IdClass(AlumnoAsignaturaId.class)
public class AlumnoAsignatura implements Serializable {

  @Id
  @ManyToOne
  @JoinColumn(name = "id_alumno", insertable = false, updatable = false)
  private Alumno alumno;

  @Id
  @ManyToOne
  @JoinColumn(name = "id_asignatura", insertable = false, updatable = false)
  private Asignatura asignatura;

  private int nota;

  public AlumnoAsignatura() {}

  public AlumnoAsignatura(Alumno alumno, Asignatura asignatura, int nota) {
    super();
    this.alumno = alumno;
    this.asignatura = asignatura;
    this.nota = nota;
  }

  public AlumnoAsignatura(Alumno alumno, Asignatura asignatura) {
    super();
    this.alumno = alumno;
    this.asignatura = asignatura;
  }

  public Alumno getAlumno() {
    return alumno;
  }

  public void setAlumno(Alumno alumno) {
    this.alumno = alumno;
  }

  public Asignatura getAsignatura() {
    return asignatura;
  }

  public void setAsignatura(Asignatura asignatura) {
    this.asignatura = asignatura;
  }

  public int getNota() {
    return nota;
  }

  public void setNota(int nota) {
    this.nota = nota;
  }

  @Override
  public int hashCode() {
    return Objects.hash(alumno, asignatura);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    AlumnoAsignatura other = (AlumnoAsignatura) obj;
    return Objects.equals(alumno, other.alumno) && Objects.equals(asignatura, other.asignatura);
  }
}
