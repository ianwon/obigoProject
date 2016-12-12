package com.obigo.obigoproject.resource.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.vo.ResourceVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class ResourceServiceTest {

	@Autowired
	ResourceService resourceService;

	@Test
	public void insertTest() {
		HttpServletRequest request = null;
		ResourceVO vo = new ResourceVO();

		vo.setResourceName("name");
		vo.setBundleKey("key");
		vo.setPath("path");
		vo.setResourceVersion("2.2.2");

		Assert.assertTrue(resourceService.insertResource(vo, request));

	}

	@Test
	public void deleteTest() {
		Assert.assertTrue(resourceService.deleteResource(4));

	}

	@Test
	public void updateTest() {
		ResourceVO vo = new ResourceVO();

		vo.setResourceNumber(7);
		vo.setResourceName("kkw update");
		vo.setBundleKey("key");
		vo.setPath("kkw update");
		vo.setResourceVersion("1.2.3.4");

		Assert.assertTrue(resourceService.updateResource(vo));

	}

	@Test
	public void selectListTest() {

		List<ResourceVO> list = resourceService.getResourceListBybundleKey("bundle_key");
		Assert.assertEquals(7, list.size());

	}

	@Test
	public void selectTest() {

		ResourceVO vo = resourceService.getResource(21);
		System.out.println(vo);
		Assert.assertNotNull(vo);

	}
}
