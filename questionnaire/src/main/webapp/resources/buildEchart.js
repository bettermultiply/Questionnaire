// var button = document.getElementById('button-0');
// button.click();
document.addEventListener('DOMContentLoaded', function() {
    var button = document.getElementById('button-0');
    button.click();
});
$(function(){
    $("#collapse-chart").on("shown.bs.collapse",function(){
        builchart();
    });
});
$(function(chartName){
    $("#collapse-chart").on("hidden.bs.collapse",function(){
        var myChart = echarts.init(document.getElementById(chartName));
        myChart.dispose();
    });
});

function buildEchart(chartName, xData, sData) {
    var chart = echarts.init(document.getElementById(chartName));
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
            data: xData.split(',').map(function(item) {
                    return item.trim()})
        },
        yAxis: {},
        series: [
            {
                name: 'renshu',
                type: 'bar',
                data: eval(sData)
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    chart.setOption(option);
}

function buildtextEchart(chartName, jsons) {
    var chart = echarts.init(document.getElementById(chartName));
    var option = {
        tooltip: {
            show: true
        },
        series: [{
            name: '答案词云',
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
            data: jsons
        }]
    }
    chart.setOption(option)

}

// 基于准备好的dom，初始化echarts实例
function builchart() {
    var myChart = echarts.init(document.getElementById("chart-0"));

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
            data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子',]
        },
        yAxis: {},
        series: [
            {
                name: 'renshu',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20,]
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

var chart = echarts.init(document.getElementById('chart-11'));
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
        name: '答案词云',
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