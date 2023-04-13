package com.sf.dao;

import com.sf.entity.messageEntity;


public interface MessageDao {
	/**
	 * 	直接保存用户留言信息到留言表
	 * @param message
	 * @return
	 */
	public int message(messageEntity message);


	
}
