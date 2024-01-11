package velazquez._1_hibernatebasics.onetoone.model;

import jakarta.persistence.*;
import velazquez._1_hibernatebasics.utils.dao.Identifiable;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "persons")
public class Person implements Serializable, Identifiable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "firstName", nullable = false)
  private String firstName;

  @Column(name = "lastName", nullable = false)
  private String lastName;

  @Column(name = "birth", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date dateOfBirth;

  // OPCION UNIDIRECCIONAL - Solo puede acceder desde la persona al pasaporte
  	@OneToOne
  	@JoinColumn(name="passport_id")
  	private Passport passport;

  // OPCION BIDIRECCIONAL
//  @OneToOne(
//      mappedBy = "person",
//      cascade = CascadeType.ALL,
//      orphanRemoval = true,
//      fetch = FetchType.LAZY)
//  private Passport passport;

  public Person() {
  }

  public Person(Long id, String firstName, String lastName, Date dateOfBirth) {
    super();
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  // No tiene sentido tener el Get ya que se auto genera
  public Long getId() {
    return id;
  }

  // Métodos HELPER para trabajar con las asociaciones
  public Passport getPassport() {
    return this.passport;
  }

////   Versión unidireccional
//  	public void setPassport(Passport passport) {
//  		this.passport = passport;
//  	}
//
//  	public void removePassport() {
//  		this.passport = null;
//  	}

  // Versión bidireccional
  public void setPassport(Passport passport) {
    passport.setPerson(this);
    this.passport = passport;
  }

  public void removePassport() {
    if (this.passport != null) {
      this.passport.setPerson(null);
      this.passport = null;
    }
  }
}
