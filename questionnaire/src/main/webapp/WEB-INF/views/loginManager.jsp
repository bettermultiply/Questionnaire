<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>管理员登录</title>
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
                        <strong class="size">帮助文档</strong>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<br><br><br>

<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <div class="card card-body">
                <h1 class="text-center mb-3">Manager Login</h1>
                <form action="/" method="post">
                    <div class="form-group">
                        <label for="ManagerName">ManagerName</label>
                        <input
                                type="text"
                                id="ManagerName"
                                name="ManagerName"
                                class="form-control"
                                placeholder="Enter ManagerName"
                        />
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input
                                type="password"
                                id="password"
                                name="password"
                                class="form-control"
                                placeholder="Enter Password"
                        />
                    </div>
                    <a class="btn btn-primary btn-block" href="managerAccount.jsp" role="button">
                        Login
                    </a>
                </form>
            </div>
        </div>
    </div>
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