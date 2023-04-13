package com.sf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sf.dao.impl.Update_login_password_Impl;
import com.sf.entity.userEntity;
import com.sf.service.Update_login_password_Service;

@Component
public class Update_login_password_Service_Impl implements Update_login_password_Service {

		@Autowired
		Update_login_password_Impl update_login_password_Impl;
		
	public boolean Update_login_password(String userName, String passWord, String newpassWord) {
		int num=update_login_password_Impl.Update_login_password(userName, passWord, newpassWord);
		if(num>0){
			return true;
		}
		return false;
	}


	@Override
	public boolean Update_user(userEntity user) {
		int num = update_login_password_Impl.Update_user(user);
		if(num>0){
			return true;
		}
		return false;
	}

}
