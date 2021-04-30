<%-- 
    Document   : loginpage
    Created on : Apr 13, 2021, 8:09:41 PM
    Author     : Anjali
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "form" uri ="http://www.springframework.org/tags/form" %>

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

            .main-head{
                height: 150px;
                background: #FFF;

            }

            .sidenav {
                height: 100%;
                background-color: #000;
                overflow-x: hidden;
                padding-top: 100px;
            }


            .main {
                padding: 0px 10px;
            }

            @media screen and (max-height: 450px) {
                .sidenav {padding-top: 15px;}
            }

            @media screen and (max-width: 450px) {
                .login-form{
                    margin-top: 10%;
                }

                .register-form{
                    margin-top: 10%;
                }
            }

            @media screen and (min-width: 768px){
                .main{
                    margin-left: 40%; 
                }

                .sidenav{
                    width: 20%;
                    position: fixed;
                    z-index: 1;
                    top: 0;
                    left: 0;
                }

                .login-form{
                    margin-top: 20%;
                }

                .register-form{
                    margin-top: 20%;
                }
            }


            .login-main-text{
                margin-top: 20%;
                padding: 60px;
                color: #fff;
            }

            .login-main-text h2{
                font-weight: 300;
            }

            .btn-black{
                background-color: #000 !important;
                color: #fff;
            }
        </style>
    </head>
    <body>
        

        <div class="sidenav">
            <div class="login-main-text">
                <h2>Skye</h2>
                <p>Register and be a part of Skye.</p>
            </div>
        </div>
        <div class="main">
            <br/>
            <div class="col-md-6 col-sm-12">
                 <c:if test="${Registered==true}">
                    <div class="alert alert-primary alert-dismissible fade show" role="alert">
                <strong>Registered Successfully!</strong> Please login to explore the world of shopping!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
                </c:if> 
                 <c:if test="${Registered==false}">
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        <strong>Registration Failed!</strong> User already exists!.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
                </c:if> 
                <div class="login-form">
                    <h2>REGISTER</h2><br/>
                    <form:form modelAttribute="users" method="post"  action="${contextPath}/register">

                        <div class="form-group">First Name
                            <form:input type="text" path="firstName" class="form-control" placeholder="First Name *" id="firstName"  />
                            <form:errors  path="firstName" cssClass="error"/>
                        </div>
                        <div class="form-group">Last Name
                            <form:input type="text" class="form-control" placeholder="Last Name*" path="lastName" />
                            <form:errors  path="lastName" cssClass="error"/>
                        </div>
                        <div class="form-group">Email
                            <form:input type="email" class="form-control" placeholder="Email *" path="email" />
                            <form:errors  path="email" cssClass="error"/>
                        </div>
                        <div class="form-group">Password
                            <form:input type="password" class="form-control" placeholder="Password *" path="password"/>
                            <form:errors  path="password" cssClass="error"/>
                        </div>
                        <div class="form-group">Contact Number
                            <form:input type="text" minlength="10" maxlength="10" name="contact" class="form-control" placeholder="Contact Number*" path="contact" />
                            <form:errors  path="contact" cssClass="error"/>
                        </div>
                        <form:label class="radio inline" path="role"> Role:
                                    <input type="radio" name="role" value="customer" checked>
                                    <span>  Customer </span> 
                                </form:label>
                                <form:label class="radio inline" path="role"> 
                                    <input type="radio" name="role" value="seller">
                                    <span> Seller </span> 
                                </form:label>
                                    <br/><br/>
                                    <input type="submit" class="btn btn-black"  value="Register" align/>
                                    <form:hidden path = "enabled"></form:hidden>

                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>