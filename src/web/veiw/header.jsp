<%@taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" 			prefix="c"%>
<!-- <h1>Name: ${customer.first_Name } logged in:${customer.is_Logged_In }</h1> -->
<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="#"><i class="fa fa-phone"></i> Phone Number</a></li>
								<li><a href="mailto:kbissell@miraclesoft.com"><i class="fa fa-envelope"></i> Email Us</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="${pageContext.request.contextPath}/products"><img src="resources/images/home/logo.png" alt="" /></a>
						</div>
						<div class="btn-group pull-right">
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									USA
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="#">Canada</a></li>
									<li><a href="#">UK</a></li>
								</ul>
							</div>
							
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									DOLLAR
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="#">Canadian Dollar</a></li>
									<li><a href="#">Pound</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								
								
								<li><a href="${pageContext.request.contextPath}/finalCheckout">Checkout &raquo;</a></li>
								<li><a href="#ToDo${pageContext.request.contextPath}/viewCart"><i class="fa fa-shopping-cart"></i> Cart</a></li>
								
								<c:if test="${customer.is_Logged_In }">
								<li><a href="${pageContext.request.contextPath}/viewProfile"><i class="fa fa-user"></i> View Profile</a></li>
								</c:if>
							
								<c:if test="${!customer.is_Logged_In }">
								<li><a href="${pageContext.request.contextPath}/signIn"><i class="fa fa-lock"></i> Login</a></li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="${pageContext.request.contextPath}/products" class="active">Home</a></li>
								<li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="${pageContext.request.contextPath}/products">Products</a></li>
										<li><a href="${pageContext.request.contextPath}/finalCheckout">Checkout</a></li> 
										<li><a href="#ToDo/shoppingCart">Cart</a></li> 
										<c:if test="${customer.is_Logged_In} ">
												<li><a href="${pageContext.request.contextPath}/viewProfile">View Profile</a></li> 
										</c:if>
										<li><a href="${pageContext.request.contextPath}/signIn">Login</a></li> 
										<li><a href="${pageContext.request.contextPath}/signUp">Register</a></li>
                                    </ul>
                                </li> 
								<li><a href="${pageContext.request.contextPath }/404">404</a></li>
								<li><a href="#Todo/contact">Contact</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<form:form method="GET" action="${pageContext.request.contextPath}/search">
								<input name="searchValue" type="text" placeholder="Search" />
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->