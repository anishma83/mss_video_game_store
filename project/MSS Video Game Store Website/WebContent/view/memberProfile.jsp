
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
							<td>${customer.first_Name}&nbsp${customer.last_Name }</td>
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
						<tr>
							<td><button class="btn btn-default" type="button" onclick="window.location = updateProfile.jsp">Update Profile</button></td>
						</tr>

					</table>
				</div>
			</div>
		</div>
	</div>
</section>
