package controlador;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.ClientesDAO;
import modelo.ClientesDTO;
import modelo.ProductosDAO;
import modelo.ProductosDTO;
import modelo.VentasDAO;
import modelo.VentasDTO;
import modelo.DetalleVentaDAO;
import modelo.DetalleVentaDTO;

/**
 * Servlet implementation class Ventas
 */
@WebServlet("/Ventas")
public class Ventas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	double iva,iva2,iva3;
	int cant1,cant2,cant3;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ventas() {
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
		
		HttpSession sesion2=request.getSession();
		
		//Busqueda Inicial de Cedula para la Sesion, y el Registro de la Venta
		if(request.getParameter("Consultar")!=null) {
			
			long Cedula;
			String Nombre;
			
			ClientesDTO listado;
			Cedula=Long.parseLong(request.getParameter("Cedula"));
			ClientesDAO clidao=new ClientesDAO();
			ClientesDTO clidto=new ClientesDTO(Cedula);
			listado=clidao.Consultar(clidto);
			
			sesion2.setAttribute("cliente", listado);
			
			request.getRequestDispatcher("interfaceventas.jsp").forward(request, response);	
			}
		
		
		//Botones Para las Consultas de los productos.
		if(request.getParameter("Consultar1")!=null) {
			long codigoProducto;
			
			ProductosDTO listProductos;
			codigoProducto=Long.parseLong(request.getParameter("CodigoProducto1"));
			ProductosDTO prodto=new ProductosDTO(codigoProducto);
			ProductosDAO prodao=new ProductosDAO();
			listProductos=prodao.ConsultarProducto(prodto);
			iva=listProductos.getIvacompra();
			sesion2.setAttribute("producto1", listProductos);
			request.getRequestDispatcher("interfaceventas.jsp").forward(request, response);
		}
		
		if(request.getParameter("Consultar2")!=null) {
			long codigoProducto;
			
			ProductosDTO listProductos;
			codigoProducto=Long.parseLong(request.getParameter("CodigoProducto2"));
			ProductosDTO prodto=new ProductosDTO(codigoProducto);
			ProductosDAO prodao=new ProductosDAO();
			listProductos=prodao.ConsultarProducto(prodto);
			iva2=listProductos.getIvacompra();
			sesion2.setAttribute("producto2", listProductos);
			request.getRequestDispatcher("interfaceventas.jsp").forward(request, response);
		}
		
		if(request.getParameter("Consultar3")!=null) {
			long codigoProducto;
			
			ProductosDTO listProductos;
			codigoProducto=Long.parseLong(request.getParameter("CodigoProducto3"));
			ProductosDTO prodto=new ProductosDTO(codigoProducto);
			ProductosDAO prodao=new ProductosDAO();
			listProductos=prodao.ConsultarProducto(prodto);
			iva3=listProductos.getIvacompra();
			sesion2.setAttribute("producto3", listProductos);
			request.getRequestDispatcher("interfaceventas.jsp").forward(request, response);
		}
		
		
		//Variables Para Calcular el Precio de los Productos
		
		double Totl,Tot2,Tot3, Resul,Resul2,Resul3, TotSinIva, TotIva, TotConIva;
		
		//Botones para Calcular Factura
		if(request.getParameter("Confirmar")!=null) {
			double Total1,Total2,Total3;
			
			cant1=Integer.parseInt(request.getParameter("Cantidad1"));
			cant2=Integer.parseInt(request.getParameter("Cantidad2"));
			cant3=Integer.parseInt(request.getParameter("Cantidad3"));
			
			Totl=Double.parseDouble(request.getParameter("Valor_total1"));
			Tot2=Double.parseDouble(request.getParameter("Valor_total2"));
			Tot3=Double.parseDouble(request.getParameter("Valor_total3"));
			
			Resul=cant1*Totl;
			Resul2=cant2*Tot2;
			Resul3=cant3*Tot3;
			
			Total1=Resul*iva/100;
			Total2=Resul2*iva2/100;
			Total3=Resul3*iva3/100;
			
			TotSinIva=Resul+Resul2+Resul3;
			TotIva=Total1+Total2+Total3;
			TotConIva=TotSinIva+TotIva;
			
			int Factura=JOptionPane.showConfirmDialog(null, 
					"Tienda Generica"+"\n"+
					"A Continuacion Encontrara el Detalle"+
						""	+
					"Articulo 1 "+Resul+"\n"+
					"IVA "+Total1+"\n"+
					"Articulo 2 "+Resul2+"\n"+
					"IVA "+Total2+"\n"+
					"Articulo 3 "+Resul3+"\n"+
					"IVA "+Total3+"\n"+
					""+
					"Total Sin IVA = "+TotSinIva+"\n"+
					"Total Iva = "+TotIva+"\n"+
					"Total Compra = "+TotConIva+"\n"+
					""+
					"Gracias por Su Compra Que Vuelva Pronto");
			//JOptionPane.showMessageDialog(null, Factura);
			
			
			//Registrar Detalle de Ventas
			if(Factura==0) {
				String CedulaCliente, CedulaUsuario;
				long CedCliente, CedUsuario;
				double Iva, TotalVenta, ValorVenta;
				boolean ress;
				CedulaCliente=request.getParameter("Cedula");
				CedulaUsuario=request.getParameter("CedulaUsuario");
				Iva=TotIva;
				TotalVenta=TotIva;
				ValorVenta=TotConIva;
				CedCliente=Long.parseLong(CedulaCliente);
				CedUsuario=Long.parseLong(CedulaUsuario);
				VentasDTO vendto=new VentasDTO(CedCliente, CedUsuario, ValorVenta, TotalVenta, Iva);
				VentasDAO vendao=new VentasDAO();
				ress=vendao.ingresarVenta(vendto);
				
				if(ress) {
					JOptionPane.showMessageDialog(null, "Venta Registrada");
					int Cantidad;
					long CodProducto;
					double IVenta,TVenta,VVenta;
					boolean x;
					VentasDTO venDTO;
					DetalleVentaDTO detalleDTO;
					DetalleVentaDAO detalleDAO;
					long codProd=Long.parseLong(request.getParameter("CodigoProducto1"));
					VentasDAO veDAO=new VentasDAO();
					venDTO=veDAO.consultarCodigo();
					
					Cantidad=cant1;
					if(Cantidad>0) {
						CodProducto=venDTO.getCodigo_venta();
						IVenta=venDTO.getIvaventa();
						TVenta=venDTO.getTotal_venta();
						VVenta=venDTO.getIvaventa();
						detalleDTO =new DetalleVentaDTO(Cantidad,codProd, CodProducto,  IVenta, TVenta, VVenta);
						detalleDAO=new DetalleVentaDAO();
						x=detalleDAO.DetalleVenta(detalleDTO);
						if(x) {
							JOptionPane.showMessageDialog(null, "Detalle Ingresado");
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "No Ingreso Cantidad");
					}
					
					Cantidad=cant2;
					if(Cantidad>0) {
						CodProducto=venDTO.getCodigo_venta();
						IVenta=venDTO.getIvaventa();
						TVenta=venDTO.getTotal_venta();
						VVenta=venDTO.getIvaventa();
						detalleDTO =new DetalleVentaDTO(Cantidad, CodProducto, codProd, IVenta, TVenta, VVenta);
						detalleDAO=new DetalleVentaDAO();
						x=detalleDAO.DetalleVenta(detalleDTO);
						if(x) {
							JOptionPane.showMessageDialog(null, "Detalle Ingresado");
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "No Ingreso Cantidad");
					}
					
					Cantidad=cant3;
					if(Cantidad>0) {
						CodProducto=venDTO.getCodigo_venta();
						IVenta=venDTO.getIvaventa();
						TVenta=venDTO.getTotal_venta();
						VVenta=venDTO.getIvaventa();
						detalleDTO =new DetalleVentaDTO(Cantidad, CodProducto, codProd, IVenta, TVenta, VVenta);
						detalleDAO=new DetalleVentaDAO();
						x=detalleDAO.DetalleVenta(detalleDTO);
						if(x) {
							JOptionPane.showMessageDialog(null, "Detalle Ingresado");
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "No Ingreso Cantidad");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Venta No Registrada");
					request.getRequestDispatcher("interfaceventas.jsp").forward(request, response);
					sesion2.invalidate();
				}
				
				
			}
			sesion2.invalidate();
		}
		
		request.getRequestDispatcher("interfaceventas.jsp").forward(request, response);
		
	}

}
