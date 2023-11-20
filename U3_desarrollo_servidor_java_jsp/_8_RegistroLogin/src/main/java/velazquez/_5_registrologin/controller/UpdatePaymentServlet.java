package velazquez._5_registrologin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._5_registrologin.dao.DAOCustomerImpl;
import velazquez._5_registrologin.dao.DAOPaymentImpl;
import velazquez._5_registrologin.model.Customer;
import velazquez._5_registrologin.model.Payment;

import java.io.IOException;
import java.util.ArrayList;

public class UpdatePaymentServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public UpdatePaymentServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Obtengo todo los clientes porque los pasaré para mostrarlos en un select

    // Obtengo también el pago correspondiente a los datos del enlace
    String customerNumber = request.getParameter("cn");
    String checkNumber = request.getParameter("checkn");

    if (customerNumber != null && checkNumber != null) {
      DAOPaymentImpl daoPaymentImpl = new DAOPaymentImpl();
      DAOCustomerImpl daoCustomerImpl = new DAOCustomerImpl();

      // Obtengo el Payment cuyos datos pasaré a la vista
      Payment payment = daoPaymentImpl.getPayment(Integer.parseInt(customerNumber), checkNumber);

      // Obtengo todos los clientes para mostrar los nombre en la vista de edición
      ArrayList<Customer> customers = daoCustomerImpl.getAllCustomers();

      // Pasamos la información a la vista
      request.setAttribute("pago", payment);
      request.setAttribute("customers", customers);

      request
          .getRequestDispatcher("/WEB-INF/view/admin/updatepayment.jsp")
          .forward(request, response);
    } else {
      response.sendRedirect("/Admin/");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}
}
