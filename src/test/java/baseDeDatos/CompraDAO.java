package baseDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entidades.Carrito;
import entidades.Compra;

public class CompraDAO {
	Connection con;
	static AdministradorDeConexiones cn = new AdministradorDeConexiones();
	PreparedStatement ps;
	ResultSet rs;
	int r= 0;
	
	public int GenerarCompra(Compra compra) {
		int idcompras;
		String sql = "insert into compras(idCliente,FechaCompras,Monto,Estado,idPago)values(?,?,?,?,?)";
		try {
			con = cn.obtenerConexion();
			ps = con.prepareStatement(sql);
			ps.setInt(1, compra.getCliente().getId());
			ps.setString(2, compra.getFecha());
			ps.setDouble(3, compra.getMonto());
			ps.setString(4, compra.getEstado());
			ps.setInt(5, compra.getIdPago());
			r = ps.executeUpdate();
			
			sql="Select @@IDENTITY as idCompras";
			rs= ps.executeQuery(sql);
			rs.next();
			idcompras=rs.getInt("idCompras");
			rs.close();
			
			for (Carrito detalle : compra.getDetallecompra()) {
				sql="insert into detalle_compras(idProducto,idCompras,Cantidad,PrecioCompra)values(?,?,?,?)";
				ps=con.prepareStatement(sql);
				ps.setInt(1, detalle.getIdProducto());
				ps.setInt(2, idcompras);
				ps.setInt(3, detalle.getCantidad());
				ps.setDouble(4, detalle.getPrecioCompra());
				r = ps.executeUpdate();
			}
			
		} catch (Exception e) {
			System.out.print(e);
		}
		return r;
	}
	
}
