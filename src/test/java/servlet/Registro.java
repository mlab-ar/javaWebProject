package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseDeDatos.UsuariosDAO;
import entidades.Cliente;
import entidades.Domicilio;
import interfaces.I_ClienteRepo;

/**
 * Servlet implementation class Registro
 */
@WebServlet("/registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) 
   			throws ServletException, IOException {
         
    		I_ClienteRepo interfaz1 = new UsuariosDAO(null);	
    	
    	 
 			String nombre = request.getParameter("nombre");
 			String dni = request.getParameter("dni");
 			String email = request.getParameter("email");
 			String pass = request.getParameter("pass");
 			
 			
 			 if(nombre!=null && !nombre.isEmpty()){
 				 Domicilio d = new Domicilio(20,"zaraza","la matanza");
 				 Cliente c = new Cliente(0,dni,nombre,email,pass,d);
 				 
 				 interfaz1.inserta(c);
 				response.getWriter().print("Le eviaremos en email de confirmación");
 			 }else{
                  response.getWriter().print("Debe ingresar datos!");
              }
          
    	
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

}
