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
        <link href="${css}/shop-homepage.css" rel="stylesheet">

    </head>

    <body>
        <div class="wrapper">
            
            <!-- Header -->
            
           <%@include file="./common/header.jsp"%>


            <!-- Homepage  -->
            <br/>
            <br/>
            <br/>
            <div class="jumbotron">
                <h1>${title}</h1>
                <h3>${error}</h3>
            </div>

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
