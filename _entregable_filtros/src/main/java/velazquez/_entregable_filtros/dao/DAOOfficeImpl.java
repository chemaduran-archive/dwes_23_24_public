package velazquez._entregable_filtros.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez._entregable_filtros.bd.ConexionBD;
import velazquez._entregable_filtros.models.Office;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOOfficeImpl implements DAOOffice {
  static final Logger logger = LoggerFactory.getLogger(DAOOfficeImpl.class);

  @Override
  public List<Office> getAllOffices() {
    logger.info("getAllOffices()");

    List<Office> officeList = new ArrayList<>();

    try {
      String sql = "SELECT * FROM offices";
      PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        Office office = new Office();
        office.setOfficeCode(rs.getString("officeCode"));
        office.setCity(rs.getString("city"));
        office.setPhone(rs.getString("phone"));
        office.setAddressLine1(rs.getString("addressLine1"));
        office.setAddressLine2(rs.getString("addressLine2"));
        office.setState(rs.getString("state"));
        office.setCountry(rs.getString("country"));
        office.setPostalCode(rs.getString("postalCode"));
        office.setTerritory(rs.getString("territory"));
        officeList.add(office);
      }
      ConexionBD.close();
    } catch (SQLException ex) {
      logger.error(ex.getMessage());
    }
    return officeList;
  }

  @Override
  public Office getOffice(String officeCode) {
    logger.info("getOffice()");
    Office office = null;

    try {
      String sql = "SELECT * FROM offices WHERE officeCode = ?";
      PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
      statement.setString(1, officeCode);
      ResultSet rs = statement.executeQuery();

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
      }
      ConexionBD.close();

    } catch (SQLException ex) {
      logger.error(ex.getMessage());
    }

    return office;
  }

  @Override
  public boolean updateOffice(Office office) {
    return false;
  }

  @Override
  public boolean insertOffice(Office office) {
    return false;
  }
}
