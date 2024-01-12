package velazquez._entregable_filtros.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez._entregable_filtros.dao.DAOOfficeImpl;
import velazquez._entregable_filtros.models.Office;

import java.io.IOException;
import java.util.List;

@WebServlet("/Oficinas")
public class OficinasServlet extends HttpServlet {

  static final Logger logger = LoggerFactory.getLogger(OficinasServlet.class);

  public OficinasServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    logger.info("doGet()");
    DAOOfficeImpl OfficeDAO = new DAOOfficeImpl();
    List<Office> listado_oficinas = OfficeDAO.getAllOffices();

    req.setAttribute("listado_oficinas", listado_oficinas);

    req.getRequestDispatcher("/WEB-INF/view/usuario/offices.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String officeCode = req.getParameter("oficinas");
    logger.info("doPost() officeCode: " + officeCode);

    DAOOfficeImpl OfficeDAO = new DAOOfficeImpl();

    Office office = OfficeDAO.getOffice(officeCode);
    logger.info("doPost() office: " + office);

    List<Office> listado_oficinas = OfficeDAO.getAllOffices();

    req.setAttribute("listado_oficinas", listado_oficinas);
    req.setAttribute("oficina", office);
    req.getRequestDispatcher("/WEB-INF/view/usuario/offices.jsp").forward(req, resp);
  }
}
