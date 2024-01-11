package velazquez._1_hibernatebasics.manytomany.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import velazquez._1_hibernatebasics.utils.dao.Identifiable;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject implements Serializable, Identifiable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @Column(nullable = false)
  @Min(value = 1, message = "Las asignaturas deben tener al menos una hora")
  @Max(value = 30, message = "No se permiten asignaturas de más de 30 horas")
  private Integer weekHours;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private Set<Teacher> teachers = new HashSet<>();

  public Subject() {}

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Subject other = (Subject) obj;
    return Objects.equals(name, other.name);
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getWeekHours() {
    return weekHours;
  }

  public void setWeekHours(Integer weekHours) {
    this.weekHours = weekHours;
  }

  public Set<Teacher> getTeachers() {
    return teachers;
  }

  // MÉTODOS HELPERS
  public void addTeacher(final Teacher teacher) {
    this.teachers.add(teacher);
    teacher.getSubjects().add(this);
  }

  public void removeTeacher(final Teacher teacher) {
    this.teachers.remove(teacher);
    teacher.getSubjects().remove(this);
  }

  @Override
  public String toString() {
    return "Subject [id="
        + id
        + ", name="
        + name
        + ", weekHours="
        + weekHours
        + "]";
  }
}
