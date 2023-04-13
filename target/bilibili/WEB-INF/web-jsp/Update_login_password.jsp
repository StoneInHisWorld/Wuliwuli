<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%--<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/User_Data_Update/css/jiazaitoubu.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/User_Data_Update/css/css.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/User_Data_Update/css/center.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/User_Data_Update/city/city.css"
	type="text/css" />--%>

<!-- <script src="<%=request.getContextPath()%>/static/User_Data_Update/"></script> -->
<script
	src="<%=request.getContextPath()%>/static/User_Data_Update/js/jquery-1.8.3.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/User_Data_Update/js/index2.js"></script>
<script
	src="<%=request.getContextPath()%>/static/User_Data_Update/js/index2.js"></script>





<title>WuliWuli-密码修改</title>
</head>
<body style="background-color:rgba(100,175,255,0.6)" >

<%--标志物--%>
<div class="page-width"
	 style="background-color:rgba(60,100,255,0);">
	<a style="font-size: 90px;width: 300px">WuliWuli</a>
</div>

<%--以上为标志物--%>
	<div class="top" id="wyqtb">
	</div>
	<script>
window.onload=function(){
	$(".aside").css({display:"none"})
	$(".important").mouseenter(function(){
		$(".aside").css({display:"block"})
		}).mouseleave(function(){
			$(".aside").css({display:"none"})
			})
	}
</script>
	<!--当前位置-->
	<div class="now_positionm">
		<a  class="center_in_self" style="font-size: 100px;left: 600px;position: absolute;top: 50px;border-radius: 4px;border: 1px solid #00a1d6;color: white;background:#00A1D6;text-decoration:none;"><font>修改密码界面</font></a>
		<%--<span>当前位置：</span>--%>
		<a href="index.sf" style="width: 300px;height: 100px;background: #00A1D6;border-radius: 4px;border: 1px solid #00a1d6;font-size: 30px;color: white;left: 400px;position: absolute;top: 600px;text-decoration:none;">点这里返回首页</a>
		<a href="Information.sf" style="width: 300px;height: 100px;background: #00A1D6;border-radius: 4px;border: 1px solid #00a1d6;font-size: 30px;color: white;left: 1100px;position: absolute;top: 600px;text-decoration:none;">点这里查看个人信息</a>
	</div>
	<!--centers-->
	<div class="centers_m">
		<!--清除浮动-->
		<div class="clear_sm"></div>
		<!--left-->
		<div class="centers_ml">
			<!--头像-->
			<div class="center_header">
			</div>
			<!--列表go-->
			<div class="centers_listm">
				<div class="centers_listm_one">

				</div>


			</div>
			<script type="text/javascript">
		$(function(){//第一步都得写这个
			$(".centers_listm_one_in").click(function(){
			$(this).next(".gjszmdm").slideToggle().siblings("gjszmdm").slideUp()
			});
		})
		</script>
		</div>

		<!--一条开始-->
		<div class="public_m1">
			<form action="Update_login_password.sf" method="post">
				<div class="public_m4">
					<p>
						<em style="font-size: 30px;left: 600px;position: absolute;top: 300px;color: #00A1D6;font-style: normal">原密码</em> <input type="text" name="passWord"
							style="height: 50px;width: 300px;left: 750px;position: absolute;top: 300px;border-color: #00A1D6">
					</p>
					<p>
						<em style="font-size: 30px;left: 600px;position: absolute;top: 400px;color: #00A1D6;font-style: normal">新密码</em> <input type="text" name="newpassWord"
							style="height: 50px;width: 300px;left: 750px;position: absolute;top: 400px;border-color: #00A1D6">
					</p>
					<p>
						<em style="font-size: 30px;left: 600px;position: absolute;top: 500px;color: #00A1D6;font-style: normal">确认密码</em> <input type="text" name="newpassWord2"
							style="height: 50px;width: 300px;left: 750px;position: absolute;top: 500px;border-color: #00A1D6">
					</p>

					<%if(request.getAttribute("PassWordErro")!=null){ %>
					<!-- <a href="#" class="public_m3">确认修改</a> -->
					<p>
						<span style="color: blue"><%=request.getAttribute("PassWordErro") %></span>
					</p>
					<%} %>
					<input href="logoone.sf" class="public_m3" type="submit" value="确认修改"
						   style="width: 300px;height: 100px;background: #00A1D6;border-radius: 4px;border: 1px solid #00a1d6;font-size: 30px;color: white;left: 750px;position: absolute;top: 600px"	>
				</div>
			</form>
		</div>
</body>
</html>