package velazquez._5_registrologin.dao;

import velazquez._5_registrologin.bd.DBConnection;
import velazquez._5_registrologin.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUsuarioImpl implements DAOUsuario {

  public DAOUsuarioImpl() {}

  @Override
  public Usuario getUsuario(String nombre) {

    Usuario usuario = null;

    try {
      String sql = "SELECT * FROM usuarios WHERE usuario=?";
      PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
      statement.setString(1, nombre);

      ResultSet rs = statement.executeQuery();
      // Como el campo de búsqueda es la clave solo debería obtener un resultado
      // si no es así estaremos machacando cada vez el valor de customer y
      while (rs.next()) {
        usuario = new Usuario();
        usuario.setUsuario(rs.getString("usuario"));
        usuario.setPassword(rs.getString("password"));
        usuario.setEmail(rs.getString("email"));
        usuario.setRole(rs.getString("role"));
      }
      DBConnection.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return usuario;
  }

  @Override
  public boolean registerUsuario(Usuario usuario) {
    int resultado = 0;

    try {
      String sql = "INSERT INTO usuarios VALUES(?,?,?,?)";
      PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
      statement.setString(1, usuario.getUsuario());
      statement.setString(2, usuario.getPassword());
      statement.setString(3, usuario.getEmail());
      statement.setString(4, usuario.getRole());

      resultado = statement.executeUpdate();

      DBConnection.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return (resultado != 0);
  }
}
