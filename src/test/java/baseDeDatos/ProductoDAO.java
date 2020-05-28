package baseDeDatos;

import java.sql.Connection;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import entidades.Producto;
import excepciones.CafeStoreException;
import excepciones.NegocioException;
import interfaces.I_ProductosRepo;

public class ProductoDAO{

//	private Connection conn;
//	public ProductoDAO(Connection conn) {
//        this.conn = conn;
//    }
	
	Connection con;
	static AdministradorDeConexiones cn = new AdministradorDeConexiones();
	PreparedStatement ps;
	ResultSet rs;
	 
	
	public static void inserta(Producto p) throws NegocioException, CafeStoreException {
		 if (existe(p.getNombre())) {
			 throw new NegocioException("El producto ya existe");
		 }
			Connection con = null;
			PreparedStatement st = null;
			try {
				con = cn.obtenerConexion();
				String sql = "insert into producto (Nombres, Foto, Descripcion, Precio, Stock) values (?,?,?,?,?)";
				st = con.prepareStatement(sql);
				st.setString(1, p.getNombre());
				st.setBlob(2, p.getFoto());
				st.setString(3, p.getDescripcion());
				st.setDouble(4, p.getPrecio());
				st.setDouble(5, p.getStock());
				st.execute();
			} catch (Exception e) {
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
				}

			}
		}
	
	public Producto listarId(int id) {
		String sql = "select * from producto where idProducto=" + id;			 
			Producto p = new Producto();
			
			try {
				con = cn.obtenerConexion();
				ps = con.prepareStatement(sql);
				rs= ps.executeQuery();
				while(rs.next()) {
					p.setId(rs.getInt(1));
					p.setNombre(rs.getString(2));
					p.setFoto(rs.getBinaryStream(3));
					p.setDescripcion(rs.getString(4));
					p.setPrecio(rs.getDouble(5));
					p.setStock(rs.getInt(6));
				}
				
			} catch (Exception e) {
			} 
			
			return p;
		}
	
	
	 public static boolean existe(String nombre) throws NegocioException, CafeStoreException {
			Connection con = null;
 			ResultSet rs = null;
			PreparedStatement st = null;
			boolean respuesta = false;
			try {
				try {
					con = cn.obtenerConexion();
				} catch (Exception e) {
					e.printStackTrace();
					throw new CafeStoreException();
				}
				String sql = "select * from producto where Nombres  = ?";
				st = con.prepareStatement(sql);
				st.setString(1, nombre);
				rs = st.executeQuery();
				if (rs.next()) {
					respuesta = true;
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					st.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}

			}
			return respuesta;
		}
	
	
	 
	public List listar() {
		List<Producto>productos=new ArrayList<Producto>();
		String sql = "select * from producto";
		try {
			con= cn.obtenerConexion();
			ps=con.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) {
				Producto p=new Producto();
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setFoto(rs.getBinaryStream(3));
				p.setDescripcion(rs.getString(4));
				p.setPrecio(rs.getDouble(5));
				p.setStock(rs.getInt(6));
				productos.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return productos;
	}
	 
	 public void listarImg(int id, HttpServletResponse response) {
		 Connection con = null;
		 ResultSet rs = null;
		 PreparedStatement st = null;
		 
		 String sql="select * from producto where idProducto=" + id;
		 InputStream inputStream=null;
		 OutputStream outputStream = null;
		 BufferedInputStream bufferedInputStream=null;
		 BufferedOutputStream bufferedOutputStream=null;
 		 try {
			outputStream= response.getOutputStream();
			con = cn.obtenerConexion();
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()) {
				inputStream= rs.getBinaryStream("Foto");
			}
			bufferedInputStream = new BufferedInputStream(inputStream);
			bufferedOutputStream = new BufferedOutputStream(outputStream);
			int i = 0;
			while((i=bufferedInputStream.read())!= -1) {
				bufferedOutputStream.write(i);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }
	 
	 
//	 @Override
//	    public List<Producto> getAll() {
//	        List<Producto>list=new ArrayList<Producto>();
//	        try (ResultSet rs=conn.createStatement().executeQuery(
//	                "select * from productos")){
//	            while(rs.next()){
//	                list.add(
//	                        new Producto(
//	                        		rs.getString("nombre"),
//	    	                        rs.getString("descripcion"),
//	    	                        rs.getDouble("precio")
//	                        )
//	                );
//	            }
//	        } catch (Exception e) { e.printStackTrace(); }
//	        return list;
//	    }



}
