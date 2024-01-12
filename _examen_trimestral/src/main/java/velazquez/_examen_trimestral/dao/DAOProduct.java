package velazquez._examen_trimestral.dao;

import velazquez._examen_trimestral.model.Product;

import java.util.ArrayList;

public interface DAOProduct {

  public ArrayList<Product> getAllProducts(String productLine);
}
