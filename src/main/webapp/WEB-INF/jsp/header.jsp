<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<title>SeeOnSite ${title}</title>
</head>


<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-primary">
		<a class="navbar-brand text-light" href="#">SeeOnSite</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse " id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link text-light"
					href="/">Home <span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link text-light"
					href="/postRoom">Post</a></li>
				<c:choose>
					<c:when test="${not empty user && user.userName != null}">
						<c:if test="${user.isAdmin}">
							<li class="nav-item"><a class="nav-link text-light"
								href="/admin/viewUsers">View Users</a></li>
						</c:if>
						<li class="nav-item"><a class="nav-link text-light"
							href="/logout">Logout</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link text-light"
							href="/login">Login</a></li>
						<li class="nav-item"><a class="nav-link text-light"
							href="/register">Register</a></li>
					</c:otherwise>
				</c:choose>
			</ul>

		</div>
	</nav>
	<%@ include file="message.jsp"%>