package velazquez._entregable_filtros.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez._entregable_filtros.bd.ConexionBD;
import velazquez._entregable_filtros.controller.UpdateProduct;
import velazquez._entregable_filtros.models.Product;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOProductImpl implements DAOProduct {
  static final Logger logger = LoggerFactory.getLogger(DAOProductImpl.class);

  @Override
  public Product getProduct(String productCode) {
    Product product = null;
    try {
      String sql = "SELECT * FROM products WHERE productCode=?";
      PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
      statement.setString(1, productCode);

      ResultSet rs = statement.executeQuery();

      // Como el campo de búsqueda es la clave solo debería obtener un resultado
      // si no es así estaremos machacando cada vez el valor de customer y
      while (rs.next()) {

        product = new Product();
        product.setProductName(rs.getString("productName"));
        product.setProductCode(rs.getString("productCode"));
        product.setProductLine(rs.getString("productLine"));
        product.setProductScale(rs.getString("productScale"));
        product.setProductVendor(rs.getString("productVendor"));
        product.setProductDescription(rs.getString("productDescription"));
        product.setQuantityInStock(rs.getInt("quantityInStock"));
        product.setBuyPrice(rs.getDouble("buyPrice"));
        product.setMsrp(rs.getDouble("MSRP"));
      }
    } catch (SQLException ex) {
      logger.error(ex.getMessage());
    } finally {
      ConexionBD.close();
    }
    return product;
  }

  public String echo() {
    return "echo";
  }

  @Override
  public boolean updateProduct(Product product) {
    int resultado = 0;

    try {

      String sql =
          "UPDATE products SET productName= ?, productCode=?, productLine= ?, quantityInStock=?, buyPrice= ?  WHERE productCode = ?";
      PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
      statement.setString(1, product.getProductName());
      statement.setString(2, product.getProductCode());
      statement.setString(3, product.getProductLine());
      statement.setInt(4, product.getQuantityInStock());
      statement.setDouble(5, product.getBuyPrice());
      statement.setString(6, product.getProductCode());

      resultado = statement.executeUpdate();

      ConexionBD.close();

    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }

    return (resultado != 0);
  }

  @Override
  public boolean insertProduct(Product product) {
    return false;
  }

  @Override
  public ArrayList<Product> getAllProducts() {
    ArrayList<Product> productList = new ArrayList<>();
    Product product;

    try {

      String sql = "SELECT * FROM products";
      PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
      ResultSet rs = statement.executeQuery();

      while (rs.next()) {

        product = new Product();
        product.setProductName(rs.getString("productName"));
        product.setProductCode(rs.getString("productCode"));
        product.setProductLine(rs.getString("productLine"));
        product.setQuantityInStock(rs.getInt("quantityInStock"));
        product.setBuyPrice(rs.getDouble("buyPrice"));

        productList.add(product);
      }

      ConexionBD.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }

    return productList;
  }
}
