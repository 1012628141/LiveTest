 <%@page contentType="text/html; charset=utf-8" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

 <div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card-header card-header-text" data-background-color="rose">
                <h4 class="card-title">客户端坏死源汇报</h4>
            </div>
            <div class="card-content">
                <div class="table-responsive">
                    <table class="table" id="datatables">
                        <thead>
                            <tr>
                                <th class="text-center">#</th>
                                <th>源地址</th>
                                <th class="text-right">来源</th>
                                <th class="text-center">审核</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${not empty deathList}">
                            <c:forEach items="${ deathList }" var="channel" varStatus="loop">
                            <tr data-sid="${loop.index}" data-id="${channel.deathSourceId}">
                                <td class="text-center">${channel.channelName}</td>
                                <td>
                                    <a href="${ channel.deathSource }" style="display: block; width: 500px; word-wrap: break-word; word-break: normal;">
                                        ${ channel.deathSource }
                                    </a>
                                </td>
                                <td class="text-right source-list">
                                    客户端反馈
                                </td>
                                <td>
                                    <button class="btn btn-primary btn-round audit" data_id="${channel.deathSourceId}"><font><font>审核操作</font></font><div class="ripple-container"></div></button>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </tbody>
            </table>
        </div>
        <div class="text-center">
            <button class="btn btn-default" onclick="loadMore()">
                点击加载
            </button>
        </div>
    </div>
</div>
</div>
</div>
<script>
   var pageCount=${pageCount};
   var page='${content}'
   init(pageCount,page);
   $('#datatables').on('click','button',function(){
    if(confirm("直播源审核，点击确认删除直播源，点取消或直接关闭对话框不会删除直播源")){
 　　//点击确定后操作
 var attr=$(this).attr("data_id")
 　　console.log(attr)
 $.post("/report/auditPass.do",
 {
    sourceid: attr,
    status : true
}
,function(resultBean, status, xhRequest){
    if(resultBean.code==200){
        showNotification('top','right',true)
    }else{
       showNotification('top','right',false)
   }
}
,"json"
)
} else{
    var attr=$(this).attr("data_id")
    $.post("/report/auditPass.do",
    {
        sourceid: attr,
        status : false
    }
    ,function(resultBean, status, xhRequest){
       if(resultBean.code==200){
        showNotification('top','right',true)
    }else{
       showNotification('top','right',false)
   }}
   ,"json"
   )
}
$(this).parent().parent().remove()
});


   function showNotification(from,align,isSuccess){
    var msg=null
    var type=null
    if(isSuccess){
        msg ="操作成功"
        type = "success"
    }else{
        msg ="操作失败"
        type = "danger"
    }
    $.notify({
        icon: "add_alert",
        message: msg

    },{
        type: type,
        timer: 4000,
        placement: {
            from: from,
            align: align
        }
    });
}
</script>