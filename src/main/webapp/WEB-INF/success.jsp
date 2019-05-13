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
</head>
<body>

	<div align="center">
		<a href="MainController?action=deconnecter">Deconnecter</a>
		<c:if test="${!empty requestScope.message}">
			<h3><c:out value="${requestScope.message}"></c:out></h3>
		</c:if>
	</div>

</body>
</html>