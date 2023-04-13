package com.sf.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sf.dao.Update_login_password_Dao;
import com.sf.tool.Data_jdbcTemplate;
import com.sf.entity.userEntity;

@Component
public class Update_login_password_Impl implements Update_login_password_Dao {
	
	@Autowired
	Data_jdbcTemplate jdbcTemplate;
	
	public int Update_login_password(String userName, String passWord, String newpassWord) {
		int what=0;
		//先查询出用户名和密码是否匹配 才能更改密码
		String sql="select count(*) from user where userName=? and passWord=?";
		int num=jdbcTemplate.getJdbcTemplate().queryForObject(sql, new Object[]{userName,passWord},Integer.class);
		System.out.println(num);
			if(num>0){
				//UPDATE user set `newpassWord`="111" where userName="admin";
				//此用户存在  并且密码匹配 可以进行修改密码
				String update="update user set passWord=? where userName=?";
				what=jdbcTemplate.getJdbcTemplate().update(update,new Object[]{newpassWord,userName});
			}else{
				return what;
			}
		return what;
	}


	@Override
	public int Update_user(userEntity user) {

		
		String sql="update  user set userName = ? ,assWord = ? where userID = ?";
		int bl = jdbcTemplate.getJdbcTemplate().update(sql,new Object[]{user.getUserName(),user.getPassWord(),user.getUserID()});
		return bl;
	}




}
