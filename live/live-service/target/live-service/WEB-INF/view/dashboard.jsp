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
    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="/css/demo.css" rel="stylesheet" />
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
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group form-search is-empty">
                                <input type="text" class="form-control" placeholder="搜索频道">
                                <span class="material-input"></span>
                            </div>
                            <button type="submit" class="btn btn-white btn-round btn-just-icon">
                                <i class="material-icons">search</i>
                                <div class="ripple-container"></div>
                            </button>
                        </form>
                    </div>
                </div>
            </nav>
            <div class="content">
                <div class="container-fluid">
                    <%--动态载入界面--%>
                    <jsp:include page="${content}" flush="true" />
                    <!--<div class="row">-->
                        <!--<div class="col-md-4">-->
                            <!--<div class="card card-chart">-->
                                <!--<div class="card-header" data-background-color="rose" data-header-animation="true">-->
                                    <!--<div class="ct-chart" id="websiteViewsChart"></div>-->
                                <!--</div>-->
                                <!--<div class="card-content">-->
                                    <!--<div class="card-actions">-->
                                        <!--<button type="button" class="btn btn-danger btn-simple fix-broken-card">-->
                                            <!--<i class="material-icons">build</i>-->
                                        <!--</button>-->
                                        <!--<button type="button" class="btn btn-info btn-simple" rel="tooltip" data-placement="bottom" title="Refresh">-->
                                            <!--<i class="material-icons">refresh</i>-->
                                        <!--</button>-->
                                        <!--<button type="button" class="btn btn-default btn-simple" rel="tooltip" data-placement="bottom" title="Change Date">-->
                                            <!--<i class="material-icons">edit</i>-->
                                        <!--</button>-->
                                    <!--</div>-->
                                    <!--<h4 class="card-title">用户日活</h4>-->
                                    <!--<p class="category">当前周每天用户在线人数</p>-->
                                <!--</div>-->
                                <!--<div class="card-footer">-->
                                    <!--<div class="stats">-->
                                        <!--<i class="material-icons">access_time</i> 2分钟前更新-->
                                    <!--</div>-->
                                <!--</div>-->
                            <!--</div>-->
                        <!--</div>-->
                        <!--<div class="col-md-4">-->
                            <!--<div class="card card-chart">-->
                                <!--<div class="card-header" data-background-color="green" data-header-animation="true">-->
                                    <!--<div class="ct-chart" id="dailySalesChart"></div>-->
                                <!--</div>-->
                                <!--<div class="card-content">-->
                                    <!--<div class="card-actions">-->
                                        <!--<button type="button" class="btn btn-danger btn-simple fix-broken-card">-->
                                            <!--<i class="material-icons">build</i>-->
                                        <!--</button>-->
                                        <!--<button type="button" class="btn btn-info btn-simple" rel="tooltip" data-placement="bottom" title="Refresh">-->
                                            <!--<i class="material-icons">refresh</i>-->
                                        <!--</button>-->
                                        <!--<button type="button" class="btn btn-default btn-simple" rel="tooltip" data-placement="bottom" title="Change Date">-->
                                            <!--<i class="material-icons">edit</i>-->
                                        <!--</button>-->
                                    <!--</div>-->
                                    <!--<h4 class="card-title">商城销量</h4>-->
                                    <!--<p class="category">-->
                                        <!--<span class="text-success"><i class="fa fa-long-arrow-up"></i> 55% </span> 增幅</p>-->
                                <!--</div>-->
                                <!--<div class="card-footer">-->
                                    <!--<div class="stats">-->
                                        <!--<i class="material-icons">access_time</i> 刚刚更新-->
                                    <!--</div>-->
                                <!--</div>-->
                            <!--</div>-->
                        <!--</div>-->
                        <!--<div class="col-md-4">-->
                            <!--<div class="card card-chart">-->
                                <!--<div class="card-header" data-background-color="blue" data-header-animation="true">-->
                                    <!--<div class="ct-chart" id="completedTasksChart"></div>-->
                                <!--</div>-->
                                <!--<div class="card-content">-->
                                    <!--<div class="card-actions">-->
                                        <!--<button type="button" class="btn btn-danger btn-simple fix-broken-card">-->
                                            <!--<i class="material-icons">build</i>-->
                                        <!--</button>-->
                                        <!--<button type="button" class="btn btn-info btn-simple" rel="tooltip" data-placement="bottom" title="Refresh">-->
                                            <!--<i class="material-icons">refresh</i>-->
                                        <!--</button>-->
                                        <!--<button type="button" class="btn btn-default btn-simple" rel="tooltip" data-placement="bottom" title="Change Date">-->
                                            <!--<i class="material-icons">edit</i>-->
                                        <!--</button>-->
                                    <!--</div>-->
                                    <!--<h4 class="card-title">服务器访问次数（万次）</h4>-->
                                    <!--<p class="category">当前周每日服务器承载量</p>-->
                                <!--</div>-->
                                <!--<div class="card-footer">-->
                                    <!--<div class="stats">-->
                                        <!--<i class="material-icons">access_time</i> 1分钟前更新-->
                                    <!--</div>-->
                                <!--</div>-->
                            <!--</div>-->
                        <!--</div>-->
                    <!--</div>-->

                    <!--<div class="row">-->
                        <!--<div class="col-md-12">-->
                            <!--<div class="card">-->
                                <!--<div class="card-header card-header-icon" data-background-color="green">-->
                                    <!--<i class="material-icons">language</i>-->
                                <!--</div>-->
                                <!--<div class="card-content">-->
                                    <!--<h4 class="card-title">智慧城市用户分布图</h4>-->
                                    <!--<div class="row">-->
                                        <!--<div class="col-md-5">-->
                                            <!--<div class="table-responsive table-sales">-->
                                                <!--<table class="table">-->
                                                    <!--<tbody>-->
                                                        <!--<tr>-->
                                                            <!--<td>-->
                                                                <!--<div class="flag">-->
                                                                    <!--<img src="/img/flags/US.png">-->
                                                                <!--</div>-->
                                                            <!--</td>-->
                                                            <!--<td>美国</td>-->
                                                            <!--<td class="text-right">-->
                                                                <!--2.920-->
                                                            <!--</td>-->
                                                            <!--<td class="text-right">-->
                                                                <!--53.23%-->
                                                            <!--</td>-->
                                                        <!--</tr>-->
                                                        <!--<tr>-->
                                                            <!--<td>-->
                                                                <!--<div class="flag">-->
                                                                    <!--<img src="/img/flags/DE.png">-->
                                                                <!--</div>-->
                                                            <!--</td>-->
                                                            <!--<td>德国</td>-->
                                                            <!--<td class="text-right">-->
                                                                <!--1.300-->
                                                            <!--</td>-->
                                                            <!--<td class="text-right">-->
                                                                <!--20.43%-->
                                                            <!--</td>-->
                                                        <!--</tr>-->
                                                        <!--<tr>-->
                                                            <!--<td>-->
                                                                <!--<div class="flag">-->
                                                                    <!--<img src="/img/flags/AU.png">-->
                                                                <!--</div>-->
                                                            <!--</td>-->
                                                            <!--<td>澳大利亚</td>-->
                                                            <!--<td class="text-right">-->
                                                                <!--760-->
                                                            <!--</td>-->
                                                            <!--<td class="text-right">-->
                                                                <!--10.35%-->
                                                            <!--</td>-->
                                                        <!--</tr>-->
                                                        <!--<tr>-->
                                                            <!--<td>-->
                                                                <!--<div class="flag">-->
                                                                    <!--<img src="/img/flags/GB.png">-->
                                                                <!--</div>-->
                                                            <!--</td>-->
                                                            <!--<td>英国</td>-->
                                                            <!--<td class="text-right">-->
                                                                <!--690-->
                                                            <!--</td>-->
                                                            <!--<td class="text-right">-->
                                                                <!--7.87%-->
                                                            <!--</td>-->
                                                        <!--</tr>-->
                                                        <!--<tr>-->
                                                            <!--<td>-->
                                                                <!--<div class="flag">-->
                                                                    <!--<img src="/img/flags/RO.png">-->
                                                                <!--</div>-->
                                                            <!--</td>-->
                                                            <!--<td>罗马</td>-->
                                                            <!--<td class="text-right">-->
                                                                <!--600-->
                                                            <!--</td>-->
                                                            <!--<td class="text-right">-->
                                                                <!--5.94%-->
                                                            <!--</td>-->
                                                        <!--</tr>-->
                                                        <!--<tr>-->
                                                            <!--<td>-->
                                                                <!--<div class="flag">-->
                                                                    <!--<img src="/img/flags/BR.png">-->
                                                                <!--</div>-->
                                                            <!--</td>-->
                                                            <!--<td>以色列</td>-->
                                                            <!--<td class="text-right">-->
                                                                <!--550-->
                                                            <!--</td>-->
                                                            <!--<td class="text-right">-->
                                                                <!--4.34%-->
                                                            <!--</td>-->
                                                        <!--</tr>-->
                                                    <!--</tbody>-->
                                                <!--</table>-->
                                            <!--</div>-->
                                        <!--</div>-->
                                        <!--<div class="col-md-6 col-md-offset-1">-->
                                            <!--<div id="worldMap" class="map"></div>-->
                                        <!--</div>-->
                                    <!--</div>-->
                                <!--</div>-->
                            <!--</div>-->
                        <!--</div>-->
                    <!--</div>-->

                    <!--<h3>最热商品/服务</h3>-->
                    <!--<br>-->
                    <!--<div class="row">-->
                        <!--<div class="col-md-4">-->
                            <!--<div class="card card-product">-->
                                <!--<div class="card-image" data-header-animation="true">-->
                                    <!--<a href="#pablo">-->
                                        <!--<img class="img" src="/img/card-2.jpeg">-->
                                    <!--</a>-->
                                <!--</div>-->
                                <!--<div class="card-content">-->
                                    <!--<div class="card-actions">-->
                                        <!--<button type="button" class="btn btn-danger btn-simple fix-broken-card">-->
                                            <!--<i class="material-icons">build</i>-->
                                        <!--</button>-->
                                        <!--<button type="button" class="btn btn-default btn-simple" rel="tooltip" data-placement="bottom" title="View">-->
                                            <!--<i class="material-icons">art_track</i>-->
                                        <!--</button>-->
                                        <!--<button type="button" class="btn btn-success btn-simple" rel="tooltip" data-placement="bottom" title="Edit">-->
                                            <!--<i class="material-icons">edit</i>-->
                                        <!--</button>-->
                                        <!--<button type="button" class="btn btn-danger btn-simple" rel="tooltip" data-placement="bottom" title="Remove">-->
                                            <!--<i class="material-icons">close</i>-->
                                        <!--</button>-->
                                    <!--</div>-->
                                    <!--<h4 class="card-title">-->
                                        <!--<a href="#pablo">Cozy 5 Stars Apartment</a>-->
                                    <!--</h4>-->
                                    <!--<div class="card-description">-->
                                        <!--The place is close to Barceloneta Beach and bus stop just 2 min by walk and near to "Naviglio" where you can enjoy the main night life in Barcelona.-->
                                    <!--</div>-->
                                <!--</div>-->
                                <!--<div class="card-footer">-->
                                    <!--<div class="price">-->
                                        <!--<h4>$899/night</h4>-->
                                    <!--</div>-->
                                    <!--<div class="stats pull-right">-->
                                        <!--<p class="category"><i class="material-icons">place</i> Barcelona, Spain</p>-->
                                    <!--</div>-->
                                <!--</div>-->
                            <!--</div>-->
                        <!--</div>-->
                        <!--<div class="col-md-4">-->
                            <!--<div class="card card-product">-->
                                <!--<div class="card-image" data-header-animation="true">-->
                                    <!--<a href="#pablo">-->
                                        <!--<img class="img" src="/img/card-3.jpeg">-->
                                    <!--</a>-->
                                <!--</div>-->
                                <!--<div class="card-content">-->
                                    <!--<div class="card-actions">-->
                                        <!--<button type="button" class="btn btn-danger btn-simple fix-broken-card">-->
                                            <!--<i class="material-icons">build</i> Fix Header!-->
                                        <!--</button>-->
                                        <!--<button type="button" class="btn btn-default btn-simple" rel="tooltip" data-placement="bottom" title="View">-->
                                            <!--<i class="material-icons">art_track</i>-->
                                        <!--</button>-->
                                        <!--<button type="button" class="btn btn-success btn-simple" rel="tooltip" data-placement="bottom" title="Edit">-->
                                            <!--<i class="material-icons">edit</i>-->
                                        <!--</button>-->
                                        <!--<button type="button" class="btn btn-danger btn-simple" rel="tooltip" data-placement="bottom" title="Remove">-->
                                            <!--<i class="material-icons">close</i>-->
                                        <!--</button>-->
                                    <!--</div>-->
                                    <!--<h4 class="card-title">-->
                                        <!--<a href="#pablo">Office Studio</a>-->
                                    <!--</h4>-->
                                    <!--<div class="card-description">-->
                                        <!--The place is close to Metro Station and bus stop just 2 min by walk and near to "Naviglio" where you can enjoy the night life in London, UK.-->
                                    <!--</div>-->
                                <!--</div>-->
                                <!--<div class="card-footer">-->
                                    <!--<div class="price">-->
                                        <!--<h4>$1.119/night</h4>-->
                                    <!--</div>-->
                                    <!--<div class="stats pull-right">-->
                                        <!--<p class="category"><i class="material-icons">place</i> London, UK</p>-->
                                    <!--</div>-->
                                <!--</div>-->
                            <!--</div>-->
                        <!--</div>-->
                        <!--<div class="col-md-4">-->
                            <!--<div class="card card-product">-->
                                <!--<div class="card-image" data-header-animation="true">-->
                                    <!--<a href="#pablo">-->
                                        <!--<img class="img" src="/img/card-1.jpeg">-->
                                    <!--</a>-->
                                <!--</div>-->
                                <!--<div class="card-content">-->
                                    <!--<div class="card-actions">-->
                                        <!--<button type="button" class="btn btn-danger btn-simple fix-broken-card">-->
                                            <!--<i class="material-icons">build</i> Fix Header!-->
                                        <!--</button>-->
                                        <!--<button type="button" class="btn btn-default btn-simple" rel="tooltip" data-placement="bottom" title="View">-->
                                            <!--<i class="material-icons">art_track</i>-->
                                        <!--</button>-->
                                        <!--<button type="button" class="btn btn-success btn-simple" rel="tooltip" data-placement="bottom" title="Edit">-->
                                            <!--<i class="material-icons">edit</i>-->
                                        <!--</button>-->
                                        <!--<button type="button" class="btn btn-danger btn-simple" rel="tooltip" data-placement="bottom" title="Remove">-->
                                            <!--<i class="material-icons">close</i>-->
                                        <!--</button>-->
                                    <!--</div>-->
                                    <!--<h4 class="card-title">-->
                                        <!--<a href="#pablo">Beautiful Castle</a>-->
                                    <!--</h4>-->
                                    <!--<div class="card-description">-->
                                        <!--The place is close to Metro Station and bus stop just 2 min by walk and near to "Naviglio" where you can enjoy the main night life in Milan.-->
                                    <!--</div>-->
                                <!--</div>-->
                                <!--<div class="card-footer">-->
                                    <!--<div class="price">-->
                                        <!--<h4>$459/night</h4>-->
                                    <!--</div>-->
                                    <!--<div class="stats pull-right">-->
                                        <!--<p class="category"><i class="material-icons">place</i> Milan, Italy</p>-->
                                    <!--</div>-->
                                <!--</div>-->
                            <!--</div>-->
                        <!--</div>-->
                    <!--</div>-->
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
<!-- Material Dashboard DEMO methods, don't include it in your project! -->
<script src="/js/demo.js"></script>
<script type="text/javascript">
    $(document).ready(function() {

        // Javascript method's body can be found in assets/js/demos.js
        demo.initDashboardPageCharts();

        demo.initVectorMap();
    });
</script>

</html>