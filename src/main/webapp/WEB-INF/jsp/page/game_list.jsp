<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<head>
	<title>游戏目录</title>
	   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h2>游戏目录</h2>
	<ul>
		<li>
			<a href="${ctx}/game/1/index.html" target="_blank">消消乐</a>
		</li>
		<li>
			<a href="${ctx}/game/2/index.html" target="_blank">推箱子</a>
		</li>
		<li>
			<a href="${ctx}/game/3/index.html" target="_blank">贪吃蛇</a>
		</li>
		<li>
			<a href="${ctx}/game/4/index.html" target="_blank">打砖块</a>
		</li>
		<li>
			<a href="${ctx}/game/5/index.html" target="_blank">天天爱消除</a>
		</li>
		<li>
			<a href="${ctx}/game/6/index.html" target="_blank">俄罗斯方块</a>
		</li>
		<li>
			<a href="${ctx}/game/7/index.html" target="_blank">2048</a>
		</li>
		<li>
			<a href="${ctx}/game/8/index.html" target="_blank">13点扑克牌</a>
		</li>
		<li>
			<a href="${ctx}/game/9/index.html" target="_blank">扫雷</a>
		</li>
		<li>
			<a href="${ctx}/game/10/index.html" target="_blank">压扁小鸟</a>
		</li>
		<li>
			<a href="${ctx}/game/11/index.html" target="_blank">驴子跳</a>
		</li>
	</ul>
</body>
</html>
