package com.obigo.obigoproject.usermessage.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.vo.UserMessageVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class UserMessageDaoTest {
	@Autowired
	UserMessageDao usermessagedao;

	@Test
	public void insertUserMessageTest() {
		UserMessageVO vo = new UserMessageVO();
		vo.setPath("gggg");
		vo.setUserId("asdf");
		vo.setMessageNumber(2);

		Assert.assertEquals(1, usermessagedao.insertUserMessage(vo));
	}

	@Test
	public void updateUserMessageTest() {
		UserMessageVO vo = new UserMessageVO();
		vo.setUserMessageNumber(2);
		vo.setPath("gjgjgjgj");

		Assert.assertEquals(1, usermessagedao.updateUserMessage(vo));
	}
	
	@Test
	public void deleteUserMessageTest(){
		Assert.assertEquals(1, usermessagedao.deleteUserMessage(2));
	}
	
	@Test
	public void getUserMessageByUserIdTest(){
		System.out.println(usermessagedao.getUserMessageListByUserId("asdf"));
	}
}
