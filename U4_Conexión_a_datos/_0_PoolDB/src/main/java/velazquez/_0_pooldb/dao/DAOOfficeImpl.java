package velazquez._0_pooldb.dao;

import velazquez._0_pooldb.bd.PoolDB;
import velazquez._0_pooldb.bd.PoolDBContext;
import velazquez._0_pooldb.model.Office;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAOOfficeImpl implements DAOOffice {
  static final Logger logger = LoggerFactory.getLogger(DAOOfficeImpl.class);

  @Override
  public List<Office> getAllOffices() {
    ArrayList<Office> officesList = new ArrayList<>();
    Office office;
    Connection con = null;

    try {
      String sql = "SELECT * FROM offices";
      PoolDB pool = new PoolDB();
      con = pool.getConnection();
      PreparedStatement statement = con.prepareStatement(sql);

      ResultSet rs = statement.executeQuery();
      // Como el campo de búsqueda es la clave solo debería obtener un resultado
      // si no es así estaremos machacando cada vez el valor de customer y
      while (rs.next()) {
        office = new Office();
        office.setOfficeCode(rs.getString("officeCode"));
        office.setCity(rs.getString("city"));
        office.setPhone(rs.getString("phone"));
        office.setAddressLine1(rs.getString("addressLine1"));
        office.setAddressLine2(rs.getString("addressLine2"));
        office.setState(rs.getString("state"));
        office.setCountry(rs.getString("country"));
        office.setPostalCode(rs.getString("postalCode"));
        office.setTerritory(rs.getString("territory"));

        officesList.add(office);
      }
    } catch (SQLException e) {
      logger.error(e.getMessage());
      logger.error(Arrays.toString(e.getStackTrace()));
    } finally {
      try {
        assert con != null;
        con.close();
      } catch (SQLException e) {
        logger.error(e.getMessage());
        logger.error(Arrays.toString(e.getStackTrace()));
      }
    }

    return officesList;
  }

  @Override
  public List<Office> getAllOfficesContext() {
    ArrayList<Office> officesList = new ArrayList<>();
    Office office;
    Connection con = null;
    try {

      String sql = "SELECT * FROM offices";
      PoolDBContext pool = new PoolDBContext();
      con = pool.getConnection();
      PreparedStatement statement = con.prepareStatement(sql);

      ResultSet rs = statement.executeQuery();

      // Como el campo de búsqueda es la clave solo debería obtener un resultado
      // si no es así estaremos machacando cada vez el valor de customer y
      while (rs.next()) {
        office = new Office();
        office.setOfficeCode(rs.getString("officeCode"));
        office.setCity(rs.getString("city"));
        office.setPhone(rs.getString("phone"));
        office.setAddressLine1(rs.getString("addressLine1"));
        office.setAddressLine2(rs.getString("addressLine2"));
        office.setState(rs.getString("state"));
        office.setCountry(rs.getString("country"));
        office.setPostalCode(rs.getString("postalCode"));
        office.setTerritory(rs.getString("territory"));

        officesList.add(office);
      }
    } catch (SQLException e) {
      logger.error(e.getMessage());
      logger.error(Arrays.toString(e.getStackTrace()));
    } finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (SQLException e) {
        logger.error(e.getMessage());
        logger.error(Arrays.toString(e.getStackTrace()));
      }
    }

    return officesList;
  }
}
