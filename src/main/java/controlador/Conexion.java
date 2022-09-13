package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	Connection cnn;

	public Connection conexionbd() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Conexion Ok");
		} catch (ClassNotFoundException e) {
			System.out.println("Error en Driver" + e);
		}
		try {
			cnn=DriverManager.getConnection("jdbc:mysql://localhost/tiendasucursales", "root", "");
			//cnn=DriverManager.getConnection("jdbc:mariadb://tiendagenericagrupo43-10-32.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/bd_TiendaG10_G43","admin","123456789");
			System.out.println("Conexion Ok");
		} catch (SQLException e) {
			System.out.println("Error con la URL" + e);
		}
		
		return cnn;
	}
}
