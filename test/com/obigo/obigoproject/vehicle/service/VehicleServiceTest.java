package com.obigo.obigoproject.vehicle.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.vo.VehicleVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class VehicleServiceTest {
	
	@Autowired
	VehicleService vehicleService;
	
	@Test
	public void insertVehicleTest(){
		VehicleVO vo = new VehicleVO();
		vo.setModelName("heaven");
		vo.setModelCode("jesus");
		vo.setModelImage("Gggg");
		vo.setDetailImage("gggg");
		vo.setEngine("gggg");
		vo.setModelYear(1111);
		vo.setMileage("gggg");
		
//		Assert.assertTrue(vehicleService.insertVehicle(vo));
	}
	
	@Test
	public void updateVehicleTest(){
		VehicleVO vo = new VehicleVO();
		vo.setModelCode("jesus");
		vo.setModelImage("c:\\path\\model.jpg");
		vo.setDetailImage("c:\\path\\detail.jpg");
		
		Assert.assertTrue(vehicleService.updateVehicle(vo));
	}
	
	@Test
	public void deleteVehicleTest(){
		Assert.assertTrue(vehicleService.deleteVehicle("jesus"));
	}
	
	@Test
	public void getVehicleListTest(){
		Assert.assertEquals(2, vehicleService.getVehicleList().size());
	}
	
	@Test
	public void getVehicleTest(){
		Assert.assertNotNull(vehicleService.getVehicle("jesus"));
	}

}
