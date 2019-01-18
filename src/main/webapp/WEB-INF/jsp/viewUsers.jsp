<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>

<c:choose>
	<c:when test="${not empty users}">
		<div class="container">
			<table class="table col-md-8 mx-auto my-5">
				<thead class="bg-primary">
					<tr>
						<th scope="col" class="text-light text-center">#</th>
						<th scope="col" class="text-light text-center">Name</th>
						<th scope="col" class="text-light text-center">Phone Number</th>
						<th scope="col" class="text-light text-center">Email</th>
						<th scope="col" class="text-light text-center">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user" varStatus="loop">
						<tr>
							<th scope="row" class="text-center">${loop.count}</th>
							<td class="text-center">${user.userName}</td>
							<td class="text-center">${user.phoneNumber}</td>
							<td class="text-center">${user.email}</td>
							<td class="text-center"><a href="/${user.userId}" class="text-danger h3"
								style="text-decoration: none !important"><b>&times;</b></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:when>
	<c:otherwise>
		<div class="container col-md-8 mx-auto">
			<p style="min-height: 100%;display: flex; align-items: center;"
				class="display-2 text-secondary">No users registered</p>
		</div>
	</c:otherwise>

</c:choose>

<%@ include file="footer.jsp"%>
