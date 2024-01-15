package services;

import models.Categoria;

import java.util.List;

public interface CategoriaService {
  public void insertNewCategoria(final Categoria categoria);

  public Categoria updateCategoria(final Categoria categoria);

  public void deleteCategoria(final Categoria categoria);

  public Categoria searchById(final Long categoriaId);

  public Categoria serchByNombre(final String nombre);

  public List<Categoria> searchAll();

}
