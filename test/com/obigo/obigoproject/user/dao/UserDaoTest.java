package com.obigo.obigoproject.user.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.user.user.dao.UserDao;
import com.obigo.obigoproject.user.user.vo.UsersVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class UserDaoTest {

	@Autowired
	UserDao userdao;

	@Test
	public void insertUserTest() {
		UsersVO vo = new UsersVO();
		vo.seteMail("aaaaa");
		vo.setName("zzzz");
		vo.setPassword("1234");
		vo.setPhone("asdf");
		vo.setRoleName("zzzzzzzzz");
		vo.setUserId("YUN");

		Assert.assertEquals(1, userdao.insertUser(vo));
	}

	@Test
	public void updateUserTest() {
		UsersVO vo = new UsersVO();
		vo.seteMail("aaaaa");
		vo.setName("zzzz");
		vo.setPassword("1234");
		vo.setPhone("456789");
		vo.setRoleName("zzzzzzzzz");
		vo.setUserId("asdf");

		Assert.assertEquals(1, userdao.updateUser(vo));
	}

	@Test
	public void deleteUserTest() {
		Assert.assertEquals(1, userdao.deleteUser("zzzzzzzz"));
	}

	@Test
	public void getUserListTest() {
		System.out.println(userdao.getUserList());
	}

	@Test
	public void getUserTest() {
		System.out.println(userdao.getUser("asdf"));
	}
	
	@Test
	public void getRegistrationByLocationTest(){
		System.out.println(userdao.getRegistrationIdByLocation("gggg"));
	}
	
	@Test
	public void getRegistrationByModelCodeTest(){
		System.out.println(userdao.getRegistrationByModelCode("gggg"));
	}
}
