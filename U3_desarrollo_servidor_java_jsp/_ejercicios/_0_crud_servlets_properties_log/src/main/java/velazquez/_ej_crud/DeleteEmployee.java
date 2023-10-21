package velazquez._ej_crud;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "delete-employee", value = "/crud/delete-employee")
public class DeleteEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf8");

        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<title>Delete Employee</title>");
        out.println("<h1>Delete Employee</h1>");
        out.println("<form action=\"delete-employee\" method=\"POST\">");
        out.println("<input id=\"id\" type=\"text\">");
        out.println("<button type=\"submit\">Submit</button>");
        out.println("</form>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
