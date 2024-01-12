package velazquez._entregable_filtros.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez._entregable_filtros.bd.ConexionBD;
import velazquez._entregable_filtros.models.Office;
import velazquez._entregable_filtros.models.ProductLine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOProductLineImpl implements DAOProductLine {
  static final Logger logger = LoggerFactory.getLogger(DAOProductLineImpl.class);

  @Override
  public List<ProductLine> getAllProductLines() {
    logger.info("getAllProductLines()");

    List<ProductLine> ProductLineList = new ArrayList<>();

    try {
      String sql = "SELECT * FROM productlines";
      PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        ProductLine productLine = new ProductLine();
        productLine.setProductLine(rs.getString("productLine"));
        productLine.setHtmlDescription(rs.getString("htmlDescription"));
        productLine.setTextDescription(rs.getString("textDescription"));
        ProductLineList.add(productLine);
      }
      ConexionBD.close();
    } catch (SQLException ex) {
      logger.error(ex.getMessage());
    }
    return ProductLineList;
  }
}
