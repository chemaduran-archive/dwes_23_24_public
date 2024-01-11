package velazquez._1_hibernatebasics.manytomany;

import java.util.Calendar;

import org.hibernate.Session;
import velazquez._1_hibernatebasics.manytomany.model.Subject;
import velazquez._1_hibernatebasics.manytomany.model.Teacher;
import velazquez._1_hibernatebasics.manytomany.services.SubjectService;
import velazquez._1_hibernatebasics.manytomany.services.SubjectServiceImpl;
import velazquez._1_hibernatebasics.manytomany.services.TeacherService;
import velazquez._1_hibernatebasics.manytomany.services.TeacherServiceImpl;
import velazquez._1_hibernatebasics.utils.HibernateUtils;

public class MainManyToMany {

  public static void main(String[] args) {

    // Para trabajar con las fechas
    Calendar calendar = Calendar.getInstance();

    // Creo la sesión
    Session session = HibernateUtils.getSessionFactory().openSession();

    // Creo los servicios definidos
    TeacherService teacherService = new TeacherServiceImpl(session);
    SubjectService subjectService = new SubjectServiceImpl(session);

    // Creo las asignaturas
    Subject lm = new Subject();
    lm.setName("LM");
    lm.setWeekHours(4);

    Subject gbd = new Subject();
    gbd.setName("Gbd");
    gbd.setWeekHours(6);

    Subject prog = new Subject();
    prog.setName("Prog");
    prog.setWeekHours(8);

    // Creo los profesores
    Teacher t1 = new Teacher();
    t1.setFirstName("John");
    t1.setLastName("Doe");
    t1.setNSS("11111111111");
    calendar.set(Calendar.YEAR, 1976);
    calendar.set(Calendar.MONTH, 5);
    calendar.set(Calendar.DAY_OF_MONTH, 13);
    t1.setDateOfBirth(calendar.getTime());

    Teacher t2 = new Teacher();
    t2.setFirstName("Ann");
    t2.setLastName("Smith");
    t2.setNSS("2222222");
    calendar.set(Calendar.YEAR, 1966);
    calendar.set(Calendar.MONTH, 8);
    calendar.set(Calendar.DAY_OF_MONTH, 13);
    t2.setDateOfBirth(calendar.getTime());

    Teacher t3 = new Teacher();
    t3.setFirstName("Anthony");
    t3.setLastName("Gordon");
    t3.setNSS("333333");
    calendar.set(Calendar.YEAR, 1985);
    calendar.set(Calendar.MONTH, 1);
    calendar.set(Calendar.DAY_OF_MONTH, 13);
    t3.setDateOfBirth(calendar.getTime());

    Teacher t4 = new Teacher();
    t4.setFirstName("Lina");
    t4.setLastName("Chastain");
    t4.setNSS("666666666666");
    calendar.set(Calendar.YEAR, 1956);
    calendar.set(Calendar.MONTH, 11);
    calendar.set(Calendar.DAY_OF_MONTH, 20);
    t4.setDateOfBirth(calendar.getTime());

    Teacher t5 = new Teacher();
    t5.setFirstName("Steve");
    t5.setLastName("Soprano");
    t5.setNSS("999999999999999");
    calendar.set(Calendar.YEAR, 2000);
    calendar.set(Calendar.MONTH, 9);
    calendar.set(Calendar.DAY_OF_MONTH, 13);
    t5.setDateOfBirth(calendar.getTime());

    // Persistimos los profesores
    teacherService.insertNewTeacher(t1);
    teacherService.insertNewTeacher(t2);
    teacherService.insertNewTeacher(t3);
    teacherService.insertNewTeacher(t4);
    teacherService.insertNewTeacher(t5);

    // Persisto las asignaturas
    subjectService.insertNewSubject(lm);
    subjectService.insertNewSubject(gbd);
    subjectService.insertNewSubject(prog);

    // Añado los profesores a las asignturas
    lm.addTeacher(t1);
    lm.addTeacher(t2);

    gbd.addTeacher(t3);
    gbd.addTeacher(t4);

    prog.addTeacher(t5);

    // Actualizo una vez hemos añadido las asignaturas
    subjectService.updateSubject(lm);
    subjectService.updateSubject(gbd);
    subjectService.updateSubject(prog);

    // Cerramos la sesión
    session.close();
  }
}
