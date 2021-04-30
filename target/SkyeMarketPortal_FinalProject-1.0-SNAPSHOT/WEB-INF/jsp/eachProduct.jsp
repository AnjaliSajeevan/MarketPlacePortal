<%-- 
    Document   : eachProduct
    Created on : Apr 11, 2021, 2:52:50 PM
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
        <div class="container">

            <!-- Breadcrumb -->
            <div class="row">

                <div class="col-xs-12">


                    <ol class="breadcrumb">

                        <li class="breadcrumb-item"><a href="${contextPath}/Customer/homepage">Home</a></li>
                        <li class="breadcrumb-item"><a href="${contextPath}/Customer/viewProducts">Products</a></li>
                        <li class="breadcrumb-item active">${product.name}</li>
                    </ol>


                </div>


            </div>

            <div class="row">

                <!-- Display the product image -->
                <div class="col-xs-12 col-sm-4">

                    <div class="thumbnail"> 
                        <img src="${images}/${product.imageURL}" width="200" height="250"/>
                    </div>

                </div>


                <!-- Display the product description -->	
                <div class="col-xs-12 col-sm-8">

                    <h3>${product.name}</h3>
                    <hr/>

                    <p>${product.description}</p>
                    <hr/>

                    <p>Price: $${product.price}</p>
                    <hr/>


<br/>
                        <br/>
                    <c:choose>

                        <c:when test="${product.quantity < 1}">

                            <a href="javascript:void(0)" class="btn btn-dark disabled"><strike> Add to Cart</strike></a>

                        </c:when>
                        
                        <c:otherwise>				

                            <a href="${contextPath}/Customer/addtocart/${product.productid}/product" class="btn btn-dark"> Add to Cart</a>

                        </c:otherwise>

                    </c:choose>

                    <a href="${contextPath}/Customer/viewProducts" class="btn btn-success">
                        Continue Shopping</a>
                </div>


            </div>

        </div>
    </body>
</html>
