package velazquez._entregable_filtros.dao;

import velazquez._entregable_filtros.models.Product;

import java.util.ArrayList;

public interface DAOProduct {
	
	public Product getProduct(String productCode);
	public boolean updateProduct(Product product);
	public boolean insertProduct(Product product);
	public ArrayList<Product> getAllProducts();

}
