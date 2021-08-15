<%-- 
    Document   : homeView
    Created on : May 26, 2021, 10:16:18 PM
    Author     : Dai
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

        <title>Document</title>
    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>
            <div class="container">
                <form class="form-row align-items-center" action="${pageContext.request.contextPath}/home" method="POST" style="width: 100%" >
                <!--                <div class="col-auto" style="display: none">
                                    <input type="text" class="form-control mb-2"  placeholder="Tên" name="name">
                                </div>-->


                <div class="col-auto" style="width: 100%" >
                    <button type="submit" name="logout" value="logout" class="btn btn-primary mb-2" style="float: right;background-color: white;border: none;color: #007bff;margin-right: 50px">Đăng Xuất</button>   
                </div>
            </form>       

        </div>


        <div class="container mt-3"style="
             " >
            <h2>Wellcome ${user.getName()}</h2>
            <h2  id="us">Danh Bạ</h2>
            <p>Nhập thông tin</p>

            <p style="color: red">${error}</p>
            <form class="form-row align-items-center" action="${pageContext.request.contextPath}/home" method="POST" >
                <div class="col-auto">
                    <input type="text" class="form-control mb-2"  placeholder="Tên" name="name">
                </div>
                <div class="col-auto" >
<!--                <input type="text" name="password" value= "${user.password}" />-->
                    <input type="text" name="phone"  class="form-control mb-2" placeholder="Tên"/> <!-- class="form-control mb-2" id="phone" --> 
                </div>

                <div class="col-auto">
                    <button type="submit"  value="Submit" class="btn btn-primary mb-2">Submit</button> 
                </div >
                <div class="telephone-directory col-lg-10" style="min-height:  330px; text-indent: ">
                    ${result}  
                </div>

            </form>





        </div>


        <!-- <div id="person--1" class="row">
            <div class="col-lg-9 row">
                <div class=" col-lg-8">ten</div>
                <div class=" col-lg-4">so</div>
            </div>
            <div class="col-lg-3">
                <div class="col-auto">
                    <button type="button" onclick="" class="btn btn-primary mb-2">Gọi</button>
                    <button type="button" onclick='xoa("person--1")' class="btn btn-primary mb-2">Xóa</button>
                </div>      
            </div>                    
        </div> -->




        <jsp:include page="_footer.jsp"></jsp:include>
        <script>
            function myFunction(phone, id) {
                console.log(phone, id);
                window.open("http://localhost:8080/DanhBaOnline/view?phone=" + phone + "&userID=" + id);
            }
            var dem = 0;

            function them() {

                var name = document.getElementById("name")
                var phone = document.getElementById("phone")
                x = 'xoa("person-' + String(dem) + '")'

                var str = '      <div  id="person-' + dem + '" class="row">    <div class="col-lg-9 row">       <div class=" col-lg-8">' + name.value + '</div>      <div class=" col-lg-4">' + phone.value + '</div> </div>   <div class="col-lg-3">       <div class="col-auto">          <button type="button" onclick="" class="btn btn-primary mb-2">Gọi</button>        <button type="button" onclick=' + x + ' class="btn btn-primary mb-2">Xóa</button></div>         </div>                    </div>'


                dem++
                var m = document.getElementById('as')
                m.innerHTML = str + m.innerHTML
                name.value = ""
                phone.value = ""

            }
            function xoa(id) {

                console.log('1' + typeof str)

                console.log(id)
                var temp = document.getElementById(id)
                temp.remove()
            }
        </script> 
        <script src="js/main.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>