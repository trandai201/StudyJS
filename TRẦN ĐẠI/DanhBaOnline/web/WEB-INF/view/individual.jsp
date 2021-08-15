<%-- 
    Document   : individual
    Created on : Aug 4, 2021, 6:56:43 AM
    Author     : Dai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                    <form method="post" >
                        <div class="row">

                            <div class="col-md-4">Tên Đăng Nhập</div>
                            <div class="col-md-8">${user.getUserName()}</div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">Số Điện Thoại</div>
                            <div class="col-md-8">${result.getSoDTString()}</div>
                        </div>

                        <div class="row">
                            <div class="col-md-4">Tên Người Dùng</div>
                            <div class="col-md-8"> <input name="name" type="text" class="form-control" placeholder="Tên Người Dùng" value="${result.getNameString()}"></div>
                        </div>

                        <div class="row">
                            <div class="col-md-4">Ngày Sinh</div>
                            <div class="col-md-8"> <input name="DOB" type="text" class="form-control" placeholder="Ngày Sinh" value="${result.getNgaySinhString()}"></div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">Địa Chỉ</div>
                            <div class="col-md-8"> <textarea name="address" class="form-control" placeholder="Địa Chỉ" cols="30" rows="2" >${result.getDicChiString()}</textarea></div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">Email</div>
                            <div class="col-md-8"> <input name="email" type="text" class="form-control" placeholder="Email" value="${result.getEmailString()}" ></div>
                        </div>
                        <div class="row" style="margin-top: 50px;"> 
                            <div class="form-group">
                                <button id='btn-edit' disabled type="submit" class="btn btn-primary">Lưu Thay Đổi</button>
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

            for (let i = 0; i < 5; i++) {

                arr[i].addEventListener("keydown", c)
            }

        </script>
        <jsp:include page="_footer.jsp"></jsp:include>  
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

    </body>
</html>
