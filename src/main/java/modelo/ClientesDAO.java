package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.Conexion;

public class ClientesDAO {
		
		Conexion con=new Conexion();
		Connection cnn=con.conexionbd();
		PreparedStatement ps;
		ResultSet rs;
		ClientesDTO clientedto = null;
		
		public boolean insertarClientes(ClientesDTO cli) {
			int r;
			boolean dat=false;
			try {
				ps=cnn.prepareStatement("INSERT INTO clientes Values(?,?,?,?,?,?)");
				ps.setLong(1, cli.getCedula_Cliente());
				ps.setString(2, cli.getNombre_Cliente());
				ps.setString(3, cli.getTelefono_Cliente());
				ps.setString(4, cli.getDireccion_Cliente());
				ps.setString(5, cli.getEmail_Cliente());
				ps.setString(6, cli.getCiudad_Cliente());
				r=ps.executeUpdate();
				System.out.println(r);
				if(r>0) {
					dat=true;
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dat;
		}
		
		public ClientesDTO Consultar(ClientesDTO cli) {
			try {
				ps=cnn.prepareStatement("SELECT * FROM clientes WHERE cedula_cliente=?");
				ps.setLong(1, cli.getCedula_Cliente());
				rs=ps.executeQuery();
			if(rs.next()) {
				clientedto=new ClientesDTO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
				else {
					return null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return clientedto;
		}
		
		
		public int Actualizar (ClientesDTO cli) {
			int x=0;
			try {
				ps=cnn.prepareStatement("UPDATE clientes SET direccion_cliente=?, email_cliente=?, nombre_cliente=?, telefono_cliente=?, ciudad_cliente=? WHERE cedula_cliente=?");
				
				ps.setString(1, cli.getDireccion_Cliente());
				ps.setString(2, cli.getEmail_Cliente());
				ps.setString(3, cli.getNombre_Cliente());
				ps.setString(4, cli.getTelefono_Cliente());
				ps.setLong(5, cli.getCedula_Cliente());
				ps.setString(6, cli.getCiudad_Cliente());
				x=ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return x;
			
			}
		
		
		public int Eliminar (ClientesDTO cli) {
			int x=0;
			try {
				ps=cnn.prepareStatement("DELETE FROM clientes WHERE cedula_cliente=?");
				ps.setLong(1, cli.getCedula_Cliente());
				x=ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return x;	
		}
		
		public ArrayList<ClientesDTO>consultageneralcliente(){
			ArrayList<ClientesDTO>lista =new ArrayList<ClientesDTO>();
			try {
				ps=cnn.prepareStatement("SELECT *FROM clientes");
				rs=ps.executeQuery();
				while(rs.next()) {
				    clientedto= new	ClientesDTO (rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				    lista.add(clientedto);
				    		
				    }
			} catch (SQLException e) {
				System.out.println("error en la consulta general"+e);
			}
			return lista;
		}
		

}

