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
import modelo.ClientesDTO;
import modelo.UsuariosDAO;
import modelo.UsuariosDTO;

/**
 * Servlet implementation class consultasgenerales
 */
@WebServlet("/consultasgenerales")
public class consultasgeneralesusuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public consultasgeneralesusuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		if (request.getParameter("usuario")!=null) {
			
		}
		ArrayList<UsuariosDTO>lista=new ArrayList<UsuariosDTO>();
		 UsuariosDAO usudao=new UsuariosDAO();
		 UsuariosDTO dto=new UsuariosDTO();
		 lista=usudao.consultageneralusuarios();
		 Gson json=new Gson();
		 out.print(json.toJson(lista));
	}

}
