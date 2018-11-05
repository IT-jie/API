<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<head>
	<title>Hello</title>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
</head>

<body>
	<h2>Welcome To API</h2>
	<hr>
	<ul>
		<li>
			<a href="${ctx}/api_list" target="_blank">接口目录</a>
		</li>
		<li>
			<a href="${ctx}/game_list" target="_blank">游戏目录</a>
		</li>
		<li>
			<a href="${ctx}/play_list" target="_blank">娱乐目录</a>
		</li>
		<li>
			<a href="${ctx}/note_list" target="_blank">个人笔记</a>
		</li>
	</ul>
	<hr>
	<div id="typewrite"></div>
</body>

<script src="${ctx}/pub/js/typewriter.js"></script>
<script>
 	var app = document.getElementById('typewrite');
	var typewriter = new Typewriter(app, {
  		loop: true
	});
	typewriter.typeString('哈喽，欢迎大家！')
		.pauseFor(2500)
	 	.deleteAll()
	 	.typeString('该说些什么呢？')
  		.pauseFor(2500)
		.typeString('让我好好想想..')
		.deleteAll()
		.typeString('有了！')
		.pauseFor(2500)
		.deleteAll()
		.typeString('其实，我挺帅的')
		.pauseFor(2500)
 		.deleteChars(3)
 	 	.typeString('很谦虚！')
 	 	.start();
</script>

</html>
