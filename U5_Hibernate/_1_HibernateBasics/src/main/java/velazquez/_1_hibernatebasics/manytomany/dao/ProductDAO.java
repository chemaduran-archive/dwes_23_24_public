package velazquez._1_hibernatebasics.manytomany.dao;

import velazquez._1_hibernatebasics.manytomany.model.Product;
import velazquez._1_hibernatebasics.utils.dao.GenericDAO;

public interface ProductDAO extends GenericDAO<Product> {

  public Product searchByBarCode(final String barCode);
}
