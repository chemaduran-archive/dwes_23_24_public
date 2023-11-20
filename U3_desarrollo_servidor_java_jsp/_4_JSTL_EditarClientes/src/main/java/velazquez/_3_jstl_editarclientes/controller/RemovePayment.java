package velazquez._3_jstl_editarclientes.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._3_jstl_editarclientes.dao.DAOPaymentImpl;

import java.io.IOException;

@WebServlet("/RemovePayment")
public class RemovePayment extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public RemovePayment() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String checkNumber = request.getParameter("checkn");
    int customerNumber = Integer.parseInt(request.getParameter("cn"));
    DAOPaymentImpl daoImpl = new DAOPaymentImpl();

    if (checkNumber != null && customerNumber != 0) {
      daoImpl.removePayment(customerNumber, checkNumber);
    }
    response.sendRedirect(request.getContextPath());
  }
}
