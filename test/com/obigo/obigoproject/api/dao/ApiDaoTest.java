package com.obigo.obigoproject.api.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.api.vo.ApiVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class ApiDaoTest {

	@Autowired
	ApiDao apiDao;


	@Test
	public void insertApiTest() {
		ApiVO vo = new ApiVO();
		vo.setApiName("a");
		vo.setResponseToSend("a");
		Assert.assertEquals(apiDao.insertApi(vo), 1);

	}

	@Test
	public void updateApi() {
		ApiVO vo = new ApiVO();
		vo.setApiName("a");
		vo.setResponseToSend("b");
		Assert.assertEquals(apiDao.updateApi(vo), 1);

	}

	// 전체 API 가져오는 메소드
	@Test
	public void getApiList() {
		List<ApiVO> list = apiDao.getApiList();
		Assert.assertEquals(list.size(), 1);

	}

	// 특정 API를 가져오는 메소드
	@Test
	public void getApi() {
		Assert.assertEquals(apiDao.getApi("a").getResponseToSend(), "b");

	}

	@Test
	public void deleteApi() {
		Assert.assertEquals(apiDao.deleteApi("a"), 1);

	}

}
