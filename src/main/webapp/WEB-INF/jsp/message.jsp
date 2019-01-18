<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container my-1">
<c:choose>
	<c:when test="${not empty info}">
		<div class="alert alert-info">
			<strong>Info : </strong> ${info}.
		</div>
	</c:when>
	<c:when test="${not empty warn}">
		<div class="alert alert-warning">
			<strong>Warning : </strong> ${warn}.
		</div>
	</c:when>
	<c:when test="${not empty error}">
		<div class="alert alert-danger">
			<strong>Error : </strong> ${error}.
		</div>
	</c:when>
	<c:when test="${not empty success}">
		<div class="alert alert-success">
			<strong>Success : </strong> ${success}.
		</div>
	</c:when>
</c:choose>
</div>