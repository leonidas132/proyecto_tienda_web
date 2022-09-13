package modelo;

public class VentasDTO {
	
	private long codigo_venta;
	private long cedula_cliente;
	private long cedula_usuario;
	private double ivaventa;
	private double total_venta;
	private double valor_venta;
	
	
	public VentasDTO(long codigo_venta, long cedula_cliente, long cedula_usuario, double ivaventa, double total_venta,
			double valor_venta) {
		this.codigo_venta = codigo_venta;
		this.cedula_cliente = cedula_cliente;
		this.cedula_usuario = cedula_usuario;
		this.ivaventa = ivaventa;
		this.total_venta = total_venta;
		this.valor_venta = valor_venta;
	}
	
	

	public VentasDTO(long cedula_cliente, long cedula_usuario, double ivaventa, double total_venta,
			double valor_venta) {
		this.cedula_cliente = cedula_cliente;
		this.cedula_usuario = cedula_usuario;
		this.ivaventa = ivaventa;
		this.total_venta = total_venta;
		this.valor_venta = valor_venta;
	}
	
	

	public VentasDTO() {
	}


	public long getCodigo_venta() {
		return codigo_venta;
	}


	public void setCodigo_venta(long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}


	public long getCedula_cliente() {
		return cedula_cliente;
	}


	public void setCedula_cliente(long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}


	public long getCedula_usuario() {
		return cedula_usuario;
	}


	public void setCedula_usuario(long cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}


	public double getIvaventa() {
		return ivaventa;
	}


	public void setIvaventa(double ivaventa) {
		this.ivaventa = ivaventa;
	}


	public double getTotal_venta() {
		return total_venta;
	}


	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}


	public double getValor_venta() {
		return valor_venta;
	}


	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}
	
	
	//Para Listar los Produtos en un Array List
	
	private String Nombre_Producto;
	private double Precio_Procuto;
	private double Sub_total;
	private int Cantidad;
	private int Codigo_Producto;
	private double Iva;
	private double TotalSinIva;


	public VentasDTO(String nombre_Producto, double precio_Procuto, double sub_total, int cantidad,
			int codigo_Producto) {
		Nombre_Producto = nombre_Producto;
		Precio_Procuto = precio_Procuto;
		Sub_total = sub_total;
		Cantidad = cantidad;
		Codigo_Producto = codigo_Producto;
		Iva = Iva;
		TotalSinIva = TotalSinIva;
	}



	public String getNombre_Producto() {
		return Nombre_Producto;
	}



	public void setNombre_Producto(String nombre_Producto) {
		Nombre_Producto = nombre_Producto;
	}



	public double getPrecio_Procuto() {
		return Precio_Procuto;
	}



	public void setPrecio_Procuto(double precio_Procuto) {
		Precio_Procuto = precio_Procuto;
	}



	public double getSub_total() {
		return Sub_total;
	}



	public void setSub_total(double sub_total) {
		Sub_total = sub_total;
	}



	public int getCantidad() {
		return Cantidad;
	}



	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}



	public int getCodigo_Producto() {
		return Codigo_Producto;
	}



	public void setCodigo_Producto(int codigo_Producto) {
		Codigo_Producto = codigo_Producto;
	}



	public double getIva() {
		return Iva;
	}



	public void setIva(double iva) {
		Iva = iva;
	}



	public double getTotalSinIva() {
		return TotalSinIva;
	}



	public void setTotalSinIva(double totalSinIva) {
		TotalSinIva = totalSinIva;
	}
	
	
	
	
	

}
