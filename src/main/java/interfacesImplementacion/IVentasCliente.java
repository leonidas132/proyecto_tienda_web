package interfacesImplementacion;

import java.util.List;

import interfacejdbc.DAOgenery;
import modelo.Ventascliente;

public interface IVentasCliente extends DAOgenery<Ventascliente,Long> {

	List<Ventascliente> getConsultaVentas();
}
