<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container my-1">
	<c:choose>
		<c:when test="${not empty info}">
			<div class="alert alert-info alert-dismissible fade show"
				role="alert">
				<strong>Info : </strong> ${info}.
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:when>
		<c:when test="${not empty warn}">
			<div class="alert alert-warning alert-dismissible fade show"
				role="alert">
				<strong>Warning : </strong> ${warn}.
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:when>
		<c:when test="${not empty error}">
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				<strong>Error : </strong> ${error}.
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:when>
		<c:when test="${not empty success}">
			<div class="alert alert-success alert-dismissible fade show"
				role="alert">
				<strong>Success : </strong> ${success}.
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:when>
	</c:choose>
</div>