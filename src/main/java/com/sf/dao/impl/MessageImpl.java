package com.sf.dao.impl;

import com.sf.dao.MessageDao;
import com.sf.tool.Data_jdbcTemplate;
import com.sf.entity.messageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageImpl implements MessageDao {
	
	@Autowired
	Data_jdbcTemplate jdbcTemplate;//得到模板
	
	
	public int message(messageEntity message) {
		System.out.println("1111111");
		String sql="insert into message(messageID,messagevideoID," + "messageuserID,messageuserName,message," + "messageTime) values(?,?,?,?,?,?)";
		int num = jdbcTemplate.getJdbcTemplate().update(sql, new Object[]{message.getMessageID(),
					message.getMessagevideoID(),message.getMessageuserID()
					,message.getMessageuserName(),
					message.getMessage(),message.getMessageTime()});
		return num;
	}
}
