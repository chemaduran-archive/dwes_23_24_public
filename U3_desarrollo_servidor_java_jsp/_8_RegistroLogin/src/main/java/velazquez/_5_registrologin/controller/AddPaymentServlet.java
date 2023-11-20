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

public class AddPaymentServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public AddPaymentServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Obtengo los datos de todos los clientes para pasarlo a la vista y
    // mostrarlos en el select como opciones
    DAOCustomerImpl daoImpl = new DAOCustomerImpl();
    ArrayList<Customer> customers = daoImpl.getAllCustomers();

    // Lo añado a la petición que se le pasa a la vista
    request.setAttribute("customers", customers);
    request.getRequestDispatcher("/WEB-INF/view/admin/addpayment.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Obtengo los parámetros
    String customerNumber = request.getParameter("customerNumber");
    String checkNumber = request.getParameter("checkNumber");
    String date = request.getParameter("paymentDate");
    String amount = request.getParameter("amount");

    if (customerNumber != null && checkNumber != null && date != null && amount != null) {
      Payment payment =
          new Payment(
              Integer.parseInt(customerNumber), checkNumber, date, Double.parseDouble(amount));
      DAOPaymentImpl dao = new DAOPaymentImpl();
      dao.insertPayment(payment);
    }
    response.sendRedirect(request.getContextPath() + "/Admin/");
  }
}
