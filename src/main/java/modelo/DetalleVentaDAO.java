package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class DetalleVentaDAO {
	
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	
	public boolean DetalleVenta(DetalleVenta dtv) {
		boolean Resul=false;
		
		try {
			ps =cnn.prepareStatement("Insert Into detalle_ventas(cantidad_producto,codigo_producto,codigo_venta,valor_venta,valoriva, valor_total)   value(?,?,?,?,?,?);");
			ps.setInt(1, dtv.getCantidad_producto());
			ps.setLong(2, dtv.getCodigo_producto());
			ps.setLong(3, dtv.getCodigo_venta());
			ps.setDouble(4, dtv.getValor_venta());
			ps.setDouble(5, dtv.getValoriva());
			ps.setDouble(6, dtv.getValor_total());
			
			Resul=ps.executeUpdate()>0;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Error Al ingresar Detalle Venta"+ e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return Resul;
	}

}
