package com.sf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.dao.impl.MessageImpl;

import com.sf.entity.messageEntity;
import com.sf.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	MessageImpl messageImpl;
	
	public boolean message(messageEntity message) {
		int bl = messageImpl.message(message);
			if(bl>0){
				return true;
			}
		return false;
	}
}
