package velazquez._3_jstl_editarclientes.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._3_jstl_editarclientes.dao.DAOPaymentImpl;
import velazquez._3_jstl_editarclientes.model.PaymentBean;

@WebServlet("/ListPayments")
public class ListPayments extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ListPayments() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    DAOPaymentImpl daoImpl = new DAOPaymentImpl();
    ArrayList<PaymentBean> listaPagos = (ArrayList<PaymentBean>) daoImpl.getAllPayments();
    request.setAttribute("pagos", listaPagos);
    request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
  }
}
