package modelo;

public class Proveedor {
    private long Nit;
    private String Nombre_proveedor;
    private String Direccion;
    private String Telefono ;
    private String Ciudad ;
    
   public Proveedor(long Nit,String Nombre_proveedor,String Direccion,String Telefono,String Ciudad) {
	   this.Nit=Nit;
	   this.Nombre_proveedor=Nombre_proveedor;
	   this.Direccion=Direccion;
	   this.Telefono=Telefono;
	   this.Ciudad=Ciudad;
	   
    }


/*public ProveedorDTO(long nit, String direccion, String telefono, String ciudad) {
	
	this.Nit = nit;
	this.Direccion = direccion;
	this.Telefono = telefono;
	this.Ciudad = ciudad;*/



public Proveedor(long nit) {
	Nit = nit;
}


public long getNit() {
	return this.Nit;
}

public void setNit(long nit) {
	this.Nit = nit;
}

public String getNombre_proveedor() {
	return this.Nombre_proveedor;
}

public void setNombre_proveedor(String nombre_proveedor) {
	this.Nombre_proveedor = nombre_proveedor;
}

public String getDireccion() {
	return this.Direccion;
}

public void setDireccion(String direccion) {
	this.Direccion = direccion;
}

public String getTelefono() {
	return this.Telefono;
}

public void setTelefono(String telefono) {
	this.Telefono = telefono;
}

public String getCiudad() {
	return this.Ciudad;
}

public void setCiudad(String ciudad) {
	this.Ciudad = ciudad;
}
   
 }
