package baseDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import entidades.Cliente;
import entidades.Producto;
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
	        try {  
	        	conn = cn.obtenerConexion();
				String sql = "insert into cliente (Dni, Nombres, Direccion, Email, Password, Estado) values (?,?,?,?,?,?)";
	        	ps = conn.prepareStatement(sql);
	            ps.setString(1, c.getDni());
	            ps.setString(2, c.getNombre());
	            ps.setString(3, c.getDomicilio().getCalle());
	            ps.setString(4, c.getEmail());
	            ps.setString(5, c.getPassword());
	            ps.setBoolean(6, false);
	            ps.execute();
	            
	            boolean test= enviarCorreo(c.getEmail(), c.getEmail(), c.getPassword());
	   		 
	    		if(test) {
	    			System.out.print("correo enviado!!");
	    		}else {
	    			System.out.print("MAL!!");
	    		}
	        } catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(e);
				}

			}
	    }
	 
	 public boolean enviarCorreo(String para, String user, String pass) {
		 boolean enviado = false;
		 try {
			String host = "smtp.gmail.com";
			Properties prop = System.getProperties();
			prop.put("mail.transport.protocol", "smtp");
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host", host);
			prop.put("mail.smtp.user", "gabrieldario.lombardo@gmail.com");
			prop.put("mail.smtp.password", "bataclana1986");
			prop.put("mail.smtp.port", "587");
			prop.put("mail.smtp.auth", "false");
			
			Session session = Session.getDefaultInstance(prop);
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress("gabrieldario.lombardo@gmail.com"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));
			
			String asunto = "Email de registro ecommerce";
			String mensaje = "<a href='http://localhost:8080/webProject2/Inicio?txtEmail=" + user 
					+ "&password=" + pass
					+ "&accion=Iniciar+Sesión'>"
					+ "Para confirmar tu registro hace click en este enlace</a>";
			message.setSubject(asunto);
			message.setText(mensaje, "ISO-8859-1", "html");
			
			Transport transport = session.getTransport("smtp");
			transport.connect("gabrieldario.lombardo@gmail.com","bataclana1986");
			
			transport.sendMessage(message, message.getAllRecipients());
			
			transport.close();
			
			enviado = true;
			
			return enviado;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			//e.printStackTrace();
		}
		 return enviado;
		
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
	 
	 public int IdCliente(String email) {
		 Cliente cli=new Cliente();
		 String sql = "select idCliente from cliente where Email=? ";
		 try {
				conn=cn.obtenerConexion();
				ps=conn.prepareStatement(sql);
				ps.setString(1, email);
				rs=ps.executeQuery();
				while(rs.next()) {
					cli.setId(rs.getInt(1));				 
					
				}

			} catch (Exception e) {
				System.out.println(e);
			}finally {	
					try {
						if(conn != null ) conn.close();
						if(ps != null ) ps.close();
						if(rs != null ) rs.close();
					} catch (SQLException e) {
					}
			}
			return cli.getId();
	 }
	 
	 	
	 
}
