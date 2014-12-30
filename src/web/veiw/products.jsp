<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!-- <@include file="cssFiles.html"-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Category</h2>
						<div class="panel-group category-products" id="accordian">
							<!--category-productsr-->
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian"
											href="#sportswear"> <span class="badge pull-right"><i
												class="fa fa-plus"></i> </span>Genre</a>
									</h4>
								</div>
								<div id="sportswear" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="/Mss_Video_Game_Store/products">All</a>
											</li>
											<c:forEach var="category" items="${categories}">
												<li>
													<form:form id="${category.name}_ID" 
														method="POST"
														action="${pageContext.request.contextPath}/genre">
														<input name="genreSearch" type="text"  value="${category.category_Id}" style="display: none;" />
														<a onclick="document.getElementById('${category.name}_ID').submit();">${category.name}</a>
													</form:form>
												</li>
											</c:forEach>
										</ul>
									</div>
								</div>

							</div>
						</div>
						<div class="price-range">
							<h2>Price Range</h2>
							<div class="well">
								<input type="text" class="span2" value="" data-slider-min="0"
									data-slider-max="600" data-slider-step="5"
									data-slider-value="[250,450]" id="sl2"><br /> <b>$
									0</b> <b class="pull-right">$ 600</b>
							</div>
							<form:form id="priceSlider"  method="POST"
								action="/Mss_Video_Game_Store/pricing">
									<input name="pID" id="pID" value="" style="display:none;" />
								<a
									onclick="document.getElementById('pID').value= document.getElementsByClassName('tooltip-inner')[0].innerHTML;document.getElementById('priceSlider').submit();">Search By Price</a>
							</form:form>
						</div>
					</div>
				</div>

				<div class="col-sm-9 padding-right">
					<div class="features_items">
						<!--features_items-->
						<h2 class="title text-center">Features Items</h2>

						<c:url value="/${URIPATH}" var="pagedLink">
							<c:param name="action" value="list" />
							<c:param name="genreSearch" value="${genreSearch}" />
							<c:param name="searchValue" value="${searchValue}" />
							<c:param name="pID" value="${priceRange}" />
							<c:param name="p" value="~" />
						</c:url>
						<c:forEach items="${pagedListHolder.pageList}" var="product">
							<div class="col-sm-4">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<img src="${product.image}" alt="" height="200" width="40" />
											<h2>$${product.unit_Price}</h2>
											<p>${product.product_Name}</p>
											<a href="#" class="btn btn-default add-to-cart"><i
												class="fa fa-shopping-cart"></i>Add to cart</a>
										</div>
										<div class="product-overlay">
											<div class="overlay-content">
												<h2>$${product.unit_Price}</h2>
												<p>${product.product_Name}</p>
												<a href="#" class="btn btn-default add-to-cart"><i
													class="fa fa-shopping-cart"></i>Add to cart</a>
											</div>
										</div>
									</div>
									<div class="choose">
										<ul class="nav nav-pills nav-justified">
											<li><a href=""><i class="fa fa-plus-square"></i>Add
													to wishlist</a>
											</li>
											<li><a href=""><i class="fa fa-plus-square"></i>Add
													to compare</a>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<br>
					<div style="text-align: center; vertical-align: middle;">
						<ul class="pagination">
							<tg:paging pagedListHolder="${pagedListHolder}"
								pagedLink="${pagedLink}" />
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--  %@include file="jsFiles.html"%-->
</body>
</html>