<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
                        <c:if test="${not empty channelList}">
                            <c:forEach items="${ channelList }" var="channel">
                                <c:set value="${ fn:split(channel.source, '|') }" var="sources" />
                                <c:forEach items="${ sources }" var="s" varStatus="loop">
                                    <c:if test="${not empty s}">
                                        <tr data-sid="${loop.index}" data-id="${channel.id}">
                                            <td class="text-center">${channel.channel}</td>
                                            <td>
                                                <a href="${ s }" style="display: block; width: 500px; word-wrap: break-word; word-break: normal;">
                                                        ${ s }
                                                </a>
                                            </td>
                                            <td class="text-right source-list" data-url="${ s }" link="${ s }">
                                                检测中...
                                            </td>
                                            <td class="td-actions text-right">
                                                <button type="button" rel="tooltip" class="btn btn-danger btn-remove-source">
                                                    <i class="material-icons">close</i>
                                                </button>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>