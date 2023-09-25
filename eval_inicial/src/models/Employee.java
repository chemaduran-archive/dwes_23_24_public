package models;

public class Employee {
  private Integer employeeNumber;
  private String lastName;
  private String firstName;
  private String extension;
  private String email;
  private String officeCode;
  private Integer reportsTo;
  private String jobTitle;

  public Employee(
      Integer employeeNumber,
      String lastName,
      String firstName,
      String extension,
      String email,
      String officeCode,
      Integer reportsTo,
      String jobTitle) {
    this.employeeNumber = employeeNumber;
    this.lastName = lastName;
    this.firstName = firstName;
    this.extension = extension;
    this.email = email;
    this.officeCode = officeCode;
    this.reportsTo = reportsTo;
    this.jobTitle = jobTitle;
  }

  public Integer getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(Integer employeeNumber) {
    this.employeeNumber = employeeNumber;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getOfficeCode() {
    return officeCode;
  }

  public void setOfficeCode(String officeCode) {
    this.officeCode = officeCode;
  }

  public Integer getReportsTo() {
    return reportsTo;
  }

  public void setReportsTo(Integer reportsTo) {
    this.reportsTo = reportsTo;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  @Override
  public String toString() {
    return "Employee{"
        + "employeeNumber="
        + employeeNumber
        + ", lastName='"
        + lastName
        + '\''
        + ", firstName='"
        + firstName
        + '\''
        + ", officeCode='"
        + officeCode
        + '\''
        + ", jobTitle='"
        + jobTitle
        + '\''
        + '}';
  }
}
