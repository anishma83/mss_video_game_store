<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<h2>${Login_Info}</h2>

	<section id="form">
		<!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form">
						<!--login form-->
						<H2>Login to your account</H2>
						<form:form action="signInCheck" modelAttribute="customer" method="GET">
	<table>
		<tr>
			<td><form:input type="email" path="email" placeholder="E-mail" required="true" /></td>
			<td><form:errors path="email" cssStyle="color: #ff0000;" /></td>
		</tr>
		<tr>
			<td><form:input type="password" path="password" placeholder="Password" required="true" /></td>
			<td><form:errors path="password" cssStyle="color: #ff0000;" /></td>

		</tr>
		
			<td><button class="btn btn-default" type="submit">Submit</button></td>
		
	</table>
</form:form>
					</div>
					<!--/login form-->
				</div>
				<div class="col-sm-1">
					<H2 class="or">OR</H2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form">
						<!--sign up form-->
						<H2>New User Signup!</H2>
						<form action="signUp">
							<BUTTON class="btn btn-default" type="submit">Signup</BUTTON>
						</form>
					</div>
					<!--/sign up form-->
				</div>
			</div>
		</div>
	</section>
	<!--/form-->
