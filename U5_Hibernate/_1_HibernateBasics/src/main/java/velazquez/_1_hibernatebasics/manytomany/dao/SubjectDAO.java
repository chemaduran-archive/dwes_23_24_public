package velazquez._1_hibernatebasics.manytomany.dao;

import velazquez._1_hibernatebasics.manytomany.model.Subject;
import velazquez._1_hibernatebasics.utils.dao.GenericDAO;

public interface SubjectDAO extends GenericDAO<Subject> {

  public Subject searchByName(final String name);
}
