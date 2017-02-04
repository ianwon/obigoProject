package com.obigo.obigoproject.user.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.user.user.service.UserService;
import com.obigo.obigoproject.user.user.vo.UsersVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class UserServiceTest {
	@Autowired
	UserService userservice;

	// user 등록
	@Test
	public void insertUserTest() {
		UsersVO vo = new UsersVO();
		vo.seteMail("aaaaa");
		vo.setName("zzzz");
		vo.setPassword("1234");
		vo.setPhone("asdf");
		vo.setRoleName("zzzzzzzzz");
		vo.setUserId("zzzzzzzz1123");
		System.out.println(userservice.insertUser(vo));
	}

	// user 정보 수정
	@Test
	public void updateUserTest() {
		UsersVO vo = new UsersVO();
		vo.seteMail("aaaaa");
		vo.setName("yun");
		vo.setPassword("5678");
		vo.setPhone("asdf");
		vo.setUserId("asdf");
		System.out.println(userservice.updateUser(vo));

	}

	// user 삭제
	@Test
	public void deleteUserTest() {
		System.out.println(userservice.deleteUser("asdf"));
	}

	@Test
	public void getUserListTest() {
		System.out.println(userservice.getUserList());
	}

	@Test
	public void getUserTest() {
		System.out.println(userservice.getUser("zzzzzzzz"));
	}
}
