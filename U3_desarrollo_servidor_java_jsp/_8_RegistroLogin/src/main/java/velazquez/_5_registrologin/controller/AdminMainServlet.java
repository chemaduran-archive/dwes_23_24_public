package velazquez._5_registrologin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._5_registrologin.dao.DAOPaymentImpl;
import velazquez._5_registrologin.model.Payment;

import java.io.IOException;
import java.util.ArrayList;

public class AdminMainServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public AdminMainServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    DAOPaymentImpl daoImpl = new DAOPaymentImpl();

    ArrayList<Payment> listaPagos = (ArrayList) daoImpl.getAllPayments();

    request.setAttribute("pagos", listaPagos);

    request.getRequestDispatcher("/WEB-INF/view/admin/index.jsp").forward(request, response);
  }
}
