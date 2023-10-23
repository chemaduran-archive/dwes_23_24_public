package velazquez._0_holamundojsp;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

  public void init() {}

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {}

  public void destroy() {}
}
