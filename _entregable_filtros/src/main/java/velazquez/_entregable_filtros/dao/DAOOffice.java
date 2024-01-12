package velazquez._entregable_filtros.dao;

import velazquez._entregable_filtros.models.Office;

import java.util.List;

public interface DAOOffice {
  public List<Office> getAllOffices();

  public Office getOffice(String officeCode);

  public boolean updateOffice(Office office);

  public boolean insertOffice(Office office);
}
