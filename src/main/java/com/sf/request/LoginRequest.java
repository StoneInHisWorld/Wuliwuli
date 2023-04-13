package com.sf.request;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sf.entity.userEntity;
import com.sf.service.impl.LoginServiceImpl;
import com.sf.service.impl.UserListServiceImpl;

@Controller
public class LoginRequest {
		
	@Autowired
	LoginServiceImpl loginServiceImpl;
	
	@Autowired
	UserListServiceImpl userListServiceImpl;
	
	@RequestMapping("loginservice.sf")
	public String web3(String userName,String passWord,HttpServletRequest request){
	 boolean bl=	loginServiceImpl.loginuser(userName, passWord);
	 if(bl){
		 //将用户的全部信息查询出来
		 userEntity list = userListServiceImpl.userlist(userName);
		 		//request.setAttribute("userlist", list);
		 //成功
		 	//将用户ID放到session里面
		 	request.getSession().setAttribute("userID", list.getUserID());
		 	request.getSession().setAttribute("userName", userName);
		/* 	request.getSession().setAttribute("userHand", list.getUserHand());*/
		 	String mamaipi = "logoone.sf";
		 	
		 	if(request.getSession().getAttribute("jiequ")!=null){
		 		
		 		//说明这个地址是用户想访问的地址 但是没用登录
		 		String ceshidizhi=(String) request.getSession().getAttribute("jiequ");
		 		//重置为空
		 		String jiequ = "";
		 		request.getSession().setAttribute("jiequ", jiequ);
		 		
		 		//赋值
		 		mamaipi = ceshidizhi;
		 		
		 	}
		 	
		 	return "redirect:/"+mamaipi;
	 }else{
		 //失败
		 request.setAttribute("PHO", "用户名或密码错误!");
		 
	 }
		
		return "loginnew";
	}

}
