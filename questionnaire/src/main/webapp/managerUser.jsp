<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>用户管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/metisMenu.min.css" rel="stylesheet">
    <link href="css/timeline.css" rel="stylesheet">
    <link href="css/startmin.css" rel="stylesheet">
    <link href="css/morris.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="bootstrap-table-1.14.1/bootstrap-table.min.css" rel="stylesheet">
    <link href="rescources/style.css" rel="stylesheet" type="text/css">
</head>
<header class="header">
    <img class="header-right" src="rescources/images/logo2.png" alt=""/>
    <span class="pull-right header-left">
        <a href=" " >
            <span class="glyphicon glyphicon-question-sign"></span>
            <strong class="size">帮助文档</strong><br><br>
        </a>
        <a href="viewMe.jsp" >
            <span class="glyphicon glyphicon-user"></span>
            <strong class="size">个人中心</strong>
        </a>
    </span>
</header>
<body>
<br><br>
<ul class="nav nav-tabs">
    <li><a href="managerAccount.jsp">管理员账号管理</a></li>
    <li class="active"><a href="managerUser.jsp">用户管理</a></li>
    <li><a href="managerQuestionnaire.jsp">问卷管理</a></li>
</ul>
<br>
<form action="#" style="margin-left: 20px">
    <input type="text" placeholder="用户名.." name="search2">
    <button type="submit"><i class="fa fa-search"></i></button>
</form>
<br><br>
<div class="table-responsive" style="text-align: center">
    <table class="table" id="table">
        <thead>
        <tr>
            <th style="text-align: center"><input type="checkbox" name="cb" id="firstCb"></th>
            <th style="text-align: center">登录名</th>
            <th style="text-align: center">操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><input type="checkbox" name="cb"></td>
            <td>用户1</td>
            <td>
                <a href="changeInfo.jsp" target="_blank">修改</a>
                <a href="viewOther.jsp" target="_blank">查看</a>
            </td>
        </tr>
        <tr>
            <td><input type="checkbox" name="cb" ></td>
            <td>用户2</td>
            <td>
                <a href="changeInfo.jsp" target="_blank">修改</a>
                <a href="viewOther.jsp" target="_blank">查看</a>
            </td>
        </tr>
        <tr>
            <td><input type="checkbox" name="cb"></td>
            <td>用户3</td>
            <td>
                <a href="changeInfo.jsp" target="_blank">修改</a>
                <a href="viewOther.jsp" target="_blank">查看</a>
            </td>
        </tr>
        <tr>
            <td><input type="checkbox" name="cb"></td>
            <td>用户4</td>
            <td>
                <a href="changeInfo.jsp" target="_blank">修改</a>
                <a href="viewOther.jsp" target="_blank">查看</a>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
<span>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/metisMenu.min.js"></script>
    <script src="js/raphael.min.js"></script>
    <script src="js/morris.min.js"></script>
    <script src="js/morris-data.js"></script>
    <script src="js/startmin.js"></script>
    <script src="bootstrap-table-1.14.1/bootstrap-table.min.js"></script>
    <script src="rescources/managerAccount.js"></script>
</span>