<%@page import="baseDeDatos.AdministradorDeConexiones"%>
<%@page import="baseDeDatos.UsuariosDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Domicilio"%>
<%@page import="entidades.Cliente"%>
<%@page import="interfaces.I_ClienteRepo" %>
<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <% Connection con= new AdministradorDeConexiones().obtenerConexion(); 
    I_ClienteRepo interfaz1 = new UsuariosDAO(con);	
 %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingresar Productos</title>
</head>
<body>

<script>
window.history.pushState({}, document.title, "/webProject2/registro.jsp");

</script>
	 
		<form >
			Nombre: <input type="text" name="nombre">
			dni: <input type="number" name="dni">
			Apellido: <input type="text" name="apellido">
			Email: <input type="text" name="email">
			Password: <input type="text" name="pass">
			<button type="submit">Enviar</button>
		</form>
		<%
		 try{
			String nombre = request.getParameter("nombre");
			String dni = request.getParameter("dni");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			 if(nombre!=null && !nombre.isEmpty()){
				 Domicilio d = new Domicilio(20,"zaraza","la matanza");
				 Cliente c = new Cliente(0,dni,nombre,email,pass,d);
				 
				interfaz1.inserta(c);
			 }else{
                 out.println("<h3>Debe ingresar datos!</h3>");
             }
         }catch(NullPointerException e){
             out.println("<h3>Agregar Producto</h3>");
         }
			
		%> 
		 
</body>
</html>