package com.obigo.obigoproject.registrationid.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.vo.RegistrationidVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class registrationidDaoTest {
	
	@Autowired
	RegistrationidDao registrationidDao;

	@Test
	public void insertRegistrationidTest(){
		RegistrationidVO vo = new RegistrationidVO();
		vo.setRegistrationId("123456789");
		vo.setUserId("ssung");
		Assert.assertEquals(1, registrationidDao.insertRegistrationid(vo));
	}
	
	@Test
	public void getRegistrationidListByuserIdTest(){
		System.out.println(registrationidDao.getRegistrationidListByuserId("ssung"));
	}
	
	@Test
	public void getRegistrationidListTest(){
		System.out.println(registrationidDao.getRegistrationidList());
	}
	
	@Test
	public void deleteRegistrationidTest(){
		Assert.assertEquals(1, registrationidDao.deleteRegistrationid("123456789"));
	}
}
