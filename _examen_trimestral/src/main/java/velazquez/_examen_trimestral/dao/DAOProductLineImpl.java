package velazquez._examen_trimestral.dao;

import velazquez._examen_trimestral.bd.PoolDB;
import velazquez._examen_trimestral.model.ProductLine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOProductLineImpl implements DAOProductLine {

  @Override
  public ArrayList<ProductLine> getAll() {
    ArrayList<ProductLine> categoriasList = new ArrayList<>();
    ProductLine categoria;
    PoolDB pool = new PoolDB();
    Connection con = pool.getConnection();

    try {

      String sql = "SELECT * FROM productlines";
      PreparedStatement statement = con.prepareStatement(sql);
      ResultSet rs = statement.executeQuery();

      while (rs.next()) {

        categoria = new ProductLine();
        categoria.setProductLine(rs.getString("productLine"));
        categoria.setTextDescription(rs.getString("textDescription"));
        categoria.setHtmlDescription(rs.getString("htmlDescription"));

        categoriasList.add(categoria);
      }

      con.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }

    return categoriasList;
  }
}
