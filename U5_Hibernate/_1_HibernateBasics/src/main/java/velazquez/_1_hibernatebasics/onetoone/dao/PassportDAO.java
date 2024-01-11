package velazquez._1_hibernatebasics.onetoone.dao;

import velazquez._1_hibernatebasics.onetoone.model.Passport;
import velazquez._1_hibernatebasics.utils.dao.GenericDAO;

public interface PassportDAO extends GenericDAO<Passport> {

  public Passport searchByNumber(final String number);

  // AQUÍ PODRíA TENER OTRAS OPERACIONES QUE FUERAN SOLO TÍPICAS DE ESTE MODELO
}
