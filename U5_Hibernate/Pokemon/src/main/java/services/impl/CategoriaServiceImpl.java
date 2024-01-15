package services.impl;

import java.util.List;

import dao.impl.CategoriaDAOImpl;
import models.Categoria;
import org.hibernate.Session;

import services.CategoriaService;
import dao.CategoriaDAO;

public class CategoriaServiceImpl implements CategoriaService {

  CategoriaDAO categoriaDAO;

  public CategoriaServiceImpl(Session session) {
    categoriaDAO = new CategoriaDAOImpl(session);
  }

  @Override
  public void insertNewCategoria(Categoria categoria) {
    if (categoria != null && categoria.getId() == null) {
      categoriaDAO.insert(categoria);
    }
  }

  @Override
  public Categoria updateCategoria(Categoria categoria) {
    Categoria categoriaUpdated = null;
    if (categoria != null && categoria.getId() != null) {
      categoriaUpdated = categoriaDAO.update(categoria);
    }
    return categoriaUpdated;
  }

  @Override
  public void deleteCategoria(Categoria categoria) {
    if (categoria != null && categoria.getId() != null) {
      categoriaDAO.delete(categoria);
    }
  }

  @Override
  public Categoria searchById(Long postId) {
    if (postId != null) {
      return categoriaDAO.searchById(postId);
    }
    return null;
  }

  @Override
  public Categoria serchByNombre(final String nombre) {
    if (nombre != null) {
      return categoriaDAO.searchByName(nombre);
    }
    return null;
  }

  @Override
  public List<Categoria> searchAll() {
    return categoriaDAO.searchAll();
  }
}
