package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.Conexion;

public class UsuariosDAO {
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	UsuariosDTO usuariosdto=null;
	
	
	public boolean InsertarUsuarios(UsuariosDTO us) {
		
		int R;
		boolean Dato=false;
		
		try {
			ps=cnn.prepareStatement("INSERT INTO usuarios Values(?,?,?,?,?)");
			ps.setLong(1, us.getCedula_Usuario());
			ps.setString(2, us.getEmail_Usuario());
			ps.setString(3, us.getNombre_Usuario());
			ps.setString(4, us.getPassword());
			ps.setString(5, us.getUsuario());
			R=ps.executeUpdate();
			
			if(R>0) {
				Dato=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Dato;	
	}
	
	public UsuariosDTO ConsultarUsuarios (UsuariosDTO us) {
		
		try {
			ps=cnn.prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario=?");
			ps.setLong(1, us.getCedula_Usuario());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				usuariosdto = new UsuariosDTO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}else
				return null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuariosdto;
	}
	
	public boolean ModificarUsuarios(UsuariosDTO us) {
		boolean Dato=false;
		int M;
		
		try {
			ps=cnn.prepareStatement("UPDATE usuarios SET email_usuario=?, nombre_usuario=?, password=?, "
					+ "usuario=? WHERE cedula_usuario=?");
			ps.setString(1, us.getEmail_Usuario());
			ps.setString(2, us.getNombre_Usuario());
			ps.setString(3, us.getPassword());
			ps.setString(4, us.getUsuario());
			ps.setLong(5, us.getCedula_Usuario());
			
			M=ps.executeUpdate();
			if(M>0) {
				Dato=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Dato;
	}
	
	public boolean EliminarUsuarios(UsuariosDTO us) {
		boolean Dato=false;
		int E;
		
		try {
			ps=cnn.prepareStatement("DELETE FROM usuarios WHERE cedula_usuario=?");
			
			ps.setLong(1, us.getCedula_Usuario());
			E=ps.executeUpdate();
			
			if(E>0) {
				Dato=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Dato;
	}
	
	
	public UsuariosDTO Login (UsuariosDTO us) {
		UsuariosDTO US=null;
		
		String sql="SELECT * FROM usuarios WHERE usuario=? and password=?";
		try {
			ps=cnn.prepareStatement(sql);
			ps.setString(1, us.getUsuario());
			ps.setString(2, us.getPassword());
			rs=ps.executeQuery();
			if(rs.next()) {
				US=new UsuariosDTO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return US;
	}
	public ArrayList<UsuariosDTO>consultageneralusuarios(){
		ArrayList<UsuariosDTO>lista=new ArrayList<UsuariosDTO>();
		try {
			ps=cnn.prepareStatement("SELECT *FROM usuarios");
			rs=ps.executeQuery();
			while(rs.next()) {
				usuariosdto=new UsuariosDTO(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				lista.add(usuariosdto);
				
			}
		} catch (SQLException e) {
			System.out.println("error en la consulta"+ e);
		}
		return lista;
		
	}
	
	
	
}
