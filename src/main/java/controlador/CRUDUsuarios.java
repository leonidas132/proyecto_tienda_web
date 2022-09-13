 package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import modelo.UsuariosDAO;
import modelo.UsuariosDTO;

/**
 * Servlet implementation class CRUDUsuarios
 */
@WebServlet("/CRUDUsuarios")
public class CRUDUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CRUDUsuarios() {
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
		HttpSession Usuarios=request.getSession();
		boolean X;
		long Usuario_Cedula;
		String Email_Usuario;
		String Nombre_Usuario;
		String Password;
		String Usuario;
		
		UsuariosDTO usdto;
		UsuariosDAO usdao;
		UsuariosDTO registro;
		
		
		//Insertar Usuarios
		if(request.getParameter("crear")!=null) {
			Usuario_Cedula=Long.parseLong(request.getParameter("cedula"));
			Email_Usuario=request.getParameter("gmail");
			Nombre_Usuario=request.getParameter("nombre");
			Password=request.getParameter("password2");
			Usuario=request.getParameter("usuario");
			
			usdto = new UsuariosDTO(Usuario_Cedula, Email_Usuario, Nombre_Usuario, Password, Usuario);
			usdao = new UsuariosDAO();
			
			X=usdao.InsertarUsuarios(usdto);
			if(X) {
				JOptionPane.showMessageDialog(null, "Se Ingreso sin Problemas");
				response.sendRedirect("interfaceUsuario.jsp");
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Error al Ingresar usuario");
				response.sendRedirect("interfaceUsuario.jsp");
			}
			//request.getRequestDispatcher("interfaceUsuario.jsp").forward(request, response);
				
		}
		
		// Buscar Usuarios
		if(request.getParameter("consultar")!=null) {
			
			
			Usuario_Cedula=Long.parseLong(request.getParameter("cedula"));
			usdto  = new UsuariosDTO(Usuario_Cedula);
			usdao = new UsuariosDAO();
			
			registro=usdao.ConsultarUsuarios(usdto);
			
			
			
			if(registro!=null) {
				
				JOptionPane.showMessageDialog(null, "Usuario Encontrado");
				Usuarios.setAttribute("usuario", registro);
				request.getRequestDispatcher("interfaceUsuario.jsp").forward(request, response);
				
				/*
				long Cedula;
				String Email;
				String Nombre;
				String Clave;
				String User;
				Cedula=registro.getCedula_Usuario();
				//JOptionPane.showMessageDialog(null, Cedula);
				Email=registro.getEmail_Usuario();
				//JOptionPane.showMessageDialog(null, Email);
				Nombre=registro.getNombre_Usuario();
				//JOptionPane.showMessageDialog(null, Nombre);
				Clave=registro.getPassword();
				//JOptionPane.showMessageDialog(null, Clave);
				User=registro.getUsuario();
				//JOptionPane.showMessageDialog(null, User);
				JOptionPane.showMessageDialog(null, "Usuario Encontrado");
				request.getRequestDispatcher("interfaceUsuario.jsp?cedula="+Cedula+"&&gmail="+Email+"&&nombre"+Nombre+"&&password2"+Clave+"&&usuario"+User).forward(request, response);
				//response.sendRedirect("interfaceUsuario.jsp?Cedula="+Cedula+"&&gmail="+Email+"&&nombre"+Nombre+"&&password2"+Clave+"&&usuario"+User);*/
			}
			else {
				JOptionPane.showMessageDialog(null, "No hay registros");
				request.getRequestDispatcher("interfaceUsuario.jsp").forward(request, response);
			}
		}
		
		
		// Actualizar Usuarios
		if(request.getParameter("actualizar")!=null) {
			Usuario_Cedula=Long.parseLong(request.getParameter("cedula"));
			Email_Usuario=request.getParameter("gmail");
			Nombre_Usuario=request.getParameter("nombre");
			Password=request.getParameter("password2");
			Usuario=request.getParameter("usuario");
			
			usdto = new UsuariosDTO(Usuario_Cedula, Email_Usuario, Nombre_Usuario, Password, Usuario);
			usdao = new UsuariosDAO();
			
			X=usdao.ModificarUsuarios(usdto);
			if(X) {
				JOptionPane.showMessageDialog(null, "Se Actualizo sin problemas");
				response.sendRedirect("interfaceUsuario.jsp");
			}else {
				JOptionPane.showMessageDialog(null, "Problemas Para Actualizar");
				request.getRequestDispatcher("menuprincipla.jsp").forward(request, response);
			}
			
		}
		
		
		//Eliminar Usuarios
		if(request.getParameter("eliminar")!=null) {
			Usuario_Cedula=Long.parseLong(request.getParameter("cedula"));
			usdto =new UsuariosDTO(Usuario_Cedula);
			usdao =new UsuariosDAO();
			
			X=usdao.EliminarUsuarios(usdto);
			if(X) {
				JOptionPane.showMessageDialog(null, "Eliminacion sin Problemas");
				response.sendRedirect("interfaceUsuario.jsp");
			}else {
				JOptionPane.showMessageDialog(null, "Hay Problemas");
				request.getRequestDispatcher("menuprincipla.jsp").forward(request, response);
			}
		}
         
		Usuarios.invalidate();
		
		
	     
		
	} 

}
