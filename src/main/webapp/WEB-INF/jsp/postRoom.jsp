
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>
<%@ include file="style.jsp"%>
<div id="form">
	<form:form method="POST" action="/postRoom" modelAttribute="home"
		class="form-signin" enctype="multipart/form-data">
		<h1 class="h3 mb-3 font-weight-normal">Please enter the details</h1>
		<label for="inputEmail" class="sr-only">Name</label>
		<form:input type="text" id="inputName" class="form-control"
			placeholder="Name" path="name" required="true" autofocus="true" />
		<label class="sr-only">Location</label>
		<form:input type="text" class="form-control" placeholder="Location"
			path="location" required="true" />
		<label for="inputEmail" class="sr-only">Description</label>
		<form:input type="text" class="form-control" placeholder="Description"
			path="description" required="true" />
		<label class="sr-only">Images</label>
		<input type="file" name="files" multiple="true" accept='image/*'
			class="form-control" placeholder="Images" />
		<button class="btn btn-lg btn-primary btn-block" type="submit">Post</button>

	</form:form>
</div>

<%@ include file="footer.jsp"%>