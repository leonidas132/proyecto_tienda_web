package modelo;

public class Ventascliente {
    private long cedula;
    private String Nombre;
    private double totalventas;
    
    
	public Ventascliente(long cedula, String nombre, double totalventas) {
		super();
		this.cedula = cedula;
		Nombre = nombre;
		this.totalventas = totalventas;
	}


	public Ventascliente() {
		super();
	}


	public long getCedula() {
		return cedula;
	}


	public void setCedula(long cedula) {
		this.cedula = cedula;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public double getTotalventas() {
		return totalventas;
	}


	public void setTotalventas(double totalventas) {
		this.totalventas = totalventas;
	}
	
    
}
