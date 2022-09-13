package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import modelo.ventasclientesDAO;
import modelo.ventasclientesDTO;

/**
 * Servlet implementation class consultageneralventas
 */
@WebServlet("/consultageneralventas")
public class consultageneralventas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public consultageneralventas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		ArrayList<ventasclientesDTO>lista=new ArrayList<ventasclientesDTO>();
		ventasclientesDAO vdao= new ventasclientesDAO();
		ventasclientesDTO vdto= new ventasclientesDTO();
		lista=vdao.consultasgeneralventas();
		Gson son=new Gson();
		out.print(son.toJson(lista));
	}

}
