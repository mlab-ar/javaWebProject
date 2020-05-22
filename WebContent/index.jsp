 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="baseDeDatos.ProductoDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Producto"%>
<%@page import="interfaces.I_ProductosRepo" %>
<%@page import="servlet.Controlador"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.util.Date" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table class="table table-hover">
                    <thead>
                        <tr class="text-center">
                            <th>ID</th>
                            <th>NOMBRES</th>
                            <th>DESCRIPCION</th>
                            <th>PRECIO</th>
                            <th>IMAGEN</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${productos}">
                            <tr class="text-center">
                                <td ></td>
                                <td>${p.getNombre()}</td>
                                <td>${p.getDescripcion()}</td>
                                <td>${p.getPrecio()}</td>
                                <td><img src="ControladorIMG?id=${p.getId()}" height="100" width="100"></td>
                                <td>
                                    <a href="Controlador?accion=AgregarCarrito&id=${p.getId()}">Agregar a carrito</a>
                                    <a href="Controlador?accion=Comprar&id=${p.getId()}">Comprar</a>
                                </td>
                            </tr>
                        </c:forEach>                    
                    </tbody>
                </table>  
                <a href="Controlador?accion=home">Home</a>
                 <a href="Controlador?accion=Carrito">(<label>${contador}</label>)Carrito</a>
                 
                 <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>