<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Order Details</title>
<section>
	<div class="container">

		<thead>
			<h3>Order Details</h3>
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
						<th>Ship Date</th>
						<th>Sales Tax</th>
						<th>Order Time</th>
						<th>Fulfilled</th>
						<th>Payment Date</th>
						<th>Total</th>
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
								<td>${details.ship_Date }</td>
								<td>${details.sales_Tax }</td>
								<td>${order.order_Timestamp }</td>
								<td>${details.fulfilled }</td>
								<td>${order.payment_Date }</td>
								<td>${details.total }</td>
								<td><img src="${details.product.image}"
									style="width: 100px; height: 120px" /></td>
							</c:forEach>
							    
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</section>
