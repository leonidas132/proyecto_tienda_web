package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;

import modelo.ProductosDAO;
import modelo.ProductosDTO;

/**
 * Servlet implementation class Productos
 */
@WebServlet("/Productos")
@MultipartConfig
public class Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Productos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
	
			
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Part archivo= request.getPart("archivo");
		//String Url="C:\\\\Users\\\\\\Moral\\\\\\git\\\\\\TiendaGenerica\\\\\\src\\\\\\main\\\\\\webapp\\\\\\archivos\\\\";
		String Url="C:/ProgramData/MySQL/MySQL Server 8.0/Uploads";
		
		ProductosDAO prodaoList=new ProductosDAO();
    	List<ProductosDTO> productos=new ArrayList<>();
    	
    	
    	String accion=request.getParameter("accion");
		productos=prodaoList.Listar();
    	
    	switch (accion) {
    	
		case "crear":
				JOptionPane.showMessageDialog(null, "Hasta Aqui Bien");
			
			try {
				
				InputStream file= archivo.getInputStream();
				File copia= new File(Url+"archivo.csv");
				FileOutputStream escribir=new FileOutputStream(copia);
				//JOptionPane.showMessageDialog(null, "Vamos bien");
				int Num=file.read();
				while(Num !=-1) {
					escribir.write(Num);
					Num=file.read();
			}
				file.close();
				escribir.close();
				JOptionPane.showMessageDialog(null, "Se Cargo el Archivo Correctamente");
				
				boolean x;
				ProductosDAO prodao=new ProductosDAO();
				x=prodao.cargarProctos(Url+"archivo.csv");
				
				if(x) {
					JOptionPane.showMessageDialog(null, "Exito");
				}
				else
					JOptionPane.showMessageDialog(null, "Fallo");
			
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			request.getRequestDispatcher("Productos?accion=Listar").forward(request, response);
			JOptionPane.showMessageDialog(null, "Si Llega a Esta Opcion");
			break;
			
			
		case "Listar":
			ProductosDAO prodao=new ProductosDAO();
			prodao.Listar();
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("interfaceproductos.jsp").forward(request, response);
			JOptionPane.showMessageDialog(null, "Deberia de Mostrar los Productos");
			
			
			break;
			default:
				request.setAttribute("productos", productos);
				request.getRequestDispatcher("interfaceproductos.jsp").forward(request, response);
		}

	}
}
