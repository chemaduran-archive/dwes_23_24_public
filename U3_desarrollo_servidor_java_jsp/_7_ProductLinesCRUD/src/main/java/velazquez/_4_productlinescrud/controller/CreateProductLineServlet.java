package velazquez._4_productlinescrud.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._4_productlinescrud.dao.DAOProductLineImpl;
import velazquez._4_productlinescrud.model.ProductLine;

import java.io.IOException;

public class CreateProductLineServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public CreateProductLineServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("/WEB-INF/view/create.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String categoria = request.getParameter("productLine");
    String texto = request.getParameter("textDescription");
    String html = request.getParameter("htmlDescription");

    if (categoria != null && texto != null && html != null) {
      DAOProductLineImpl dao = new DAOProductLineImpl();
      if (dao.getProductLine(categoria) == null) {
        ProductLine pl = new ProductLine(categoria, texto, html);
        dao.createProductLine(pl);
        response.sendRedirect(request.getContextPath());
      } else {
        request.setAttribute("error", "Categoría ya existente");
        request.setAttribute("categoria", categoria);
        request.setAttribute("texto", texto);
        request.setAttribute("html", html);
        doGet(request, response);
      }
    }
  }
}
