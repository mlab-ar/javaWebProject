package interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import entidades.Producto;
import excepciones.CafeStoreException;
import excepciones.NegocioException;

public interface I_ProductosRepo {
		 
		 
//		static void inserta(Producto p) throws NegocioException, CafeStoreException {
//		}
//		default void listarImg(int id, HttpServletResponse response) {
//		}
	
		public List<Producto> listar();
		ArrayList<Producto> getProductos();
		
	 
}
