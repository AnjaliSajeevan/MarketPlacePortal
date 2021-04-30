<%-- 
    Document   : manageproducts
    Created on : Apr 22, 2021, 2:21:38 PM
    Author     : Anjali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    margin-top: 50%;
                }

                .register-form{
                    margin-top: 10%;
                }
            }

            @media screen and (min-width: 768px){
                .main{
                    margin-left: 25%; 
                }

                .sidenav{
                    width: 20%;
                    position: fixed;
                    z-index: 1;
                    top: 0;
                    left: 0;
                }

                .login-form{
                    margin-top: 5%;
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
        <script src="https://kit.fontawesome.com/75860174f0.js" crossorigin="anonymous"></script>


        <div class="sidenav">
            <div class="login-main-text">
                <h2>Skye</h2>
                <p>Explore the world of shopping.</p>
            </div>
        </div>
        <div class="main">
            <div class="col-md-12">
                <div class="login-form">
                    <h2 style="text-align:center;">  MANAGE PRODUCTS </h2><br/>
                    <div class="text-center"> <a href="${contextPath}/Seller/products" class="btn btn-dark"> Add Product</a></div><br/>
                    
	<hr/>	
	<h2 style="text-align:center;"> Available Products</h2>
	<hr/>
	

				
		
		<div class='col-xs-12'>
		
		
			<table id="productsTable" class="table table-condensed table-bordered">
							
				<thead>					
					<tr>					
						<th>Id</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Price</th>
						<th>Quantity</th>
                                                <th></th>
						<th>Update</th>	
                                                <th>Delete</th>	
					</tr>					
				</thead>
                                <c:forEach items="${requestScope.products}" var="products">
                                                <tr>
                                                    <td>${products.productid}</td>
                                                    <td>${products.name}</td>
                                                    <td>${products.brand}</td>
                                                    <td>$${products.price}</td>
                                                    <td>${products.quantity}</td>
                                                    <td> <img src="${images}/${products.imageURL}" width="50" height="50"/></td>
                                                    <td><a href="${contextPath}/Seller/${products.productid}/updateproduct" class="btn btn-dark"><i class="fas fa-edit"></i></a></td>
                                                    <td><a href="${contextPath}/Seller/${products.productid}/deleteproduct" class="btn btn-dark"><i class="fas fa-trash-alt"></i></a></td>
                                                </tr>
                                            </c:forEach>
                                            <tr></tr>  
				
			</table>
		
		
		</div>
	
	
	</div>

            </div>
        </div>         




 
    </body>
</html>

