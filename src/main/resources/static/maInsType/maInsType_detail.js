//获取单据ID
var billId = getParam("billId")
//异步请求数据
$(document).ready(function() {
    //开启全局异步请求
    $.ajaxSetup({
        async : false
    })
    if(billId){
        $.ajax({
            url:"/api/sssfmIoBillTest/"+billId+"?fetchProperties=*,itemTestList[*]",
            type:"GET",
            success:function(data){
                if(data){
                    render(data);
                }else{
                    layer.msg(data.msg);
                }
            },
            error:function(){
                layer.msg("客户端请求有误");
            }
        });
    }
});
//显示数据
function render(data) {
    $("#billNo").html(data.billNo);
    $("#billType").html(data.billType);
    $("#srcSys").html(data.srcSys);
    $("#isPrint").html(data.isPrint);
    $("#remark").html(data.remark);
    if(data.itemTestList.length>0){
        for (var i = 0 ; i < data.itemTestList.length ; i++){
            $("#billItemList").append(
                $("<tr>").append($("<td>").append(data.itemTestList[i].insType))
                    .append($("<td>").append(data.itemTestList[i].outUseReason))
                    .append($("<td>").append(data.itemTestList[i].payCo))
                    .append($("<td>").append(data.itemTestList[i].payBank))
                    .append($("<td>").append(data.itemTestList[i].ioCo))
                    .append($("<td>").append(data.itemTestList[i].ioBank))
                    .append($("<td>").append(data.itemTestList[i].amount))
                    .append($("<td>").append(data.itemTestList[i].remark))
            );
        }
    }
}