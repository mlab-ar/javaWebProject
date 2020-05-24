package servlet;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import baseDeDatos.CompraDAO;
import baseDeDatos.Fecha;
import baseDeDatos.ProductoDAO;
import entidades.Carrito;
import entidades.Cliente;
import entidades.Compra;
import entidades.Pago;
import entidades.Producto;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    ProductoDAO pdao = new ProductoDAO();
    Producto p = new Producto();
    ArrayList<Producto>productos=new ArrayList<>();
   	
    ArrayList<Carrito>listaCarrito = new ArrayList<>();
   	int item;
   	double totalPagar=0.0;
   	int cantidad=1;
   	int idp;
   	Carrito car;
   	
       @SuppressWarnings("unchecked")
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
       	
       	
    	HttpSession objsesion = request.getSession(false);
		String usuario = (String)objsesion.getAttribute("usuario");
		System.out.println("Persona logeada" +usuario);
    	
    	
		String accion = request.getParameter("accion");
       	productos=(ArrayList<Producto>) pdao.listar();
       	if(usuario != null) { 
   		switch(accion) {
   			case "Comprar":
   				totalPagar=0.0;
   				idp=Integer.parseInt(request.getParameter("id"));
   				p = pdao.listarId(idp);
   				item = item+1;
   				car = new Carrito();
   				car.setItem(item);
   				car.setIdProducto(p.getId());
   				car.setNombre(p.getNombre());
   				car.setDescripcion(p.getDescripcion());
   				car.setPrecioCompra(p.getPrecio());
   				car.setCantidad(cantidad);
   				car.setSubtotal(cantidad * p.getPrecio());
   				listaCarrito.add(car);
   				for (int i = 0; i < listaCarrito.size(); i++) {
					totalPagar = totalPagar+listaCarrito.get(i).getSubtotal();
				}
   				request.setAttribute("totalPagar", totalPagar);
   				request.setAttribute("carrito", listaCarrito);
   				request.setAttribute("contador", listaCarrito.size());
   				request.getRequestDispatcher("carrito.jsp").forward(request, response);
   			break;
   			case "AgregarCarrito":
   				int pos=0;
   				cantidad=1;	
   				idp=Integer.parseInt(request.getParameter("id"));
   				p = pdao.listarId(idp);    				
   				if(listaCarrito.size()>0) {
   					for (int i = 0; i < listaCarrito.size(); i++) {
						if(idp==listaCarrito.get(i).getIdProducto()) {
							pos=i;
						}
					}
   					if(idp==listaCarrito.get(pos).getIdProducto()) {
   						cantidad= listaCarrito.get(pos).getCantidad()+cantidad;
   						double subtotal = listaCarrito.get(pos).getPrecioCompra()*cantidad;
   						listaCarrito.get(pos).setCantidad(cantidad);
   						listaCarrito.get(pos).setSubtotal(subtotal);
   					}else {
   						item = item+1;
   	   	   				car = new Carrito();
   	   	   				car.setItem(item);
   	   	   				car.setIdProducto(p.getId());
   	   	   				car.setNombre(p.getNombre());
   	   	   				car.setDescripcion(p.getDescripcion());
   	   	   				car.setPrecioCompra(p.getPrecio());
   	   	   				car.setCantidad(cantidad);
   	   	   				car.setSubtotal(cantidad * p.getPrecio());
   	   	   				listaCarrito.add(car);
   	   	   				 
   					}
   				}else {
   					item = item+1;
   	   				car = new Carrito();
   	   				car.setItem(item);
   	   				car.setIdProducto(p.getId());
   	   				car.setNombre(p.getNombre());
   	   				car.setDescripcion(p.getDescripcion());
   	   				car.setPrecioCompra(p.getPrecio());
   	   				car.setCantidad(cantidad);
   	   				car.setSubtotal(cantidad * p.getPrecio());
   	   				listaCarrito.add(car);
   	   				
   				}		
   				request.setAttribute("contador", listaCarrito.size());
	   			request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
   				
   				break;
   			case "Delete":
   				int idproducto = Integer.parseInt(request.getParameter("idp"));
   				for (int i = 0; i < listaCarrito.size(); i++) {
					if(listaCarrito.get(i).getIdProducto()==idproducto) {
						listaCarrito.remove(i);
					}
				}
   				break;
   			case "ActualizarCantidad":
   				int idpro = Integer.parseInt(request.getParameter("idp"));
   				int cant = Integer.parseInt(request.getParameter("cantidad"));
   				for (int i = 0; i <  listaCarrito.size(); i++) {
					if(listaCarrito.get(i).getIdProducto() == idpro) {
						listaCarrito.get(i).setCantidad(cant);
						double st=listaCarrito.get(i).getPrecioCompra()*cant;
						listaCarrito.get(i).setSubtotal(st);
					}
				}
   				
   				break;
   			case "GenerarCompra":	
   					Cliente cliente= new Cliente();
   					cliente.setId(12);
   					//Pago pago = new Pago();
   					CompraDAO dao = new CompraDAO();
   					Compra compra = new Compra(cliente, 19, Fecha.FechaBD(), totalPagar, "Cancelado",listaCarrito);
   					int res = dao.GenerarCompra(compra);
   					if(res!=0 && totalPagar>0) {
   						request.getRequestDispatcher("mensaje.jsp").forward(request, response);
   					}else {
   						request.getRequestDispatcher("error.jsp").forward(request, response);
   					}
   					break;
   			case "Carrito":
   				totalPagar=0.0;
   				request.setAttribute("carrito", listaCarrito);
   				
   				for (int i = 0; i < listaCarrito.size(); i++) {
					totalPagar = totalPagar+listaCarrito.get(i).getSubtotal();
				}
   				request.setAttribute("totalPagar", totalPagar);
   				request.getRequestDispatcher("carrito.jsp").forward(request, response);
   				
   				break;
   			default:
   				request.setAttribute("productos", productos);
   				request.getRequestDispatcher("index.jsp").forward(request, response);

   		}
       	
       	}else {
       		request.getRequestDispatcher("index.jsp").forward(request, response);
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
