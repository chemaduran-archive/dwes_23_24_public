package velazquez._examen_trimestral.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._examen_trimestral.dao.DAOProductImpl;
import velazquez._examen_trimestral.model.Product;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/MostrarProductosServlet")
public class MostrarProductosServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public MostrarProductosServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String productLine = request.getParameter("pl");
    if (productLine != null) {
      DAOProductImpl productDao = new DAOProductImpl();

      ArrayList<Product> productos = productDao.getAllProducts(productLine);
      request.setAttribute("productos", productos);
      request.setAttribute("productLine", productLine);
      request.getRequestDispatcher("/WEB-INF/view/mostrarproductos.jsp").forward(request, response);
    } else {
      request.setAttribute("error", "Categoría NO SELECCIONADA");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
