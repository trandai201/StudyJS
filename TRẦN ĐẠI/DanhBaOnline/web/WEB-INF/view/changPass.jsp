<%-- 
    Document   : changPass
    Created on : Aug 4, 2021, 11:54:14 AM
    Author     : Dai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <style>
            .row .row {
                margin-top: 20px;
            }

            .row .col-md-9 {
                font-weight: bold;
            }
        </style>
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


            <div class="content row" style="margin-top: 25px;width: 100%; height: 500px;">
                <div class="col-md-3">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="${pageContext.request.contextPath}/user">Thông Tin</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/changepassword">Đổi Mật Khẩu</a>
                        </li>

                        </li>
                    </ul>
                </div>
                <div class="col-md-7">
                    <form  method="post" >
                        <div class="row">
                            <div class="col-md-4">Mật Khẩu cũ</div>
                            <div class="col-md-8">  <input name="oldPass" type="password" class="form-control" placeholder="Old Password"></div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">Mật Khẩu Mới</div>
                            <div class="col-md-8"> <input name="newPass" type="password" class="form-control" placeholder="New Nassword"></div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">Nhập Lại Mật Khẩu Mới</div>
                            <div class="col-md-8"> <input name="reNewPass" type="password" class="form-control" placeholder="Retype New Nassword"></div>
                        </div>
                        <p class="errors" style="color: red;margin-top: 5px">${errors}</p>

                        <div class="row" style="margin-top: 50px;"> 
                            <div class="form-group">
                                <button id='btn-edit' disabled type="submit" class="btn btn-primary">Thay Đổi Mật Khẩu</button>
                            </div>
                        </div>
                    </form>




                </div>
            </div>
        </div>
        <script>
            function c() {
                btn.disabled = false;
            }
            var btn = document.getElementById('btn-edit')
            var arr = document.getElementsByClassName('form-control')

            for (let i = 0; i < 3; i++) {

                arr[i].addEventListener("keydown", c)
            }

        </script>
        <jsp:include page="_footer.jsp"></jsp:include>  
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

    </body>
</html>
