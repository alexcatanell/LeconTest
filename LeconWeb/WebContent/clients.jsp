<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes</title>
<link href="leconWeb.css" rel="stylesheet" type="text/css"/>
<script src="<c:url value='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js' />"></script>
<script type="text/javascript">
 function hideDiv(){
	 $('#demo').hide();
	 $('#open').show();
	 $('#close').hide();
 }
 function showDiv(){
	 $('#demo').show();
	 $('#open').hide();
	 $('#close').show();
 }
</script>
</head>
<body onload="hideDiv()">
<table>
	<tr>
		<td><a href="${pageContext.request.contextPath}/index.jsp"> <img src="http://www.lecom.com.br/wp-content/themes/starkers-master/images/logo_lecom_padrao.png"></a> </td>
	</tr>
</table>
<h3>CLIENTES</h3>
<br/><br/>
<input id="open" type="button" value="Novo" onclick="showDiv()"/>
<input id="close" type="button" value="Fechar" onclick="hideDiv()"/>
<br/><br/>

<div id="demo">
	<form action="${pageContext.request.contextPath}/Clientes?action=1" method="post">

	<table>
		<tr>
			<td>NOME:</td>
			<td> <input type="text" name="name"> </td>
		</tr>
			<tr>
			<td>CPF:</td>
			<td> <input type="text" name="cpf"> </td>
		</tr>
			<tr>
			<td>E-MAIL:</td>
			<td> <input type="text" name="email"> </td>
		</tr>
			<tr>
			<td>CLASSE:</td>
			<td>
			<select name="classe">
				<option value="" >Selecione</option>
				<option value="1">OURO</option>
				<option value="2">PRATA</option>
			</select>
			</td>
		</tr>
		<tr>
			<td> <input type="submit" value="Salvar"></td>
			<td> <input type="reset" value="Limpar"> </td>
		</tr>
	</table>
</form>
</div>

<br/><br/>

<table>
	<tr>
		<td>ID</td>
		<td>NOME</td>
		<td>E-MAIL</td>
		<td>CPF</td>
		<td>CLASSE</td>
		<td>EXCLUIR</td>
		<td>VISUALIZAR</td>
	</tr>
	<tbody>
	    <c:forEach var="var" items="${listCliente}">
	        <tr>
	            <td>${var.id}</td>
	            <td>${var.name}</td> 
	            <td>${var.email}</td> 
	            <td>${var.cpf}</td> 
	            <td>
	            	<c:if test="${var.classe == 1}">OURO</c:if>
	            	<c:if test="${var.classe == 2}">PRATA</c:if>
	            </td>
	            <td>
	            	<form action="${pageContext.request.contextPath}/Clientes?action=2&id=${var.id}" method="post"><input type="submit" value="X"/></form>
	            </td>
	            <td>
	            	<form action="${pageContext.request.contextPath}/Clientes?action=3&id=${var.id}&name=${var.name}" method="post"><input type="submit" value="SERVIÇOS"/></form>
	            </td>  
	        </tr> 
	    </c:forEach>
    </tbody>
</table>
<br/><br/>
<a href="index.jsp">Voltar</a>
</body>
</html>