package interfacejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	

	public Connection conexionbd() {
		Connection connection = null;
		String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost/tiendasucursales";
		String DB_USER ="root";
		String DB_PASSWORD = "";
		try {
			Class.forName(DB_DRIVER);
			//Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			System.out.println("Conexion Ok");	
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error con la URL" + e);
		}
		
		return connection;
	}
	
	
	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		conexion.conexionbd();
	}
}
