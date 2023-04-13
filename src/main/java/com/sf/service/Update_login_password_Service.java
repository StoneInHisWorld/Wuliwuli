package com.sf.service;

import com.sf.entity.userEntity;

public interface Update_login_password_Service {
	
	public boolean Update_login_password(String userName,String passWord,String newpassWord);
	public boolean Update_user(userEntity user);
}
