<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="vendor" value="/resources/vendor"/>
<spring:url var="images" value="/resources/images" />

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Skye.com : ${title}</title>

        <script>
            window.menu = "${title}";
        </script>     



        <!-- Homepage Bootstrap CSS -->
        <link href="${vendor}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Bootstrap theme for product table (datatable)-->
        <link href="${vendor}/bootstrap/css/dataTables.bootstrap.css" rel="stylesheet">

        <!-- CSS template -->
        <link href="${css}/myapp.css" rel="stylesheet">

    </head>

    <body>
        <div class="wrapper">

            <!-- Header -->

            <%@include file="./common/header.jsp"%>



            <div class="content">

                <!-- Homepage  -->
                <c:if test="${clickHome==true}">}
                    <%@include file="homepage.jsp"%>
                </c:if> 

                <c:if test="${clickAccount==true}">}
                    <%@include file="account.jsp"%>
                </c:if> 

                <c:if test="${clickCart==true}">}
                    <%@include file="cart.jsp"%>
                </c:if> 

                <c:if test="${clickOrders==true}">}
                     <%@include file="orders.jsp"%>
                </c:if> 
                     

                <c:if test="${clickProducts==true or clickDeptProducts==true}">}
                    <%@include file="products.jsp"%>
                </c:if> 

                <c:if test="${clickEachProducts==true}">}
                    <%@include file="eachProduct.jsp"%>
                </c:if> 
                
                <c:if test="${shipping==true}">}
                    <%@include file="shippingAddress.jsp"%>
                </c:if> 
                
                <c:if test="${account==true}">}
                    <%@include file="userDetails.jsp"%>
                </c:if> 
                
                <c:if test="${billing==true}">}
                    <%@include file="billingAddress.jsp"%>
                </c:if> 
                
                <c:if test="${orderItemList==true}">}
                    <%@include file="orderpdf.jsp"%>
                </c:if> 
                
                <c:if test="${LooseSearch==true}">}
                    <%@include file="looseSearch.jsp"%>
                </c:if> 
              

            <!-- Bootstrap core JavaScript -->
            <script src="${vendor}/jquery/jquery.min.js"></script>
            <script src="${vendor}/bootstrap/js/bootstrap.bundle.min.js"></script>



            <!-- DataTable -->
            <script src="${vendor}/jquery/jquery.dataTables.js"></script>

            <!-- js file-->
            <script src="${vendor}/jquery/myapp.js"></script>



        </div>

    </body>

</html>
