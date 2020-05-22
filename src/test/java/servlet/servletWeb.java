package servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;

import baseDeDatos.ProductoDAO;
import entidades.Producto;
import excepciones.CafeStoreException;
import excepciones.NegocioException;

/**
 * Servlet implementation class servletWeb
 */
@WebServlet("/servletWeb")
@MultipartConfig
public class servletWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletWeb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("desc");
		Double precio = Double.valueOf(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		Part part = request.getPart("fileFoto");
		String nombreImg = request.getParameter("fileFoto");
		InputStream inputStream = part.getInputStream();
		System.out.println(part);
		System.out.println(inputStream);
		System.out.println(nombreImg);
		Producto p = new Producto(0,nombre, descripcion, precio, inputStream, stock);
		//System.out.println(p);
		try {
			ProductoDAO.inserta(p);
			request.setAttribute("mensaje:", "El precio ya esta cargado");
		} catch (NegocioException e) {
			request.setAttribute("mensaje", e.getMessage());
			e.printStackTrace();
		} catch (CafeStoreException e) {
			request.setAttribute("mensaje", "estamos realizando mantenimiento, por favor intente más tarde");
			System.out.println(e);
			e.printStackTrace();
	}
		
		request.getRequestDispatcher("ingresar.jsp").forward(request,response);
	}

}
