<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jstl标签 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="<%=request.getContextPath()%>/static/User_Data_Update/js/jquery-1.8.3.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/User_Data_Update/js/index2.js"></script>
<script
	src="<%=request.getContextPath()%>/static/User_Data_Update/js/index2.js"></script>





<title>WuliWuli-个人信息</title>
</head>
<body style="background-color:rgba(100,175,255,0.6)" >
	<div class="top" id="wyqtb">
		<!--热门搜索-->
		<!--导航-->
		<div class="dao_hang" style="background-color: white;">
			<!--结束-->
			<div class="dao_list">
				<a href="logoone.sf" style="width: 300px;height: 100px;top:800px;background: #00A1D6;border-radius: 4px;border: 1px solid #00a1d6;font-size: 30px;color: white;top :500px;left: 700px;position: absolute;font-size: 40px;text-decoration:none;">点这里返回首页</a>

			</div>
		</div>
	</div>

	<!--当前位置-->
	<div class="now_positionm">

	</div>
	<!--centers-->
	<div class="centers_m">
		<!--清除浮动-->
		<div class="clear_sm"></div>
		<!--left-->
		<div class="centers_ml">
			<!--头像-->
			<div class="center_header">
					<em style="font-size: 50px;font-style: normal;font-family:楷体;top: 200px;left: 400px;position:absolute;color: #00A1D6">尊敬的WuliWuli用户您的个人信息如下:</em>
			</div>
			<!--列表go-->
			<div class="centers_listm">

				<span class="gjszmdm">
					<a href="Information.sf" class="center_in_self" style="font-size: 100px;left: 600px;position: absolute;top: 50px;border-radius: 4px;border: 1px solid #00a1d6;color: white;background:#00A1D6;text-decoration:none;"><font>信息资料界面</font></a>
				</span>
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

			<div class="public_m4">
				<p>
					<em style="font-size: 30px;left: 600px;position: absolute;top: 300px;color: #00A1D6;font-style: normal">用户ID</em> <input type="text" style="color: #00A1D6;font-size: 30px; height: 50px;width: 300px;left: 700px;position: absolute;top: 300px;border-color: #00A1D6" value="${user.userName}" onfocus=this.blur()>
				</p>
				<p>
					<em style="font-size: 30px;left: 600px;position: absolute;top: 400px;color: #00A1D6;font-style: normal">密码</em> <input type="text" style="color: #00A1D6;font-size: 30px; height: 50px;width: 300px;left: 700px;position: absolute;top: 400px;border-color: #00A1D6" value="${user.passWord}" onfocus=this.blur()>
				</p>
			</div>
		</div>
</body>
</html>