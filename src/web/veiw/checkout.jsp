
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="content">
	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li class="active">Check out</li>
				</ol>
			</div><!--/breadcrums-->
			<div>
				<div class="bill-to">
					<p>Bill To</p>
					<div class="form-one">
						<form action="">
							<input type="text" placeholder="Email*" value="${customer.email}">
							<input type="text" placeholder="Title" value=""> <input
								type="text" placeholder="First Name *"
								value="${customer.first_Name}"> <input type="text"
								placeholder="Last Name *" value="${customer.last_Name }">
							<input type="text" placeholder="Address 1 *"
								value="${customer.address_1 }"> <input type="text"
								placeholder="Address 2" value="${customer.address_2}">
						</form>
					</div>
					<div class="form-two">
						<form action="">
							<input type="text" placeholder="Zip / Postal Code *"> 
								<select>
									<option>-- Country --</option>
									<option>United States</option>
									<option>Bangladesh</option>
									<option>UK</option>
									<option>India</option>
									<option>Pakistan</option>
									<option>Ucrane</option>
									<option>Canada</option>
									<option>Dubai</option>
								</select>
								<select>
									<option>-- State / Province / Region --</option>
									<option>United States</option>
									<option>Bangladesh</option>
									<option>UK</option>
									<option>India</option>
									<option>Pakistan</option>
									<option>Ucrane</option>
									<option>Canada</option>
									<option>Dubai</option>
								</select> 
								<input type="text" placeholder="Phone *"
									value="${customer.phone}">
						</form>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="order-message">
						<p>Shipping Order</p>
						<textarea name="message"
							placeholder="Notes about your order, Special Notes for Delivery"
							rows="16" cols=""></textarea>
						<label>
							<input type="checkbox"> Shipping to bill
							address
						</label>
					</div>
				</div>
			</div>
			<div class="review-payment">
				<h2>Review & Payment</h2>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${orderDetails}" var="orderDetail"
								varStatus="loop">
							<%@include file="cartProduct.jsp"%>
						</c:forEach>
						<tr>
							<td colspan="4">&nbsp;</td>
							<td colspan="2">
								<table class="table table-condensed total-result">
									<tr>
										<td>Cart Sub Total</td>
										<td>$${cartTotal}</td>
									</tr>
									<tr>
										<td>Sales Tax</td>
										<td>$${salesTax}</td>
									</tr>
									<tr class="shipping-cost">
										<td>Shipping Cost</td>
										<td>$${shippingCost}</td>
									</tr>
									<tr>
										<td>Total</td>
										<td><span>$${total}</span></td>
									</tr>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="payment-options">
				<span> 
					<label>
						<input type="checkbox"> Direct
						Bank Transfer
					</label> 
				</span>
				<span>
					<label>
						<input type="checkbox">
						Check Payment
					</label> 
				</span> 
				<span> 
					<label>
						<input type="checkbox">
						Paypal
					</label>
				</span>
			</div>
		</div>
	</section>
	<!--/#cart_items-->
</div>