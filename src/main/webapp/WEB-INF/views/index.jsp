<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Url Shortener</title>
</head>
<body>
	<div>
		<form method="post" action="getUrlRaccourcie">
			Url complète: <input type="text" name="urlComplete" /> <input
				type="submit" value="Raccourcir">
		</form>
		<c:if test="${not empty urlRaccourcie}">
			<h4>Url raccourcie : ${urlRaccourcie}</h4>
		</c:if>
	</div>
	<div>
		<form method="post" action="getUrlComplete">
			Url raccourcie: <input type="text" name="urlRaccourcie"> <input
				type="submit" value="Rechercher url compplete">
		</form>
		<c:if test="${not empty urlComplete}">
			<h4>Url complète : ${urlComplete}</h4>
		</c:if>
		<c:if test="${not empty error}">
			<h4>L'URL demandée est introuvable</h4>
		</c:if>
	</div>
</body>
</html>