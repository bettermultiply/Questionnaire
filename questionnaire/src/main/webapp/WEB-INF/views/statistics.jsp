<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="statistics" content="width=device-width, initial-scale=1">
    <title>统计数据</title>
    <link rel="stylesheet" href="<c:url value="/rescources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/rescources/css/statistics.css"/>">
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
            <a class="navbar-brand" href="#">Questionnaire</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">UserName<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">个人信息</a></li>
                        <li><a href="#">注销登录</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container -->
</nav>

<div class="container">
        <div class="text-center" >
            <h1>问卷标题</h1>
        </div>

    <div class="col-md-12">
        <div class="col-md-2">
            <div class="questionnaireList-title">
                <strong>统计数据</strong>
            </div>
        </div>
        <div class="col-md-2 col-md-offset-8">
            <form method="post" action="">
                <button type="button" class="btn btn-primary addQuestionnaire">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>全部展开
                </button>
            </form>
        </div>
    </div>

    <div class="question-chart col-md-12">
        <div class="questionnaire-info col-md-12 img-thumbnail">
            <div class="col-md-10">
                <p>问题 1</p>
                <a href="#">
                    <img class="icon" src="<c:url value="/rescources/images/icons/comment-question.svg"/>" alt="link svg">
                </a>
            </div>
            <div class="col-md-2 questionnaire-option">
                <button id="button-0" type="button" aria-expanded="false" class="btn btn-primary" data-toggle="collapse" data-target="#collapse-chart">折叠图标</button>
            </div>
        </div>
        <div id="collapse-chart" class="collapse">
            <div class="img-thumbnail chart-margin">
                <div id="chart-0" class="chart" ></div>
            </div>
        </div>

    </div>
<br>
    <div class="question-chart col-md-12">
        <div class="questionnaire-info col-md-12 img-thumbnail">
            <div class="col-md-6">
                <p>问题 1</p>
                <a href="#">
                    <img class="icon" src="<c:url value="/rescources/images/icons/comment-question.svg"/>" alt="link svg">
                </a>
            </div>
        </div>

        <div class="question-chart">
            <div class="img-thumbnail chart-margin" >
                <div id="chart-1" class="chart"></div>
            </div>
        </div>

    </div>

</div>
<div class="clearfix"></div>


<div class="container-fluid footer">
    <footer>
        <div class="col-md-4 col-md-offset-4">
            <p>Questionnaire</p>
            <p>Make with BootStrap<img class="icon" src="<c:url value="/rescources/images/icons/Bootstrap.svg"/>" alt="bootstrap icon"></p>
            <p>© Group One</p>
        </div>
    </footer>
</div>
<script src="<c:url value="/rescources/js/echarts.min.js"/>"></script>
<script src="<c:url value="/rescources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/rescources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/rescources/js/echarts-wordcloud.min.js"/>"></script>
<script type="text/javascript">

    // var button = document.getElementById('button-0');
    // button.click();
    document.addEventListener('DOMContentLoaded', function() {
        var button = document.getElementById('button-0');
        button.click();
    });
    $(function(){
        $("#collapse-chart").on("shown.bs.collapse",function(){
            helloEchart();
        });
    });
    $(function(){
        $("#collapse-chart").on("hidden.bs.collapse",function(){
            var myChart = echarts.init(document.getElementById('chart-0'));
            myChart.dispose();
        });
    });
    // 基于准备好的dom，初始化echarts实例
    function helloEchart() {
        var myChart = echarts.init(document.getElementById('chart-0'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: 'ECharts 入门示例'
            },
            tooltip: {},
            legend: {
                data: ['销量']
            },
            xAxis: {
                data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
            },
            yAxis: {},
            series: [
                {
                    name: '销量',
                    type: 'bar',
                    data: [5, 20, 36, 10, 10, 20]
                }
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }

    var chart = echarts.init(document.getElementById('chart-1'));
    var JosnList = [
        {name: "龙头镇", value: "111"},
        {name: "大埔镇", value: "222"},
        {name: "太平镇", value: "458"},
        {name: "沙埔镇", value: "445"},
        {name: "东泉镇", value: "456"},
        {name: "凤山镇", value: "647"},
        {name: "六塘镇", value: "189"},
        {name: "冲脉镇", value: "864"},
        {name: "寨隆镇", value: "652"},
        {name: "龙头镇", value: "111"},
        {name: "大埔镇", value: "222"},
        {name: "太平镇", value: "458"},
        {name: "沙埔镇", value: "445"},
        {name: "东泉镇", value: "456"},
        {name: "凤山镇", value: "647"},
        {name: "六塘镇", value: "189"},
        {name: "冲脉镇", value: "864"},
        {name: "寨隆镇", value: "652"},
        {name: "龙头镇", value: "111"},
        {name: "大埔镇", value: "222"},
        {name: "太平镇", value: "458"},
        {name: "沙埔镇", value: "445"},
        {name: "东泉镇", value: "456"},
        {name: "凤山镇", value: "647"},
        {name: "六塘镇", value: "189"},
        {name: "冲脉镇", value: "864"},
        {name: "寨隆镇", value: "652"},
        {name: "龙头镇", value: "111"},
        {name: "大埔镇", value: "222"},
        {name: "太平镇", value: "458"},
        {name: "沙埔镇", value: "445"},
        {name: "东泉镇", value: "456"},
        {name: "凤山镇", value: "647"},
        {name: "六塘镇", value: "189"},
        {name: "冲脉镇", value: "864"},
        {name: "寨隆镇", value: "652"},
    ];
    var option = {
        tooltip: {
            show: true
        },
        series: [{
            name: '项目分析',
            type: 'wordCloud',
            sizeRange: [10, 50],//文字范围
            //文本旋转范围，文本将通过rotationStep45在[-90,90]范围内随机旋转
            rotationRange: [-45, 90],
            rotationStep: 45,
            textRotation: [0, 45, 90, -45],
            //形状
            shape: 'circle',
            textStyle: {
                normal: {
                    color: function() {//文字颜色的随机色
                        return 'rgb(' + [
                            Math.round(Math.random() * 250),
                            Math.round(Math.random() * 250),
                            Math.round(Math.random() * 250)
                        ].join(',') + ')';
                    }
                },
                //悬停上去的字体的阴影设置
                emphasis: {
                    shadowBlur: 10,
                    shadowColor: '#333'
                }
            },
            data: JosnList
        }]
    }
    chart.setOption(option)

</script>
</body>
</html>
