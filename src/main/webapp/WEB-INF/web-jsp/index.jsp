<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>唔哩唔哩 (゜-゜)つロ 干杯~</title>

	<link rel="stylesheet"
		  href="<%=request.getContextPath()%>/static/bilibiliIndex/css/reset.css">
	<link rel="stylesheet"
		  href="<%=request.getContextPath()%>/static/bilibiliIndex/css/common.css">
	<link rel="stylesheet"
		  href="<%=request.getContextPath()%>/static/bilibiliIndex/css/index.css">

	<script
			src="<%=request.getContextPath()%>/static/Homepage/js/jquery.min.js"></script>
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script
			src="<%=request.getContextPath()%>/static/wuliwuliIndex/js/script.js"></script>
</head>
<body style="background-color: rgba(60,200,255,0.5)">
<div id="page_top" style="background-color: rgba(60,100,255,0.5)">

	<div class="header-top">
		<div class="page-width clearfix">
			<div class="header-top__nav">
				<ul>

					<li class="item">
						<a href="videoFileTop;" style="font-size: 25px;position: relative">视频上传</a>

				</ul>
			</div>

			<div class="header-top__user">
				<%if (request.getSession().getAttribute("userName") == null) {%>
				<div class="login-box" align="left">
					<a href="login.sf" style="color: black;font-size: 25px" >登录</a>
					<span></span>
					<a href="zhuce.sf" style="color: black;font-size: 25px" >注册</a>
				</div>
				<%} else {%>
				<div onmouseover="project()" style="margin-top: 15px">
						<span style="color: black;font-size: 25px">
							欢迎你的登录: &nbsp; &nbsp; &nbsp;
							<%=request.getSession().getAttribute("userName") %>
						</span>
					&nbsp;&nbsp;&nbsp;
				</div>
				<%} %>
			</div>
			<div class="header-top__user"
				 style="position: fixed;  width: 200px; height: 130px;
					background-color: rgba(60,100,255,0.5); margin-left: 55%; margin-top: 3%;
					border-radius: 4px;border: 1px solid #00a1d6;"
				 id="div2">
				<div id="kawayi"
					 onmouseover="project()"
					 onmouseout="asjdh()" >
					<div
							style="width: 130px; height: 160px; background-color: rgba(0,0,0,0); position: fixed; margin-left: 14%">

						<div
								style="width: 90px; height: 90px; margin-top: -113px; margin-left: -110px">

						</div>
					</div>

				</div>
				<div class="center_header">
					<div align="center" style="margin-left: 60%">

					</div>
				</div>

				<div align="center" style="">
					<br>
					<div align="center"
						 style="color: white;position:relative;font-size: 15px">
								<span style="color: white;"> <b>用户<%=request.getSession().getAttribute("userName")%></b>
								</span>
					</div>
					<div style="background-color: rgba(60,100,255,0.5)">------------------------</div>

					<a href="Information.sf" style="color: white;position:relative;font-size: 15px;">查看个人信息</a>&nbsp;&nbsp;
					<a href="Update_login_password.sf"
					   style="color: white;position:relative;font-size: 15px">修改密码</a>&nbsp;&nbsp;

					<div style="background-color: rgba(60,100,255,0.5)">------------------------</div>
					<a href="exect.sf"
					   style="color: white;position:relative;font-size: 15px">切换用户</a>
				</div>


			</div>

		</div>

	</div>
</div>
</div>
</div>
<div class="header-c clearfix" style="background-color:rgba(60,100,255,0.5)">

	<div class="page-width"
		 style="background-color:rgba(60,100,255,0)">
		<a style="font-size: 90px;width: 300px">WuliWuli</a>

	</div>
</div>
</header>

<div id="main" style="background-color: rgba(60,100,255,0.5)" align="left">
	<div class="page-width" style="background-color: rgba(60,100,255,0.2);width:1400px">
		<!-- 推广 -->
		<!-- 舞蹈 -->
		<div class="mainCont clearfix" id="dance" js-move="true">
			<div class="pic-list fl" js-tab="true">
				<div class="pic-list__title">
					<h2 style="margin-left: 100px;font-size: 40px">动画</h2>
				</div>
				<ul class="pic-list__wrapper clearfix tab-cont__item tab-cont__cur"
					style="margin-left: 100px; width:1400px;height: 300px;background-color: rgba(0,0,0,0)">
					<!-- 这里开始遍历 -->
					<c:forEach items="${list}" var="list">
						<li class="item">
							<a href="video.sf?dizhi=${list.videoAddress}&shipingID=${list.videoID}"	class="img-link">
								<img src="<%=request.getContextPath()%>${list.videoImage}" alt="#">
								<span class="mask"></span>
								<span class="time">${list.videoTime}</span>
							</a>
							<div class="img-info" >
								<a href="video.sf?dizhi=${list.videoAddress}&shipingID=${list.videoID}">${list.videoName }</a>
								<div class="btm">

								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>

		</div>

		<!-- 游戏 -->
		<div class="mainCont clearfix" id="game" js-move="true"
			 style="position: relative; width: 1400px;height: 400px;background-color: rgba(60,100,255,0.4)">

			<h2 style="margin-left: 100px;font-size: 40px;margin-top: 25px;margin-bottom: 15px">游戏</h2>

			<ul class="pic-list__wrapper clearfix tab-cont__item tab-cont__cur"
				style="margin-left: 100px; width:1400px;height: 300px;background-color: rgba(0,0,0,0)">

				<c:forEach items="${list2}" var="list2">
					<li class="item"><a
							href="video.sf?dizhi=${list2.videoAddress}&shipingID=${list2.videoID}"
							class="img-link"> <img
							src="<%=request.getContextPath()%>${list2.videoImage}" alt="#">
						<span class="mask"></span> <span class="time">${list2.videoTime}</span>
					</a>
						<div class="img-info">
							<a
									href="video.sf?dizhi=${list2.videoAddress}&shipingID=${list2.videoID}">${list2.videoName}
							</a>
							<div class="btm">

							</div>
						</div></li>
				</c:forEach>
			</ul>
		</div>

		<!-- 科技 -->
		<div class="mainCont clearfix" id="technology" js-move="true"
			 style="width: 1400px;height: 400px;background-color: rgba(60,100,255,0.6)">
			<div class="pic-list fl" js-tab="true">

				<h2 style="margin-left: 100px;font-size: 40px;margin-top: 15px;margin-bottom: 15px">科技</h2>

				<ul class="pic-list__wrapper clearfix tab-cont__item tab-cont__cur"
					style="margin-left: 100px; width:1400px;height: 400px;background-color: rgba(0,0,0,0)">

					<c:forEach items="${list3}" var="list3">
						<li class="item" >
							<a href="video.sf?dizhi=${list3.videoAddress}&shipingID=${list3.videoID}"
							   class="img-link">
								<img src="<%=request.getContextPath()%>${list3.videoImage}" alt="#">
								<span class="mask"></span>
								<span class="time">${list3.videoTime}</span>
							</a>
							<div class="img-info" >
								<a href="video.sf?dizhi=${list3.videoAddress}&shipingID=${list3.videoID}">${list3.videoName }</a>
								<div class="btm">

								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
				<%--以上我改的--%>
			</div>
			<%--以上我改的--%>
			<div class="main-side fr" js-tab="true">

				<div class="main-side__cont">


					<!-- 这里是AJAX 提交 后台刷新数据 -->
					<script
							src="<%=request.getContextPath()%>/static/adminjs/adminjs.js">
					</script>
				</div>
			</div>
		</div>



	</div>
</div>
</body>
</html>