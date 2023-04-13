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
	<title>哔哩哔哩-注册</title>


	<%--<link href="<%=request.getContextPath()%>/static/register/css/jq22.css"
        rel="stylesheet" type="text/css" />--%>
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script language='javascript'
			src="<%=request.getContextPath()%>/static/register/js/jq22.js"></script>
</head>
<body style="background-color: rgba(100,175,255,0.6)">
<%--标志物--%>
<div class="page-width"
	 style="background-color:rgba(60,100,255,0);">
	<a style="font-size: 90px;width: 300px">WuliWuli</a>
</div>

<%--以上为标志物--%>
<div class='body_main'>
	<!-- start main content -->
	<div class='index_box' style='margin-top: 20px;'>
		<div
				style="position: fixed; color: red; margin: 70px 0 0 450px; font-size: 16px; Z-index: 100; display: block;"
				id="hint"></div>
		<div class='box_title'>
			<div class='text_content'></div>
		</div>

		<!-- 注册From 表单 -->
		<a class="center_in_self"
		   style="
			   color: #00A1D6;font-size: 80px;margin-left: 500px;
/*			   font-size: 100px;left: 600px;position: absolute;top: 50px;border-radius: 4px;
					   border: 1px solid #00a1d6;color: white;background:#00A1D6;text-decoration:none;*/
">
			欢迎注册WuliWuli！
		</a>
		<div class='box_main'>
			<div id="register" class="register">
				<%--以下为用户对象的表单--%>
				<form id="form" action="register.sf" method="post"
					  onSubmit="return check();">
					<div id="form_submit" class="form_submit">
						<div class="fieldset">
							<div class="field-group">
								<label class="required title"style="font-size: 30px;left: 600px;position: absolute;top: 300px;color: #00A1D6">账号</label> <span
									class="control-group" id="email_input">
										<div class="input_add_long_background">
											<input class="register_input" type="text" id=""
												   name="userName" maxLength="50" onblur=""style="height: 50px;width: 300px;left: 700px;position: absolute;top: 300px;border-color: #00A1D6">
										</div>
							</div>


							<div class="field-group">
								<label class="required title"style="font-size: 30px;left: 600px;position: absolute;top: 400px;color: #00A1D6">密码</label> <span
									class="control-group" id="password1_input">
										<div class="input_add_long_background">
											<input class="register_input" type="passWord"  id="password1" name="passWord" maxLength="20" onblur="checkPwd1(this.value);" style="height: 50px;width: 300px;left: 700px;position: absolute;top: 400px;border-color: #00A1D6" />
										</div>
							</div>

						</div>
					</div>
					<div id="" class="">
						<div class='div_submit_button'>
							<input id="submit" type="submit" value="注册"
								   class='button_button disabled'
								   style="width: 300px;height: 100px;background: #00A1D6;
									   border-radius: 4px;border: 1px solid #00a1d6;font-size: 30px;color: white;
									   left: 700px;position: absolute;top: 500px">

							<a href="login.sf"
							   style="font-size: 30px;right: 100px;position: absolute;top: 800px;
									   color: white;background:#00A1D6;text-decoration:none;border: 1px solid #00a1d6;border-radius: 4px;">返回登录界面</a>
						</div>
					</div>
				</form>
			</div>

			<script type="text/javascript">
				function __changeUserName(of){
					var username=$('#'+of).val();
					if(of=='email'){
						if (username.search(/^[\w\.+-]+@[\w\.+-]+$/) == -1) {
							showTooltips('email_input','请输入正确的Email地址');
							return;
						}
					}
					else{
						if(username=='' || !isMobilePhone(username)) {
							showTooltips('mobile_input','请输入正确的手机号码');
							return;
						}
					}
				}
			</script>
		</div>
		<div class='box_bottom'></div>
	</div>
</div>


</body>
</html>