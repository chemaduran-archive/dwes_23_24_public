package velazquez._1_hibernatebasics.manytomany.dao;

import velazquez._1_hibernatebasics.manytomany.model.Teacher;
import velazquez._1_hibernatebasics.utils.dao.GenericDAO;

public interface TeacherDAO extends GenericDAO<Teacher> {

  public Teacher searchByNSS(final String nss);
}
