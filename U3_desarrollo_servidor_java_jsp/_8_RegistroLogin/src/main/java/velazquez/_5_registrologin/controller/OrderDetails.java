package velazquez._5_registrologin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._5_registrologin.dao.DAOOrderImpl;
import velazquez._5_registrologin.model.Order;

import java.io.IOException;

@WebServlet("/OrderDetails")
public class OrderDetails extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public OrderDetails() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String orderNumber = request.getParameter("on");

    DAOOrderImpl dao = new DAOOrderImpl();

    if (orderNumber != null) {
      Order order = dao.getOrder(Integer.parseInt(orderNumber));
      request.setAttribute("pedido", order);
    }
    request.getRequestDispatcher("/WEB-INF/view/admin/orderdetails.jsp").forward(request, response);
  }
}
