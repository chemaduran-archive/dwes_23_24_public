package velazquez._1_hibernatebasics.manytomany;

import java.util.Calendar;

import org.hibernate.Session;
import velazquez._1_hibernatebasics.manytomany.model.Order;
import velazquez._1_hibernatebasics.manytomany.model.Product;
import velazquez._1_hibernatebasics.manytomany.services.OrderService;
import velazquez._1_hibernatebasics.manytomany.services.OrderServiceImpl;
import velazquez._1_hibernatebasics.manytomany.services.ProductService;
import velazquez._1_hibernatebasics.manytomany.services.ProductServiceImpl;
import velazquez._1_hibernatebasics.utils.HibernateUtils;

public class MainManyToManyAttributes {

  public static void main(String[] args) {

    // Para trabajar con las fechas
    Calendar calendar = Calendar.getInstance();

    // Creo la sesión
    Session session = HibernateUtils.getSessionFactory().openSession();

    // Creo los servicios definidos
    OrderService orderService = new OrderServiceImpl(session);
    ProductService productService = new ProductServiceImpl(session);

    // Creo los productos
    Product p1 = new Product();
    p1.setName("Pera");
    p1.setPrice(1.5);
    p1.setBarCode("2222222");

    Product p2 = new Product();
    p2.setName("Manzana");
    p2.setPrice(1.10);
    p2.setBarCode("333333");

    Product p3 = new Product();
    p3.setName("Lechuga");
    p3.setPrice(0.5);
    p3.setBarCode("4444");

    // Creo los pedidos
    Order o1 = new Order();
    o1.setCustomer("Manolo");
    calendar.set(Calendar.YEAR, 2022);
    calendar.set(Calendar.MONTH, 1);
    calendar.set(Calendar.DAY_OF_MONTH, 15);
    o1.setOrderDate(calendar.getTime());

    Order o2 = new Order();
    o2.setCustomer("Ana");
    calendar.set(Calendar.YEAR, 2022);
    calendar.set(Calendar.MONTH, 1);
    calendar.set(Calendar.DAY_OF_MONTH, 10);
    o2.setOrderDate(calendar.getTime());

    // Persistimos los productos antes de añadirlos a los distintos pedidos
    productService.insertNewProduct(p1);
    productService.insertNewProduct(p2);
    productService.insertNewProduct(p3);

    // Persistimos los pedidos
    orderService.insertNewOrder(o1);
    orderService.insertNewOrder(o2);

    // Añadimos dichos productos a los pedidos
    // Tengo que haber persistido los pedidos ya que hace falta ID
    // para que se añadan a la tabla de la relación
    o1.addProduct(p1, 5);
    o1.addProduct(p2, 10);

    o2.addProduct(p3, 2);
    o2.addProduct(p1, 4);

    // Actualizo los pedidos
    orderService.updateOrder(o1);
    orderService.updateOrder(o2);

    session.close();
  }
}
