package com.sf.request;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sf.entity.userEntity;
import com.sf.service.impl.RegisterServiceImpl;
import com.sf.tool.GetUUID;

@Controller//控制器用于接收用户请求
public class RegisterRequest {
	@Autowired
	RegisterServiceImpl registerService;

	@RequestMapping("register.sf")
//	public String web3(userEntity user, HttpServletRequest request, String yanzheng) {
	public String web3(userEntity user, HttpServletRequest request, HttpServletResponse response) {
		user.setUserID(GetUUID.getUUID());
		String userNmae = "^[a-zA-Z]\\w{5,17}$";
		Pattern regexuserNmae = Pattern.compile(userNmae);
		Matcher matcheruserName = regexuserNmae.matcher(user.getUserName());
		boolean username = matcheruserName.matches();
		username = true;
		boolean bl = registerService.RegisterService(user);
		if (bl) {
			// 这里是注册成功
			request.getServletContext().setAttribute("getUserName", user.getUserName());
			try {
				System.out.println(request.getContextPath());
				response.sendRedirect(request.getContextPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {//对于ifbl
			request.setAttribute("fail", "注册失败,此用户已经被注册");
			return "forward:/zhuce.sf";
		}

		return "forward:/zhuce.sf";
	}

	@RequestMapping("zhuce.sf")
	public String zhuce(HttpServletRequest request) {
		// 随机生成一个4位数验证码
		int num = GetUUID.yanzma();
		// 将int 转换为 String
		String yanzheng = "";
		yanzheng = String.valueOf(num);
		// 将验证码放入到session里面....暂时想不到其他办法
		request.getSession().setAttribute("yanzhengma", yanzheng);
		return "zhuce";
	}
}

