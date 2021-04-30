<%-- 
    Document   : Home
    Created on : Apr 5, 2021, 5:42:05 PM
    Author     : Anjali
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .card-img-top {
width:100px;
height:200px

}
        </style>
    </head>
    <body>
         <div class="container">

    <div class="row">

     
      

      <div class="col-lg-12">

        <div id="carouselExampleIndicators" class="carousel slide my-4 " data-ride="carousel">
          <ol class="carousel-indicators ">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox" >
            <div class="carousel-item active">
              <img class=" mx-auto d-block img-fluid" src="${images}/mainPageImage1.jpg" alt="First slide">
            </div>
            <div class="carousel-item">
              <img class=" mx-auto d-block img-fluid" src="${images}/mainPageImage2.jpg" alt="Second slide">
            </div>
            <div class="carousel-item">
              <img class=" mx-auto d-block img-fluid" src="${images}/mainPageImage3.jpg" alt="Third slide">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>

        <div class="row" >
            <c:forEach items="${requestScope.products}" var="products" end="5">
          <div class="col-lg-4 col-md-3 mb-4">
            <div class="card h-100" >
                <br/>
             <img alt="Card image cap" class="card-img-top img-fluid mx-auto h-50" src="${images}/${products.imageURL}">
              <div class="card-body h-25">
                <h4 class="card-title">
                  ${products.name}</a>
                </h4>
                <h5>$${products.price}</h5>
                <p class="card-text">${products.description}</p>
              </div>
            </div>
          </div>

          </c:forEach>
        </div>

      </div>


    </div>


  </div>

    </body>
</html>
