<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
                            <th>频道名</th>
                            <th>源地址</th>
                            <th>清晰度</th>
                            <th>更新日期</th>
                            <th class="disabled-sorting text-right">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty channelList}">
                            <c:forEach var="channel" items="${channelList}" varStatus="loop">
                                <tr role="row" class="${loop.index % 2 == 0 ? "odd": "even"}">
                                    <td>${channel.channel}</td>
                                    <c:set value="${ fn:split(channel.source, '|') }" var="sources" />
                                    <td style="overflow-x: scroll">
                                        <div style="display: block; width: 70%; word-wrap: break-word; word-break: normal;">
                                            <c:forEach items="${ sources }" var="s">
                                                <a href="${s}" type="button" rel="tooltip" class="btn btn-info btn-simple" style="padding: 0; margin: 0; margin-top: 2px" data-original-title="" title="">
                                                    <i class="material-icons">flag</i>${ s } <br/>
                                                    <div class="ripple-container"></div></a>
                                            </c:forEach>
                                        </div>
                                    </td>
                                    <td>未设置</td>
                                    <td>未设置</td>
                                    <td class="text-right">
                                        <a href="#" class="btn btn-simple btn-info btn-icon refresh"><i class="material-icons">refresh</i></a>
                                        <a href="#" class="btn btn-simple btn-warning btn-icon edit"><i class="material-icons">edit</i></a>
                                        <a href="#" class="btn btn-simple btn-danger btn-icon remove"><i class="material-icons">close</i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- end content-->
        </div>
        <!--  end card  -->
    </div>
    <!-- end col-md-12 -->
</div>