<%-- 
    Document   : about
    Created on : Apr 7, 2021, 4:36:10 PM
    Author     : Anjali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri ="http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
body{margin-top:20px;
color: #bcd0f7;
    background: #ffffff;
}
.account-settings .user-profile {
    margin: 0 0 1rem 0;
    padding-bottom: 1rem;
    text-align: center;
}
.account-settings .user-profile .user-avatar {
    margin: 0 0 1rem 0;
}
.account-settings .user-profile .user-avatar img {
    width: 90px;
    height: 90px;
    -webkit-border-radius: 100px;
    -moz-border-radius: 100px;
    border-radius: 100px;
}
.account-settings .user-profile h5.user-name {
    margin: 0 0 0.5rem 0;
}
.account-settings .user-profile h6.user-email {
    margin: 0;
    font-size: 0.8rem;
    font-weight: 400;
}
.account-settings .about {
    margin: 1rem 0 0 0;
    font-size: 0.8rem;
    text-align: center;
}
.card {
    background: black;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    border-radius: 5px;
    border: 0;
    margin-bottom: 1rem;
}
.form-control {
    border: 1px solid #596280;
    -webkit-border-radius: 2px;
    -moz-border-radius: 2px;
    border-radius: 2px;
    font-size: .825rem;
    background: #EFEFE8FF;
    color: black;
}
        </style>
    </head>
    <body>
          <div class="container">
<div class="row gutters">
	<div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
		<div class="card h-100">
			<div class="card-body">
				<div class="account-settings">
					<div class="user-profile">
                                            <br/>
						<div class="user-avatar">
							<img src="${images}/userProfilePic.jpg" alt="Maxwell Admin">
						</div>
						<h5 class="user-name">${requestScope.user.firstName} 
                                                 ${requestScope.user.lastName} </h5>
						<h6 class="user-email">${requestScope.user.email}</h6>
					</div>

				</div>
			</div>
		</div>
	</div>
	<div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
		<div class="card h-100">
			<div class="card-body">
				<div class="row gutters">
					<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
						<div class="text-right">
                                                    <br/><br/>
							 <div class="text-center"> <a href="${contextPath}/Customer/userDetails" class="btn btn-dark">Account Details</a></div><br/>
                                                         <div class="text-center"> <a href="${contextPath}/Customer/updateShippingAddress" class="btn btn-dark"> Shipping Address</a></div><br/>
                                                         <div class="text-center"> <a href="${contextPath}/Customer/updateBillingAddress" class="btn btn-dark"> Billing Address</a></div><br/>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
          </div>
    </body>
</html>
