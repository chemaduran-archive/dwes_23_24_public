package velazquez._examen_trimestral.model;

public class Employee {
  private int employeeNumber;
  private String lastName;
  private String firstName;
  private String extension;
  private String email;
  private int officeCode;
  private int reportsTo;
  private String jobTitle;
  private String reportsToName;
  private String officeName;

  public Employee() {
    super();
  }

  public Employee(
      int employeeNumber,
      String lastName,
      String firstName,
      String extension,
      String email,
      int officeCode,
      int reportsTo,
      String jobTitle) {
    super();
    this.employeeNumber = employeeNumber;
    this.lastName = lastName;
    this.firstName = firstName;
    this.extension = extension;
    this.email = email;
    this.officeCode = officeCode;
    this.reportsTo = reportsTo;
    this.jobTitle = jobTitle;
  }

  public int getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(int employeeNumber) {
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

  public int getOfficeCode() {
    return officeCode;
  }

  public void setOfficeCode(int officeCode) {
    this.officeCode = officeCode;
  }

  public int getReportsTo() {
    return reportsTo;
  }

  public void setReportsTo(int reportsTo) {
    this.reportsTo = reportsTo;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public String getOfficeName() {
    return officeName;
  }

  public void setOfficeName(String officeName) {
    this.officeName = officeName;
  }

  public String getReportsToName() {
    return reportsToName;
  }

  public void setReportsToName(String reportsToName) {
    this.reportsToName = reportsToName;
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
        + ", extension='"
        + extension
        + '\''
        + ", email='"
        + email
        + '\''
        + ", officeCode='"
        + officeCode
        + '\''
        + ", reportsTo="
        + reportsTo
        + ", jobTitle='"
        + jobTitle
        + '\''
        + '}';
  }
}
