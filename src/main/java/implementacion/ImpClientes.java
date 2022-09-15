package implementacion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import interfacesImplementacion.IClientes;
import modelo.Clientes;

public class ImpClientes implements IClientes {
	private PreparedStatement preparedStatementBuscarId;
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementModificar;
	private PreparedStatement preparedStatementEliminar;
	private PreparedStatement preparedStatementListar;
    
	
	@Override
	public Clientes getConsultar(Long k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getInsertar(Clientes e) {
		
		return false;
	}

	@Override
	public boolean getModificar(Clientes e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getEliminar(Clientes e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Clientes> getListar() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
