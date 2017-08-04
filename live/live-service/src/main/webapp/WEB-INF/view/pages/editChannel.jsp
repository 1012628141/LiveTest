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
    <title>Live-编辑频道信息</title>
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
                <a class="navbar-brand" href="#"> 编辑频道信息 </a>
            </div>
        </nav>
        <div class="content" style="margin-top: 45px;">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header card-header-text" data-background-color="rose">
                                <h4 class="card-title">TYPE: ${channel.typeid} - ${channel.channel} ( ID: ${channel.id} )</h4>
                            </div>
                            <div class="card-content">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th class="text-center">#</th>
                                            <th>源地址</th>
                                            <th class="text-right">状态</th>
                                            <th class="text-right">操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:if test="${channel.source != null}">
                                            <c:set value="${ fn:split(channel.source, '|') }" var="sources" />
                                            <c:forEach items="${ sources }" var="s" varStatus="loop">
                                                <c:if test="${not empty s}">
                                                    <tr data-sid="${loop.index}" data-id="${channel.id}">
                                                        <td class="text-center">${loop.index + 1}</td>
                                                        <td>
                                                            <a href="${fn:toLowerCase(s)}" style="display: block; width: 70%; word-wrap: break-word; word-break: normal;">
                                                                    ${fn:toLowerCase(s)}
                                                            </a>
                                                        </td>
                                                        <td class="text-right">
                                                            未知
                                                        </td>
                                                        <td class="td-actions text-right">
                                                            <button type="button" rel="tooltip" class="btn btn-danger btn-remove-source">
                                                                <i class="material-icons">close</i>
                                                            </button>
                                                        </td>
                                                    </tr>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="card-footer">
                                <div style="float: right; padding-bottom: 10px;">
                                    <button class="btn btn-primary btn-add-source" data-id="${channel.id}">新增频道源</button>
                                    <button class="btn btn-warning btn-change-type" data-id="${channel.id}">修改频道分类</button>
                                    <button class="btn btn-danger btn-remove-channel" data-id="${channel.id}">删除频道</button>
                                </div>
                            </div>
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
    $(document).ready(function() {
        // Bind actions
        $('.btn-remove-source').on('click', function () {
            var id = $(this).parent().parent().data("id");
            var sid = $(this).parent().parent().data("sid");
            // Remove this id source, with alert confirm.
            swal.queue([{
                title: '确认删除 ？',
                confirmButtonText: '确认删除',
                cancelButtonText: '取消',
                cancelButtonClass: 'btn btn-default',
                text: '将要删除该视频源，删除后客户端将不再显示...',
                type: 'warning',
                showCancelButton: true,
                showLoaderOnConfirm: true,
                allowOutsideClick: false,
                preConfirm: function () {
                    return new Promise(function (resolve) {
                        $.ajax(
                            {
                                type: "POST",
                                url: "/webChannel/removeSource.do",
                                data: {"channelId": id, "sourceId": sid},
                                success: function (data) {
                                    var result = data;
                                    if (result.code === 200) {
                                        swal.insertQueueStep("删除成功 !");
                                        window.location.reload();
                                    } else {
                                        swal.insertQueueStep("删除失败！");
                                    }
                                    resolve()
                                },
                                error: function () {
                                    swal.insertQueueStep("删除失败！");
                                    resolve()
                                }
                            }
                        );
                    });
                }
            }]);
        });

        // Add New sources
        $('.btn-add-source').on('click', function () {
            var id = $(this).data("id");
            // Add new source
            swal.queue([{
                title: '请输入源地址，通常以m3u8或flv结尾',
                html:
                '<div class="form-group">' +
                    '<input id="input-field" type="text" class="form-control" />' +
                '</div>',
                confirmButtonClass: 'btn btn-warning',
                cancelButtonClass: 'btn btn-default',
                confirmButtonText: '确认添加',
                buttonsStyling: false,
                showLoaderOnConfirm: true,
                allowOutsideClick: false,
                cancelButtonText: '取消',
                showCancelButton: true,
                preConfirm: function () {
                    return new Promise(function (resolve) {
                        var value = $('#input-field').val();
                        if (value && value.trim()) {
                            $.ajax(
                                {
                                    type: "POST",
                                    url: "/webChannel/addSource.do",
                                    data: {"channelId": id, "sourceUri": value},
                                    success: function (data) {
                                        console.log(data);
                                        var result = data;
                                        if (result.code === 200) {
                                            swal.insertQueueStep("添加成功 !");
                                            window.location.reload();
                                        } else {
                                            swal.insertQueueStep("添加失败！");
                                        }
                                        resolve()
                                    },
                                    error: function (data) {
                                        console.log(data);
                                        swal.insertQueueStep("添加失败！");
                                        resolve()
                                    }
                                }
                            );
                        } else {
                            swal.insertQueueStep("不能新增空字符串！");
                            resolve()
                        }
                    });
                }
            }])
        });

        // Change channel type
        $('.btn-change-type').on('click', function () {
            var id = $(this).data("id");
            // Add new source
            swal.queue([{
                title: '请输入修改后的分类ID',
                html:
                '<div class="form-group">' +
                '<input id="input-field" type="text" class="form-control" />' +
                '</div>',
                confirmButtonClass: 'btn btn-warning',
                confirmButtonText: '确认添加',
                buttonsStyling: false,
                showLoaderOnConfirm: true,
                cancelButtonText: '取消',
                cancelButtonClass: 'btn btn-default',
                showCancelButton: true,
                allowOutsideClick: false,
                preConfirm: function () {
                    return new Promise(function (resolve) {
                        var value = $('#input-field').val();
                        if (value && value.trim()) {
                            $.ajax(
                                {
                                    type: "POST",
                                    url: "/webChannel/changeType.do",
                                    data: {"channelId": id, "typeId": value},
                                    success: function (data) {
                                        var result = data;
                                        if (result.code === 200) {
                                            swal.insertQueueStep("修改成功 !");
                                            window.location.reload();
                                        } else {
                                            swal.insertQueueStep("修改失败！");
                                        }
                                        resolve()
                                    },
                                    error: function () {
                                        swal.insertQueueStep("修改失败！");
                                        resolve()
                                    }
                                }
                            );
                        } else {
                            swal.insertQueueStep("不能新增空字符串！");
                            resolve()
                        }
                    });
                }
            }])
        });

        // Delete channel
        $('.btn-remove-channel').on('click', function () {
            var id = $(this).data("id");

            swal.queue([{
                title: '确认删除此频道？',
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
                                url: "/webChannel/removeChannel.do",
                                data: {"channelId": id},
                                success: function (data) {
                                    var result = data;
                                    if (result.code === 200) {
                                        swal.insertQueueStep("删除成功 !，请关闭该窗口！");
                                    } else {
                                        swal.insertQueueStep("删除失败！");
                                    }
                                    $(window).attr('location','/');
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
    });
</script>

</html>