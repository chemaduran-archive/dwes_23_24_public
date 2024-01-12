package velazquez._entregable_filtros.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez._entregable_filtros.dao.DAOProductImpl;
import velazquez._entregable_filtros.dao.DAOProductLine;
import velazquez._entregable_filtros.dao.DAOProductLineImpl;
import velazquez._entregable_filtros.models.Product;

import java.io.IOException;

@WebServlet("/Admin/EditarProduct")
public class UpdateProduct extends HttpServlet {
  static final Logger logger = LoggerFactory.getLogger(UpdateProduct.class);
  private static final long serialVersionUID = 1L;

  public UpdateProduct() {
    super();
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String productCode = req.getParameter("pc");
    logger.info("doGet() " + productCode);
    DAOProductImpl daoImpl = new DAOProductImpl();
    Product product = daoImpl.getProduct(productCode);
    logger.info("doGet() " + product);
    req.setAttribute("producto", product);

    DAOProductLine daoProductLine = new DAOProductLineImpl();
    req.setAttribute("productLines", daoProductLine.getAllProductLines());

    req.getRequestDispatcher("/WEB-INF/view/admin/editproduct.jsp").forward(req, resp);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String productName = request.getParameter("productName");
    String productCode = request.getParameter("productCode");
    String productLine = request.getParameter("productLine");
    int quantityInStock = Integer.parseInt(request.getParameter("quantityInStock"));
    double buyPrice = Double.parseDouble(request.getParameter("buyPrice"));

    if (productName != null
        && productCode != null
        && productLine != null
        && quantityInStock != 0
        && buyPrice != 0.0) {

      Product product = new Product();

      product.setProductName(productName);
      product.setProductCode(productCode);
      product.setProductLine(productLine);
      product.setQuantityInStock(quantityInStock);
      product.setBuyPrice(buyPrice);

      DAOProductImpl daoImpl = new DAOProductImpl();

      if (daoImpl.updateProduct(product)) {
        logger.info(product.getProductCode() + " modificado correctamente");
      } else {
        logger.info(product.getProductCode() + ": Modificación no realizada");
      }
    }

    response.sendRedirect(request.getContextPath() + "/Admin/Inicio");
  }
}
