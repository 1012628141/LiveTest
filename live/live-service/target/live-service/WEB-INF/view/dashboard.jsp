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
    <title>Live-直播源管理系统</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <!-- Bootstrap core CSS     -->
    <link href="/css/bootstrap.min.css" rel="stylesheet" />
    <!--  Material Dashboard CSS    -->
    <link href="/css/material-dashboard.css" rel="stylesheet" />
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons" />
</head>

<body>
    <div class="wrapper">
        <div class="sidebar" data-active-color="rose" data-background-color="black" data-image="/img/sidebar-1.jpg">
            <!--
        Tip 1: You can change the color of active element of the sidebar using: data-active-color="purple | blue | green | orange | red | rose"
        Tip 2: you can also add an image using data-image tag
        Tip 3: you can change the color of the sidebar with data-background-color="white | black"
    -->
            <div class="logo">
                <a href="/" class="simple-text">
                    Live-直播源管理系统
                </a>
            </div>
            <div class="logo logo-mini">
                <a href="/" class="simple-text">
                    Yd
                </a>
            </div>
            <div class="sidebar-wrapper">
                <div class="user">
                    <div class="photo">
                        <img src="/img/faces/avatar.jpg" />
                    </div>
                    <div class="info">
                        <a data-toggle="collapse" href="#collapseExample" class="collapsed">
                            dylan（管理员）
                            <b class="caret"></b>
                        </a>
                        <div class="collapse" id="collapseExample">
                            <ul class="nav">
                                <li>
                                    <a href="#">安全设置</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <%--获得导航--%>
                <c:if test="${not empty navItem}">
                    <ul class="nav">
                        <c:forEach var="listValue" items="${navItem}" varStatus="loop">
                            <li class="${listValue.id == active ? "active": ""}">
                                <a href="${listValue.href}">
                                    <i class="material-icons">${listValue.icon}</i>
                                    <p>${listValue.name}</p>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>

                <%--<ul class="nav">--%>
                    <%--<li class="active">--%>
                        <%--<a href="dashboard.jsp">--%>
                            <%--<i class="material-icons">dashboard</i>--%>
                            <%--<p>统计数据</p>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a data-toggle="collapse" href="#componentsExamples">--%>
                            <%--<i class="material-icons">apps</i>--%>
                            <%--<p>直播频道--%>
                                <%--<b class="caret"></b>--%>
                            <%--</p>--%>
                        <%--</a>--%>
                        <%--<div class="collapse" id="componentsExamples">--%>
                            <%--<ul class="nav">--%>
                                <%--<li>--%>
                                    <%--<a href="#">全部频道</a>--%>
                                <%--</li>--%>
                                <%--<li>--%>
                                    <%--<a href="#">频道存活检测</a>--%>
                                <%--</li>--%>
                                <%--<li>--%>
                                    <%--<a href="#">高清频道</a>--%>
                                <%--</li>--%>
                                <%--<li>--%>
                                    <%--<a href="#">其他频道（未使用）</a>--%>
                                <%--</li>--%>
                            <%--</ul>--%>
                        <%--</div>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a data-toggle="collapse" href="#">--%>
                            <%--<i class="material-icons">grid_on</i>--%>
                            <%--<p>频道分类--%>
                                <%--<!--<b class="caret"></b>-->--%>
                            <%--</p>--%>
                        <%--</a>--%>
                        <%--<!--<div class="collapse" id="tablesExamples">-->--%>
                            <%--<!--<ul class="nav">-->--%>
                                <%--<!--<li>-->--%>
                                    <%--<!--<a href="#">数据统计/分析</a>-->--%>
                                <%--<!--</li>-->--%>
                                <%--<!--<li>-->--%>
                                    <%--<!--<a href="#">用户数据</a>-->--%>
                                <%--<!--</li>-->--%>
                                <%--<!--<li>-->--%>
                                    <%--<!--<a href="#">用户数据</a>-->--%>
                                <%--<!--</li>-->--%>
                                <%--<!--<li>-->--%>
                                    <%--<!--<a href="#">商家管理</a>-->--%>
                                <%--<!--</li>-->--%>
                                <%--<!--<li>-->--%>
                                    <%--<!--<a href="#">商品管理</a>-->--%>
                                <%--<!--</li>-->--%>
                            <%--<!--</ul>-->--%>
                        <%--<!--</div>-->--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="#">--%>
                            <%--<i class="material-icons">gavel</i>--%>
                            <%--<p>服务器状态</p>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="#">--%>
                            <%--<i class="material-icons">timeline</i>--%>
                            <%--<p>用户热图</p>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            </div>
        </div>
        <div class="main-panel">
            <nav class="navbar navbar-transparent navbar-absolute">
                <div class="container-fluid">
                    <div class="navbar-minimize">
                        <button id="minimizeSidebar" class="btn btn-round btn-white btn-fill btn-just-icon">
                            <i class="material-icons visible-on-sidebar-regular">more_vert</i>
                            <i class="material-icons visible-on-sidebar-mini">view_list</i>
                        </button>
                    </div>
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse">
                            <span class="sr-only">切换菜单</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#"> 管理后台 </a>
                    </div>
                    <div class="collapse navbar-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <!--<li>-->
                                <!--<a href="#pablo" class="dropdown-toggle" data-toggle="dropdown">-->
                                    <!--<i class="material-icons">dashboard</i>-->
                                    <!--<p class="hidden-lg hidden-md">管理后台</p>-->
                                <!--</a>-->
                            <!--</li>-->
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="material-icons">notifications</i>
                                    <span class="notification">2</span>
                                    <p class="hidden-lg hidden-md">
                                        通知
                                        <b class="caret"></b>
                                    </p>
                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="#">您有直播源挂掉了</a>
                                    </li>
                                    <li>
                                        <a href="#">服务器故障</a>
                                    </li>
                                </ul>
                            </li>
                            <!--<li>-->
                                <!--<a href="#pablo" class="dropdown-toggle" data-toggle="dropdown">-->
                                    <!--<i class="material-icons">person</i>-->
                                    <!--<p class="hidden-lg hidden-md">Profile</p>-->
                                <!--</a>-->
                            <!--</li>-->
                            <li class="separator hidden-lg hidden-md"></li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="content">
                <div class="container-fluid">
                    <%--动态载入界面--%>
                    <jsp:include page="${content}" flush="true" />
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
                            <li>
                                <a href="#">
                                    技术博客
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
<!--   Core JS Files   -->
<!--   Core JS Files   -->
<script src="/js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="/js/jquery-ui.min.js" type="text/javascript"></script>
<script src="/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/js/material.min.js" type="text/javascript"></script>
<script src="/js/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
<!-- Forms Validations Plugin -->
<script src="/js/jquery.validate.min.js"></script>
<!--  Plugin for Date Time Picker and Full Calendar Plugin-->
<script src="/js/moment.min.js"></script>
<!--  Charts Plugin -->
<script src="/js/chartist.min.js"></script>
<!--  Plugin for the Wizard -->
<script src="/js/jquery.bootstrap-wizard.js"></script>
<!--  Notifications Plugin    -->
<script src="/js/bootstrap-notify.js"></script>
<!-- DateTimePicker Plugin -->
<script src="/js/bootstrap-datetimepicker.js"></script>
<!-- Vector Map plugin -->
<script src="/js/jquery-jvectormap.js"></script>
<!-- Sliders Plugin -->
<script src="/js/nouislider.min.js"></script>
<!--  Google Maps Plugin    -->
<script src="https://maps.googleapis.com/maps/api/js"></script>
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

