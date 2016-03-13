<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes</title>
<link href="leconWeb.css" rel="stylesheet" type="text/css"/>
<script src="<c:url value='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js' />"></script>

</head>
<body">
<table>
	<tr>
		<td><a href="${pageContext.request.contextPath}/index.jsp"> <img src="http://www.lecom.com.br/wp-content/themes/starkers-master/images/logo_lecom_padrao.png"></a> </td>
	</tr>
</table>
<h3>Servicos - Cliente:  ${name}</h3>
<table>
	<tr>
		<td>ID</td>
		<td>NOME</td>
		<td>DESCRIÇÃO</td>
		<td>VALOR</td>
		<td>VALOR COM DESCONTO</td>
		<td>DIAS TERMINO SERVIÇO</td>
	</tr>
	<tbody>
	    <c:forEach var="var" items="${listServicoCliente}">
	        <tr>
	            <td>${var.id}</td>
	            <td>${var.name}</td> 
	            <td>${var.desc}</td> 
	            <td>${var.valor}</td> 
				<td>${var.valorDesconto}</td> 
				<td>${var.daysLeft}</td> 
	        </tr> 
	    </c:forEach>
    </tbody>
</table>
<br/><br/>
<a href="${pageContext.request.contextPath}/Clientes">Voltar</a>
</body>
</html>