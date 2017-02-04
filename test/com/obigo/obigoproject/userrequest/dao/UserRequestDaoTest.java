package com.obigo.obigoproject.userrequest.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.user.userrequest.dao.UserRequestDao;
import com.obigo.obigoproject.user.userrequest.vo.UserRequestVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class UserRequestDaoTest {
@Autowired
UserRequestDao userrequestdao;
	@Test
	public void insertUserRequestTest(){
		UserRequestVO vo = new UserRequestVO();
		vo.setColor("gggg");
		vo.setLocation("zzzzz");
		vo.setModelCode("gggg");
		vo.setUserId("asdf");
		vo.setVin("gggg");
		
		Assert.assertEquals(1, userrequestdao.insertUserRequest(vo));
	}
	
	@Test
	public void updateUserRequestTest(){
		UserRequestVO vo = new UserRequestVO();
		vo.setUserRequestNumber(3);
		vo.setLocation("kkkkk");
		
		Assert.assertEquals(1, userrequestdao.updateUserRequest(vo));
	}
	
	@Test
	public void deleteUserRequestTest(){
		Assert.assertEquals(1, userrequestdao.deleteUserRequest(3));
	}
	
	@Test
	public void getUserRequestListTest(){
		System.out.println(userrequestdao.getUserRequestList().size());
	}
}
