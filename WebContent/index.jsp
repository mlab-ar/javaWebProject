<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>

	<%
		HttpSession objsesion = request.getSession(false);
		String usuario = (String)objsesion.getAttribute("usuario");
// 		if(usuario==null){
// 			response.sendRedirect("index.jsp");
			 
// 		}   
	%> 


<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrito</title>
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

</head>
<body>

 <jsp:include page="header.jsp" /> 
<div class="container-fluid">
  
<jsp:include page="login.jsp" /> 

 	<table class="table table-hover">
         <thead>
             <tr class="text-center">
                 <th>ID</th>
                 <th>NOMBRES</th>
                 <th>DESCRIPCION</th>
                 <th>PRECIO</th>
                 <th>IMAGEN</th>
                  <th>ACCIONES</th>
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
                         <a href="Controlador?accion=Comprar&id=${p.getId()}&<%=usuario%>">Comprar</a>
                     </td>
                 </tr>
             </c:forEach>                    
         </tbody>
     </table>  
                
</div>                 
                 <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</body>
</html>