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
                                <tr role="row" class="${loop.index % 2 == 0 ? "odd": "even"}">
                                    <td style="text-align: center">${channel.id}</td>
                                    <td style="text-align: center">${channel.channel}</td>
                                    <c:set value="${ fn:split(channel.source, '|') }" var="sources" />
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
            </div>
        </div>
        <!--  end card  -->
    </div>
    <!-- end col-md-12 -->
</div>