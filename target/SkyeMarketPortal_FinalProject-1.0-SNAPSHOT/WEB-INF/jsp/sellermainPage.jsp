<%-- 
    Document   : sellerMainPage
    Created on : Apr 16, 2021, 11:05:30 AM
    Author     : Anjali
--%>

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
                <%@include file="./common/headerSeller.jsp"%>           

            <div class="content">

                <!-- Homepage  -->
                <c:if test="${clickHome==true}">}
                    <%@include file="homepage.jsp"%>
                </c:if> 

                <c:if test="${addProduct==true}">}
                    <%@include file="addProducts.jsp"%>
                </c:if> 

                <c:if test="${addDepartment==true}">}
                    <%@include file="department.jsp"%>
                </c:if> 
                
                <c:if test="${manageProduct==true}">}
                    <%@include file="manageproducts.jsp"%>
                </c:if> 
                
                 <c:if test="${updateProducts==true}">}
                    <%@include file="updateProducts.jsp"%>
                </c:if> 
                 
                  <c:if test="${dashboard==true}">}
                    <%@include file="sellerDashboard.jsp"%>
                </c:if> 
                 
                 
             
                
                

            </div>

            <!-- Footer -->
            <%--<%@include file="./common/footer.jsp"%>--%>

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
