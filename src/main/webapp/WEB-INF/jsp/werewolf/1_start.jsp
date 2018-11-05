<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<head>
	<title>狼人杀</title>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<script src="${ctx}/pub/plugins/jquery/jquery-2.2.3.min.js"></script>

<script type="text/javascript">
	function startGame(){
		// 判断是否是整数
		var reg = /^[0-9]+$/;
		
		var num_total = $("#num_total").val();
		var num_wolf = $("#num_wolf").val();
		var num_villager = $("#num_villager").val();
		if(reg.test(num_total) && reg.test(num_wolf) && reg.test(num_villager)){
			var num_skill = 0;
			$("[name='skill_role']:checked").each(function(){
				num_skill ++;
			});
			$("[name='skill_wolf']:checked").each(function(){
				num_skill ++;
			});
			
			if(Number(num_total) == (Number(num_wolf) + Number(num_villager) + Number(num_skill))){
				$("#listForm").attr("action", "${ctx}/werewolf/play");
				$("#listForm").submit();
			}else{
				alert("总人数与安排的人数不一致！");
			}
		}else{
			alert("人数必须是整数！");
		}
	}
</script>

</head>

<body>
	<div style="width: 60%;">
		<h1 style="text-align: center;">狼人杀游戏</h1>
		
		<form id="listForm" method="post">
			<h3>
				分配角色，总人数：<input id="num_total" name="num_total" value="9" style="width: 50px;" />
			</h3>
			<table width="100%" border="1" cellspacing="0">
				<tr>
					<td width="25%">
						<div>
							<div style="width: 50px; float: left;">狼人</div>
							<input id="num_wolf" name="num_wolf" value="3" style="width: 30px;" />
						</div>
					</td>
					<td width="25%">
						<div>
							<div style="width: 50px; float: left;">村民</div>
							<input id="num_villager" name="num_villager" value="3" style="width: 30px;" />
						</div>
						
					</td>
					<td width="25%">
						<div>
							<div style="width: 50px; float: left;">预言家</div>
							<input type="checkbox" name="skill_role" value="预言家" checked="checked" />
						</div>
					</td>
					<td width="25%">
						<div>
							<div style="width: 50px; float: left;">女巫</div>
							<input type="checkbox" name="skill_role" value="女巫" checked="checked" />
						</div>
					</td>
				</tr>
				<tr>
					<td width="25%">
						<div>
							<div style="width: 50px; float: left;">猎人</div>
							<input type="checkbox" name="skill_role" value="猎人" checked="checked" />
						</div>
					</td>
					<td width="25%">
						<div>
							<div style="width: 50px; float: left;">守卫</div>
							<input type="checkbox" name="skill_role" value="守卫" />
						</div>
					</td>
					<td width="25%">
						<div>
							<div style="width: 50px; float: left;">白痴</div>
							<input type="checkbox" name="skill_role" value="白痴" />
						</div>
					</td>
					<td width="25%">
						<div>
							<div style="width: 50px; float: left;">骑士</div>
							<input type="checkbox" name="skill_role" value="骑士" />
						</div>
					</td>
				</tr>
				<tr>
					<td width="25%">
						<div>
							<div style="width: 50px; float: left;">白狼王</div>
							<input type="checkbox" name="skill_wolf" value="白狼王" />
						</div>
					</td>
					<td width="25%">
						<div>
							<div style="width: 50px; float: left;">狼美人</div>
							<input type="checkbox" name="skill_wolf" value="狼美人" />
						</div>
					</td>
					<td width="25%"></td>
					<td width="25%"></td>
				</tr>
			</table>
			<div style="margin-top: 20px;"">
				游戏类型：
				<input type="radio" name="game_type" value="屠边局" checked="checked" />屠边局
				<input type="radio" name="game_type" value="屠城局" />屠城局
			</div>
		</form>
		
		<div style="text-align: center; margin-top: 20px;">
			<button onclick="startGame()">开始游戏</button>
		</div>
	</div>
</body>
</html>
