<html>
    <head>
        <title> jsp page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            .row{
            margin-top: 2%;
            }
        </style>
    </head>
    <body>
        <script src="https://kit.fontawesome.com/75860174f0.js" crossorigin="anonymous"></script>
        <div class="container" >

            <div class="row">

                <div class="col-lg-3">

                    <!--Sidebar-->
                    <%@include file="./common/sidetab.jsp"%>
                </div>
                <!--to display the actual product-->
                <div class="col-md-9">

                    <!--add the /component breadcrumb-->
                    <div class="row">
                        <div class="col-lg-12">

                            <c:if test="${clickProducts==true}">

                                <ol class="breadcrumb">

                                    <li class="breadcrumb-item"><a href="${contextPath}/Customer/homepage">Home</a></li>
                                    <li class="breadcrumb-item active"> All Products</li>
                                </ol>

                                <div class="row">

                                    <div class="col-lg-12">
                                        <table class="table table-striped table-bordered">
                                            <thead> 
                                                <tr>
                                                    <th>Name</th>
                                                    <th>Brand</th>
                                                    <th>Price</th>
                                                    <th>Quantity</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <c:forEach items="${requestScope.products}" var="products">
                                                <tr>
                                                    <td>${products.name}</td>
                                                    <td>${products.brand}</td>
                                                    <td>$${products.price}</td>
                                                    <td>${products.quantity}</td>
                                                    <td><a href="${contextPath}/Customer/show/${products.productid}/product" class="btn btn-dark"><i class="fab fa-readme"></i></a></td>

                                                </tr>

                                            </c:forEach>
                                            <tr></tr>     
                                        </table>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${clickDeptProducts==true}">

                                <ol class="breadcrumb">

                                    <li class="breadcrumb-item"><a href="${contextPath}/Customer/homepage">Home</a></li>
                                    <li class="breadcrumb-item active">Category</li>
                                    <li class="breadcrumb-item active">${category.name}</li>

                                </ol>
                                <div class="row">

                                    <div class="col-lg-12">
                                        <table class="table table-striped table-bordered">
                                            <thead> 
                                                <tr>
                                                    <th>Name</th>
                                                    <th>Brand</th>
                                                    <th>Price </th>
                                                    <th>Quantity</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <c:forEach items="${requestScope.products}" var="products">
                                                <tr>
                                                    <td>${products.name}</td>
                                                    <td>${products.brand}</td>
                                                    <td>$${products.price}</td>
                                                    <td>${products.quantity}</td>
                                                    <td><a href="${contextPath}/Customer/show/${products.productid}/product" class="btn btn-dark"><i class="fab fa-readme"></i></a> </td>
                                                </tr>
                                            </c:forEach>
                                            <tr></tr>     
                                        </table>
                                    </div>
                                </div>

                            </c:if>

                        </div>
                    </div>




                </div>
            </div>    
        </div>
    </body>
</html> 