<script type="text/javascript">
//    var i = 0;
//
//    function check() {
//        var source = $($('.source-list')[i]).data("url");
//        $.ajax({
//            type: "GET",
//            url: "webChannel/checkSource.do?sourceUri=" + source,
//            success: function (data) {
//                var result = JSON.parse(data);
//                console.log(result);
//                if (result.code === 200) {
//                    $("td[link='" + result.data + "']").html("有效");
//                } else {
//                    $("td[link='" + result.data + "']").html("失效");
//                }
//                i ++;
//                check();
//            },
//            error: function () {
//                i ++;
//                $("td[link='" + source + "']").html("检测失败");
//                check();
//            }
//        });
//    }
    
    $(document).ready(function() {

        var page = "${content}";
        if ( page === 'pages/checkChannel.jsp') {
            // 毛都不用干
        }

        if ( page === 'pages/livingChannel.jsp' ) {
            $('#datatables').DataTable({
                pageLength: 20,
                lengthChange: false,
                info: false,
                ordering: false,
                autoWidth: true,
                "language": {
                    "paginate": {
                        "previous": "上一页",
                        "last": "最后一页",
                        "next": "下一页"
                    },
                    "search": "检索频道："
                },
                "search": {
                    "caseInsensitive": false
                }
            });

            var table = $('#datatables').DataTable();

            $('.card .material-datatables label').addClass('form-group');

            // Add channel
            $('.btn-add-channel').on('click', function () {
                // Add new channel
                swal.queue([{
                    title: '请输入频道名称',
                    html:
                    '<div class="form-group">' +
                    '<input id="input-field" type="text" class="form-control" />' +
                    '</div>',
                    confirmButtonClass: 'btn btn-success',
                    confirmButtonText: '确认添加',
                    buttonsStyling: false,
                    showLoaderOnConfirm: true,
                    preConfirm: function () {
                        return new Promise(function (resolve) {
                            var value = $('#input-field').val();
                            if (value && value.trim()) {
                                $.ajax(
                                    {
                                        type: "POST",
                                        url: "/webChannel/addChannel/" + value,
                                        contentType: "application/json; charset=utf-8",
                                        success: function (data) {
                                            var result = data;
                                            if (result.code === 200) {
                                                swal.insertQueueStep("添加成功 !");
                                                window.location.reload();
                                            } else {
                                                swal.insertQueueStep("添加失败！");
                                            }
                                            resolve()
                                        },
                                        error: function () {
                                            swal.insertQueueStep("添加失败！");
                                            resolve()
                                        }
                                    }
                                );
                            } else {
                                swal.insertQueueStep("不能添加空字符串！");
                                resolve()
                            }
                        });
                    }
                }])
            });
        }
    });
</script>
</html>