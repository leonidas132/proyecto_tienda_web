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

import modelo.ClientesDAO;
import modelo.Clientes;

/**
 * Servlet implementation class consultasgeneralesclientes
 */
@WebServlet("/consultasgeneralesclientes")
public class consultasgeneralesclientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public consultasgeneralesclientes() {
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
		
		ArrayList<Clientes>lista=new ArrayList<Clientes>();
		ClientesDAO cidao=new ClientesDAO();
		Clientes dto=new Clientes();
		lista=cidao.consultageneralcliente();
		Gson gson=new Gson();
		out.print(gson.toJson(lista));
	
	}

}
