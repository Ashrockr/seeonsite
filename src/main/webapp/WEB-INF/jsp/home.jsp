<%@ include file="header.jsp"%>

<div class="album py-5 bg-light">
	<div class="container">
		<div class="row">
			<c:forEach items="${homes}" var="home">
				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">
						<c:choose>
							<c:when test="${home.image == null}">
								<div class="carousel slide my-auto" data-ride="carousel">
									<div class="carousel-inner">
										<div class="carousel-item active }">
											<img class="card-img-top" src="../images.png"
												class="img-fluid">
										</div>
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="carousel slide my-auto" data-ride="carousel">
									<div class="carousel-inner">
										<c:forEach items="${home.images}" var="image" varStatus="loop">
											<div class="carousel-item ${loop.count==1?'active':'' }">
												<img class="d-block w-100 card-img-top"
													src="data:image/jpeg;base64,${image.data}"
													alt="${loop.count} slide">
											</div>
										</c:forEach>
									</div>
								</div>
							</c:otherwise>
						</c:choose>
						<div class="card-body">
							<p class="card-text">
								<b>Name: </b>${home.name}</p>
							<p class="card-text">
								<b>Location: </b>${home.location}</p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<a href="/viewRoom/${home.id}"
										class="btn btn-sm btn-outline-secondary">View</a>
									<c:if test="${home.owner.userId == user.userId}">
										<a href="/updateRoom/${home.id}"
											class="btn btn-sm btn-outline-secondary">Edit</a>
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