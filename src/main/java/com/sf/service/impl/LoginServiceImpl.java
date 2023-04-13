package com.sf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.dao.impl.LoginDaoimpl;
import com.sf.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDaoimpl loginService;
	
	public boolean loginuser(String userName, String passWord) {
		int num=loginService.login(userName, passWord);
		if(num>0){
			return true;
		}
		return false;
	}

}
