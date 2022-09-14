package modelo;


import java.sql.*;
import java.util.ArrayList;

import controlador.Conexion;

public class ventasclientesDAO {
    Conexion con= new Conexion();
    Connection cnn=con.conexionbd();
    PreparedStatement ps;
    ResultSet rs;
    Ventascliente ventasclientedto;
    
    public ArrayList<Ventascliente>consultasgeneralventas(){
    	ArrayList<Ventascliente>lista=new ArrayList<Ventascliente>();
    	try {
			ps=cnn.prepareStatement("SELECT ventas.cedula_cliente, ventas.total_venta,  clientes.nombre_cliente FROM ventas INNER JOIN clientes  ON clientes.cedula_cliente = ventas.cedula_cliente");
			rs=ps.executeQuery();
			while(rs.next()) {
				ventasclientedto = new Ventascliente(rs.getLong(1),rs.getString(3),rs.getLong(2));
				lista.add(ventasclientedto);
			}
		} catch (SQLException e) {
			System.out.println("error en la consulta de ventas"+e);	
			}
    	return lista;
    }
}
