<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri ="http://www.springframework.org/tags/form" prefix = "form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>


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
                    margin-top: 10%;
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
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <c:if test="${addedSuccessfullyPro==true}">	
            <div class="col-md-6 col-sm-12">
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>Added Successfully!</strong> The department has been successfully added.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            </div>
        </c:if>
        <div class="sidenav">
            <div class="login-main-text">
                <h2>Skye</h2>
                <p>Explore the world of shopping.</p>
            </div>
        </div>

        <div class="main">
            <div class="col-md-9 col-sm-12">
                <div class="login-form">
                    <h2 style="text-align:center;"> UPDATE PRODUCTS </h2><br/>
                    <!--Elements-->
                    <form:form class="form-horizontal" modelAttribute="product" method= "post" action="${contextPath}/Seller/updateProductResult" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="name">Id</label>
                            <form:input type="text" path="productid" class="form-control" id="productid" value="${requestScope.product.productid}" readonly="true"/>
                        </div>
                        <div class="form-group">
                            <label for="name">Name</label>
                            <form:input type="text" path="name" class="form-control" id="name" value="${requestScope.product.name}"/>
                        </div>
                        <div class="form-group">
                            <label for="brand">Brand</label>
                            <form:input type="text" path="brand" class="form-control" id="brand" value="${requestScope.product.brand}"/>
                        </div>
                        <div class="form-group">
                            <label for="description">Description</label>
                            <form:input type="text" path="description" class="form-control" id="description" value="${requestScope.product.description}"/>
                        </div>
                        <div class="form-group">
                            <label for="price">Price</label>
                            <form:input type="text" path="price" class="form-control" id="price" value="${requestScope.product.price}"/>
                        </div>

                        <div class="form-group">
                            <label for="quantity">Quantity</label>
                            <form:input type="text" path="quantity" class="form-control" id="quantity"  value="${requestScope.product.quantity}"/>
                        </div>
                        
                     <div class="form-group">
                            <label for="quantity">Image</label>
                            <form:input type="text" path="imageURL" class="form-control" id="quantity"  value="${requestScope.product.imageURL}" readonly="true" />
                        </div>
                        
                        <div class="form-group">
                            <label for="category">Category</label>
                            <form:input type="text" path="categoryid" class="form-control" value="${requestScope.category.categoryid}" readonly="true"/>
                            </div>
                            <input type="submit" class="btn btn-black" value="Update">

                    </form:form>
                </div>

            </div>	
</div>
</body>
</html>
