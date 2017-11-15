<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="row">
	<div class="col-md-12">
		<div class="card">
			<div class="card-header card-header-icon" data-background-color="purple">
				<i class="material-icons">assignment</i>
			</div>
			<div class="card-content">
				<h4 class="card-title">全部频道</h4>
				<div class="material-datatables">
					<table id="datatables" class="table table-striped table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
						<thead>
							<tr role="row">
								<th style="text-align: center">频道ID</th>
								<th style="text-align: center">频道名</th>
								<th style="text-align: center">源数量（个）</th>
								<th style="text-align: center">清晰度</th>
								<th style="text-align: center">更新日期</th>
								<th style="text-align: center">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${not empty channelList}">
								<c:forEach var="channel" items="${channelList}" varStatus="loop">
									<tr role="row" class="${loop.index % 2 == 0 ? " odd ": "even "}">
										<td style="text-align: center">${channel.id}</td>
										<td style="text-align: center">${channel.channel}</td>
										<!--<c:set value="0" var="sources" />-->
										<c:if test="${channel.source!=null }">
											<c:set value="${ fn:split(channel.source, '|') }" var="sources" />
										</c:if>
										<td style="text-align: center">
											<c:set value="${ 0 }" var="count" />
											<c:forEach var="s" items="${sources}" varStatus="loop">
												<c:if test="${not empty s}">
													<c:set value="${ count + 1 }" var="count" />
												</c:if>
											</c:forEach>
											${ count }
										</td>
										<td style="text-align: center">未设置</td>
										<td style="text-align: center">未设置</td>
										<td style="text-align: center">
											<a href="?eid=${channel.id}" class="btn btn-simple btn-warning btn-icon edit">
												<i class="material-icons">edit</i>
											</a>
										</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
			<!-- end content-->
			<div class="card-footer">
				<button class="btn btn-info btn-add-channel">新增频道</button>
				<button class="btn btn-primary" id="btn-remove-cache">清除客户端缓存</button>
				<a href="/router/channel/delete.do" class="btn btn-danger ">批量删除源</a>
			</div>
		</div>
		<!--  end card  -->
	</div>
	<script>
		$(function() {
			$('#btn-remove-cache').click(function() {
				swal.queue([{
					title: '确认清除客户端缓存 ？',
					confirmButtonClass: 'btn btn-warning',
					confirmButtonText: '确认',
					buttonsStyling: false,
					showLoaderOnConfirm: true,
					cancelButtonText: '取消',
					cancelButtonClass: 'btn btn-default',
					showCancelButton: true,
					allowOutsideClick: false,
					preConfirm: function() {
						return new Promise(function(resolve) {
							$.ajax({
								type: "get",
								url: "/channel/mapCacheExpire.do",
								success: function(data) {
									var result = data;
									if(result.code === 200) {
										swal({
											title: "success!",
											text: "推送发送成功！",
											type: "success",
											buttonsStyling: true,
											confirmButtonClass: "btn btn-info"
										})
									} else {
										swal({
											title: "error!",
											text: "推送发送失败！",
											type: "error",
											buttonsStyling: true,
											confirmButtonClass: "btn btn-info"
										})
									}
								},
								error: function() {
									swal({
										title: "error!",
										text: "推送发送失败！",
										type: "error",
										buttonsStyling: true,
										confirmButtonClass: "btn btn-info"
									})
								}
							})
						})
					}
				}])
			});
    $('#datatables').DataTable({
       pageLength: 20,
       lengthChange: false,
       info: false,
       ordering: false,
       autoWidth: true,
       searching:false,
       "language": {
           "paginate": {
               "previous": "上一页",
               "last": "最后一页",
               "next": "下一页"
           },
       },
       "search": {
           "caseInsensitive": false
       }
   });
    var pageNo=${pageNo};
    var pageCount=${pageCount};
    var page='${content}'
    init(pageCount,page);
    changeButton(1)
});
	</script>
	<!-- end col-md-12 -->
</div>