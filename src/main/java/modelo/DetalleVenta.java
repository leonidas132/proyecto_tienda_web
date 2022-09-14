package modelo;

public class DetalleVenta {
	
	private long codigo_detalle_venta;
	private int cantidad_producto;
	private long codigo_producto;
	private long codigo_venta;
	private double valor_total;
	private double valor_venta;
	private double valoriva;
	
	
	public DetalleVenta(int cantidad_producto, long codigo_producto, long codigo_venta,
			double valor_total, double valor_venta, double valoriva) {

		this.cantidad_producto = cantidad_producto;
		this.codigo_producto = codigo_producto;
		this.codigo_venta = codigo_venta;
		this.valor_total = valor_total;
		this.valor_venta = valor_venta;
		this.valoriva = valoriva;
	}

	
	

	public long getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}


	public void setCodigo_detalle_venta(long codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}


	public int getCantidad_producto() {
		return cantidad_producto;
	}


	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}


	public long getCodigo_producto() {
		return codigo_producto;
	}


	public void setCodigo_producto(long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}


	public long getCodigo_venta() {
		return codigo_venta;
	}


	public void setCodigo_venta(long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}


	public double getValor_total() {
		return valor_total;
	}


	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}


	public double getValor_venta() {
		return valor_venta;
	}


	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}


	public double getValoriva() {
		return valoriva;
	}


	public void setValoriva(double valoriva) {
		this.valoriva = valoriva;
	}
	
	
	
	

}
