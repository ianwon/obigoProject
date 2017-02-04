package com.obigo.obigoproject.vehicle.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.vehicle.dao.VehicleDao;
import com.obigo.obigoproject.vehicle.vo.VehicleVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class VehicleDaoTest {

	@Autowired
	VehicleDao vehicledao;
	
	@Test
	public void insertVehicleTest(){
		VehicleVO vo = new VehicleVO();
		vo.setModelName("zzzz");
		vo.setModelCode("gggg");
		vo.setModelImage("Gggg");
		vo.setDetailImage("gggg");
		vo.setEngine("gggg");
		vo.setModelYear(1111);
		vo.setMileage("gggg");
		
		Assert.assertEquals(1, vehicledao.insertVehicle(vo));
	}
	
	@Test
	public void updateVehicleTest(){
		VehicleVO vo = new VehicleVO();
		vo.setModelCode("gggg");
		vo.setModelImage("1234");
		vo.setDetailImage("1234");
		
		Assert.assertEquals(1, vehicledao.updateVehicle(vo));
	}
	
	@Test
	public void deleteVehicleTest(){
		Assert.assertEquals(1, vehicledao.deleteVehicle("gggg"));
	}
	
	@Test
	public void getVehicleListTest(){
		System.out.println(vehicledao.getVehicleList());
	}
	
	@Test
	public void getVehicleTest(){
		Assert.assertNotNull(vehicledao.getVehicle("jesus"));
	}
}
