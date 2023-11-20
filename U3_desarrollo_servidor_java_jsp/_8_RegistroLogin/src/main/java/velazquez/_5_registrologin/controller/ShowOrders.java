package velazquez._5_registrologin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._5_registrologin.dao.DAOOrderImpl;

import java.io.IOException;

@WebServlet("/ShowOrders")
public class ShowOrders extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ShowOrders() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    DAOOrderImpl dao = new DAOOrderImpl();
    request.setAttribute("pedidos", dao.getAllOrders());
    request.getRequestDispatcher("/WEB-INF/view/admin/orders.jsp").forward(request, response);
  }
}
