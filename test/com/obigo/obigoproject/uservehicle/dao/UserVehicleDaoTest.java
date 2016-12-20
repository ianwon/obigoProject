package com.obigo.obigoproject.uservehicle.dao;

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
public class UserVehicleDaoTest {
	@Autowired
	UserVehicleDao uservehicledao;

	@Test
	public void insertUserVehicleTest(){
		UserVehicleVO vo = new UserVehicleVO();
		vo.setColor("gggg");
		vo.setLocation("gggg");
		vo.setModelCode("gggg");
		vo.setUserId("YUN");
		vo.setVin("gggg");
		vo.setActiveDtcCount(5);
		
		Assert.assertEquals(1,uservehicledao.insertUserVehicle(vo));
	}
	
	@Test
	public void updateUserVehicleTest(){
		UserVehicleVO vo = new UserVehicleVO();
		vo.setUserVehicleNumber(1);
		vo.setActiveDtcCount(4);
		
		Assert.assertEquals(1, uservehicledao.updateUserVehicle(vo));
	}
	
	@Test
	public void deleteUserVehicleTest(){
		Assert.assertEquals(1, uservehicledao.deleteUserVehicle(1));	
	}
	
	@Test
	public void getUserVehicleTest(){
		System.out.println(uservehicledao.getUserVehicle(0));
	}
	@Test
	public void getUserVehicleListTest(){
		System.out.println(uservehicledao.getUserVehicleList("asdf"));
	}
	@Test
	public void getLocationTest(){
		System.out.println(uservehicledao.getLocation().size());
	}
	
	@Test
	public void getUserIdTest(){
		PushMessageVO vo = new PushMessageVO();
		System.out.println(uservehicledao.getUserId(vo));
	}
}
