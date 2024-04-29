package velazquez._entregable_filtros.dao;

import velazquez._entregable_filtros.models.Usuario;

import java.util.ArrayList;


public interface DAOUsuario {
	public ArrayList<Usuario> getAllUsers();
	public boolean updateUser(Usuario user);
	public boolean insertUser(Usuario user);
	public boolean changePassword(Usuario user, String password);
	public Usuario getUsuario(String nombre);
	public boolean registerUsuario(Usuario usuario);
}
