<%-- 
    Document   : loginView
    Created on : May 25, 2021, 10:35:02 AM
    Author     : Dai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">


        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <title>Document</title>
    </head>
    <style>

        .head-main{
            background-color: rgb(243, 243, 243);
            height: 600px;

        }
        .login{
            background-color: white;
            padding: 30px;
            margin-top: 100px;
            box-shadow: 0px 5px 10px 0px rgb(209, 209, 209);
            width: 120%;
            height: 300px;
            margin-left: -35px;
            border: 1px solid rgb(197, 197, 197);
            border: rgb(197, 197, 197) 1px solid;
            border-radius: 5px;
        }

        .db{
            font-size: 70px;
            font-weight: bold;
            color: rgb(11, 159, 218);

        }
        .ol{
            margin-left: 300px;
            color: rgb(87, 87, 87);

        }



        .left-content{
            margin-top: 110px;
        }

        .purpose{
            margin-top: 20px;
            text-align: center;
        }
        .purpose-1{
            width: 70%;
            text-align: center;
        }
        .block-image{
            margin-left: 20px;
        }

        .modal-content{
            width: 800px;
            height: 650px;
            position:absolute;

        }
        #notification{
            position: relative;
            width: 450px;
            height: 200px;
            background-color: rgba(0, 0, 0, 0.651);
            display: block;
            border-radius: 3px;
            text-align: center;
            margin: auto;
            top: -700px;

        }
        .notification-text{
            color: white;
            font-size: 23px;
            margin-top: 55px;
        }


    </style>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>

            <div class="head-main">
                <div class="container">
                    <div class="row temp">
                        <div class="col-lg-8">
                            <div class="left-content">
                                <h1 class="db">Danh Bạ</h1>
                                <h1 class="ol">Online</h1>
                                <p class="purpose-1">Giúp bạn liên lạc tốt hơn</p>
                            </div>

                        </div>

                        <div class="col-lg-4" >
                            <div class="login row">

                                <form action="${pageContext.request.contextPath}/login" name="reigisterForm" class="temp" method="POST" >
                                <div class="form-group">
                                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item">
                                        <input type="text" name="userName" class="form-control" placeholder="User Name" id="name" value = "${user.userName}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item">
                                        <input type="password" name="password" class="form-control" placeholder="Password" id="pass" value= "${user.password}">
                                    </div>
                                </div>


                                <div class="form-group row">
                                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 form-item">
                                        <input type="checkbox" name="remember-me"> Remember Me !
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 form-item">
                                        <a href="#">Forgot password ?</a>
                                    </div>
                                </div>


                                <p style=" height: 20px; color: red;font-size: 15px;display: inline-block" id="p">${error}</p><p style=" height: 20px; color: green;font-size: 15px;display: inline-block" id="p">${error2}</p>


                                <div class="form-group">

                                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item">
                                        <input type="submit"  name="submit"  class="form-control"  value="Đăng Nhập" onclick="doLogin()">
                                    </div>
                                </div>
                                <div class="form-group user-register" >
                                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item"  style="margin-top:  20px">
                                        <br>Don't have an Accuont ?
                                        <a href="" data-toggle = "modal" data-target= ".bs-example-modal-lg" >Register an Account</a> 


                                        <!-- <button type="button" class="bt btn-primary" data-toggle = "modal" data-target= ".bs-example-modal-lg" >
                                          Click Here
                                        </button> -->
                                        <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-describedby="myLargeModalLabel">
                                            <div class="modal-dialog modal-lg" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-body">
                                                        <div class="row">
                                                            <div class="col-md-5 col-lg-5 block-image">
                                                                <div class ="row">  <img  src="./image/dialog-dk.png" alt="" style="width: 350px;margin-right: 20px;">
                                                             
                                                                </div>
                                                            </div>

                                                            <div class="col-md-6 col-lg-6 block-image">
                                                                <h3 style="padding-bottom: 20px;color: rgb(94, 94, 94);">Register Account</h3>
                                                                <form action="${pageContext.request.contextPath}/login" method="POST" >  
                                                                    <div class="form-group">
                                                                        <input type="text" name="nameNewAccout" id="nameNewAccount" class="form-control" placeholder="Your Name">
                                                                    </div>       
                                                                    <div class="form-group">
                                                                        <input type="text" name="DOB" id="DOB" class="form-control" placeholder="dd / mm / yyyy">
                                                                    </div>  
                                                                    <div class="form-group">
                                                                        <input type="text" name="phone" id="nameNewAccount" class="form-control" placeholder="Phone">
                                                                    </div>     
                                                                    <div class="form-group">
                                                                        <textarea placeholder="Địa Chỉ" class="form-control" name="address" id="" cols="30" rows="2"></textarea>

                                                                    </div>        
                                                                    <div class="form-group">
                                                                        <input type="text" name="email" id="nameNewAccount" class="form-control" placeholder="Email">
                                                                    </div> 
                                                                    <div class="form-group">
                                                                        <input type="text" name="userNameNewAccout" id="nameNewAccount" class="form-control" placeholder="Enter Your User Name">
                                                                    </div>   
                                                                    <div class="form-group">
                                                                        <input type="password" name="newpass" id="passwordNewAccount" class="form-control" placeholder="Password">
                                                                    </div>                           
                                                                    <div class="form-group">
                                                                        <input type="password" name="reNewpass" id="repasswordNewAccount" class="form-control" placeholder="Re-enter The Password">
                                                                    </div>
                                                                    <p id="error" style="display: block; height: 20px; color: rgb(245, 0, 0);"></p>
                                                                    <!-- <div class="form-group">
                                                                      <textarea name="text" id="" cols="30" rows="4" class="form-control" onblur="if(this.value == ''){this.value = 'Enter your massage';}" 
                                                                      onfocus="this.value = '';"></textarea>
                                                                      </div> -->
                                                                    <div class="form-group">
                                                                        <button type="submit" name="action" value="newUser" class="btn btn-success" id="btn-create">Submit</button>
                                                                    </div>
                                                                </form>
                                                            </div>


                                                        </div>
                                                    </div>


                                                    <div class="modal-footer" style="display: block;" >
                                                        <div class="" style="float: left; ">
                                                            <span>Enter call : 0866146741</span>
                                                        </div> 
                                                        <div class="pull-right" style="float: right; ">
                                                            <span>Mail : trandai2401@gmail.com</span>
                                                        </div>

                                                    </div>



                                                </div>
                                            </div>
                                        </div>


                                    </div>
                                </div>
                            </form>

                        </div>
                        <p class="purpose" style="margin-top: 35px" >Web này tạo ra chỉ để giúp những người hay quên</p>
                    </div>
                </div>

            </div>

        </div>
        <jsp:include page="_footer.jsp"></jsp:include>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <script src="js/main-index.js"></script>

    </body>
</html>
