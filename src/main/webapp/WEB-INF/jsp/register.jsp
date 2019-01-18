
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>
<%@ include file="style.jsp"%>
<div id="form">
	<form:form method="POST" action="/register" modelAttribute="user"
		class="form-signin">
		<h1 class="h3 mb-3 font-weight-normal">Please register</h1>
		<label for="inputName" class="sr-only">Name</label>
		<form:input type="text" id="inputName" class="form-control"
			placeholder="Name" path="userName" required="true" autofocus="true" />
		<label for="inputEmail" class="sr-only">Email address</label>
		<form:input type="email" id="inputEmail" class="form-control"
			placeholder="Email address" path="email" required="true" />
		<label for="inputPhoneNumber" class="sr-only">Phone Number</label>
		<form:input type="text" pattern="[6789][0-9]{9}" id="inputPhoneNumber" class="form-control"
			placeholder="Phone Number" path="phoneNumber" required="true" title="Phone number with 6-9 and remaing 9 digit with 0-9"/>
		<label for="inputPassword" class="sr-only">Password</label>
		<form:input type="password" id="inputPassword" class="form-control"
			placeholder="Password" path="password" required="true" />
		<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>

	</form:form>
</div>

<%@ include file="footer.jsp"%>