package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.ClientesDAO;
import modelo.ClientesDTO;
import modelo.DetalleVentaDAO;
import modelo.DetalleVentaDTO;
import modelo.ProductosDAO;
import modelo.ProductosDTO;
import modelo.VentasDAO;
import modelo.VentasDTO;
import modelo.ventasclientesDTO;

/**
 * Servlet implementation class Compras
 */
@WebServlet("/Compras")
public class Compras extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	ProductosDAO pdao = new ProductosDAO();
	ProductosDTO pdto = new ProductosDTO();
	List<ProductosDTO> ProductosDTO = new ArrayList<ProductosDTO>();
	
	
	VentasDTO vendto=new VentasDTO();
	List<VentasDTO> ListaVentas = new ArrayList<>();
	
	boolean x;
	boolean ress;
	int Codigo;
	double Precio;
	int Cantidad;
	double subtotal;
	double TotalPagar;
	double Iva;
	double SinIva;
	double TotalsinIva;
	double TotalIVA;
	String Nombre_Producto;
	ProductosDTO listProductos;
	
	ClientesDTO clidto;
	ClientesDAO clidao;
	ClientesDTO registro;
	
	VentasDTO venDTO;
	DetalleVentaDTO detalleDTO;
	DetalleVentaDAO detalleDAO;
	
	Long Cedula_Usuario;
	Long Cedula_Cliente;
	Long Codigo_Venta;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Compras() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
		//Variable de Sesion
		HttpSession Sesion=request.getSession();
		
		
		//buscar Clientes en la Interface de Carro de Ventas
		if(request.getParameter("BuscarCliente")!=null) {
			
			Cedula_Cliente = (long) Integer.parseInt(request.getParameter("Cedula_Cliente"));
			clidto = new ClientesDTO(Cedula_Cliente);
			clidao = new ClientesDAO();
			registro = clidao.Consultar(clidto);
			Sesion.setAttribute("Registro", registro);
			request.getRequestDispatcher("carritoVentas.jsp").forward(request, response);	
			}
		
		
		//buscar Productos en la Interface de Carro de Ventas
		if(request.getParameter("BuscarProducto")!=null) {
			long Codigo_Producto = (long) Integer.parseInt(request.getParameter("Codigo_Producto"));
			ProductosDTO prodto = new ProductosDTO(Codigo_Producto);
			ProductosDAO prodao = new ProductosDAO();
			listProductos = prodao.ConsultarProducto(prodto);
			Sesion.setAttribute("Producto", listProductos);
			request.getRequestDispatcher("carritoVentas.jsp").forward(request, response);
		}
		
		
		//Agregar a la Lista en la Interface de Carro de Ventas
		if(request.getParameter("Agregar")!=null) {
			TotalPagar=0.0;
			Codigo=Integer.parseInt(request.getParameter("Codigo_Producto"));
			Precio=Double.parseDouble(request.getParameter("precio"));
			Cantidad=Integer.parseInt(request.getParameter("cantidad"));
			subtotal=Precio*Cantidad;
			Nombre_Producto=request.getParameter("nom_Producto");
			Iva=listProductos.getIvacompra();
			SinIva=listProductos.getPrecio_compra();
			vendto=new VentasDTO();
			vendto.setCodigo_Producto(Codigo);
			vendto.setPrecio_Procuto(Precio);
			vendto.setCantidad(Cantidad);
			vendto.setSub_total(subtotal);
			vendto.setNombre_Producto(Nombre_Producto);
			vendto.setIva(Iva);
			vendto.setTotalSinIva(SinIva);
			ListaVentas.add(vendto);
			for (int i=0; i<ListaVentas.size(); i++) {
				TotalPagar=TotalPagar+ListaVentas.get(i).getSub_total();
				TotalsinIva=TotalsinIva+ListaVentas.get(i).getTotalSinIva();
			}
			TotalIVA=TotalPagar-TotalsinIva;
			Sesion.setAttribute("lista", ListaVentas);
			Sesion.setAttribute("iva", TotalIVA);
			Sesion.setAttribute("SinIva", TotalsinIva);
			Sesion.setAttribute("Total", TotalPagar);
			request.getRequestDispatcher("carritoVentas.jsp").forward(request, response);
		}
		
		if(request.getParameter("GenerarVenta")!=null) {
			Cedula_Usuario=(long) Integer.parseInt(request.getParameter("CedulaUsuario"));
			VentasDTO vendto=new VentasDTO(Cedula_Cliente, Cedula_Usuario, TotalIVA, TotalsinIva, TotalPagar);
			VentasDAO vendao=new VentasDAO();
			ress=vendao.ingresarVenta(vendto);
			//registrar Ventas y Detalle Ventas
			
			
			if(ress) {
				JOptionPane.showMessageDialog(null, "Venta Registrada");
				for (int i=0; i < ListaVentas.size(); i++) {
					
					VentasDAO veDAO=new VentasDAO();
					venDTO=veDAO.consultarCodigo();
					Codigo_Venta=venDTO.getCodigo_venta();
					
					detalleDTO =new DetalleVentaDTO(ListaVentas.get(i).getCantidad(),ListaVentas.get(i).getCodigo_Producto(), Codigo_Venta,  TotalPagar, TotalIVA, TotalsinIva);
					detalleDAO=new DetalleVentaDAO();
					x=detalleDAO.DetalleVenta(detalleDTO);
					if(x) {
						JOptionPane.showMessageDialog(null, "Detalle Registrado");
						TotalPagar=0.0;
						Sesion.setAttribute("Total", TotalPagar);
						ListaVentas.clear();
						request.getRequestDispatcher("carritoVentas.jsp").forward(request, response);
					}
					
				}
			}
		}
		
		if(request.getParameter("Salir")!=null) {
			ListaVentas.clear();
			Sesion.invalidate();
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
		/*
		String accion = request.getParameter("accion");

		switch (accion) {
		case "Listar":
			// Esto lo que Hace es Mostrar la Lista de Productos, para Saber como Ver la
			// Interfaz Carriyo Ventas Jajaj
			ProductosDTO = pdao.Listar();
			request.setAttribute("productos", ProductosDTO);
			request.getRequestDispatcher("carritoVentas.jsp").forward(request, response);
			break;
		case "BuscarCliente":
			// Se Supone que Esto Debe de Agregar los Productos a la Cesta y Listarlos para
			// que se vea Despues mas Cool
			Long Cedula_Cliente = (long) Integer.parseInt(request.getParameter("Cedula_Cliente"));
			clidto = new ClientesDTO(Cedula_Cliente);
			clidao = new ClientesDAO();
			registro = clidao.Consultar(clidto);
			request.setAttribute("Registro", registro);
			request.setAttribute("lista", ListaVentas);
			request.getRequestDispatcher("carritoVentas.jsp").forward(request, response);
			break;
		case "BuscarProducto":
			// Aqui se van a Hacer muchas Cosas, como por Ejemplo Hacer los Calculos
			
			long Codigo_Producto = (long) Integer.parseInt(request.getParameter("Codigo_Producto"));
			ProductosDTO prodto = new ProductosDTO(Codigo_Producto);
			ProductosDAO prodao = new ProductosDAO();
			listProductos = prodao.ConsultarProducto(prodto);
			request.setAttribute("Producto", listProductos);
			request.setAttribute("lista", ListaVentas);
			request.getRequestDispatcher("carritoVentas.jsp").forward(request, response);
			break;
		case "Agregar":
			TotalPagar=0.0;
			Codigo=Integer.parseInt(request.getParameter("Codigo_Producto"));
			Precio=Double.parseDouble(request.getParameter("precio"));
			Cantidad=Integer.parseInt(request.getParameter("cantidad"));
			subtotal=Precio*Cantidad;
			Nombre_Producto=request.getParameter("nom_Producto");
			vendto.setCodigo_Producto(Codigo);
			vendto.setPrecio_Procuto(Precio);
			vendto.setCantidad(Cantidad);
			vendto.setSub_total(subtotal);
			vendto.setNombre_Producto(Nombre_Producto);
			ListaVentas.add(vendto);
			for (int i=0; i<ListaVentas.size(); i++) {
				TotalPagar=TotalPagar+ListaVentas.get(i).getSub_total();
			}
			request.setAttribute("lista", ListaVentas);
			request.setAttribute("Total", TotalPagar);
			request.getRequestDispatcher("carritoVentas.jsp").forward(request, response);
			break;

		// Mas Operaciones que se Iran Haciendo con el Paso de los Dias, si Funciona
		// Esta Vaina.

		default:
			request.getRequestDispatcher("carritoVentas.jsp").forward(request, response);

		}*/
	}

}
