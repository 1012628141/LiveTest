<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card-header card-header-text" data-background-color="rose">
                <h4 class="card-title">客户端坏死源汇报</h4>
            </div>
            <div class="card-content">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th class="text-center">#</th>
                            <th>源地址</th>
                            <th class="text-right">来源</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty deathList}">
                            <c:forEach items="${ deathList }" var="channel" varStatus="loop">
                                <tr data-sid="${loop.index}" data-id="${channel.channelId}">
                                    <td class="text-center">${channel.channelName}</td>
                                    <td>
                                        <a href="${ channel.deathSource }" style="display: block; width: 500px; word-wrap: break-word; word-break: normal;">
                                                ${ channel.deathSource }
                                        </a>
                                    </td>
                                    <td class="text-right source-list">
                                        客户端反馈
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>