package velazquez._1_hibernatebasics.manytomany.services;

import velazquez._1_hibernatebasics.manytomany.model.Product;

import java.util.List;

public interface ProductService {

  public void insertNewProduct(final Product product);

  public void updateProduct(final Product product);

  public void deleteProduct(final Product product);

  public Product searchById(final Long productId);

  public List<Product> searchAll();

  public Product searchProductByBarCode(final String barCode);
}
