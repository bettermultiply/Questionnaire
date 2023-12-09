<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>问卷管理</title>
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
    <li><a href="managerUser.jsp">用户管理</a></li>
    <li class="active"><a href="managerQuestionnaire.jsp">问卷管理</a></li>
</ul>
<br><br>
<div class="table-responsive" style="text-align: center">
    <table class="table" id="table">
        <thead>
        <tr>
            <th style="text-align: center"><input type="checkbox" name="cb" id="firstCb"></th>
            <th style="text-align: center">所属用户</th>
            <th style="text-align: center">问卷名</th>
            <th style="text-align: center">审核</th>
            <th style="text-align: center">操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><input type="checkbox" name="cb"></td>
            <td>用户1</td>
            <td>问卷1</td>
            <td>
                <button>通过</button>
                <button>不通过</button>
            </td>
            <td><a href="viewQuestionnaire.jsp" target="_blank">查看</a></td>
        </tr>
        <tr>
            <td><input type="checkbox" name="cb"></td>
            <td>用户2</td>
            <td>问卷2</td>
            <td>
                <button>通过</button>
                <button>不通过</button>
            </td>
            <td><a href="viewQuestionnaire.jsp" target="_blank">查看</a></td>
        </tr>
        <tr>
            <td><input type="checkbox" name="cb"></td>
            <td>用户3</td>
            <td>问卷3</td>
            <td>
                <button>通过</button>
                <button>不通过</button>
            </td>
            <td><a href="viewQuestionnaire.jsp" target="_blank">查看</a></td>
        </tr>
        <tr>
            <td><input type="checkbox" name="cb"></td>
            <td>用户4</td>
            <td>问卷4</td>
            <td>
                <button>通过</button>
                <button>不通过</button>
            </td>
            <td><a href="viewQuestionnaire.jsp" target="_blank">查看</a></td>
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