<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>开始使用layui</title>
	<link rel="stylesheet" href="${ctx}/pub/plugins/layui/css/layui.css">
</head>

<body>

<!-- 你的HTML代码 -->

<script src="${ctx}/pub/plugins/layui/layui.js"></script>
<script>
	//一般直接写在一个js文件中
	layui.use( [ 'layer', 'form' ], function() {
		var layer = layui.layer, form = layui.form;
		layer.msg('Hello World');
	});
</script>

</body>
</html>
