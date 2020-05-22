<%@page import="baseDeDatos.AdministradorDeConexiones"%>
<%@page import="baseDeDatos.UsuariosDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
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
window.history.pushState({}, document.title, "/webProject/registro.jsp");

</script>
	 
		<form  onsubmit=limpia();>
			Nombre: <input type="text" name="nombre">
			Apellido: <input type="text" name="apellido">
			Email: <input type="text" name="email">
			<button type="submit">Enviar</button>
		</form>
		<%
		 try{
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String email = request.getParameter("email");
			 if(nombre!=null && !nombre.isEmpty() && apellido!=null && !apellido.isEmpty()){
				 Cliente c = new Cliente(nombre,apellido,email);
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