package modelo;

public class Usuario {
	
	private long Cedula_Usuario;
	private String Email_Usuario;
	private String Nombre_Usuario;
	private String Password;
	private String Usuario;
	
	
	public Usuario(long cedula_Usuario, String email_Usuario, String nombre_Usuario, String password,
			String usuario) {
		Cedula_Usuario = cedula_Usuario;
		Email_Usuario = email_Usuario;
		Nombre_Usuario = nombre_Usuario;
		Password = password;
		Usuario = usuario;
	}
	
	
	
	

	public Usuario() {
		super();
	}





	public Usuario(String password, String usuario) {
		Password = password;
		Usuario = usuario;
	}

	public Usuario(long cedula_Usuario) {
		Cedula_Usuario = cedula_Usuario;
	}


	public long getCedula_Usuario() {
		return Cedula_Usuario;
	}


	public void setCedula_Usuario(long cedula_Usuario) {
		Cedula_Usuario = cedula_Usuario;
	}


	public String getEmail_Usuario() {
		return Email_Usuario;
	}


	public void setEmail_Usuario(String email_Usuario) {
		Email_Usuario = email_Usuario;
	}


	public String getNombre_Usuario() {
		return Nombre_Usuario;
	}


	public void setNombre_Usuario(String nombre_Usuario) {
		Nombre_Usuario = nombre_Usuario;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getUsuario() {
		return Usuario;
	}


	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	
	
	

}
