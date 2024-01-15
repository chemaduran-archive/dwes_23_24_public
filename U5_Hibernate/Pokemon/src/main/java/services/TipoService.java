package services;

import models.Tipo;

import java.util.List;

public interface TipoService {
  public void insertNewTipo(final Tipo tipo);

  public Tipo updateTipo(final Tipo tipo);

  public void deleteTipo(final Tipo tipo);

  public Tipo searchById(final Long tipoId);

  public Tipo serchByNombre(final String nombre);

  public List<Tipo> searchAll();

}
