package velazquez._examen_trimestral.dao;

import velazquez._examen_trimestral.bd.PoolDB;
import velazquez._examen_trimestral.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

public class DAOUsuarioImpl implements DAOUsuario {

  @Override
  public boolean registerUsuario(Usuario usuario) {
    int resultado = 0;
    PoolDB pool = new PoolDB();
    Connection con = pool.getConnection();
    try {

      String sql = "INSERT INTO usuarios VALUES (?,?,?,?,?,?)";
      PreparedStatement statement = con.prepareStatement(sql);
      statement.setString(1, usuario.getUsuario());
      statement.setString(2, usuario.getEmail());
      statement.setString(3, usuario.getPassword());
      statement.setString(4, usuario.getFirstName());
      statement.setString(5, usuario.getLastName());
      statement.setString(6, usuario.getRole());

      resultado = statement.executeUpdate();

      con.close();

    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }

    return (resultado != 0);
  }

  @Override
  public Usuario getUsuario(String email) {
    Usuario usuario = null;
    PoolDB pool = new PoolDB();
    Connection con = pool.getConnection();

    try {

      String sql = "SELECT * FROM usuarios WHERE email=?";
      PreparedStatement statement = con.prepareStatement(sql);
      statement.setString(1, email);

      ResultSet rs = statement.executeQuery();

      // Como el campo de búsqueda es la clave solo debería obtener un resultado
      // si no es así estaremos machacando cada vez el valor de customer y
      while (rs.next()) {

        usuario = new Usuario();
        usuario.setUsuario(rs.getString("usuario"));
        usuario.setPassword(rs.getString("password"));
        usuario.setEmail(rs.getString("email"));
        usuario.setFirstName(rs.getString("firstName"));
        usuario.setLastName(rs.getString("lastName"));
        usuario.setRole(rs.getString("role"));
      }

      con.close();

    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }

    return usuario;
  }
}
