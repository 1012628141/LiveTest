<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!doctype html>
<html lang="en">

	<head>
		<meta charset="utf-8" />
		<link rel="apple-touch-icon" sizes="76x76" href="/img/apple-icon.png" />
		<link rel="icon" type="image/png" href="/img/favicon.png" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<title>Live-批量删除</title>
		<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
		<meta name="viewport" content="width=device-width" />
		<!-- Bootstrap core CSS     -->
		<link href="/css/bootstrap.min.css" rel="stylesheet" />
		<!--  Material Dashboard CSS    -->
		<link href="/css/material-dashboard.css" rel="stylesheet" />
		<!--     Fonts and icons     -->
		<link href="/css/mont.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="/css/gont.css" />
	</head>

	<body>
		<div class="wrapper">
			<div class="main-panel" style="width: 100%; float: none;">
				<nav class="navbar navbar-transparent navbar-absolute">
					<div class="navbar-minimize">
						<button class="btn btn-round btn-white btn-fill btn-just-icon">
	                    <i class="material-icons visible-on-sidebar-regular">more_vert</i>
	                    <i class="material-icons visible-on-sidebar-mini">view_list</i>
	                </button>
					</div>
					<div class="container-fluid">
						<a class="navbar-brand" href="/?item=livingChannel"> 返回 </a>
					</div>
				</nav>
				<div class="content" style="margin-top: 45px;">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="card-header card-header-text" data-background-color="rose">
										<h4 class="card-title">批量删除源</h4>
									</div><br/>
									<form name="F1">
										<select name="select1" onChange="set_list(this.options.selectedIndex)" class="selectpicker col-md-2" data-style="btn btn-primary btn-round" title="Single Select" data-size="7">
											<option disabled selected> 选择源的类型</option>
											<option>软件获取</option>
											<option>央视</option>
											<option>卫视</option>
										</select>
										<select name="select2" class="selectpicker col-md-2" id="selectpackage" onChange="set_tr(this.options.selectedIndex)" data-style="btn btn-primary btn-round" data-size="7">
											<option>详细分类</option>
										</select>
										<div class="col-sm-2" style="float:right">
											<div class="form-group label-floating">
												<label class="control-label">输入频道名</label>
												<input id="search" type="text" class="form-control">
											</div>
										</div>
									</form>

									<form name="F2">
										<div class="card-content">
											<div class="table-responsive">
												<table class="table">
													<thead>
														<tr>
															<th class="text-center">源的分类</th>
															<th class="text-center">视频源url</th>
															<th class="text-right">选中</th>
														</tr>
													</thead>
													<tbody class="t-data-body">

													</tbody>
												</table>
											</div>
										</div>
										<div class="card-footer">
											<div style="float: right; padding-bottom: 10px;">
												<input id="AllOptions" type="button" value="全选" class="btn btn-primary btn-submit-source" />
												<input id="deleted" type="button" value="提交删除" class="btn btn-primary btn-submit-source" />
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<footer class="footer">
					<div class="container-fluid">
						<nav class="pull-left">
							<ul>
								<li>
									<a href="/">
										管理后台主页
									</a>
								</li>
							</ul>
						</nav>
						<p class="copyright pull-right">
							&copy;
							<script>
								document.write(new Date().getFullYear())
							</script>
							<a href="/">Living city .admin</a>, 直播源管理系统
						</p>
					</div>
				</footer>
			</div>
		</div>
	</body>
	<script src="/js/jquery-3.1.1.min.js" type="text/javascript"></script>
	<script src="/js/jquery-ui.min.js" type="text/javascript"></script>
	<script src="/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="/js/material.min.js" type="text/javascript"></script>
	<script src="/js/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
	<script src="/js/jquery.validate.min.js"></script>
	<script src="/js/moment.min.js"></script>
	<script src="/js/chartist.min.js"></script>
	<script src="/js/jquery.bootstrap-wizard.js"></script>
	<script src="/js/bootstrap-notify.js"></script>
	<script src="/js/bootstrap-datetimepicker.js"></script>
	<script src="/js/jquery-jvectormap.js"></script>
	<script src="/js/nouislider.min.js"></script>
	<!--  Google Maps Plugin    -->
	<%--<script src="https://maps.googleapis.com/maps/api/js"></script>--%>
	<!-- Select Plugin -->
	<script src="/js/jquery.select-bootstrap.js"></script>
	<!--  DataTables.net Plugin    -->
	<script src="/js/jquery.datatables.js"></script>
	<!-- Sweet Alert 2 plugin -->
	<script src="/js/sweetalert2.js"></script>
	<!--	Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
	<script src="/js/jasny-bootstrap.min.js"></script>
	<!--  Full Calendar Plugin    -->
	<script src="/js/fullcalendar.min.js"></script>
	<!-- TagsInput Plugin -->
	<script src="/js/jquery.tagsinput.js"></script>
	<!-- Material Dashboard javascript methods -->
	<script src="/js/material-dashboard.js"></script>
	<!-- Material Dashboard DEMO methods, don't include it in your project! -->
	<script src="/js/demo.js"></script>

	<script type="text/javascript">
		var first = true;
		var same = null;

		function set_list(x) {
			first = true;
			var args = {
				"number": x
			};
			var url = "/router/channel/select1Class.do";
			var selobj = document.F1.select2;
			$('#selectpackage').find('option').remove();
			$.get(url, args, function(data) {
			    var dataList = data.data
				if(data != null && dataList.length > 0) {
					for(var i = 0; i < dataList.length+1; i++) {
					    if(i==0){
					        selobj.options[i] = new Option("详细分类","")
					    }
					    else{
						if(x == 2) {
							selobj.options[i] = new Option(dataList[i-1], dataList[i-1] + "1");
						} else {
							selobj.options[i] = new Option(dataList[i-1], dataList[i-1] + "2");
						}
						}
						$('#selectpackage').selectpicker('refresh');
						$('#selectpackage').selectpicker('render');
					}
				}
			})
		}

		function set_tr(x) {
			$('.t-data-body').find('tr').remove();
			var value = document.F1.select2.options[x].value;
			var number = value.length
			var program = value.slice(0, number - 1);
			var form = value.slice(number - 1, number);

			var args = {
				"form": form,
				"TvName": program
			}
			var url = "/router/channel/select2Class.do";
			$.get(url, args, function(data) {
			    var dataMap = data.data
			    if(data != null && dataMap.length != 0) {
				for(var i = 0; i < dataMap.length; i++) {
						if(dataMap[i].source.length > 100) {
							var sources = dataMap[i].source.substring(0, 100) + "....";
						} else {
							sources = dataMap[i].source;
						}
						var channel = dataMap[i].channel
						var source = dataMap[i].channel
						var id = dataMap[i].id
						appends(channel, source, sources, id)
					}
				}
			})
		}
		$('#search').blur(function() {
			var test = $('#search').val()
			if(test == same || test == "") {
				return
			}
			var r = /^-?[ADFHJM-RU-Yadfhjm-ru-y02-9]\d*$/
			same = test
			if(r.test(test.substring(0, 1))) {
				swal({
					title: "error!",
					text: "请输入正确的频道名称",
					type: "error",
					buttonsStyling: true,
					confirmButtonClass: "btn btn-info"
				})
				return
			}
			$('.t-data-body').find('tr').remove();
			var url = "/router/channel/selectColumn.do";
			var args = {
				"search": test + "%"
			}
			$.get(url, args, function(data) {
			    var listMap = data.data
				if(data != null && listMap.length != 0) {
					for(var i = 0; i < listMap.length; i++) {
						if(listMap[i].source.length > 100) {
							var sources = listMap[i].source.substring(0, 100) + "....";
						} else {
							sources = listMap[i].source;
						}
						var channel = listMap[i].channel;
						var source = listMap[i].source;
						var id = listMap[i].id;
						appends(channel, source, sources, id);
					}
				}
			})
		})
		$('#AllOptions').click(function() {
			if(first) {
				if($(':checkbox').length == 0) {
					swal({
						title: "error!",
						text: "页面不存在能选中的词条",
						type: "error",
						buttonsStyling: true,
						confirmButtonClass: "btn btn-info"
					})
					first = false
					return;
				}
			} else {
				if($(':checkbox').length == 1) {
					swal({
						title: "error!",
						text: "页面不存在能选中的词条",
						type: "error",
						buttonsStyling: true,
						confirmButtonClass: "btn btn-info"
					})
					return;
				}
			}
			if($('#AllOptions').val() == "全选") {
				$(':checkbox').prop("checked", true);
				$('#AllOptions').attr("value", "取消");

			} else {
				$(':checkbox').prop("checked", false);
				$('#AllOptions').attr("value", "全选");
			}
		})
		$('#deleted').click(function() {
			var form = new Array();
			if($(':checkbox').is(':checked')) {
				$(':checkbox').each(function() {
					if($(this).is(':checked')) {
						form.push($(this).val())
					}
				})
				swal.queue([{
					title: '确认删除的数据源 ？',
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
								url:"/router/channel/deleteMoreUrl.do",
								data:{"form":JSON.stringify(form)  },
								success: function(data) {
									var result = data;
									console.log(result)
									swal({
										title: "success!",
										text: "选中项删除成功！",
										type: "success",
										buttonsStyling: true,
										confirmButtonClass: "btn btn-info"
									})
									$(':checkbox').each(function() {
										for(var i = 0; i < form.length; i++) {
											if(form[i] == $(this).val()) {
												$(this).parent().parent().parent().parent().remove();
											}
										}
									})
								},
								error: function() {
									swal({
										title: "error!",
										text: "选中项删除失败！",
										type: "error",
										buttonsStyling: true,
										confirmButtonClass: "btn btn-info"
									})
								}
							})
						})
					}
				}])

			} else {
				swal({
					title: "error!",
					text: "并未发现被选中视频源！",
					type: "error",
					buttonsStyling: true,
					confirmButtonClass: "btn btn-info"
				})
			}
		})

		function appends(channel, source, sources, id) {
			$('.t-data-body').append(
				'<tr>' +
				'<td class="text-center col-md-2">' + channel + '</td>' +
				'<td class="text-left ">' +
				'<a href=' + source + 'title=' + source + ' width: 70%; word-wrap: break-word; word-break: normal;">' +
				sources +
				'</a>' +
				'</td>' +
				'<td class="text-center">' +
				'<div class="checkbox col-md-1">' +
				'<label>' +
				'<input type="checkbox" name="optionsCheckboxes" value=' + id + '>' +
				'<span class="checkbox-material">' +
				'<span class="check" >' +
				'</span>' +
				'</span>' +
				'</label>' +
				'</div>' +
				'</td>' +
				'</tr>'
			)
		}
	</script>