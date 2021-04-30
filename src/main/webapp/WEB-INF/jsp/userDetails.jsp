<%-- 
    Document   : userDetails
    Created on : Apr 22, 2021, 11:22:39 PM
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
						<h5 class="user-name">${requestScope.user.firstName}</h5>
						<h6 class="user-email">${requestScope.user.email}</h6>
					</div>

				</div>
			</div>
		</div>
	</div>
	<div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
		<div class="card h-100">
			<div class="card-body">
				
                            <form:form class="form-horizontal" modelAttribute="user" method="post"  action="${contextPath}/Customer/userDetails">
                                <div class="row gutters">
                                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                        <h6 class="mb-3 text-primary">Account Details</h6>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="userid">User ID</label>
                                            <form:input type="text" path="userid" class="form-control" id="userid" value="${user.userid}" readonly="true" />
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="firstName">First Name</label>
                                            <form:input type="text" path="firstName" class="form-control" id="firstName" value="${requestScope.user.firstName}" />
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="lastName">Last Name</label>
                                            <form:input type="text" path="lastName" class="form-control" id="lastName" value="${requestScope.user.lastName}"/>
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="email">Email</label>
                                            <form:input type="email" path="email" class="form-control" id="email" value="${requestScope.user.email}"/>
                                        </div>
                                    </div>
                                         <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="password">Password</label>
                                            <form:input type="text" path="password" class="form-control" id="password" value="${requestScope.user.password}" />
                                        </div>
                                    </div>
                                        
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="contact">Contact Number</label>
                                            <form:input type="text" path="contact" class="form-control" id="contact" value="${requestScope.user.contact}"/>
                                        </div>
                                    </div>
                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="role">Role</label>
                                            <form:input type="text" path="role" class="form-control" id="role" value="${requestScope.user.role}" readonly="true" />
                                        </div>
                                    </div>
                                        

                                </div>
                                <div class="row gutters">
                                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="text-right">
                                            <input type="submit" value="Update" class="btn btn-primary">
                                        </div>
                                    </div>
                                </div>
                            </form:form>

				
    </body>
</html>
