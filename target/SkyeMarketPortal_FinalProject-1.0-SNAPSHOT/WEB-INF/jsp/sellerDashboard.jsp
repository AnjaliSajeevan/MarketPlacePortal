<%-- 
    Document   : sellerDashboard
    Created on : Apr 25, 2021, 8:47:50 PM
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
                <div class="login-form"><br/><br/>
                    <h2 style="text-align:center;">  ORDERS RECEIVED </h2><br/>
                    
			
		
		<div class='col-xs-12'>
		
		
			<table id="productsTable" class="table table-condensed table-bordered">
							
				<thead>					
					<tr>					
						<th>Order ID</th>
                                                <th>Name</th>
						<th>Quantity</th>
						<th>Total </th>
						<th>Date</th>
                                                <th>Order Status</th>	
                                                <th>Action</th>	
					</tr>					
				</thead>
                                <c:forEach items="${requestScope.orders}" var="orders">
                                                <tr>
                                                    <td>${orders.orders.orderid}</td>
                                                    <td>${orders.product.name}</td>
                                                    <td>${orders.quantity}</td>
                                                    <td>$${orders.price}</td>
                                                    <td>${orders.orders.date}</td>
                                                    <td>${orders.status}</td>
                                                 
                                                    <td><a href="${contextPath}/Seller/${orders.orderItemid}/processOrder" class="btn btn-dark"><i class="fas fa-box-open"></i></a>
                                                    <a href="${contextPath}/Seller/${orders.orderItemid}/delievered" class="btn btn-dark"><i class="fas fa-shipping-fast"></i></a>
                                                    <a href="${contextPath}/Seller/${orders.orderItemid}/cancelOrder" class="btn btn-dark"><i class="far fa-trash-alt"></i></a></td>
                                                </tr>
                                            </c:forEach>
                                            <tr></tr>  
				
			</table>
		
		
		</div>
	
	
	</div>

            </div>
                   


    </body>
</html>
    </body>
</html>
