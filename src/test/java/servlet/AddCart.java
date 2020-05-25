package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import baseDeDatos.ProductoDAO;
import entidades.Carrito;
import entidades.Producto;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/add")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }
    ProductoDAO pdao = new ProductoDAO();
    Producto p = new Producto();
    ArrayList<Producto>productos=new ArrayList<>();
    int item;
   	double totalPagar=0.0;
   	int cantidad=1;
   	int idp;
   	Carrito car;
    @SuppressWarnings("unchecked")
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String accion = request.getParameter("accion");
    	
    	
    	
    	HttpSession sesion = request.getSession(true);
    	ArrayList<Carrito> articulos= sesion.getAttribute("carrito") == null? new ArrayList<>() : (ArrayList) sesion.getAttribute("carrito");
    	String usuario = (String)sesion.getAttribute("usuario");
    	productos=(ArrayList<Producto>) pdao.listar();
    	if(usuario != null) { 
	    	if(accion.equals("AgregarCarrito")) {
	    		int cantidad =Integer.parseInt(request.getParameter("cantidad"));
	        	int idProducto =Integer.parseInt(request.getParameter("id"));
		    	boolean flag = false;
		    	
		    	if(articulos.size()>0) {
		    		for(Carrito a: articulos) {
		    			if(idProducto == a.getIdProducto()) {
		    				a.setCantidad(a.getCantidad() + cantidad);
		    				flag = true;
		    				break;
		    			}
		    		}
		    	}
		    	
		    	if(!flag) {
		    		totalPagar=0.0;
		    		car = new Carrito();
	   				idp=Integer.parseInt(request.getParameter("id"));
	   				p = pdao.listarId(idp);
	   				item = item+1;
	   				car.setCurrentCar(1);
	   				car.setItem(item);
	   				car.setIdProducto(p.getId());
	   				car.setNombre(p.getNombre());
	   				car.setDescripcion(p.getDescripcion());
	   				car.setPrecioCompra(p.getPrecio());
	   				car.setCantidad(cantidad);
	   				car.setSubtotal(cantidad * p.getPrecio());
	   				articulos.add(car);
		    		//car.add(new Carrito(idProducto, null, null, null, null, null, cantidad, null));
		    	}
		    	sesion.setAttribute("carrito", articulos);
		    	
		    	response.sendRedirect("carrito.jsp");
	    	}
    	}else {
    		
    		request.getRequestDispatcher("add?accion=home").forward(request, response);
    	}
    	 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
