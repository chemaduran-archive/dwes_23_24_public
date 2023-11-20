package velazquez._4_productlinescrud.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._4_productlinescrud.dao.DAOProductLineImpl;
import velazquez._4_productlinescrud.model.ProductLine;

import java.io.IOException;
import java.util.ArrayList;

public class ProductLinesServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ProductLinesServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // Obtengo desde la base de datos y través del DAO todos los productlines
    DAOProductLineImpl dao = new DAOProductLineImpl();
    ArrayList<ProductLine> categorias = dao.getAll();

    request.setAttribute("categorias", categorias);

    request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
  }
}
