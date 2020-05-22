package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseDeDatos.ProductoDAO;
import entidades.Producto;
import excepciones.CafeStoreException;
import excepciones.NegocioException;


/**
 * Servlet implementation class BusquedaServlet
 */
@WebServlet("/BusquedaServlet")
public class BusquedaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String nombre = request.getParameter("nombre");
//		try {
////			Producto p = ProductoDAO.getProducto(nombre);
//			System.out.println(p);
//			request.setAttribute("productos", p);
//		} catch (NegocioException e) {
//			request.setAttribute("mensaje", e.getMessage());
//		} catch (CafeStoreException e) {
//			request.setAttribute("mensaje", "Estamos realizando tareas de mantenimiento por favor intente más tarde");
//			e.printStackTrace();
//		} finally {
//			request.getRequestDispatcher("buscar.jsp").forward(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
