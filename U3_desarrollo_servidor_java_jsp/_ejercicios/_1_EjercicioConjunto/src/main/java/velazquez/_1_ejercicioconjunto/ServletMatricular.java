package velazquez._1_ejercicioconjunto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/MatricularServlet")
public class ServletMatricular extends HttpServlet {

    static final Logger log = LoggerFactory.getLogger(SeleccionServlet.class);

    public void init(){}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando Get");
        HttpSession session = req.getSession();
        if (!session.isNew() && (boolean) session.getAttribute("LOGUEADO")) {
            log.info(session.getAttribute("matriculaBean").toString());
        } else {
            log.error("No se ha recibido la sesión adecuada");
            session.invalidate();
            resp.sendRedirect(req.getContextPath());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
