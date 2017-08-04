var pageTotal=null
var pageno=null
function init(pageNo,pageCount){
    var strList=new Array();
    strList[0]=pageNo;
    pageTotal=pageCount;
    pageno=pageNo
    var indexBefore=0;
    while(strList[0]!=1&&(indexBefore<3)){
    strList.unshift(strList[0]-1);
    indexBefore++;
    }
    var indexAfter=0;
    while(strList[strList.length-1]!=pageCount&&(indexAfter<3||strList.length<7)){
        strList.push(strList[strList.length-1]+1);
        indexAfter++;
        }
    while(strList.length<7)
    {
    strList.unshift(strList[0]-1);
    }
    strList[0]=1;
    strList[strList.length-1]=pageCount;
    if(strList[1]!=2){
    strList[1]="..."
    }
    if(strList[strList.length-2]!=pageCount-1){
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
     if(pageNo<pageCount){
     $("#datatables_next a").attr("onclick","skipPage(" +(pageNo+1)+")")}
     $("input.form-control").keyup(function(){
                       var value=$(this).val()
                       console.log(value == "")
                       if (value == ""){
                        console.log(pageNo)
                        console.log(pageTotal)
                        init(pageno,pageCount);
                       }
                       })
    }
function skipPage(pageIndex){
    $('.main-panel').animate({ scrolladsfaTop: 0 }, 100);
    $.get("http://192.168.4.99:6262/pageLoad?pageno="+pageIndex,
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
               init(pageIndex,pageTotal)
               }
               },
               "json"
              );
}