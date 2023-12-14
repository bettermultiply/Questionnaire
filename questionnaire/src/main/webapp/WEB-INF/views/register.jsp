<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户注册</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/userHome.css"/>">
    <link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/style.css"/>" rel="stylesheet" type="text/css">
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
            <img class="logo-img" src="<c:url value="/resources/images/logo2.png"/>" alt="图片加载失败">
            <a class="navbar-brand" href="<c:url value="/"/>">Questionnaire</a>
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
                <h1 class="text-center mb-3">User Register</h1>
                <form method="post">
                    <div class="form-group">
                        <label for="LastName">姓</label>
                        <input
                                type="text"
                                id="LastName"
                                name="lastName"
                                class="form-control"
                                placeholder="Enter LastName"
                        />
                    </div>
                    <div class="form-group">
                        <label for="FirstName">名</label>
                        <input
                                type="text"
                                id="FirstName"
                                name="firstName"
                                class="form-control"
                                placeholder="Enter FirstName"
                        />
                    </div>
                    <div class="form-group">
                        <label for="UserName">用户名</label>
                        <input
                                type="text"
                                id="UserName"
                                name="userName"
                                class="form-control"
                                placeholder="Enter UerName"
                                required
                        />
                        <c:if test="${not empty taken}" >
                            <label style="color: darkred" >名字已被占用</label>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="password">密码</label>
                        <input
                                type="password"
                                id="password"
                                name="password"
                                class="form-control"
                                placeholder="Enter Password"
                                required
                        />
                    </div>
                    <div class="form-group">
                        <label for="Pho">电话号码</label>
                        <input
                                type="tel"
                                id="Pho"
                                name="pho"
                                class="form-control"
                                placeholder="Enter PhoNumber"
                        />
                    </div>
                    <div class="form-group">
                        <label for="email">电子邮箱</label>
                        <input
                                type="email"
                                id="email"
                                name="email"
                                class="form-control"
                                placeholder="Enter UerName"
                        />
                    </div>
                    <input role="button" class="btn btn-primary btn-block" type="submit" value="Register" />
                </form>
            </div>
        </div>
    </div>
</div>

<div class="container-fluid footer">
    <footer>
        <div class="col-md-4 col-md-offset-4">
            <p>Questionnaire</p>
            <p>Make with BootStrap<img class="icon" src="<c:url value="/resources/images/icons/Bootstrap.svg"/>" alt="bootstrap icon"></p>
            <p>© Group One</p>
        </div>
    </footer>
</div>

</body>
<span>
    <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/js/metisMenu.min.js"/>"></script>
    <script src="<c:url value="/resources/js/raphael.min.js"/>"></script>
    <script src="<c:url value="/resources/js/morris.min.js"/>"></script>
    <script src="<c:url value="/resources/js/morris-data.js"/>"></script>
    <script src="<c:url value="/resources/js/startmin.js"/>"></script>
    <script src="<c:url value="/resources/bootstrap-table-1.14.1/bootstrap-table.min.js"/>"></script>
    <script src="<c:url value="/resources/managerAccount.js"/>"></script>
</span>