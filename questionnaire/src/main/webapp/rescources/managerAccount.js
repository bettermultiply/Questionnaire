//给全选按钮绑定鼠标单击事件
document.getElementById("selectAll").onclick=function (){
    //通过标签的name值，获取table标签中所有的checkbox对象
    var checkBoxObject=document.getElementsByName("cb");
    //遍历
    for(var i=0;i<checkBoxObject.length;i++){
        checkBoxObject[i].checked =true;
    }
};
//给全部选按钮绑定鼠标单击事件
document.getElementById("unSelectAll").onclick = function() {
    // 通过标签name值，获取table标签中所有的checkbox对象
    var checkBoxObject = document.getElementsByName("cb");
    // 遍历
    for (var i = 0; i < checkBoxObject.length; i++) {
        // 设置每一个checkbox的状态为选中 checked
        checkBoxObject[i].checked = false;
    }
};
//为表头勾选按钮绑定鼠标单击事件
document.getElementById("firstCb").onclick = function() {
    // 获取所有的checkbox
    var checkBoxObject = document.getElementsByName("cb");
    // 遍历
    for (var i = 0; i < checkBoxObject.length; i++) {
        // 设置每一个cb的状态和第一个cb的状态一样
        checkBoxObject[i].checked =  this.checked;
    }
};
//给所有tr绑定鼠标移到元素之上和移出元素事件
var trs = document.getElementsByTagName("tr");
// 遍历
for (var i = 0; i < trs.length; i++) {
    // 移到元素之上
    trs[i].onmouseover = function(){
        this.className = "over";
    };
    // 移出元素
    trs[i].onmouseout = function(){
        this.className = "out";
    };
}
//删除弹窗
function myfunction(){
    alert("该管理员账户已成功删除！");
}
//添加管理员账号显示成功弹窗
function functionmanager(){
    alert("账户已添加！");
}
//显示修改自己信息成功
function functionchange(){
    alert("修改成功！");
}