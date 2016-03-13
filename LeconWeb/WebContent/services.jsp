<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Serviços</title>
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
<h3>SERVIÇOS</h3>
<br/><br/>
<input id="open" type="button" value="Novo" onclick="showDiv()"/>
<input id="close" type="button" value="Fechar" onclick="hideDiv()"/>
<br/><br/>

<div id="demo">
	<form action="${pageContext.request.contextPath}/Servicos?action=1" method="post">

	<table>
		<tr>
			<td>NOME:</td>
			<td> <input type="text" name="name"> </td>
		</tr>
			<tr>
			<td>DESCRIÇÃO:</td>
			<td> <input type="text" name="desc"> </td>
		</tr>
			<tr>
			<td>VALOR:</td>
			<td> <input type="text" name="valor"> </td>
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
		<td>DESCRIÇÃO</td>
		<td>VALOR</td>
		<td>EXCLUIR</td>
	</tr>
	<tbody>
	    <c:forEach var="var" items="${listServicos}">
	        <tr>
	            <td>${var.id}</td>
	            <td>${var.name}</td> 
	            <td>${var.desc}</td> 
	            <td>${var.valor}</td> 
	            <td>
	            	<form action="${pageContext.request.contextPath}/Servicos?action=2&id=${var.id}" method="post"><input type="submit" value="X"/></form>
	            </td>
	        </tr> 
	    </c:forEach>
    </tbody>
</table>
<br/><br/>
<a href="index.jsp">Voltar</a>
</body>
</html>