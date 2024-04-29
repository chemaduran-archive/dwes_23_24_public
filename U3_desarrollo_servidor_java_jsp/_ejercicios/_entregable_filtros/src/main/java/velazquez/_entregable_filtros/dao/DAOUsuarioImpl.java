package velazquez._entregable_filtros.dao;

import velazquez._entregable_filtros.bd.ConexionBD;
import velazquez._entregable_filtros.models.Usuario;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUsuarioImpl implements DAOUsuario {

  @Override
  public Usuario getUsuario(String nombre) {

    Usuario usuario = null;

    try {
      String sql = "SELECT * FROM usuarios_modificada WHERE usuario=?";
      PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
      statement.setString(1, nombre);

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

      ConexionBD.close();

    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }

    return usuario;
  }

  @Override
  public boolean registerUsuario(Usuario usuario) {
    int resultado = 0;

    try {

      String sql = "INSERT INTO usuarios_modificada VALUES (?,?,?,?,?,?)";
      PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
      statement.setString(1, usuario.getUsuario());
      statement.setString(2, usuario.getFirstName());
      statement.setString(3, usuario.getLastName());
      statement.setString(4, usuario.getPassword());
      statement.setString(5, usuario.getEmail());
      statement.setString(6, usuario.getRole());


      resultado = statement.executeUpdate();

      ConexionBD.close();

    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }

    return (resultado != 0);
  }

  @Override
  public ArrayList<Usuario> getAllUsers() {
    return null;
  }

  @Override
  public boolean updateUser(Usuario user) {
    return false;
  }

  @Override
  public boolean insertUser(Usuario user) {
    int resultado = 0;

    try {

      String sql = "INSERT INTO usuarios VALUES (?,?,?,?,?,?)";
      PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
      statement.setString(1, user.getUsuario());
      statement.setString(2, user.getEmail());
      statement.setString(3, user.getPassword());
      statement.setString(4, user.getFirstName());
      statement.setString(5, user.getLastName());
      statement.setString(6, user.getRole());

      resultado = statement.executeUpdate();

      ConexionBD.close();

    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }

    return (resultado != 0);
  }

  @Override
  public boolean changePassword(Usuario user, String password) {
    return false;
  }
}
