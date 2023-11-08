package velazquez._1_ejercicioconjunto;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "ServletPrincipal")
public class ServletPrincipal extends HttpServlet {

    static final Logger log = LoggerFactory.getLogger(ServletPrincipal.class);

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("Realizando Get");
        request.getRequestDispatcher("botonEntrar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Ejecutando Post");
        log.info("VALOR DEL ATRIBUTO boton_entrar " +req.getParameter("boton_entrar"));
        if(req.getParameter("boton_entrar").equals("Entrar")){
            HttpSession session = req.getSession();
            session.setAttribute("LOGUEADO", true);
        } else {
            log.error("Se ha recibido un parámetro erróneo");
        }
        resp.sendRedirect(req.getContextPath()+"/SeleccionServlet");
    }

    public void destroy() {
    }
}