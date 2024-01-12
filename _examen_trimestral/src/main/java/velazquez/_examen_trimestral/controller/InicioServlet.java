package velazquez._examen_trimestral.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import velazquez._examen_trimestral.dao.DAOProductLineImpl;
import velazquez._examen_trimestral.model.ProductLine;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/InicioServlet")
public class InicioServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public InicioServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession sesion = request.getSession();
    String role = (String) sesion.getAttribute("role");
    DAOProductLineImpl productlineDAO = new DAOProductLineImpl();
    ArrayList<ProductLine> productLineList = productlineDAO.getAll();

    request.setAttribute("role", role);
    request.setAttribute("productLineList", productLineList);
    request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
