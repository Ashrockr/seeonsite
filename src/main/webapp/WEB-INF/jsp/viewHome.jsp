<%@ include file="header.jsp"%>
<div class="container album py-5 card-group col-md-6">
	<div class="card col-4">
		<img class="card-img-top" src="../images.png" class="img-fluid"
			style="width: auto; height: 195px;">
	</div>
	<div class="card col-6 container">
		<div class="card-block">
			<h4 class="card-title">${home.name}</h4>
			<div class="card-text">
				<ul class="nav flex-column">
					<li class="nav-item"><span class="text-primary">Location: </span> ${home.location}
					</li>
					<li class="nav-item"><span class="text-primary">Owner Name: </span> ${home.owner.userName}</li>
					<li class="nav-item"><span class="text-primary">Owner Phone Number: </span> ${home.owner.phoneNumber}</li>
					<li class="nav-item"><span class="text-primary">Owner Email: </span> ${home.owner.email}</li>
					<li class="nav-item">
						<c:choose>
							<c:when test="${!home.isApplied}">
								<Strong><span class="text-success">Available</span></Strong>
							</c:when>
							<c:otherwise>
								<Strong><span class="text-danger">Not Available</span></Strong>
							</c:otherwise>
						</c:choose>
					</li>
				</ul>
			</div>

		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>