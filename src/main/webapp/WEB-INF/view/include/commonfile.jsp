<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="shortcut icon" href="${ctx}/upload/favicon.ico"/>
<link rel="stylesheet" href="${ctx}/static/plugins/amaze/css/amazeui.min.css">
<link rel="stylesheet" href="${ctx}/static/plugins/amaze/css/admin.css">
<link rel="stylesheet" href="${ctx}/static/plugins/contextjs/css/context.standalone.css">
<script src="${ctx}/static/plugins/jquery/jquery-2.1.4.min.js"></script>
<script src="${ctx}/static/plugins/amaze/js/amazeui.min.js"></script>
<script src="${ctx}/static/plugins/amaze/js/app.js"></script>
<script src="${ctx}/static/plugins/layer/layer.js"></script>
<script src="${ctx}/static/plugins/laypage/laypage.js"></script>
<script src="${ctx}/static/plugins/contextjs/js/context.js"></script>
<script>
    var oldTitle = document.title, timeOut;
    document.onvisibilitychange = function () {
        if (document.hidden) {
            document.title = "还没完呢,别跑啊!";
            clearTimeout(timeOut);
        } else {
            document.title = "_φ(❐_❐✧ 这就对了嘛!";
            timeOut = setTimeout(function () {
                document.title = oldTitle;
            }, 2000);
        }
    }
</script>