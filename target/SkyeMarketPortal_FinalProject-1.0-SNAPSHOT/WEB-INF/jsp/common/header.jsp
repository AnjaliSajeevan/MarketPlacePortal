<%-- 
    Document   : header
    Created on : Apr 7, 2021, 3:46:16 PM
    Author     : Anjali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="${contextPath}/Customer/homepage">Skye</a> 
                
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">

                        
                         <li class="nav-link" id="user">
                             <p style="color:white;"> Hello ${username}!</p>
                            
                        </li> 
                        
                        <li class="nav-item" id="account" >
                           
                            <a class="nav-link"  href="${contextPath}/Customer/account">Account</a>
                            
                        </li> 
                        
                        <li class="nav-item" id="products">
                            <a class="nav-link" href="${contextPath}/Customer/viewProducts">Products</a>
                        </li>
                        
                        
                       
                        <li class="nav-item" id="orders">
                            <a class="nav-link" href="${contextPath}/Customer/orders">Orders</a>
                        </li>
                        
                        <li class="nav-item" id="cart">
                            <a class="nav-link" href="${contextPath}/Customer/cart">Cart</a>
                        </li>
                        
                        <li class="nav-item" id="signout">
                            <a class="nav-link" href="${contextPath}/Customer/signout">Sign out</a>
                        </li>

                    </ul>
                </div>
            </div>
        </nav>
</body>
</html>
