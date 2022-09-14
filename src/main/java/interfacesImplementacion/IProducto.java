package interfacesImplementacion;

import interfacejdbc.DAOgenery;
import modelo.Producto;

public interface IProducto extends DAOgenery<Producto,Long> {

	boolean getCargarProducto(String url);
}
