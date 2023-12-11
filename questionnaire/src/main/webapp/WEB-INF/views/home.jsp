<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    <link rel="stylesheet" href="<c:url value="/rescources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/rescources/css/home.css"/>">
    <link href="<c:url value="/rescources/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/rescources/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <img class="logo-img" src="<c:url value="/rescources/images/logo2.png"/>" alt="图片加载失败">
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href=" " target="_blank">
                        <span class="glyphicon glyphicon-question-sign"></span>
                        <strong class="size" >帮助文档</strong>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
    <h1 class="center">SurveyEase,让问卷创建更简单</h1>
    <h4 class="center">轻松定制在线问卷，收集信息，智能分析</h4>
    <br><br><br>
    <div style="text-align: center">
        <a class="btn btn-info" href="register.jsp" role="button">用户注册</a><br><br>
        <a class="btn btn-info" href="loginUser.jsp" role="button">用户登录</a><br><br>
        <a class="btn btn-info" href="loginManager.jsp" role="button">管理员登录</a><br><br>
        <img src="../../rescources/images/0001.png" alt="" class="image-size">
    </div>

<div class="container-fluid footer">
    <footer>
        <div class="col-md-4 col-md-offset-4">
            <p>Questionnaire</p>
            <p>Make with BootStrap<img class="icon" src="<c:url value="/rescources/images/icons/Bootstrap.svg"/>" alt="bootstrap icon"></p>
            <p>© Group One</p>
        </div>
    </footer>
</div>
</body>
<span>
    <script src="<c:url value="/rescources/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/rescources/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/rescources/js/metisMenu.min.js"/>"></script>
    <script src="<c:url value="/rescources/js/raphael.min.js"/>"></script>
    <script src="<c:url value="/rescources/js/morris.min.js"/>"></script>
    <script src="<c:url value="/rescources/js/morris-data.js"/>"></script>
    <script src="<c:url value="/rescources/js/startmin.js"/>"></script>
    <script src="<c:url value="/rescources/bootstrap-table-1.14.1/bootstrap-table.min.js"/>"></script>
    <script src="<c:url value="/rescources/managerAccount.js"/>"></script>
</span>
</html>