<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<jsp:useBean id="manager" class="questionnaire.database.Manager" scope="request"></jsp:useBean>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>创建一个新的管理员账户</title>
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
            <a class="navbar-brand" href="<c:url value="/manager/manageManager"/>">Questionnaire</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">UserName<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/manager/managerinfo/${manager.userName}"/>">个人信息</a></li>
                        <li><a onclick="LogOut()" href="<c:url value="/manager/logout.do"/>">注销登录</a></li>
                    </ul>
                </li>
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
<br><br><br><br>
<div class="container">
    <sf:form method="POST" modelAttribute="manager" class="form-horizontal custom-form" role="form">
        <div class="form-group">
            <div class="col-sm-1"></div>
            <label for="firstname" class="col-sm-2 control-label">名</label>
            <div class="col-sm-6">
                <sf:input path="firstName" type="text" class="form-control custom-input" id="firstname" placeholder="请输入名" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-1"></div>
            <label for="lastname" class="col-sm-2 control-label">姓</label>
            <div class="col-sm-6">
                <sf:input path="lastName" type="text" class="form-control custom-input" id="lastname" placeholder="请输入姓" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-1"></div>
            <label for="username" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-6">
                <sf:input path="userName" type="text" class="form-control custom-input" id="username" placeholder="请输入用户名" required="true" />
            </div>
            <c:if test="${not empty duplicateName}" >
                <label style="color: darkred" >名字<c:out value="${duplicateName}"/>已被占用</label>
            </c:if>
        </div>
        <div class="form-group">
            <div class="col-sm-1"></div>
            <label for="password" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-6">
                <sf:input path="password" type="password" class="form-control custom-input" id="password" placeholder="请输入密码" required="true" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-1"></div>
            <label for="telephone" class="col-sm-2 control-label">电话号码</label>
            <div class="col-sm-6">
                <sf:input path="phoneNo" type="tel" class="form-control custom-input" id="telephone" placeholder="请输入电话号码" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-1"></div>
            <label for="email" class="col-sm-2 control-label">邮箱</label>
            <div class="col-sm-6">
                <sf:input path="email" type="email" class="form-control custom-input" id="email" placeholder="请输入邮箱" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-5">
                <input type="submit" class="btn btn-default" onclick="functionmanager()" value="确定" />
            </div>
        </div>
    </sf:form>
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