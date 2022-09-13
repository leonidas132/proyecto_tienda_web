package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import modelo.ProductosDAO;
import modelo.ProductosDTO;
import modelo.UsuariosDAO;
import modelo.UsuariosDTO;

/**
 * Servlet implementation class Ingresar
 */
@WebServlet("/Ingresar")
public class Ingresar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ingresar() {
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
		HttpSession sesion=request.getSession();
		String usuario,clave;
		
		usuario=request.getParameter("userId");
		clave=request.getParameter("contra");
		
		ProductosDAO pdo=new ProductosDAO();
		List<ProductosDTO> ProductosDTO=new ArrayList<ProductosDTO>();
		
		ProductosDTO=pdo.Listar();
		
		
		
		
		if (usuario.equalsIgnoreCase("admininicial")&& clave.equals("123456")) {
			String X="Admin";
			sesion.setAttribute("AccesoUserID", X);
			response.sendRedirect("menuprincipal.jsp");
			
		}else {
			UsuariosDTO usdto;
			UsuariosDTO login=new UsuariosDTO(clave, usuario);
			UsuariosDAO lo= new UsuariosDAO();
			usdto=lo.Login(login);
			
			if(usdto==null) {
				response.sendRedirect("index.jsp");
			}
			else
				if(usdto.getUsuario().equalsIgnoreCase(usuario) && usdto.getPassword().equals(clave)) {
					String uss=usdto.getNombre_Usuario();
					sesion.setAttribute("AccesoUserID", uss);
					sesion.setAttribute("Inicio", usdto);
					request.setAttribute("productos", ProductosDTO);
					request.getRequestDispatcher("carritoVentas.jsp").forward(request, response);
			}
				else
					response.sendRedirect("index.jsp");
		}
		
		
	}

}
