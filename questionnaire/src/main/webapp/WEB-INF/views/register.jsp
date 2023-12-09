<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>用户注册</title>
    <style>
        #a {
            width:50%;
            height:200px;
            text-align:center;
        }
    </style>
</head>
<body>
<div id="a">
    <form>
    <h1>用户注册界面</h1>
    用户名:<input type="text" name="id"/>
    <br>
    密码:<input type="password" name="password"/>
    <br>
    邮件:<input type="email" name="email"/>
    <br>
    电话号码：<input type="tel" name="tel"/>
    <br>
    <input type="submit" value="register"/>
    </form>
</div>
</body>
</html>

