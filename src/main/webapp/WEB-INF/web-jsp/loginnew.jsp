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
<title>WuliWuli-登录</title>
<script src="<%=request.getContextPath()%>/static/Homepage/js/jquery.min.js"></script>

</head>

<body style="background-color:rgba(100,175,255,0.6)" >

<%--标志物--%>
<div class="page-width"
	 style="background-color:rgba(60,100,255,0);">
	<a style="font-size: 90px;width: 300px">WuliWuli</a>
</div>

<%--以上为标志物--%>
<article class="htmleaf-container">
		<header class="htmleaf-header">
		</header>

		<div class="panel-lite">

		  <div class="thumbur">
		    <div class="icon-lock">
			</div>
		  </div>

		  <form action="loginservice.sf" method="post" style="height: 800px">
		  <h4 style="font-size: 80px;height: 50px;width: 800px;left: 550px;position: absolute;top: 50px;color: #00A1D6">WuliWuli用户登录</h4>

		  <div class="form-group">
		    <input required="required" name="userName" id="userName" class="form-control" style="height: 50px;width: 300px;left: 700px;position: absolute;top: 300px;border-color: #00A1D6"/>
		    <label class="form-label"style="font-size: 30px;left: 600px;position: absolute;top: 300px;color: #00A1D6">用户名</label>
		  </div>

		  <div class="form-group">
		    <input type="password" name="passWord" id="passWord" required="required" class="form-control"style="height: 50px;width: 300px;left: 700px;position: absolute;top: 400px;border-color: #00A1D6"/>
		    <label class="form-label" style="font-size: 30px;left: 600px;position: absolute;top: 400px;color: #00A1D6">密码</label>
		  </div>

		  <div><%if(request.getAttribute("PHO")!=null){ %>
		 		<b style="color: red"><%= request.getAttribute("PHO") %></b>
		  <%} %>
		  </div>


			  <a style="font-size: 40px;left: 200px;position: absolute;top: 800px;color: white;background:#00A1D6;text-decoration:none;"href="zhuce.sf">立即注册 点这里 </a>
		  <br>
		    <a style="font-size: 40px;left: 1200px;position: absolute;top: 800px;color: #00A1D6;color: white;background:#00A1D6;text-decoration:none;"href="logoone.sf">返回首页  点这里</a>
		  <button class="floating-btn" id="tijiao" style="width: 300px;height: 100px;background: #00A1D6;border-radius: 4px;border: 1px solid #00a1d6;font-size: 30px;color: white;left: 700px;position: absolute;top: 500px"> 登录<i class="icon-arrow"></i></button>
		</div>
		</form>
	</article>
</body>



</html>