<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<h3>CONTRATOS</h3>
<br/><br/>
<input id="open" type="button" value="Novo" onclick="showDiv()"/>
<input id="close" type="button" value="Fechar" onclick="hideDiv()"/>
<br/><br/>

<div id="demo">
	<form action="${pageContext.request.contextPath}/Contratos?action=1" method="post">

	<table>
		<tr>
			<td>CLIENTE:</td>
			<td>
				<select name="cliente" style="min-width: 200px">
					<option value="" >Selecione</option>
					<c:forEach items="${listCliente}" var="cliente">
						<option value="${cliente.id}">${cliente.id} - ${cliente.name}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
			<tr>
			<td>SERVICO:</td>
			<td>
				<select name="servico" style="min-width: 200px">
					<option value="" >Selecione</option>
					<c:forEach items="${listServicos}" var="servico">
						<option value="${servico.id}">${servico.id} - ${servico.name}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
			<tr>
			<td>DATA INICIO:</td>
			<td> <input type="date" name="dtIni"> </td>
		</tr>
		<tr>
			<td>DATA FIM:</td>
			<td> <input type="date" name="dtFim"> </td>
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
		<td>NOME CLIENTE</td>
		<td>CPF CLIENTE</td>
		<td>NOME SERVICO</td>
		<td>VALOR SERVICO</td>
		<td>DT INICIO</td>
		<td>DT FIM</td>
		<td>EXCLUIR</td>
	</tr>
	<tbody>
	    <c:forEach var="var" items="${listContratos}">
	        <tr>
	            <td>${var.id}</td>
	            <td>${var.cliente.name}</td> 
	            <td>${var.cliente.cpf}</td> 
	            <td>${var.servico.name}</td>
	            <td>${var.servico.valor}</td>
	            <td><fmt:formatDate value="${var.dtInicio}" pattern="dd/MM/yyyy" /></td>
	            <td><fmt:formatDate value="${var.dtFim}" pattern="dd/MM/yyyy" /></td>
	            <td>
	            	<form action="${pageContext.request.contextPath}/Contratos?action=2&id=${var.id}" method="post"><input type="submit" value="X"/></form>
	            </td>
	        </tr> 
	    </c:forEach>
    </tbody>
</table>
<br/><br/>
<a href="index.jsp">Voltar</a>
</body>
</html>