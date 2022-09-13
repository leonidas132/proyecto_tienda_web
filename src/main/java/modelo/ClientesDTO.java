package modelo;

public class ClientesDTO {
	
	private long Cedula_Cliente;
	private String Nombre_Cliente;
	private String Direccion_Cliente;
	private String Telefono_Cliente;
	private String Email_Cliente;
	private String Ciudad_Cliente;
	
	
	
	
	public ClientesDTO(long cedula_Cliente,String nombre_Cliente, String direccion_Cliente,String telefono_Cliente, String email_Cliente, String ciduad_Cliente 
			) {
	
		this.Cedula_Cliente = cedula_Cliente;
		this.Nombre_Cliente = nombre_Cliente;
		this.Direccion_Cliente = direccion_Cliente;
	    this.Telefono_Cliente = telefono_Cliente;
		this.Email_Cliente = email_Cliente;
		this.Ciudad_Cliente= ciduad_Cliente;
	}
	

	public ClientesDTO() {
		super();
	}


	public ClientesDTO(long cedula_Cliente) {
		Cedula_Cliente = cedula_Cliente;
	}

	public long getCedula_Cliente() {
		return Cedula_Cliente;
	}


	public void setCedula_Cliente(long cedula_Cliente) {
		Cedula_Cliente = cedula_Cliente;
	}


	public String getDireccion_Cliente() {
		return Direccion_Cliente;
	}


	public void setDireccion_Cliente(String direccion_Cliente) {
		Direccion_Cliente = direccion_Cliente;
	}


	public String getEmail_Cliente() {
		return Email_Cliente;
	}


	public void setEmail_Cliente(String email_Cliente) {
		Email_Cliente = email_Cliente;
	}


	public String getNombre_Cliente() {
		return Nombre_Cliente;
	}


	public void setNombre_Cliente(String nombre_Cliente) {
		Nombre_Cliente = nombre_Cliente;
	}


	public String getTelefono_Cliente() {
		return Telefono_Cliente;
	}


	public void setTelefono_Cliente(String telefono_Cliente) {
		Telefono_Cliente = telefono_Cliente;
	}
	
	public String getCiudad_Cliente() {		

		return Ciudad_Cliente;
	}
	
	public void setCiudad_Cliente(String ciudad_Cliente) {
		Ciudad_Cliente =ciudad_Cliente;
	}
}



