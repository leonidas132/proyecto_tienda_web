package implementacion;

import java.util.List;

import interfacesImplementacion.IProducto;
import modelo.Producto;

public class ImpProducto implements IProducto{

	@Override
	public Producto getConsultar(Long k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getInsertar(Producto e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getModificar(Producto e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getEliminar(Producto e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Producto> getListar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getCargarProducto(String ruta) {
		// TODO Auto-generated method stub
		return false;
	}



}
