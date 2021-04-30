<%-- 
    Document   : loginpage
    Created on : Apr 13, 2021, 8:09:41 PM
    Author     : Anjali
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "form" uri ="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <script src="https://kit.fontawesome.com/75860174f0.js" crossorigin="anonymous"></script>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Angular JS</title>
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
                    margin-top: 20%;
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




        <div class="sidenav">
            <div class="login-main-text">
                <h2>Skye</h2>
                <p>Explore the world of shopping.</p>
            </div>
        </div>
        <div class="main">
            <div class="col-md-6 col-sm-12">
                <div class="login-form" >
                    <h2 style="text-align:center;"> ADD DEPARTMENT </h2><br/>
                    <form:form modelAttribute="department" method="post" id="frmDepartment" action="${contextPath}/Seller/department">

                        <div class="form-group">
                            <label for="categoryid">Category ID</label>
                            <form:input path="categoryid" type="text" class="form-control" id="categoryid" value="${requestScope.category.categoryid}" placeholder="Name" readonly="true"/>
                        </div>

                        <div class="form-group">
                            <label for="name">Name</label>
                            <form:input path="name" type="text" class="form-control" id="name" value="${requestScope.category.name}" placeholder="Name"/>
                            <form:errors  path="name" cssClass="error"/>
                        </div>

                        <div class="form-group">
                            <label for="description">Description</label>
                            <form:input type="text" path="description" class="form-control" id="description" value="${requestScope.category.description}" placeholder="Description"/>
                            <form:errors  path="description" cssClass="error"/>
                        </div>

                        <div class="form-group">				
                            <div  class="text-center">
                                <input type="submit" name="save" value="Save" class="btn btn-black" />
                                <input class="btn btn-black" type="submit" name="update" value="Update"/>
                            </div>
                        </div>
                    </form:form>
                </div>
                <br/>

                <h3 style="text-align:center;"> AVAILABLE DEPARTMENTS </h3>

                <br/>


                <div class='col-xs-12'>


                    <table id="table" class="table table-condensed table-bordered">

                        <thead>					
                            <tr>					
                                <th>Id</th>
                                <th>Name</th>
                                <th>Description</th>
                                <th>Update</th>	
                                <th>Delete</th>	
                            </tr>					
                        </thead>
                        <c:forEach items="${requestScope.departmentlist}" var="department">
                            <tr>
                                <td>${department.categoryid}</td>
                                <td>${department.name}</td>
                                <td>${department.description}</td>
                                <td><a href="${contextPath}/Seller/${department.categoryid}/updateDepartment" class="btn btn-dark"><i class="fas fa-edit"></i></a></td>
                                <td><a href="${contextPath}/Seller/${department.categoryid}/deleteDepartment" class="btn btn-dark"><i class="fas fa-trash-alt"></i></a></td>
                            </tr>
                        </c:forEach>
                        <tr></tr>  

                    </table>



                </div>



            </div>
        </div>



    </body>
</html>



