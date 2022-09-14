package implementacion;

import java.util.List;

import interfacesImplementacion.IDetallesVentas;
import modelo.DetalleVenta;

public class ImpDetalleVenta implements IDetallesVentas{

	@Override
	public DetalleVenta getConsultar(String k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getInsertar(DetalleVenta e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getModificar(DetalleVenta e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getEliminar(DetalleVenta e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<DetalleVenta> getListar() {
		// TODO Auto-generated method stub
		return null;
	}
  
}
