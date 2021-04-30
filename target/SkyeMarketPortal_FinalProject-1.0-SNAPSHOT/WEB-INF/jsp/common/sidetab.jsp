<%-- 
    Document   : sidetab
    Created on : Apr 7, 2021, 3:46:44 PM
    Author     : Anjali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h5 class="my-4">Department</h5>
        <div class="list-group">
          <c:forEach items="${categories}" var="category">
              <a href="${contextPath}/Customer/show/category/${category.categoryid}/products" class="list-group-item" id="a_${category.name}">${category.name}</a>
          </c:forEach>
              <br/>
              
              <div class="text-center"> <a href="${contextPath}/Customer/looseSearchPage" class="btn btn-dark"> Search </a></div><br/>
        </div>
    </body>
</html>
