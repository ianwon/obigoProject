package com.obigo.obigoproject.uservehicle.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.vo.PushMessageVO;
import com.obigo.obigoproject.vo.UserVehicleVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class UserVehicleServiceTest {
	@Autowired
	UserVehicleService uservehicleservice;

	@Test
	public void insertUserVehicleTest() {
		UserVehicleVO vo = new UserVehicleVO();
		vo.setUserId("agaagaga12as");
		vo.setModelCode("gggg");
		vo.setActiveDtcCount(5);
		vo.setColor("Red");
		vo.setLocation("gggg");
		vo.setVin("1234");

		Assert.assertTrue(uservehicleservice.insertUserVehicle(vo));
	}
	@Test
	public void updateUserVehicleTest(){
		UserVehicleVO vo = new UserVehicleVO();
		vo.setActiveDtcCount(4);
		vo.setUserVehicleNumber(6);
		
		Assert.assertTrue(uservehicleservice.updateUserVehicle(vo));
	}
	
	@Test
	public void deleteUserVehicleTest(){
		Assert.assertTrue(uservehicleservice.deleteUserVehicle(6));
	}
	
	@Test
	public void getUserVehicleTest(){
		System.out.println(uservehicleservice.getUserVehicle(7));
	}
	
	@Test
	public void getUserVehicleListTest(){
		System.out.println(uservehicleservice.getUserVehicleList("agaagaga12as"));
	}
	
	@Test
	public void getUserId(){
		PushMessageVO vo = new PushMessageVO();
		vo.setLocation("korea");
		vo.setModelCode("asdf");
		uservehicleservice.getUserId(vo);
	}
}
