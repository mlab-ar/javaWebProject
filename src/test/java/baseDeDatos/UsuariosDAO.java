package baseDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Cliente;
import interfaces.I_ClienteRepo;

public class UsuariosDAO implements I_ClienteRepo{

	private Connection conn;
	static AdministradorDeConexiones cn = new AdministradorDeConexiones();
	PreparedStatement ps;
	ResultSet rs;
	
	public UsuariosDAO(Connection conn) {
        this.conn = conn;
    }
	 public void inserta(Cliente c) {
	        try (PreparedStatement ps=conn.prepareStatement(
	                "insert into cliente (Dni, Nombres, Direccion, Email, Password) values (?,?,?,?,?)",
	                PreparedStatement.RETURN_GENERATED_KEYS)) {
	            ps.setString(1, c.getDni());
	            ps.setString(2, c.getNombre());
	            ps.setString(3, c.getDomicilio().getCalle());
	            ps.setString(4, c.getEmail());
	            ps.setString(5, c.getPassword());
	            ps.execute();
	            ResultSet rs=ps.getGeneratedKeys();
	            if(rs.next()) c.setId(rs.getInt(1));
	        } catch (Exception e) { 
	        }
	    }
	 
	 @Override
	public boolean validar(String email, String password) {
		 String sql = "select * from cliente where Email=? and Password=?";
		try {
			conn=cn.obtenerConexion();
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			rs=ps.executeQuery();
			
			if(rs.absolute(1)) {
				return true;
			}
 
		} catch (Exception e) {
			
		}finally {	
				try {
					if(conn != null ) conn.close();
					if(ps != null ) ps.close();
					if(rs != null ) rs.close();
				} catch (SQLException e) {
				}
		}
		return false;
	}
	 
	 	
	 
}
