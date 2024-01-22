package services;

import model.Sede;

import java.util.List;

public interface SedeService {

  public void insertNewSede(final Sede sede);

  public void updateSede(final Sede sede);

  public void deleteSede(final Sede sede);

  public Sede searchById(final Long sedeId);

  public List<Sede> searchAll();
}
