package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseDeDatos.ProductoDAO;
import entidades.Producto;

/**
 * Servlet implementation class ContollerIMG
 */
@WebServlet("/ControladorIMG")
public class ControladorIMG extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorIMG() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    ProductoDAO pdao = new ProductoDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  	
    	 response.setContentType("text/html;charset=UTF-8");
    	 try(PrintWriter out = response.getWriter()){
    		 out.println("<!DOCTYPE html>");
    		 out.println("<html>");
    		 out.println("<head>");
    		 out.println("<title>Servlet ControladorIMG</title>"); 		 
    		 out.println("<body>");
    		 out.println("<h1>"+ request.getContextPath() +"</h1>");   		 
    		 out.println("</body>");    		 
    		 out.println("</head>");	 
    		 out.println("</html>");
    	 }
    	
    }
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		 System.out.println(id);
		 pdao.listarImg(id, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		processRequest(request, response);
 		
	}

}
