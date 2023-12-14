<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="ques" uri="ques"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="statistics" content="width=device-width, initial-scale=1">
    <title>统计数据</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/statistics.css"/>">
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
            <a class="navbar-brand" href="<c:url value="/questionnaire"/>">Questionnaire</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">${commonUser.userName}<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/questionnaire/info"/>">个人信息</a></li>
                        <li><a onclick="LogOut()"  href="<c:url value="/commonuser/logout.do"/>">注销登录</a></li>
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

<div class="container">
        <div class="text-center" >
<%--            name of questionnare--%>
            <h1><c:out value="${tableName}"/></h1>
        </div>

    <div class="col-md-12">
        <div class="col-md-2">
            <div class="questionnaireList-title">
                <strong>统计数据</strong>
            </div>
        </div>
    </div>
    <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>

    <c:forEach items="${questions}" var="question" varStatus="status">
        <div class="question-chart col-md-12">
            <div class="questionnaire-info col-md-12 img-thumbnail">
                <div class="col-md-10">
                    <p><c:out value="${question.description}" /></p>
                        <img class="icon" src="<c:url value="/resources/images/icons/comment-question.svg"/>" alt="link svg">
                </div>
                <div class="col-md-2 questionnaire-option">
                    <ques:handleResult question="${question}" iCount="${status.count}"/>
                    <button id="button-${status.count}" type="button" aria-expanded="false" class="btn btn-primary" data-toggle="collapse" data-target="#collapse-chart-${status.count}">折叠图表</button>
                </div>
            </div>
            <div id="collapse-chart-${status.count}" class="collapse">
                <div class="img-thumbnail chart-margin">
                    <div id="chart-${status.count}" class="chart" ></div>
                </div>
            </div>

        </div>
        <script type="text/javascript" >
            document.addEventListener('DOMContentLoaded', function() {
                var button = document.getElementById('button-${status.count}');
                button.click();
            });
            $(function(){
                $("#collapse-chart-${status.count}").on("shown.bs.collapse",function(){
                    if (${question.questionType}){
                        var text = document.getElementById("text-${status.count}");
                        buildtextEchart("chart-${status.count}", ${sessionScope.text});

                    } else {
                        var xData = document.getElementById("xData-${status.count}");
                        var sData = document.getElementById("sData-${status.count}");
                        buildEchart("chart-${status.count}", xData.value, sData.value);
                    }
                    document.getElementById("button-${status.count}").innerText = "折叠图表"

                });
            });
            $(function(){
                $("#collapse-chart-${status.count}").on("hidden.bs.collapse",function(){
                    echarts.init(document.getElementById("chart-${status.count}")).dispose();
                    document.getElementById("button-${status.count}").innerText = "展开图表"
                });
            });
        </script>
    </c:forEach>

</div>
<div class="clearfix"></div>


<div class="container-fluid footer">
    <footer>
        <div class="col-md-4 col-md-offset-4">
            <p>Questionnaire</p>
            <p>Make with BootStrap<img class="icon" src="<c:url value="/resources/images/icons/Bootstrap.svg"/>" alt="bootstrap icon"></p>
            <p>© Group One</p>
        </div>
    </footer>
</div>
<script src="<c:url value="/resources/js/echarts.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/echarts-wordcloud.min.js"/>"></script>
<script src="<c:url value="/resources/buildEchart.js"/>"></script>

</body>
</html>
