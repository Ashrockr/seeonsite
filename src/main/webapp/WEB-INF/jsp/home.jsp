<%@ include file="header.jsp"%>

<div class="album py-5 bg-light">
	<div class="container">
		<div class="row">
			<c:forEach items="${homes}" var="home">
				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">
						<img class="card-img-top" src="images.png" class="img-fluid"
							style="width: auto; height: 195px;">
						<div class="card-body">
							<p class="card-text"><b>Name: </b>${home.name}</p>
							<p class="card-text"><b>Location: </b>${home.location}</p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<a href="/viewRoom/${home.id}" class="btn btn-sm btn-outline-secondary">View</a>
									<c:if test="${home.owner.userId == user.userId}">
									<a href="/updateRoom/${home.id}" class="btn btn-sm btn-outline-secondary">Edit</a>
									</c:if>
								</div>
								<small class="text-muted">${home.postedOn}</small>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>