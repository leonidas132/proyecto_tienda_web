package controlador;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;



import modelo.ClientesDAO;
import modelo.ClientesDTO;

/**
 * Servlet implementation class CRUDClientes
 */
@WebServlet("/CRUDClientes")
public class CRUDClientes extends HttpServlet {

    /**
     * Default constructor. 
     */
    public CRUDClientes() {
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
		HttpSession Clientes=request.getSession();
		boolean X;
		Long Cedula_Cliente;
		String Direccion_Cliente;
		String Email_Cliente;
		String Nombre_Cliente;
		String Telefono_Cliente;
		String Ciudad_Clietne;
		
		ClientesDTO clidto;
		ClientesDAO clidao;
		ClientesDTO registro;
		
		
		
		String Ciudad_Cliente;
		//Ingresar Clientes
		if(request.getParameter("Crear")!=null) {
			Cedula_Cliente=Long.parseLong(request.getParameter("Cedula"));
			Nombre_Cliente=request.getParameter("Nombre");			
			Direccion_Cliente=request.getParameter("Direccion");
			Telefono_Cliente=request.getParameter("Telefono");
			Email_Cliente=request.getParameter("Correo");
			Ciudad_Cliente=request.getParameter("Ciudad");
		    clidto=new ClientesDTO(Cedula_Cliente,Nombre_Cliente, Direccion_Cliente,Telefono_Cliente, Email_Cliente, Ciudad_Cliente  );
			clidao=new ClientesDAO();
			X=clidao.insertarClientes(clidto);
		    System.out.println(X);
			if(X==true){
				JOptionPane.showMessageDialog(null, "Se Agrego sin problemas");
				response.sendRedirect("interface_cliente.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Error, Cliente no ingresado");
			}
			
		}
		
		//Buscar Usuarios
	

			long Cedula;
			String Direccion;
			String Email;
			String Nombre;
			String Telefono;
			String Ciudad;


			if(request.getParameter("Buscar")!=null) { 
			Cedula_Cliente=Long.parseLong(request.getParameter("Cedula"));
			clidto=new ClientesDTO(Cedula_Cliente);
			clidao= new ClientesDAO();
			registro=clidao.Consultar(clidto);
			if(registro!=null) {


				JOptionPane.showMessageDialog(null, "Cliente Encontrado");
				Clientes.setAttribute("clientes", registro);
				request.getRequestDispatcher("interface_cliente.jsp").forward(request, response);
			
				

				System.out.println(registro);
				Cedula=registro.getCedula_Cliente();
				Direccion=registro.getDireccion_Cliente();
				Email=registro.getEmail_Cliente();
				Nombre=registro.getNombre_Cliente();
				Telefono=registro.getTelefono_Cliente();
				Ciudad=registro.getCiudad_Cliente();
			
				response.sendRedirect("interface_cliente.jsp?Cedula="+Cedula+"&&Direccion"+Direccion+"&&Correo"+Email+"&&Nombre"+Nombre+"&&Telefono"+Telefono+"&&Ciudad"+Ciudad);
				request.getRequestDispatcher("interface_cliente.jsp?Cedula="+Cedula+"&&Direccion"+Direccion+"&&Correo"+Email+"&&Nombre"+Nombre+"&&Telefono"+Telefono+"&&Ciudad"+Ciudad).forward(request, response);
			}
			else {
				JOptionPane.showMessageDialog(null, "No hay datos");
				response.sendRedirect("interface_cliente.jsp");
			}
			
		}
			
		
		//Modificar Usuarios
		if(request.getParameter("Actualizar")!=null) {
			int Dat;
			Cedula_Cliente=Long.parseLong(request.getParameter("Cedula"));
			Direccion_Cliente=request.getParameter("Direccion");
			Email_Cliente=request.getParameter("Correo");
			Nombre_Cliente=request.getParameter("Nombre");
			Telefono_Cliente=request.getParameter("Telefono");
			Ciudad_Cliente= request.getParameter("ciudad");
			
			clidto=new ClientesDTO(Cedula_Cliente, Direccion_Cliente, Email_Cliente, Nombre_Cliente, Telefono_Cliente, Ciudad_Cliente);
			clidao=new ClientesDAO();
			Dat=clidao.Actualizar(clidto);
			if(Dat>0) {
				JOptionPane.showMessageDialog(null, "Actualizacion Ok");
				response.sendRedirect("menuprincipla.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Error, No se actualizo");
				response.sendRedirect("menuprincipla.jsp");
			}
		}
		
		
		//Eliminar usuarios
		if(request.getParameter("Borrar")!=null) {
			int x=0;
			Cedula_Cliente=Long.parseLong(request.getParameter("Cedula"));
			clidto =new ClientesDTO(Cedula_Cliente);
			clidao =new ClientesDAO();
			
			x=clidao.Eliminar(clidto);
			if(x>0) {
				JOptionPane.showMessageDialog(null, "Eliminacion Ok");
				response.sendRedirect("menuprincipla.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "No se Puede Eliminar");
				response.sendRedirect("menuprincipla.jsp");
			}
		}
		
	Clientes.invalidate();
		
		
	}

}

