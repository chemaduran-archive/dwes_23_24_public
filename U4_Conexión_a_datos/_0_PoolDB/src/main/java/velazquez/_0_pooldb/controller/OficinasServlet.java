package velazquez._0_pooldb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._0_pooldb.dao.DAOOffice;
import velazquez._0_pooldb.dao.DAOOfficeImpl;
import velazquez._0_pooldb.model.Office;

import java.io.IOException;
import java.util.List;

public class OficinasServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public OficinasServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // Obtengo la lsita de oficinas usando el DAO
    DAOOffice dao = new DAOOfficeImpl();
    List<Office> oficinas = dao.getAllOffices();
    List<Office> oficinasContexto = dao.getAllOfficesContext();

    request.setAttribute("oficinas", oficinas);
    request.setAttribute("oficinasContexto", oficinasContexto);

    request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
  }
}
