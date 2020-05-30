<%@page import="baseDeDatos.AdministradorDeConexiones"%>
<%@page import="baseDeDatos.ProductoDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Producto"%>
<%@page import="interfaces.I_ProductosRepo" %>
<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingresar Productos</title>
</head>
<body>
	 
		<form action="servletWeb" method="POST" enctype="multipart/form-data">
			Precio: <input type="text" name="precio">
			Stock: <input type="text" name="stock">
			Nombre: <input type="text" name="nombre">
			Descripción: <input type="text" name="desc">
			Subir imagen: <input type="file" name="fileFoto">
			<button type="submit">Enviar</button>
		</form>
		
		 
</body>
</html>