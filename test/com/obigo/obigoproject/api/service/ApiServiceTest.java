package com.obigo.obigoproject.api.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.vo.ApiVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class ApiServiceTest {
	
	@Autowired
	ApiService apiService;

	@Test
	public void insertApiTest() {
		ApiVO vo = new ApiVO();

		vo.setApiName("aa");
		vo.setResponseToSend("aa");

		Assert.assertTrue(apiService.insertApi(vo));
	}

	@Test
	public void updateApiTest() {
		ApiVO vo = new ApiVO();

		vo.setApiName("aa");
		vo.setResponseToSend("bb");

		Assert.assertTrue(apiService.updateApi(vo));
	}

	@Test
	public void deleteApiTest() {
		Assert.assertTrue(apiService.deleteApi("aa"));
	}

	// 특정 API를 가져오는 메소드
	@Test
	public void getApiTest() {
		ApiVO vo = apiService.getApi("aa");
		Assert.assertEquals(vo.getResponseToSend(), "bb");

	}

	// 전체 API 가져오는 메소드
	@Test
	public void getApiListTest() {
		List<ApiVO> list = apiService.getApiList();

		Assert.assertEquals(list.size(), 3);
	}

}
