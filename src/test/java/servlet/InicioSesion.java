package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import baseDeDatos.UsuariosDAO;
import entidades.Cliente;

/**
 * Servlet implementation class InicioSecion
 */
@WebServlet("/Inicio")
public class InicioSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioSesion() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	private void processRequest(HttpServletRequest request, HttpServletResponse response) 
   			throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
		 
			String accion = request.getParameter("accion");
		 	String email= request.getParameter("txtEmail");
			String pass= request.getParameter("password");
			int clienteId;
			UsuariosDAO udao = new UsuariosDAO(null);
			clienteId = udao.IdCliente(email);
			String test = String.valueOf(clienteId);
			
			if(udao.validar(email, pass)) {
				HttpSession objsesion = request.getSession(true);
				Cliente currentCli = new Cliente();
				currentCli.setId(clienteId);
				currentCli.setEmail(email);
				
				//System.out.println(currentCli);
				objsesion.setAttribute("usuario", email);
				objsesion.setAttribute("pass", pass);
				objsesion.setAttribute("test", test);				
				request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
			}else {
				HttpSession objsesion = request.getSession(false);
				objsesion.removeAttribute("usuario");
				objsesion.removeAttribute("clienteId");
				objsesion.removeAttribute("pass");
				//request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			if(accion.equals("Salir")) {
				HttpSession objsesion = request.getSession(false);
				objsesion.removeAttribute("usuario");
				objsesion.removeAttribute("clienteId");
				objsesion.invalidate();
				request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
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
