package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import interfacejdbc.Conexion;

public class ProductosDAO {
	
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	Producto prodto;
	
	
	public boolean cargarProctos(String URL) {
		//JOptionPane.showMessageDialog(null, "En Dao"+URL);
		
		boolean resul=false;
		
		try {
			ps=cnn.prepareStatement("load data infile '"+URL+"' into table productos fields terminated by',' lines terminated by '\r\n';");
			resul=ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Error Al Ingresar: " +e);
			e.printStackTrace();
		}
		return resul;
	}
	
	public Producto ConsultarProducto(Producto pd) {
		
		try {
			ps=cnn.prepareStatement("SELECT * FROM productos WHERE codigo_producto=?");
			ps.setLong(1, pd.getCodigo_producto());
			rs=ps.executeQuery();
			if(rs.next()) {
				prodto=new Producto(rs.getLong(1), rs.getLong(2), rs.getLong(3), rs.getString(4), rs.getDouble(5),rs.getDouble(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prodto;
		
	}
	
	
	public Producto listarId(long id) {
		String sql="SELECT * FROM productos WHERE codigo_producto"+id;
		try {
			ps=cnn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				prodto.setCodigo_producto(rs.getLong(1));
				prodto.setIvacompra(rs.getLong(2));
				prodto.setNitproveedor(rs.getLong(3));
				prodto.setNombre_producto(rs.getString(4));
				prodto.setPrecio_compra(rs.getLong(5));
				prodto.setPrecio_venta(rs.getLong(6));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return prodto;
	}
	
	
	public List<Producto> Listar (){
		
		String SQL="SELECT * FROM productos";
		List<Producto>lista=new ArrayList<>();
		
		try {
			ps=cnn.prepareStatement(SQL);
			rs=ps.executeQuery();
			while (rs.next()) {
				prodto=new Producto(rs.getLong(1), 
						rs.getLong(2), 
						rs.getLong(3), 
						rs.getString(4), 
						rs.getDouble(5),
						rs.getDouble(6));
				lista.add(prodto);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	

}
