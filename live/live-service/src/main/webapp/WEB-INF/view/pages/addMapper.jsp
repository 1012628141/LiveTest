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
    <title>Live-新增映射</title>
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
                <a class="navbar-brand" href="/"> 回到主页 </a>
            </div>
        </nav>
        <div class="content" style="margin-top: 45px;">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header card-header-text" data-background-color="rose">
                                <h4 class="card-title">新增频道映射</h4>
                            </div>
                            <form>
                                <div class="card-content">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th class="text-center">语音识别结果</th>
                                                <th class="text-center">真实完整频道名称</th>
                                                <th class="text-center">操作</th>
                                            </tr>
                                            </thead>
                                            <tbody class="t-data-body">
                                                <tr>
                                                    <td class="text-center" style="border: none;">
                                                        <div class="form-group">
                                                            <input type="text" prop="key" name="key" placeholder="识别结果" class="form-control text-center" />
                                                        </div>
                                                    </td>
                                                    <td class="text-center" style="border: none;">
                                                        <div class="form-group">
                                                            <input type="text" prop="value" name="value" placeholder="完整名称" class="form-control text-center" />
                                                        </div>
                                                    </td>
                                                    <td class="td-actions text-center" style="border: none;">
                                                        <button type="button" rel="tooltip" class="btn btn-danger btn-rm-row">
                                                            <i class="material-icons">close</i>
                                                        </button>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="card-footer">
                                    <div style="float: right; padding-bottom: 10px;">
                                        <%--<div>--%>
                                            <%--<span class="btn btn-round btn-rose btn-file">--%>
                                            <%--<span class="fileinput-new">使用文件上传</span>--%>
                                                <%--<span class="fileinput-exists"></span>--%>
                                                <%--<input type="file" name="file" accept="text/csv, text/xml, application/xml, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" />--%>
                                            <%--</span>--%>
                                        <%--</div>--%>
                                        <input type="button" value="新增一行" class="btn btn-warning btn-add-row" />
                                        <input type="button" value="提交表格" class="btn btn-primary btn-submit-source" />
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
    
    function bindFunctions() {
        $('.btn-rm-row').on('click', function () {
            // 删除当前行
            $(this).parent().parent().remove();
        });
    }
    
    $(document).ready(function() {
        $('.btn-add-row').on('click', function () {
            // 增加一行新的
            $('.t-data-body').append(
                '<tr>' +
                    '<td class="text-center" style="border: none;">' +
                        '<div class="form-group">' +
                            '<input type="text" prop="key" placeholder="识别结果" class="form-control text-center" />' +
                        '</div> ' +
                    '</td> ' +
                    '<td class="text-center" style="border: none;"> ' +
                        '<div class="form-group"> ' +
                            '<input type="text" prop="value" placeholder="完整名称" class="form-control text-center" /> ' +
                        '</div> ' +
                    '</td> ' +
                    '<td class="td-actions text-center" style="border: none;"> ' +
                        '<button type="button" rel="tooltip" class="btn btn-danger btn-rm-row"> ' +
                            '<i class="material-icons">close</i> ' +
                        '</button> ' +
                    '</td> ' +
                '</tr>'
            );
            // 重新绑定事件
            bindFunctions();
        });

        bindFunctions();

        // 提交新的数据
        $('.btn-submit-source').on('click', function () {

            var data = new Array();

            $('tr').each(function () {

                var $key = $('input[prop="key"]');
                var $value = $('input[prop="value"]');

                var key = $(this).find($key).val();
                var value = $(this).find($value).val();

                console.log(key + '|' + value);

                if (key && value) {
                    data.push(key + ',' + value);
                }
            });

            // Add new
            if (data.length != 0) {
                swal.queue([{
                    title: '确认添加这批新的规则么？',
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
                            $.ajax(
                                {
                                    type: "POST",
                                    url: "/router/channel/addMapper.do",
                                    data: {"content": data.join('|')},
                                    success: function (data) {
                                        var result = data;
                                        if (result.code === 200) {
                                            var rd = result.data;
                                            swal.insertQueueStep('结果' + rd.join(', '));
                                        } else {
                                            swal.insertQueueStep("新增失败！");
                                        }
                                        resolve()
                                    },
                                    error: function () {
                                        swal.insertQueueStep("新增失败！");
                                        resolve()
                                    }
                                }
                            );
                        });
                    }
                }])
            }
        });
    });
</script>

</html>