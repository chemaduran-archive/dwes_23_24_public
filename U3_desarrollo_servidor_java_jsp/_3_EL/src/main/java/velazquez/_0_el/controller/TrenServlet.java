package velazquez._0_el.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._0_el.model.Maquinista;
import velazquez._0_el.model.Tren;
import velazquez._0_el.model.Vagon;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/TrenServlet")
public class TrenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TrenServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Maquinista maquinista = new Maquinista("Pepe","Perez","22222222X");
		ArrayList<Vagon> vagones = new ArrayList<>();
		Vagon v1 = new Vagon(1000,1600);
		Vagon v2 = new Vagon(2000,1700);
		Vagon v3 = new Vagon(3000,1800);
		Vagon v4 = new Vagon(4000,1900);
		Vagon v5 = new Vagon(5000,1500);
		
		vagones.add(v1);
		vagones.add(v2);
		vagones.add(v3);
		vagones.add(v4);
		vagones.add(v5);
		
		Tren tren = new Tren("AVE",maquinista,vagones);
		
		request.setAttribute("tren", tren);
		
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
	}

	

}
