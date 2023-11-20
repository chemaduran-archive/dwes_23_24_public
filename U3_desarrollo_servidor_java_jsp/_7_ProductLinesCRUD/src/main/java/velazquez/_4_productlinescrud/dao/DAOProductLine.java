package velazquez._4_productlinescrud.dao;

import velazquez._4_productlinescrud.model.ProductLine;

import java.util.ArrayList;

public interface DAOProductLine {

  public ProductLine getProductLine(String productLine);

  public ArrayList<ProductLine> getAll();

  public boolean updateProductLine(ProductLine productLine);

  public boolean removeProductLine(String productLine);

  public boolean createProductLine(ProductLine productLine);
}
