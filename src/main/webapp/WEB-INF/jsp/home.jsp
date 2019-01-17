<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<c:choose>
  <c:when test="${not empty user}">
  <b>Welcome </b> ${user.userName}<br>
  <a href="logout">Logout</a>
  </c:when>
  <c:otherwise>
  <a href="login">Login</a>
  </c:otherwise>
</c:choose>
<table>
	<c:forEach  items="${homes}" var="home">
		<tr>
	    <td>${home.name}</td>
	    <td>${home.location}</td>
	    <td>${home.owner.userName}</td>
	    <td>${home.postedOn}</td>
	  </tr>
	</c:forEach>
</table>
</body>
</html>