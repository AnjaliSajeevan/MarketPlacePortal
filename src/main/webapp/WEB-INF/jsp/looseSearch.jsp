<%-- 
    Document   : looseSearch
    Created on : Apr 29, 2021, 7:00:55 PM
    Author     : Anjali
--%>



<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">

    function search() {
        $.ajax({
            type: "post",
            url: "${contextPath}/Customer/looseSearch/",
            data: "name=" + $('#name').val(),
            success: function (res) {
                var result = "<thead><tr><td>Name</td></tr></thead>";
                result += "<tbody>";
                $.each(res, function (k, v) {
                    result += "<tr>";
                    result += "<td>";
                    result += v;
                    result += "</td>";;
                    result += "</tr>";
                });
                result += "<tbody>";
                $("#result").html(result);
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    }

</script>






<div class="main">
    <div class="col-md-6">
        <div class="login-form">
            <br/>
            <h2 style="text-align:center;"> <b>  AJAX SEARCH <b/> </h2><br/>

            <form>
                <div><h6><b>ENTER CATEGORY ID:</h6><b/>
                    <input type="text" name="name" id="name"/>  <button type="button" onclick="search();" class="btn-black">Search</button>
                </div>

               
            </form>

            <br/>

            <div class='col-xs-12'>


                <table id="result" class="table table-bordered">

                    <thead>					
                        <tr>					
                            <th>Name</th>

                        </tr>					
                    </thead>
                </table>


            </div>


        </div>

    </div>
</div>         

