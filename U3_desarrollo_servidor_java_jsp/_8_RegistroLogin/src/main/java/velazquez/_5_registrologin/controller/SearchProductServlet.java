package velazquez._5_registrologin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._5_registrologin.dao.DAOProduct;
import velazquez._5_registrologin.dao.DAOProductImpl;

import java.io.IOException;

@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public SearchProductServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("/WEB-INF/view/searchproduct.jsp").forward(request, response);
    ;
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String searchTerm = request.getParameter("busqueda");

    if (searchTerm != null) {
      DAOProduct dao = new DAOProductImpl();
      request.setAttribute("productos", dao.getProductSearch(searchTerm));
      doGet(request, response);
      return;
    }
    doGet(request, response);
  }
}
