package velazquez._entregable_filtros.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez._entregable_filtros.dao.DAOProductImpl;
import velazquez._entregable_filtros.models.Product;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Admin/Inicio")
public class AdminInicioServlet extends HttpServlet {
  static final Logger logger = LoggerFactory.getLogger(AdminInicioServlet.class);
  private static final long serialVersionUID = 1L;

  public AdminInicioServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    logger.info("doGet()");
    DAOProductImpl daoProduct = new DAOProductImpl();

    ArrayList<Product> listaProductos = daoProduct.getAllProducts();
    request.setAttribute("productos", listaProductos);

    request.getRequestDispatcher("/WEB-INF/view/admin/products.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    logger.info("doPost()");
    doGet(request, response);
  }
}
