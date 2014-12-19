<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!--form-->

<div class="signup-form">
	<!--login form-->
	<H2>Update Profile</H2>
	<form:form action="saveCustomer" modelAttribute="customer"
		method="GET">
		<table>
			<tr>
				<td><form:input type="text" path="first_Name"
						placeholder="${customer.first_Name }" required="true" />
					<form:errors path="first_Name" cssStyle="color: #ff0000;" /></td>

				<td><form:input type="text" path="last_Name"
						placeholder="${customer.last_Name }" required="true" /> <form:errors
						path="last_Name" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><form:input type="text" path="address_1"
						placeholder="${customer.address_1 }" required="true" /> <form:errors
						path="address_1" cssStyle="color: #ff0000;" /></td>

				<td><form:input type="text" path="address_2"
						placeholder="${customer.address_2 }" /> <form:errors path="address_2"
						cssStyle="color: #ff0000;" /></td>
			</tr>
		
			<tr>
				<td><form:input type="text" path="city" placeholder="${customer.city }"
						required="true" /> <form:errors path="city"
						cssStyle="color: #ff0000;" /> 
						<form:input type="text"
						path="us_State" placeholder="${customer.us_State }" minlength="2" maxlength="2"
						required="true" style="width: 50px;" /> <form:errors
						path="us_State" cssStyle="color: #ff0000;" />
						 <form:input
						type="text" path="postal" placeholder="${customer.postal }" minlength="5"
						maxlength="9" pattern="\d+" required="true" style="width: 100px;" />
					<form:errors path="postal" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><form:input type="text" path="country"
						placeholder="${customer.country }" required="true" /></td>
				<td><form:errors path="country" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><form:input type="tel" path="phone" placeholder="${customer.phone }"
						minlength="10" maxlength="10" required="true" /></td>
				<td><form:errors path="phone" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><form:input type="email" path="email" placeholder="${customer.email }"
						required="true" /></td>
				<td><form:errors path="email" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><form:input type="password" path="password"
						placeholder="${customer.password }" required="true" /></td>
				<td><form:errors path="password" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><form:input type="text" path="credit_Card"
						placeholder="${customer.credit_Card }" required="true" minlength="16"
						pattern="\d+" /></td>
				<td><form:errors path="credit_Card" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><form:select path="credit_Card_Id">
						<form:option value="NONE" label="Credit Card Type" />
						<form:option value="1" label="MasterCard"/>
						<form:option value="2" label="Visa"/>
						<form:option value="3" label="Discover"/>
						<form:option value="4" label="American Express" />
					</form:select>
				<td><form:errors path="credit_Card_Id"
						cssStyle="color: #ff0000;" /></td>
				<td><form:select path="credit_Expiration_Month">
						<form:option value="None" label="Expiration Month" />
						<form:option value="01" label="January" />
						<form:option value="02" label="February" />
						<form:option value="03" label="March" />
						<form:option value="04" label="April" />
						<form:option value="05" label="March" />
						<form:option value="06" label="June"/>
						<form:option value="07" label="July" />
						<form:option value="08" label="August" />
						<form:option value="09" label="September" />
						<form:option value="10" label="October" />
						<form:option value="11" label="November" />
						<form:option value="12" label="December" />
					</form:select>
				<td><form:errors path="credit_Expiration_Month"
						cssStyle="color: #ff0000;" /></td>

				<td><form:input type="year" path="credit_Expiration_Year"
						placeholder="${customer.credit_Expiration_Year }" size="2" minlength="2" maxlength="2" required="true" /></td>
				<td><form:errors path="credit_Expiration_Year"
						cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><form:input type="text" path="billing_Address"
						placeholder="${customer.billing_Address }" required="true" /></td>
				<td><form:errors path="email" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><form:input type="text" path="billing_Address_1"
						placeholder="${customer.billing_Address_1 }" /></td>
				<td><form:errors path="billing_Address_1"
						cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><form:input type="text" path="billing_City"
						placeholder="${customer.billing_City }" required="true" /></td>
				<td><form:errors path="billing_City" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><form:input type="text" path="billing_State"
						placeholder="${customer.billing_State }" minlength="2" maxlength="2"
						required="true" /></td>
				<td><form:errors path="billing_State"
						cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><form:input type="text" path="billing_Postal"
						placeholder="${customer.billing_Postal }" minlength="5" maxlength="9"
						pattern="\d+" required="true" /></td>
				<td><form:errors path="billing_Postal"
						cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><form:input type="text" path="billing_Country"
						placeholder="${customer.billing_Country }" required="true" /></td>
				<td><form:errors path="billing_Country"
						cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><button class="btn btn-default" type="submit">Submit</button></td>
			</tr>
		
		</table>
	</form:form>
</div>
<!--/form-->
