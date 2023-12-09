<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>管理员账号管理</title>
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
        <a href="viewMe.jsp" target="_blank">
            <span class="glyphicon glyphicon-user"></span>
            <strong class="size">个人中心</strong>
        </a>
    </span>
</header>
<body>
<br><br>
<ul class="nav nav-tabs">
    <li class="active"><a href="managerAccount.jsp">管理员账号管理</a></li>
    <li><a href="managerUser.jsp">用户管理</a></li>
    <li><a href="managerQuestionnaire.jsp">问卷管理</a></li>
</ul>
<br>
<form action="#" style="margin-left: 5px">
    <a class="btn btn-info" href="addManager.jsp" role="button" style="margin-left: 50px" target="_blank">创建一个管理员账号</a>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" placeholder="管理员账号名.." name="search2">
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
            <td>管理员1</td>
            <td>
                <a onclick="myfunction()">删除</a>
                <a href="changeInfo.jsp" target="_blank">修改</a>
                <a href="viewOther.jsp" target="_blank">查看</a>
            </td>
        </tr>
        <tr>
            <td><input type="checkbox" name="cb" ></td>
            <td>管理员2</td>
            <td>
                <a onclick="myfunction()">删除</a>
                <a href="changeInfo.jsp" target="_blank">修改</a>
                <a href="viewOther.jsp" target="_blank">查看</a>
            </td>
        </tr>
        <tr>
            <td><input type="checkbox" name="cb"></td>
            <td>管理员3</td>
            <td>
                <a onclick="myfunction()" >删除</a>
                <a href="changeInfo.jsp" target="_blank">修改</a>
                <a href="viewOther.jsp" target="_blank">查看</a>
            </td>
        </tr>
        <tr>
            <td><input type="checkbox" name="cb"></td>
            <td>管理员4</td>
            <td>
                <a onclick="myfunction()">删除</a>
                <a href="changeInfo.jsp" target="_blank">修改</a>
                <a href="viewOther.jsp" target="_blank">查看</a>
            </td>
        </tr>
        </tbody>
    </table>
    <div>
        <input type="button" id="selectAll" value="全选">
        <input type="button" id="unSelectAll" value="全不选">
    </div>
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