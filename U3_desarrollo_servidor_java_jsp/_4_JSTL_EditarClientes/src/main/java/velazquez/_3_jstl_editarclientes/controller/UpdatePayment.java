package velazquez._3_jstl_editarclientes.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._3_jstl_editarclientes.dao.DAOPaymentImpl;
import velazquez._3_jstl_editarclientes.model.PaymentBean;

import java.io.IOException;



/**
 * Servlet implementation class UpdatePayment
 */
@WebServlet("/UpdatePayment")
public class UpdatePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String checkNumber = request.getParameter("checkn");
		int customerNumber = Integer.parseInt(request.getParameter("cn"));
		
		DAOPaymentImpl daoImpl = new DAOPaymentImpl();
		
		PaymentBean payment = daoImpl.getPayment(customerNumber, checkNumber);
		
		request.setAttribute("pago", payment);
		
		request.getRequestDispatcher("WEB-INF/view/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String checkNumber = request.getParameter("checkn");
		int customerNumber = Integer.parseInt(request.getParameter("cn"));
		String date = request.getParameter("date");
		Double amount  = Double.parseDouble(request.getParameter("amount"));
		
		if (checkNumber!=null && customerNumber!=0 && date!=null && amount!=0.0) {
			
			PaymentBean payment = new PaymentBean(customerNumber,checkNumber,date,amount);
			
			DAOPaymentImpl daoImpl = new DAOPaymentImpl();
			
			daoImpl.updatePayment(payment);
		}
		
		response.sendRedirect(request.getContextPath());
	}

}
