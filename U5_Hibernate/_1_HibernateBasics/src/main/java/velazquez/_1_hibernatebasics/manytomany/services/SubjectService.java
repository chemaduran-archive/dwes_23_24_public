package velazquez._1_hibernatebasics.manytomany.services;

import velazquez._1_hibernatebasics.manytomany.model.Subject;

import java.util.List;

public interface SubjectService {

  public void insertNewSubject(final Subject subject);

  public void updateSubject(final Subject subject);

  public void deleteSubject(final Subject subject);

  public Subject searchById(final Long subjectId);

  public List<Subject> searchAll();

  public Subject searchSubjectByNname(final String name);
}
