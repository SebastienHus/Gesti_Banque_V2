<%@page import="controller.ConversionDevises"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ConversionDevises2</title>
</head>
<body>
<% 

ConversionDevises cd = new ConversionDevises();

float res=cd.conversion(request.getParameter("deviseSRC"), request.getParameter("deviseDest"),Float.parseFloat(request.getParameter("sum")));
%>
<%=res%>
</body>
</html>