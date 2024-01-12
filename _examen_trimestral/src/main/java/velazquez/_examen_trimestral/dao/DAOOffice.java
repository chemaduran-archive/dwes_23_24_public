package velazquez._examen_trimestral.dao;

import velazquez._examen_trimestral.model.Office;

import java.util.ArrayList;

public interface DAOOffice {
  public ArrayList<Office> getAllOffices();

  public Office getOffice(int officeCode);

  public Office getOffice(String city);
}
