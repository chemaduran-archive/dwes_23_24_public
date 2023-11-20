package velazquez._5_registrologin.dao;

import velazquez._5_registrologin.model.Product;

import java.util.ArrayList;

public interface DAOProduct {

  public Product getProduct(String productName);

  public Product getProductByCode(String code);

  public ArrayList<Product> getProductSearch(String searchTerm);
}
