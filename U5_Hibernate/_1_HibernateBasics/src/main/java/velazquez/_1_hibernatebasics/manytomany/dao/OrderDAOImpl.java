package velazquez._1_hibernatebasics.manytomany.dao;

import java.util.List;

import org.hibernate.Session;
import velazquez._1_hibernatebasics.manytomany.model.Order;
import velazquez._1_hibernatebasics.utils.dao.GenericDAOImpl;

public class OrderDAOImpl extends GenericDAOImpl<Order> implements OrderDAO {

  private Session session;

  public OrderDAOImpl(Session session) {
    super(session);
    this.session = session;
  }
}
