package velazquez._4_productlinescrud.dao;

import velazquez._4_productlinescrud.bd.DBConnection;
import velazquez._4_productlinescrud.model.ProductLine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAOProductLineImpl implements DAOProductLine {
  static final Logger logger = LoggerFactory.getLogger(DAOProductLineImpl.class);

  public DAOProductLineImpl() {
  }

  @Override
  public ProductLine getProductLine(String productLine) {
    ProductLine categoria = null;

    try {
      String sql = "SELECT * FROM productlines WHERE productLine = ?";
      PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
      statement.setString(1, productLine);
      ResultSet rs = statement.executeQuery();

      // Como el campo de búsqueda es la clave solo debería obtener un resultado
      // si no es así estaremos machacando cada vez el valor de productLine
      while (rs.next()) {
        categoria = new ProductLine();

        categoria.setProductLine(rs.getString("productLine"));
        categoria.setTextDescription(rs.getString("textDescription"));
        categoria.setHtmlDescription(rs.getString("htmlDescription"));
      }

      DBConnection.close();
    } catch (SQLException e) {
      logger.error(e.getMessage());
      logger.error(Arrays.toString(e.getStackTrace()));
    }
    return categoria;
  }

  @Override
  public ArrayList<ProductLine> getAll() {
    ArrayList<ProductLine> categoriasList = new ArrayList<>();
    ProductLine categoria;

    try {
      String sql = "SELECT * FROM productlines";
      PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
      ResultSet rs = statement.executeQuery();

      while (rs.next()) {

        categoria = new ProductLine();
        categoria.setProductLine(rs.getString("productLine"));
        categoria.setTextDescription(rs.getString("textDescription"));
        categoria.setHtmlDescription(rs.getString("htmlDescription"));

        categoriasList.add(categoria);
      }
      DBConnection.close();
    } catch (SQLException e) {
      logger.error(e.getMessage());
      logger.error(Arrays.toString(e.getStackTrace()));
    }
    return categoriasList;
  }

  @Override
  public boolean updateProductLine(ProductLine productLine) {
    int resultado = 0;
    try {
      String sql =
          "UPDATE productlines productLine=?, textDescription=?, htmlDescription=? SET WHERE productLine = ?";
      PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
      statement.setString(1, productLine.getProductLine());
      statement.setString(2, productLine.getTextDescription());
      statement.setString(3, productLine.getHtmlDescription());
      statement.setString(4, productLine.getProductLine());

      resultado = statement.executeUpdate(sql);

      DBConnection.close();
    } catch (SQLException e) {
      logger.error(e.getMessage());
      logger.error(Arrays.toString(e.getStackTrace()));
    }
    return (resultado != 0);
  }

  @Override
  public boolean removeProductLine(String productLine) {
    int resultado = 0;
    try {
      String sql = "DELETE FROM productlines WHERE productLine = ?";
      PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
      statement.setString(1, productLine);

      resultado = statement.executeUpdate(sql);

      DBConnection.close();
    } catch (SQLException e) {
      logger.error(e.getMessage());
      logger.error(Arrays.toString(e.getStackTrace()));
    }
    return (resultado != 0);
  }

  @Override
  public boolean createProductLine(ProductLine productLine) {
    int resultado = 0;
    try {
      String sql = "INSERT INTO productlines VALUES(?,?,?,null)";
      PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
      statement.setString(1, productLine.getProductLine());
      statement.setString(2, productLine.getTextDescription());
      statement.setString(3, productLine.getHtmlDescription());

      resultado = statement.executeUpdate();

      DBConnection.close();
    } catch (SQLException e) {
      logger.error(e.getMessage());
      logger.error(Arrays.toString(e.getStackTrace()));
    }
    return (resultado != 0);
  }
}
