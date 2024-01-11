package velazquez._1_hibernatebasics.onetoone.dao;

import java.util.List;

import org.hibernate.Session;
import velazquez._1_hibernatebasics.onetoone.model.Passport;
import velazquez._1_hibernatebasics.utils.dao.GenericDAOImpl;

public class PassportDAOImpl extends GenericDAOImpl<Passport> implements PassportDAO {

  private Session session;

  public PassportDAOImpl(Session session) {
    super(session);
  }

  @Override
  public Passport searchByNumber(final String number) {

    // Compruebo que la conexión está abierta
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    // Recupero el passaporte atendiendo al número.
    final List<Passport> passportList =
        session.createQuery("FROM Passport WHERE number =" + number).list();

    // Compruebo si he tenido valores y si en caso afirmativo solo
    // devuelvo el primero ya que supondremos que solo puede haber un pasaporte por
    Passport passport = null;
    if (passportList != null && !passportList.isEmpty()) {
      passport = passportList.get(0);
    }

    return passport;
  }
}
