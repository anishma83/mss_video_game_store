<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Member Profile</title>
<section id="form">
	<!--form-->
	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-1">
				<div class="login-form">
					<table>
						<thead>
							<h3>Personal Information</h3>
						</thead>
						<tr>
							<h5>Member Since: &nbsp ${customer.date_Entered}</h5>
						</tr>
						<tr>
							<td>Name:
							<td>&nbsp
							<td>${customer.first_Name}&nbsp${customer.last_Name}</td>
						</tr>
						<tr></tr>
						<tr>
							<td>Address:
							<td>&nbsp
							<td>${customer.address_1 }&nbsp${customer.address_2}</td>
						</tr>
						<tr>
							<td>
							<td>
							<td>${customer.city },${customer.us_State}
								${customer.postal}, ${customer.country }</td>
						</tr>
						<tr></tr>
						<tr>
							<td>Phone:
							<td>
							<td>${customer.phone }</td>
						</tr>
						<tr>
							<td>Email:
							<td>
							<td>${customer.email }</td>
						</tr>

					</table>

				</div>

				<div>
					<table>
						<thead>
							<h3>Billing Information</h3>
						</thead>
						<tr>
							<td>Card Number:
							<td>&nbsp
							<td>${customer.credit_Card }</td>
						</tr>
						<tr>
							<td>Expiration:
							<td>
							<td>${customer.credit_Expiration_Month },&nbsp
								20${customer.credit_Expiration_Year }</td>
						</tr>
						<tr>
							<td>Address:
							<td>&nbsp
							<td>${customer.billing_Address }${customer.billing_Address_1 }</td>
						</tr>
						<tr>
							<td>
							<td>
							<td>${customer.billing_City },${customer.billing_State}
								${customer.billing_Postal}, ${customer.billing_Country }</td>
						</tr>
					</table>
					<br>
					<div class="signup-form">
						<form action="updateProfile">
							<BUTTON class="btn btn-default" type="submit">Update
								Profile</BUTTON>
						</form>
					</div>
					<br>
				</div>
			</div>
		</div>
	</div>

</section>
<section>
<div class="container">
		
			<thead>
							<h3>Order History</h3>
						</thead>
		
<div>
		<c:if test="${!empty order}">
			<table border="1" style="width: 100%">
				<tr>
					<th>Order Number</th>
					<th>Order Date</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>SKU</th>
					<th>Product Name</th>
					<th>Supplier</th>
					<th>Image</th>

				</tr>
				<c:forEach items="${order}" var="order">
					<tr>
						<td>${order.order_Id}</td>
						<td>${order.order_Date}</td>
						<c:forEach items="${order.orderDetails }" var="details">
							<td>${details.quantity}</td>
							<td>${details.product.unit_Price}</td>
							<td>${details.product.sku}</td>
							<td>${details.product.product_Name}</td>
							<td>${details.product.supplier.company_Name}</td>
							<td><img src="${details.product.image}"
								style="width: 100px; height: 120px" /></td>
						</c:forEach>
						     <td><a href="${pageContext.request.contextPath}/viewOrderDetails?id=${order.order_Id}" >View Details</a></td> 

					</tr>
				</c:forEach>
			</table>
		</c:if>
		<br>
		<div>
			<div class="signup-form">
				<form action="updateProfile">
					<BUTTON class="btn btn-default" type="submit">Update
						Profile</BUTTON>
				</form>
			</div>
			</div>
	</div>
	</div>
	</section>		
