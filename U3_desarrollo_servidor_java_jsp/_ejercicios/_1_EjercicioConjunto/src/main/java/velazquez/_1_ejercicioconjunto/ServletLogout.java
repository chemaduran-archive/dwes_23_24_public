package velazquez._1_ejercicioconjunto;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/ServletLogout")
public class ServletLogout extends HttpServlet {
    static final Logger log = LoggerFactory.getLogger(SeleccionServlet.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        log.info("Cerrando sesión");
        session.invalidate();
        response.sendRedirect(request.getContextPath());
    }

}
