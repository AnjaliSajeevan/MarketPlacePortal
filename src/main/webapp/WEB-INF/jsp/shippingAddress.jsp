<%-- 
    Document   : shippingAddress
    Created on : Apr 22, 2021, 11:22:55 PM
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
             .error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
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


                            <form:form class="form-horizontal" modelAttribute="addresss" method="post"  action="${contextPath}/Customer/updateShippingAddress">      
                                <div class="row gutters">
                                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                        <h6 class="mb-3 text-primary">Shipping Address</h6>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="addressid">Address Id</label>
                                            <form:input type="text" path="addressid" class="form-control" id="addressid" value="${requestScope.address.addressid}" readonly="true" />
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="apartment">Apartment</label>
                                            <form:input type="text" path="apartment" class="form-control" id="apartment" value="${requestScope.address.apartment}" />
                                            <form:errors  path="apartment" cssClass="error"/>
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="street">Street</label>
                                            <form:input type="text" path="street" class="form-control" id="street" value="${requestScope.address.street}" />
                                            <form:errors  path="street" cssClass="error"/>
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="city">City</label>
                                            <form:input type="text" path="city" class="form-control" id="city" value="${requestScope.address.city}" />
                                            <form:errors  path="city" cssClass="error"/>
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="state">State</label>
                                            <form:input type="text" path="state" class="form-control" id="state" value="${requestScope.address.state}" />
                                            <form:errors  path="state" cssClass="error"/>
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="country">Country</label>
                                            <form:input type="text" path="country" class="form-control" id="country" value="${requestScope.address.country}" />
                                            <form:errors  path="country" cssClass="error"/>
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="zipCode">Zip Code</label>
                                            <form:input type="text" path="zipCode" class="form-control" id="zipCode" value="${requestScope.address.zipCode}" />
                                            <form:errors  path="zipCode" cssClass="error"/>
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
                        </div>
                    </div>
                </div>
                </body>
                </html>
