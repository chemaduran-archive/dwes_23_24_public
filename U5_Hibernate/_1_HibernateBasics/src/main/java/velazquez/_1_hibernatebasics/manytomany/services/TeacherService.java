package velazquez._1_hibernatebasics.manytomany.services;

import velazquez._1_hibernatebasics.manytomany.model.Teacher;

import java.util.List;

public interface TeacherService {

  public void insertNewTeacher(final Teacher teacher);

  public void updateTeacher(final Teacher teacher);

  public void deleteTeacher(final Teacher teacher);

  public Teacher searchById(final Long teacherId);

  public List<Teacher> searchAll();

  public Teacher searchTeacherByNSS(final String nss);
}
