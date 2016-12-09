package com.obigo.obigoproject.userrequest.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.vo.UserRequestVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class UserRequestServiceTest {
	@Autowired
	UserRequestService userrequestservice;

	@Test
	public void insertUserRequestTest() {
		UserRequestVO vo = new UserRequestVO();
		vo.setUserId("superwyh");
		vo.setModelCode("gggg");
		vo.setColor("red");
		vo.setLocation("korea");
		vo.setVin("vin123123123");
		Assert.assertTrue(userrequestservice.insertUserRequest(vo));
	}

	@Test
	public void updateUserRequestTest() {
		UserRequestVO vo = new UserRequestVO();
		vo.setUserRequestNumber(8);
		vo.setLocation("japan");

		Assert.assertTrue(userrequestservice.updateUserRequest(vo));
	}

	@Test
	public void deleteUserRequestTest() {
		Assert.assertTrue(userrequestservice.deleteUserRequest(8));
	}

	@Test
	public void getUserRequestListTest() {
		System.out.println(userrequestservice.getUserRequestList());
	}
}
