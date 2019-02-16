//异步请求数据
$(document).ready(function() {
    //开启全局异步请求
    $.ajaxSetup({
        async : false
    })
    $.ajax({
        url:"/sssfmDemo/api/sssfmIoBillTest",
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
});
//显示数据
function render(data) {
    if(data.length>0){
        for (var i = 0 ; i < data.length ; i++){
            $("#billList").append(
                $("<tr>").append($("<td>").append(data[i].billNo))
                    .append($("<td>").append(data[i].billType))
                    .append($("<td>").append(data[i].srcSys))
                    .append($("<td>").append(data[i].isPrint))
                    .append($("<td>").append(data[i].remark))
                    .append($("<td>").append($("<a href='./sssfmIoBill_detail.html?billId="+data[i].id+"'>").append("详情")))
            );
        }
    }
}