<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>WebChat | 聊天记录</title>
    <jsp:include page="include/commonfile.jsp"/>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<div class="am-cf admin-main">
    <jsp:include page="include/sidebar.jsp"/>

    <!-- content start -->
    <div class="admin-content">
        <div class="am-cf am-padding">
            <div class="am-fl am-cf">
                <strong class="am-text-primary am-text-lg">聊天记录</strong> /
                <small>chat</small>
            </div>
        </div>
        <div class="am-cf am-padding">
            <div class="am-fl am-cf">
                <form class="am-form am-form-inline">
                    开始日期:&nbsp;
                    <div class="am-form-group am-form-icon">
                        <i class="am-icon-calendar"></i>
                        <input type="date" class="am-form-field">
                    </div>
                    结束日期:&nbsp;
                    <div class="am-form-group am-form-icon">
                        <i class="am-icon-calendar"></i>
                        <input type="date" class="am-form-field">
                    </div>
                    选择好友:&nbsp;
                    <div class="am-form-group">
                        <select multiple data-am-selected>
                            <c:forEach items="${toList}" var="to">
                                <option value="${to.to}">${to.to}</option>
                            </c:forEach>
                        </select>
                        <span class="am-form-caret"></span>
                    </div>
                    <button type="button" class="am-btn am-btn-default am-round">提交</button>
                </form>
            </div>
        </div>

        <div class="am-tabs am-margin">
            <!-- 聊天区 -->
            <div class="am-scrollable-vertical" id="chat-view" style="height: 510px;border:1px solid cadetblue;">
                <ul class="am-comments-list am-comments-list-flip" id="chat">
                </ul>
            </div>
            <div id="page" style="float: right"></div>
        </div>
    </div>
    <!-- content end -->
</div>
<a href="#" class="am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}">
    <span class="am-icon-btn am-icon-th-list"></span>
</a>
<jsp:include page="include/footer.jsp"/>
<script>
    $(function () {
        laypage({
            cont: 'page',
            pages: ${count},
            curr: function () {
                var page = location.search.match(/page=(\d+)/);
                return page ? page[1] : 1;
            }(),
            skin: '#AF0000',
            groups: 5, //连续显示分页数
            jump: function (e, first) { //触发分页后的回调
                if (!first) { //一定要加此判断，否则初始时会无限刷新
                    location.href = '?page=' + e.curr;
                }
            }
        });
    });

    <c:forEach items="${list}" var="l">
    showChat(${l.content});
    </c:forEach>

    /**
     * 过滤条件提交
     */
    $("button").click(function () {
        var check = $("select option").selected().text();
        alert(check);
    });

    /**
     * 展示会话信息
     */
    function showChat(message) {
        if (message == null) return;
        message = message.message;
        var to = message.to == null || message.to == "" ? "全体成员" : message.to;   //获取接收人
        var isSef = '${userid}' == message.from ? "am-comment-flip" : "";   //如果是自己则显示在右边,他人信息显示在左边
        var html = "<li class=\"am-comment " + isSef + " am-comment-primary\"><a href=\"#link-to-user-home\"><img width=\"48\" height=\"48\" class=\"am-comment-avatar\" alt=\"\" src=\"${ctx}/" + message.from + "/head\"></a><div class=\"am-comment-main\">\n" +
            "<header class=\"am-comment-hd\"><div class=\"am-comment-meta\">   <a class=\"am-comment-author\" href=\"#link-to-user\">" + message.from + "</a> 发表于<time> " + message.time + "</time> 发送给: " + to + " </div></header><div class=\"am-comment-bd\"> <p>" + message.content + "</p></div></div></li>";
        $("#chat").append(html);
        $("#message").val("");  //清空输入区
        var chat = $("#chat-view");
        chat.scrollTop(chat[0].scrollHeight);   //让聊天区始终滚动到最下面
    }
</script>
</body>
</html>
