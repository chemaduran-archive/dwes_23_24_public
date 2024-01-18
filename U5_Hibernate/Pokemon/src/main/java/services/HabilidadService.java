package services;

import models.Habilidad;

import java.util.List;

public interface HabilidadService {

  public void insertNewHabilidad(final Habilidad habilidad);

  public Habilidad updateHabilidad(final Habilidad habilidad);

  public void deleteHabilidad(final Habilidad habilidad);

  public Habilidad searchById(final Long habilidadId);

  public Habilidad serchByNombre(final String nombre);

  public List<Habilidad> searchAll();
}
