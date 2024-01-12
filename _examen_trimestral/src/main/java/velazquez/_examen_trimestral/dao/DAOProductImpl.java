package velazquez._examen_trimestral.dao;

import velazquez._examen_trimestral.bd.PoolDB;
import velazquez._examen_trimestral.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOProductImpl implements DAOProduct {

  @Override
  public ArrayList<Product> getAllProducts(String productLine) {

    ArrayList<Product> products = new ArrayList<Product>();
    Product product = null;
    PoolDB pool = new PoolDB();
    Connection con = pool.getConnection();

    try {

      String sql = "SELECT * FROM products WHERE productLine=?";
      PreparedStatement statement = con.prepareStatement(sql);
      statement.setString(1, productLine);

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

        products.add(product);
      }
      con.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }

    return products;
  }
}
