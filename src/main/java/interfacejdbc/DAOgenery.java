package interfacejdbc;

import java.util.List;

public interface DAOgenery <E,K> {
     
	E getConsultar(K k);
	
	boolean getInsertar(E e);
	
	boolean getModificar(E e);
	
	boolean getEliminar(E e);
	
	List<E> getListar();
	
}
