<%-- 
    Document   : viewuser
    Created on : Aug 3, 2021, 9:24:21 AM
    Author     : Dai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông Tin CHi Tiết</title>
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
                <div class="row " style="font-size: 23px;width: 100%;margin-top: 50px;height: 500px;">
                    <div class="col-md-2"></div>
                    <div class="col-md-8">
                        <h2 style="color: #0b9fda;">THông Tin Chi Tiết</h2>
                        <div class="row">
                            <div class="col-md-3">Tên</div>
                            <div class="col-md-9"> ${user.getNameString()}</div>
                    </div>
                    <div class="row">
                        <div class="col-md-3">Ngày Sinh </div>
                        <div class="col-md-9">${user.getNgaySinhString()}</div>
                    </div>
                    <div class="row">
                        <div class="col-md-3">Số Điện Thoại</div>
                        <div class="col-md-9">${user.getSoDTString()}</div>
                    </div>
                    <div class="row">
                        <div class="col-md-3">Địa Chỉ</div>
                        <div class="col-md-9">${user.getDicChiString()}</div>
                    </div>
                    <div class="row">
                        <div class="col-md-3">Email</div>
                        <div class="col-md-9">${user.getEmailString()}</div>
                    </div>
                    <div class="row">   
                        <form action="" method="post">
                            <button name="action" value="delete" class="btn btn-primary" type="submit" style="margin: 20px;">Xóa Liên Lạc</button>
                        </form>
                    </div>
                </div>
                <div class="col-md-2"></div>

            </div>


        </div>
        <jsp:include page="_footer.jsp"></jsp:include>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

    </body>
</html>
