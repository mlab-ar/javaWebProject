package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import baseDeDatos.ProductoDAO;
import entidades.Carrito;
import entidades.Producto;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/edit")
public class CurrentCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrentCart() {
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
    	String accion2 = request.getParameter("continua");
    	double totalPagar=0.0;
    	
    	
    	HttpSession sesion = request.getSession(true);
    	ArrayList<Carrito> articulos= sesion.getAttribute("carrito") == null? new ArrayList<>() : (ArrayList) sesion.getAttribute("carrito");
    	ArrayList<Carrito> currentCar= sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");
    	String usuario = (String)sesion.getAttribute("usuario");
    	productos=(ArrayList<Producto>) pdao.listar();
    	if(usuario != null) { 
	    	
	    	switch(accion) {
	    		case "Comprar" :
 	    		case "AgregarCarrito":
	    	
		    		int cantidad =Integer.parseInt(request.getParameter("cantidad"));
		        	int idProducto =Integer.parseInt(request.getParameter("id"));
			    	boolean flag = false;
			    	
			    	if(articulos.size()>0) {
			    		for(Carrito a: articulos) {
			    			if(idProducto == a.getIdProducto()) {
			    				a.setCantidad(a.getCantidad() + cantidad);
			    				a.setSubtotal(a.getPrecioCompra() * a.getCantidad());
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
		   				car.setSubtotal(p.getPrecio());
		   				articulos.add(car);
			    	}
			    	sesion.setAttribute("contador2", articulos.size());
			    	sesion.setAttribute("carrito", articulos);    	
			    	if(accion2.equals("si")) {
			    		 request.getRequestDispatcher("edit?accion=Carrito").forward(request, response); 
			    	 }else{
			    		 
			    		 request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
			    	 }
		    	break;
 	    		case "ActualizarCantidad":
 	   				int idpro = Integer.parseInt(request.getParameter("idp"));
 	   				int cant = Integer.parseInt(request.getParameter("cantidad"));
 	   				for (int i = 0; i <  articulos.size(); i++) {
 						if(articulos.get(i).getIdProducto() == idpro) {
 							articulos.get(i).setCantidad(cant);
 							double st=articulos.get(i).getPrecioCompra()*cant;
 							articulos.get(i).setSubtotal(st);
 						}
 					}
 							request.getRequestDispatcher("edit?accion=Carrito").forward(request, response);
 	   				break;
	    		case "Delete":
	    			int idProducto2 =Integer.parseInt(request.getParameter("idp"));
	    			if(currentCar != null) {
			    		for(Carrito ca: currentCar) {
			    			if(ca.getIdProducto() == idProducto2 ) {
 			    				currentCar.remove(ca);
			    				break;
			    			}
			    		}
			    		sesion.setAttribute("contador2", articulos.size());
			    		//response.getWriter().print("/" + articulos.size() + "/");
			    	}
	    			totalPagar=0.0;
	   				request.setAttribute("carrito", articulos);
	   				
	   				for (int i = 0; i < articulos.size(); i++) {
						totalPagar = totalPagar+articulos.get(i).getSubtotal();
					}
 	   				//response.getWriter().print(totalPagar);
	   				ArrayList<Number> currentData = new ArrayList();
	   				currentData.add(articulos.size());
	   				currentData.add(totalPagar);
 	   				Gson gson = new Gson();
 	   				String datos = gson.toJson(currentData);
 	   				PrintWriter printWriter = response.getWriter();
 	   				response.setContentType("application/json");
 	   				response.setCharacterEncoding("UTF-8");
 	   				printWriter.write(datos);
 	   				printWriter.close();
 	   				
	    			break;
	    		case "Carrito":
	   				totalPagar=0.0;
	   				request.setAttribute("carrito", articulos);
	   				
	   				for (int i = 0; i < articulos.size(); i++) {
						totalPagar = totalPagar+articulos.get(i).getSubtotal();
					}
	   				request.setAttribute("totalPagar", totalPagar);
	   				request.getRequestDispatcher("carrito.jsp").forward(request, response);
	   				
	   				break;	
		    	default:
		    		request.getRequestDispatcher("index.jsp").forward(request, response);
	    	}
    	}else {
    		String notLogged = "Debes logearte";
    		request.setAttribute("debesLogearte", notLogged);
    		request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
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
