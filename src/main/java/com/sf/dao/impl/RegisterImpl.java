package com.sf.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sf.dao.RegisterDao;
import com.sf.tool.Data_jdbcTemplate;
import com.sf.entity.userEntity;

@Component
public class RegisterImpl implements RegisterDao {

	@Autowired
	Data_jdbcTemplate jdbcTemplate;
	
	
	
	public int Register(userEntity user) {
		//默认为0
		int register=0;
		String sql = "SELECT count(*) FROM user WHERE userName = ?";  //这里的name就相当于ID
		int num=jdbcTemplate.getJdbcTemplate().queryForObject(sql, new Object[] {user.getUserName()},Integer.class);
			if(num>0){
				System.out.println("此用户被注册");
			}else{
				/*String chaxunSql="insert into user(" + "userID,userName,passWord) " + "values(?,?,?)";*/
				String chaxunSql="insert into user(" + "userName,passWord) " + "values(?,?)";
				register=jdbcTemplate.getJdbcTemplate().update(chaxunSql, new Object[]{user.getUserName(),user.getPassWord(),});
				
			}
		return register;
	}

}
