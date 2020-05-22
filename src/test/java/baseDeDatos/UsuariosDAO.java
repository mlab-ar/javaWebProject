package baseDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entidades.Cliente;
import interfaces.I_ClienteRepo;

public class UsuariosDAO implements I_ClienteRepo{

	private Connection conn;
	
	public UsuariosDAO(Connection conn) {
        this.conn = conn;
    }
	 public void inserta(Cliente c) {
	        try (PreparedStatement ps=conn.prepareStatement(
	                "insert into usuarios (nombre, apellido, email) values (?,?,?)",
	                PreparedStatement.RETURN_GENERATED_KEYS)) {
	            ps.setString(1, c.getNombre());
	            ps.setString(2, c.getApellido());
	            ps.setString(3, c.getEmail());
	            System.out.println(c.getNombre() + c.getApellido() + c.getEmail());
	            ps.execute();
	            ResultSet rs=ps.getGeneratedKeys();
	            if(rs.next()) c.setId(rs.getInt(1));
	        } catch (Exception e) { e.printStackTrace(); }
	    }
	 
}
