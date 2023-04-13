package com.sf.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sf.dao.LoginDao;
import com.sf.tool.Data_jdbcTemplate;

@Component
public class LoginDaoimpl implements LoginDao {

	@Autowired
	Data_jdbcTemplate jdbcTemplate;

	//这里是用于登录的sql语句：将来用mybatis代提

	public int login(String userName,String passWord) {

		String  sql="select count(*) from user where userName = ? and passWord = ?";
			int num=jdbcTemplate.getJdbcTemplate().queryForObject(sql, new Object[]{userName,passWord},Integer.class);
			return num;
	}

}
