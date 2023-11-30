package velazquez._0_pooldb.dao;

import velazquez._0_pooldb.model.Office;
import java.util.List;

public interface DAOOffice {

  public List<Office> getAllOffices();

  public List<Office> getAllOfficesContext();
}
