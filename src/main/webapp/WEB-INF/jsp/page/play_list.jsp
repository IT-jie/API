<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<head>
	<title>娱乐目录</title>
	   
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
	<h2>娱乐目录</h2>
	<ul>
		<li>
			<a href="${ctx}/play/jisuanqi/index.html" target="_blank">计算器</a>
		</li>
		<li>
			<a href="${ctx}/play/jishiqi/index.html" target="_blank">计时器</a>
		</li>
		<li>
			<a href="${ctx}/play/dazhuanpan/index.html" target="_blank">幸运大转盘</a>
		</li>
		<li>
			<a href="${ctx}/play/food/index.html" target="_blank">今天吃什么</a>
		</li>
		<li>
			<a href="${ctx}/werewolf/start" target="_blank">狼人杀</a>
		</li>
		<li>
			<a href="${ctx}/play/love/index.html" target="_blank">LOVE 爱</a>
		</li>
	</ul>
</body>
</html>
