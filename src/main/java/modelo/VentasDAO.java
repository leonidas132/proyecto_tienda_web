package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class VentasDAO {
	
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	
	VentasDTO vendto;
	
	
	public boolean ingresarVenta(VentasDTO ve) {
		
		boolean Resultado=false;
		
		try {
			ps =cnn.prepareStatement("Insert Into ventas(cedula_cliente,cedula_usuario,ivaventa,total_venta,valor_venta) value(?,?,?,?,?)");
			ps.setLong(1, ve.getCedula_cliente());
			ps.setLong(2,ve.getCedula_usuario());
			ps.setDouble(3, ve.getIvaventa());
			ps.setDouble(4, ve.getTotal_venta());
			ps.setDouble(5, ve.getValor_venta());
			Resultado=ps.executeUpdate()>0;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al Ingresar la Venta"+e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Resultado;
	}
	
	public VentasDTO consultarCodigo() {
		
		try {
			ps=cnn.prepareStatement("SELECT MAX(codigo_venta),cedula_cliente,cedula_usuario,ivaventa,total_venta,valor_venta AS id FROM ventas");
			rs=ps.executeQuery();
			
			if(rs.next()) {
				vendto=new VentasDTO(rs.getLong(1), rs.getLong(2), rs.getLong(3), rs.getDouble(4), rs.getDouble(5),rs.getDouble(6));
				//JOptionPane.showMessageDialog(null, vendto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vendto;
		
	}

}
