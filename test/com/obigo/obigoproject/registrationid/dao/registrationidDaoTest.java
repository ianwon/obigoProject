package com.obigo.obigoproject.registrationid.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.registrationid.vo.RegistrationidVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class registrationidDaoTest {
	
	@Autowired
	RegistrationidDao registrationidDao;

	@Test
	public void insertRegistrationidTest(){
		RegistrationidVO vo = new RegistrationidVO();
		vo.setRegistrationId("cKYJ_azyA3E:APA91bGI1uYegrQJYzecGS1ufQXAsKz2qzOam4BPGNCyGnt90x_pdJ-syEc-L7me5j4X35sQi_MoOesddy5GcHEHB7FO_T331BFA9XxR6i6wOm8qc_UhrfiVQl1AusfLuUpPhGWZNVXO");
		vo.setUserId("won");
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
