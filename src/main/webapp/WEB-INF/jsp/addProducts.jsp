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


        
        <div class="sidenav">
            <div class="login-main-text">
                <h2>Skye</h2>
                <p>Explore the world of shopping.</p>
            </div>
        </div>

        <div class="main">
            <div class="col-md-9 col-sm-12">
                
                <div class="login-form">
                    <h2 style="text-align:center;"> ADD PRODUCTS </h2><br/>
                    <!--Elements-->
                    <form:form class="form-horizontal" modelAttribute="product" method= "post" action="${contextPath}/Seller/productsadded" enctype="multipart/form-data">

                        <div class="form-group">
                            <label for="name">Name</label>
                            <form:input type="text" path="name" class="form-control" id="name" placeholder="Name"/>
                            <form:errors  path="name" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="brand">Brand</label>
                            <form:input type="text" path="brand" class="form-control" id="brand" placeholder="Brand"/>
                            <form:errors  path="brand" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="description">Description</label>
                            <form:input type="text" path="description" class="form-control" id="description" placeholder="Description"/>
                            <form:errors  path="description" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="price">Price</label>
                            <form:input type="text" path="price" class="form-control" id="price" placeholder="Price"/>
                            <form:errors  path="price" cssClass="error"/>
                        </div>

                        <div class="form-group">
                            <label class="form-label" path="file">Upload Image</label>
                            <form:input type="file" class="form-control" id="file" path="file" placeholder="Please upload an image" />
                            <form:errors  path="file" cssClass="error"/>
                        </div>

                        <div class="form-group">
                            <label for="quantity">Quantity</label>
                            <form:input type="text" path="quantity" class="form-control" id="quantity" placeholder="Quantity"/>
                            <form:errors  path="quantity" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="category">Category</label>
                            <form:select  path="categoryid" class="form-control" items="${categories}" itemLabel="name" itemValue="categoryid"> </form:select>
                            </div>
                            <input type="submit" class="btn btn-black" value="Add Products">

                    </form:form>
                </div>

            </div>	





</div>
</body>
</html>
