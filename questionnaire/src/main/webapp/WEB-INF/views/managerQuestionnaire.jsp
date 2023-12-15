<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>管理员问卷管理</title>
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
                       aria-expanded="false"><c:out value="${manager.userName}" /><span class="caret"></span></a>
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
<ul class="nav nav-tabs">
    <li><a href="<c:url value="/manager/manageManager"/>">管理员账号管理</a></li>
    <li><a href="<c:url value="/manager/manageUser"/>">用户管理</a></li>
    <li class="active"><a href="<c:url value="/manager/manageQuestionnaire"/>">问卷管理</a></li>
</ul>
<br>
<div class="table-responsive" style="text-align: center">
    <table class="table" id="table">
        <tbody>
        <c:choose>
        <c:when test="${not empty uncheckedQuestionnaires}">
            <thead>
            <tr>
                <th style="text-align: center"><input type="checkbox" name="cb" id="firstCb"></th>
                <th style="text-align: center">所属用户</th>
                <th style="text-align: center">问卷名</th>
                <th style="text-align: center">审核</th>
                <th style="text-align: center">操作</th>
            </tr>
            </thead>
        <c:forEach var="unCQuestionnaire" items="${uncheckedQuestionnaires}">
            <tr>
                    <td><input type="checkbox" name="cb"></td>
                    <td>${unCQuestionnaire.user.userName}</td>
                    <td>${unCQuestionnaire.tableName}</td>
                    <td>
                        <form method="post" action="<c:url value="/manager/checkQue.do"/>">
                        <input type="hidden" name="tableId" value="${unCQuestionnaire.tableId}">
                        <button type="submit" name="check" value="1">通过</button>
                        <button type="submit" name="check" value="-1">不通过</button>
                        </form>
                    </td>
                    <td><a href="<c:url value="/manager/preview/${unCQuestionnaire.tableId}"/>" >查看</a></td>
            </tr>
        </c:forEach>
        </c:when><c:otherwise>
        This is a questionnaire wasteland!
        </c:otherwise>
        </c:choose>
        </tbody>
    </table>
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