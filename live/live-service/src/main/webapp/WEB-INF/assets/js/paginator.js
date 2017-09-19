var pageTotal=null
var pageno=1
var content=null
function init(pageCount,page){
  pageTotal=pageCount
  content=page
}
Date.prototype.Format = function(fmt)
{ //author: meizz
  var o = {
    "M+" : this.getMonth()+1,                 //月份
    "d+" : this.getDate(),                    //日
    "h+" : this.getHours(),                   //小时
    "m+" : this.getMinutes(),                 //分
    "s+" : this.getSeconds(),                 //秒
    "q+" : Math.floor((this.getMonth()+3)/3), //季度
    "S"  : this.getMilliseconds()             //毫秒
  };
  if(/(y+)/.test(fmt))
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
  for(var k in o)
    if(new RegExp("("+ k +")").test(fmt))
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
  }
  function changeButton(pageNo){

    var strList=new Array();
    strList[0]=pageNo;
    pageno=pageNo
    var indexBefore=0;
    while(strList[0]!=1&&(indexBefore<3)){
      strList.unshift(strList[0]-1);
      indexBefore++;
    }
    var indexAfter=0;
    while(strList[strList.length-1]!=pageTotal&&(indexAfter<3||strList.length<7)){
      strList.push(strList[strList.length-1]+1);
      indexAfter++;
    }
    while(strList.length<7)
    {
      strList.unshift(strList[0]-1);
    }
    strList[0]=1;
    strList[strList.length-1]=pageTotal;
    if(strList[1]!=2){
      strList[1]="..."
    }
    if(strList[strList.length-2]!=pageTotal-1){
      strList[strList.length-2]="..."
    }
    $(".pagination").empty()
    $(".pagination").append('<li class="paginate_button previous disabled" id="datatables_previous"><a href="#">上一页</a></li>')
    strList.forEach(function(e){
      if(e=="..."){
       $(".pagination").append('<li class="paginate_button disabled" id="datatables_ellipsis"><a href="#">…</a></li>')
     }else{
      $(".pagination").append('<li class="paginate_button"><a href="#">1</a></li>')
      $(".paginate_button:last a").text(e).attr("onclick","skipPage(" +e+")")
      if(e==pageNo){
        $(".paginate_button:last").addClass("active")
      }}
    })
    $(".pagination").append('<li class="paginate_button next" id="datatables_next"><a href="#">下一页</a></li>')
    if(pageNo-1>0){
     $("#datatables_previous a").attr("onclick","skipPage(" +(pageNo-1)+")")}
     if(pageNo<pageTotal){
       $("#datatables_next a").attr("onclick","skipPage(" +(pageNo+1)+")")}
       $("input.form-control").keyup(function(){
         var value=$(this).val()
         if (value == ""){
          changeButton(pageno);
        }
      })
     }
     function loadMore(){
     pageno+=1
      $.get('http://112.35.30.146:19090/pageDeathLoad.do?pageno='+pageno,
//        $.get('http://192.168.4.99:6262/pageDeathLoad.do?pageno='+pageno,
        function(resultBean, status, xhRequest){
          var tableElement=$(".table tbody")
          var trCount=tableElement.children('tr').length
          for(var i in resultBean.data){
            var result=resultBean.data[i]
            var index =parseInt(i)+parseInt(trCount)
            tableElement.append('<tr data-sid="'+index+'" data-id="'+result.deathSourceId+'">')
            var trElement=$("#datatables tbody tr:last")
            trElement.append('<td style="text-align: center">'+result.channelName+'</td>')
            trElement.append('<td><a href="'+result.deathSource+'" style="display: block; width: 500px; word-wrap: break-word; word-break: normal;">'+result.deathSource+'</td>')
            trElement.append('<td class="text-right source-list"> 客户端反馈</td>')
            trElement.append('<td><button class="btn btn-primary btn-round audit" data_id="'+result.deathSourceId+'"><font><font>chilk</font></font><div class="ripple-container"></div></button></td>')
          }
      })
    }
    function skipPage(pageIndex){
      if(content === "pages/livingChannel.jsp"){
        $.get("http://112.35.30.146:19090/pageLoad.do?pageno="+pageIndex,
//          $.get("http://192.168.4.99:6262/pageLoad.do?pageno="+pageIndex,
          function(resultBean, status, xhRequest){
           if (resultBean.data != undefined) {
             resultList=resultBean.data
             var element=$("#datatables tbody").empty()
             for(var i in resultList){
               var result=resultList[i]
               element.append('<tr role="row"></tr>')
               var trElement=$("#datatables tbody tr:last").addClass(i%2==0?"odd":"even")
               trElement.append('<td style="text-align: center">'+result.id+'</td>')
               trElement.append('<td style="text-align: center">'+result.channel+'</td>')
               trElement.append('<td style="text-align: center">'+(typeof(result.source)=="undefined"?0:result.source.split("|").length)+'</td>')
               trElement.append('<td style="text-align: center">未设置</td>')
               trElement.append('<td style="text-align: center">未设置</td>')
               trElement.append('<td style="text-align: center"></td>')
               trElement.find('td:last').append('<a href="?eid='+result.id+'" class="btn btn-simple btn-warning btn-icon edit"><i class="material-icons">edit</i></a>')
             }
             changeButton(pageIndex)
             $('.main-panel').animate({ scrollTop: 0 }, 100);
           }
         },
         "json"
         );    }
        if(content === "pages/typeChannel.jsp"){
          $.get("http://112.35.30.146:19090/pageMapLoad.do?pageno="+pageIndex,
//          $.get("http://192.168.4.99:6262/pageMapLoad.do?pageno="+pageIndex,
            function(resultBean, status, xhRequest){
              if (resultBean.data != undefined) {
               resultList=resultBean.data
               var element=$("#datatables tbody").empty()
               for(var i in resultList){
                 var result=resultList[i]
                 element.append('<tr role="row"></tr>')
                 var trElement=$("#datatables tbody tr:last").addClass(i%2==0?"odd":"even")
                 trElement.append('<td style="text-align: center">'+result.id+'</td>')
                 trElement.append('<td style="text-align: center">'+result.key+'</td>')
                 trElement.append('<td style="text-align: center">'+result.value+'</td>')
                 trElement.append('<td style="text-align: center">'+new Date(result.createdat).Format("yyyy-MM-dd hh:mm:ss")+'</td>')
                 trElement.append('<td style="text-align: center" class="td-actions text-right"></td>')
                 trElement.find('td:last').append('<button data-id="'+result.id+'" type="button" rel="tooltip" class="btn btn-danger btn-remove-mapping"> <i class="material-icons">close</i></button>')
               }
               $('.btn-remove-mapping').on('click', function () {
                                   // 删除 Mapper
                                   var id = $(this).data("id");

                                   swal.queue([{
                                     title: '确认删除此映射 ？',
                                     confirmButtonClass: 'btn btn-warning',
                                     confirmButtonText: '确认',
                                     buttonsStyling: false,
                                     showLoaderOnConfirm: true,
                                     cancelButtonText: '取消',
                                     cancelButtonClass: 'btn btn-default',
                                     showCancelButton: true,
                                     allowOutsideClick: false,
                                     preConfirm: function () {
                                       return new Promise(function (resolve) {
                                         $.ajax(
                                         {
                                           type: "POST",
                                           url: "/router/channel/removeMapper.do",
                                           data: {"id": id},
                                           success: function (data) {
                                             var result = data;
                                             if (result.code === 200) {
                                               window.location.reload();
                                             } else {
                                               swal.insertQueueStep("删除失败！");
                                             }
                                             resolve();
                                           },
                                           error: function () {
                                             swal.insertQueueStep("删除失败！");
                                             resolve()
                                           }
                                         }
                                         );
                                       });
                                     }
                                   }])
                                 });
               changeButton(pageIndex)
               $('.main-panel').animate({ scrollTop: 0 }, 100);
             }
           },
           "json"
           );}
        }