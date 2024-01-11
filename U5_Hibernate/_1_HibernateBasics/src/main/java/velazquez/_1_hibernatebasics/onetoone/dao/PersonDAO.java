package velazquez._1_hibernatebasics.onetoone.dao;

import velazquez._1_hibernatebasics.onetoone.model.Person;
import velazquez._1_hibernatebasics.utils.dao.GenericDAO;

import java.util.List;

public interface PersonDAO extends GenericDAO<Person> {

  public List<Person> searchByFirstAndLastName(final String firstName, final String lastName);

  // AQUÍ PODRíA TENER OTRAS OPERACIONES QUE FUERAN SOLO TÍPICAS DE ESTE MODELO

}
