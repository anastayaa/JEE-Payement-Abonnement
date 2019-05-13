<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${empty sessionScope.client}">
		<c:redirect url="/public/login.jsp"></c:redirect>
	</c:when>
	<c:when test="${sessionScope.client.role!='abonne'}">
		<c:redirect url="/public/login.jsp"></c:redirect>
	</c:when>
</c:choose>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="public/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div class="form-style-5">
		<form action="MainController" method="POST">
			<fieldset>
				<legend>Paiement de facture en ligne</legend>
				<legend>Mr/Mme: <c:out value="${sessionScope.client.nom}"></c:out></legend>
				<legend>Numero: <c:out value="${sessionScope.client.id}"></c:out></legend>
				<legend>Montant: <c:out value="${sessionScope.client.montant}"></c:out></legend>
				<input type="text" name="carte" placeholder="numero carte *" required>
				<input type="text" name="date" placeholder="Date *" required>
				<input type="text" name="chiffre" placeholder="Chiffres *" required>
				<input type="hidden" name="action" value="paiement">    
			</fieldset>
			<input type="submit" value="Ajouter" />
		</form>
		
		<c:if test="${!empty requestScope.message}">
			<h3><c:out value="${requestScope.message}"></c:out></h3>
		</c:if>
	</div>

</body>
</html>