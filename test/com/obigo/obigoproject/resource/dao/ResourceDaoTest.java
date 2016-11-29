package com.obigo.obigoproject.resource.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.vo.ResourceVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class ResourceDaoTest {

	@Autowired
	ResourceDao resourceDao;
	
	@Test
	public void insertTest(){
		ResourceVO vo=new ResourceVO();
		
		vo.setResourceName("name");
		vo.setBundleKey("key");
		vo.setPath("path");
		vo.setResourceVersion("2.2.2");
		
		int resultCount=resourceDao.insertResource(vo);
		
		Assert.assertEquals(1, resultCount);
		
	}
	
	@Test
	public void deleteTest(){
		int resultCount=resourceDao.deleteResource(2);
		Assert.assertEquals(1, resultCount);
		
	}
	
	@Test
	public void updateTest(){
		ResourceVO vo=new ResourceVO();
		
		vo.setResourceNumber(2);
		vo.setResourceName("name update");
		vo.setBundleKey("key");
		vo.setPath("path update");
		vo.setResourceVersion("11.11.12");
		
		int resultCount=resourceDao.updateResource(vo);
		Assert.assertEquals(1, resultCount);
		
	}
	
	@Test
	public void selectListTest(){
				
		List<ResourceVO>list=resourceDao.getResourceList("key");
		Assert.assertEquals(1, list.size());
		
	}
	
	@Test
	public void selectTest(){
				
		ResourceVO vo=resourceDao.getResource(2);
		System.out.println(vo);
		Assert.assertNotNull(vo);
		
	}
}
