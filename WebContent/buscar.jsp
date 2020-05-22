<%@page import="entidades.Producto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
		if(request.getAttribute("mensaje") != null){
			out.print(request.getAttribute("mensaje"));
		}
	%>
	<form action="BusquedaServlet" method="POST">
		Nombre: <input type="text" name="nombre" /><br> 
		 <input type="submit" value="Enviar">
	</form>
	
	<% if(request.getAttribute("productos")!= null){
		Producto p = (Producto) request.getAttribute("productos");
		out.print("Se ha encontrado el "+ p);
	}
	 %>
	 
</body>
</html>