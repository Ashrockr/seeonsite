
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>
<%@ include file="style.jsp"%>
<div id="form">
	<form:form method="PUT" action="/postRoom/${home.id}" modelAttribute="home"
		class="form-signin">
		<h1 class="h3 mb-3 font-weight-normal">Please enter the details</h1>
		<label for="inputEmail" class="sr-only">Name</label>
		<form:input type="text" id="inputName" class="form-control"
			placeholder="Name" path="name" required="true" autofocus="true" />
		<label class="sr-only">Location</label>
		<form:input type="text"  class="form-control"
			placeholder="Location" path="location" required="true" />
		<label for="inputEmail" class="sr-only">Description</label>
		<form:input type="text" class="form-control"
			placeholder="Description" path="description" required="true" />
		<button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
		<c:choose>
							<c:when test="${home.isApplied}">
								<a class="btn btn-lg btn-info btn-block" href="/unoccupied/${home.id}">Set as UnOccupied</a>
							</c:when>
							<c:otherwise>
								<a class="btn btn-lg btn-info btn-block" href="/occupied/${home.id}">Set as Occupied</a>
							</c:otherwise>
						</c:choose>
		

	</form:form>
</div>

<%@ include file="footer.jsp"%>