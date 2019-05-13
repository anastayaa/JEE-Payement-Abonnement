<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div class="form-style-5">
		<form action="../MainController" method="POST">
			<fieldset>
				<legend><span class="number">1</span> Authentification</legend>
				<input type="text" name="login" placeholder="login*" required>
				<input type="password" name="mdp" placeholder="mot de passe *" required>
				<input type="hidden" name="action" value="login">     
			</fieldset>
			<input type="submit" value="Login" />
		</form>
	</div>

</body>
</html>