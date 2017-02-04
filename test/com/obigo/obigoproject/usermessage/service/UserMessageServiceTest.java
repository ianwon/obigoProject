package com.obigo.obigoproject.usermessage.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.user.usermessage.service.UserMessageService;
import com.obigo.obigoproject.user.usermessage.vo.UserMessageVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class UserMessageServiceTest {
	@Autowired
	UserMessageService usermessageservice;

	@Test
	public void insertUserMessageTest() {
		UserMessageVO vo = new UserMessageVO();
		vo.setUserId("agaagaga12as");
		vo.setMessageNumber(2);

		Assert.assertTrue( usermessageservice.insertUserMessage(vo));
	}
	
	@Test
	public void updateUserMessageTest(){
		UserMessageVO vo = new UserMessageVO();
		vo.setUserMessageNumber(8);
		
		Assert.assertTrue(usermessageservice.updateUserMessage(vo));
		
	}
	@Test
	public void deleteUserMessageTest(){
		Assert.assertTrue(usermessageservice.deleteUserMessage(8));
	}
	
	@Test
	public void getUserMessageList(){
		System.out.println(usermessageservice.getUserMessageList("agaagaga12as"));
	}
}
