package dao;

import java.util.List;

import model.Sede;
import org.hibernate.Session;
import utils.dao.GenericDAOImpl;

public class SedeDAOImpl extends GenericDAOImpl<Sede> implements SedeDAO {

  public SedeDAOImpl(Session session) {
    super(session);
  }
}
