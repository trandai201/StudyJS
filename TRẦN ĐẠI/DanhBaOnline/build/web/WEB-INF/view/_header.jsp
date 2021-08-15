<%-- 
    Document   : newjsp
    Created on : May 28, 2021, 10:28:46 PM
    Author     : Dai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div style="display: block;background-color: #0B9FDA;margin: 0px">
    <!--            <h3 style="color: white;padding: 4px;margin: auto;padding-left: 50px ">Danh Bạ</h3>
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>-->
    <nav class="navbar navbar-expand-lg navbar-light " style="color: white" >
        <a class="navbar-brand" href="#" style="color: white;font-size: 30px;font-weight: bold" >Danh Bạ</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto"  style="color: white;font-size: 20px;font-weight: 400">
                <li class="nav-item active">
                    <a style="color: white" class="nav-link" href="${pageContext.request.contextPath}/home">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a style="color: white" class="nav-link" href="${pageContext.request.contextPath}/user"> Cá Nhân <span class="sr-only">(current)</span></a>
                </li>


            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>
 

