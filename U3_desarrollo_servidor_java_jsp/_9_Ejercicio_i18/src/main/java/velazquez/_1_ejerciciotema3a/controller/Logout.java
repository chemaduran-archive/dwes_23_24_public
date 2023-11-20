package velazquez._1_ejerciciotema3a.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	final static Logger logger = LoggerFactory.getLogger(Logout.class);

    public Logout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Destruyo la sesión
		request.getSession().invalidate();
		//Logeo que he salido de sesión
		logger.info("El usuario ha salido de sesión");
		//Vuelvo a la página principal de la aplicación
		//Deberá estar mapeado correctamente el Servlet en el web.xml
		response.sendRedirect(request.getContextPath());
	}

}
