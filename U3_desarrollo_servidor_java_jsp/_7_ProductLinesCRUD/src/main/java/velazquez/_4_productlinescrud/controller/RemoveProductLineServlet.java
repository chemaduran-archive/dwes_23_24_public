package velazquez._4_productlinescrud.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._4_productlinescrud.dao.DAOProductLineImpl;

public class RemoveProductLineServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public RemoveProductLineServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // ¿PUEDO BORRAR LA CATEGORÍA?
    String productLine = request.getParameter("pl");

    DAOProductLineImpl dao = new DAOProductLineImpl();

    // ¿Vale con intentar el borrado en una sola tabla?
    dao.removeProductLine(productLine);
  }
}
