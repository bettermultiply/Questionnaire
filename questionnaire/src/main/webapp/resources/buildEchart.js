//点击展开加载图像
$(function(){
    $("#collapse-chart").on("shown.bs.collapse",function(){
        builchart();
    });
});

//点击关闭摧毁图像
$(function(chartName){
    $("#collapse-chart").on("hidden.bs.collapse",function(){
        var myChart = echarts.init(document.getElementById(chartName));
        myChart.dispose();
    });
});

//建立选择题柱状图
function buildEchart(chartName, xData, sData) {
    var chart = echarts.init(document.getElementById(chartName));
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '柱状图'
        },
        tooltip: {},
        legend: {
            data: ['数量']
        },
        xAxis: {
            data: xData.split(',').map(function(item) {
                    return item.trim()})
        },
        yAxis: {},
        series: [
            {
                name: '数量',
                type: 'bar',
                data: eval(sData)
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    chart.setOption(option);
}

//建立填空题云图
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