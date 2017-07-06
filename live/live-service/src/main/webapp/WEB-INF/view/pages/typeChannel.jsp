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
                <h4 class="card-title">全部Map</h4>
                <div class="material-datatables">
                    <table id="datatables" class="table table-striped table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                        <thead>
                        <tr role="row">
                            <th style="text-align: center">ID</th>
                            <th style="text-align: center">语音识别结果</th>
                            <th style="text-align: center">对应频道</th>
                            <th style="text-align: center">创建日期</th>
                            <th style="text-align: center">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty routerMaps}">
                            <c:forEach var="channel" items="${routerMaps}" varStatus="loop">
                                <tr role="row" class="${loop.index % 2 == 0 ? "odd": "even"}">
                                    <td style="text-align: center">${channel.id}</td>
                                    <td style="text-align: center">${channel.key}</td>
                                    <td style="text-align: center">${channel.value}</td>
                                    <td style="text-align: center">未设置</td>
                                    <td style="text-align: center">
                                        <a class="btn btn-simple btn-warning btn-icon edit">
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
                <button class="btn btn-info btn-add-channel">新增Map</button>
            </div>
        </div>
        <!--  end card  -->
    </div>
    <!-- end col-md-12 -->
</div>