package com.obigo.obigoproject.log.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.log.vo.LogVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class LogServiceTest {

	@Autowired
	LogService logService;

	@Test
	public void insertLogTest() {
		LogVO vo = new LogVO();
		vo.setBody("hahah");
		vo.setReturned("name:name");
		vo.setUrl("/tods/api/wyh");
		Assert.assertTrue(logService.insertLog(vo));
	}

	@Test
	public void deleteAllLogTest() {
		Assert.assertTrue(logService.deleteAllLog());
	}

	// 로그 내용을 이메일 발송, 혹은 pdf형태로 출력
	// public boolean sendEmail(List<LogVO> list);

	// 전체 API 가져오는 메소드
	@Test
	public void getLogListTest() {
		List<LogVO> list = logService.getLogList();

		Assert.assertEquals(list.size(), 4);
	}

	// 특정 URL API 가져오는 메소드(카테고리)
	@Test
	public void getLogListByUrlTest() {
		List<LogVO> list = logService.getLogListByUrl("/tods/api/wyh");

		Assert.assertEquals(list.size(), 1);

	}

}
