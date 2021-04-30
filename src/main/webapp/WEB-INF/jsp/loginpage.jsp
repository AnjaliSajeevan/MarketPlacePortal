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
                    margin-top: 50%;
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
                <p>Login to explore the world of shopping.</p>
            </div>
        </div>
        <div class="main">
            <div class="col-md-6 col-sm-12">
                <br/>
                <c:if test="${loginfailed==true}">
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        <strong>Login Failed!</strong> Please verify the credentials and login again!.
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if> 

                <div class="login-form">
                    <h2> LOGIN </h2><br/>
                    <form method="post" action="${contextPath}/login">
                        <div class="form-group">
                            <label for= "email">Email</label>
                            <input name="email" type="email" class="form-control" placeholder="Email Address"/>
                            <form:errors  path="email" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="password" >Password</label>
                            <input name="password" type="password" class="form-control" placeholder="Password"/>
                            <form:errors  path="password" cssClass="error"/>
                        </div>
                       <button type="submit" class="btn btn-black">Login</button>
                    </form>

                </div>
            </div>
        </div>
    </body>
</html>