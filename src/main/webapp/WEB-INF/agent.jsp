<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${empty sessionScope.client}">
		<c:redirect url="/public/login.jsp"></c:redirect>
	</c:when>
	<c:when test="${sessionScope.client.role!='agent'}">
		<c:redirect url="/public/login.jsp"></c:redirect>
	</c:when>
</c:choose>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<a href="MainController?action=deconnecter">Deconnecter</a><br><br>
		<table border="2">
			<tr><th>Nom</th><th>Prenom</th><th>Montant</th></tr>
			<c:forEach var="client" items="${requestScope.clients}">
				<tr>
					<td><c:out value="${client.nom}"></c:out></td>
					<td><c:out value="${client.prenom}"></c:out></td>
					<td><c:out value="${client.montant}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>