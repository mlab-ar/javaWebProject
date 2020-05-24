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
@WebServlet("/inicio")
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
		 	String email= request.getParameter("txtEmail");
			String pass= request.getParameter("password");
			UsuariosDAO udao = new UsuariosDAO(null);
			if(udao.validar(email, pass)) {
				HttpSession objsesion = request.getSession(true);
				objsesion.setAttribute("usuario", email);
				request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
			}else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			String accion = request.getParameter("accion");
			
			if(accion.equals("Salir")) {
				HttpSession objsesion = request.getSession(false);
				objsesion.setAttribute("usuario", email);
				//request.getRequestDispatcher("menu.jsp").forward(request, response);
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
