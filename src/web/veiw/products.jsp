<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#sportswear">
										<span class="badge pull-right"><i class="fa fa-plus"></i></span>Genre</a>
									</h4>
								</div>
								<div id="sportswear" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li>
												<a href="/Mss_Video_Game_Store/products">All</a>
											</li>
											<c:forEach var="category" items="${categories}">
												<li>
													<form:form commandName="catnames" id="${category.name}_ID" method="POST" action="/Mss_Video_Game_Store/genre">
														<form:input path ="name" value="${category.name}" style="display:none;"/>
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
								<input type="text" class="span2" value="" data-slider-min="0" data-slider-max="600" data-slider-step="5" data-slider-value="[250,450]" id="sl2" ><br />
								<b>$ 0</b> <b class="pull-right">$ 600</b>
							</div>
							<form:form id="priceSlider" commandName="pr" method="POST" action="/Mss_Video_Game_Store/pricing">
								<form:input id = "pID" path ="notes" value="" style="display:none;"/>
								<a onclick="document.getElementById('pID').value= document.getElementsByClassName('tooltip-inner')[0].innerHTML;document.getElementById('priceSlider').submit();">GO</a>
								</form:form>
						</div>	
						</div>
					</div>				
				<div class="shipping text-center"><!--shipping-->
					<img src="images/home/shipping.jpg" alt="" />
				</div><!--/shipping-->				
				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
					<h2 class="title text-center">Features Items</h2>
				
				<c:forEach var="product" items="${products}">
					<div class="col-sm-4">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="${product.image}" alt="" height="200" width="40" />
									<h2>$${product.unit_Price}</h2>
									<p>${product.product_Name}</p>
									<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
								</div>
								<div class="product-overlay">
									<div class="overlay-content">
										<h2>$${product.unit_Price}</h2>
										<p>${product.product_Name}</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
									</div>
								</div>
							</div>
							<div class="choose">
								<ul class="nav nav-pills nav-justified">
									<li><a href=""><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
									<li><a href=""><i class="fa fa-plus-square"></i>Add to compare</a></li>
								</ul>
							</div>
						</div>
					</div>
				</c:forEach>
			
				<ul class="pagination">
					<li class="active"><a href="">1</a></li>
					<li><a href="">2</a></li>
					<li><a href="">3</a></li>
					<li><a href="">&raquo;</a></li>
				</ul>
			</div>
		</div>
			</div>
		</div>
</section>
<!--  %@include file="jsFiles.html"%-->
</body>
</html>