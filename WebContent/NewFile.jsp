<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- DIRECTIVA Y ME PERMITE HACERR CONFIGURACIONES -->   
    <%@ page import="java.util.Date" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!--EXPRESIÓN-->
<%-- <%= new java.util.Date() %> --%>

<!--DECLARIACIÓN: Puedo declarar metodos y atributos-->
<%! 
	Date fechaAcutal = new Date();
	Date obtenerFecha(){
		return fechaAcutal;
	}

%>

La fecha actual es <%= obtenerFecha() %> 
</body>
</html>