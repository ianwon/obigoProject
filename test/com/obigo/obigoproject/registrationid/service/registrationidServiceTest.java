package com.obigo.obigoproject.registrationid.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.registrationid.vo.RegistrationidVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class registrationidServiceTest {
	@Autowired
	RegistrationidService registrationidService;
	
	@Test
	public void insertRegistrationidTest(){
		RegistrationidVO vo = new RegistrationidVO();
		vo.setRegistrationId("12345678910");
		vo.setUserId("ssung");
		Assert.assertTrue(registrationidService.insertRegistrationid(vo));
	}
	
	@Test
	public void getRegistrationidListByuserIdTest(){
		System.out.println(registrationidService.getRegistrationidListByuserId("ssung"));
	}
	
	@Test
	public void getRegistrationidList(){
		System.out.println(registrationidService.getRegistrationidList());
	}
	
	@Test
	public void deleteRegistrationid(){
		System.out.println(registrationidService.deleteRegistrationid("12345678910"));
	}
}
