package com.obigo.obigoproject.pushmessage.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.vo.PushMessageVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class PushMessageServiceTest {

	@Autowired
	PushMessageService pushMessageService;

	@Test
	public void insertTest() {

		PushMessageVO vo = new PushMessageVO();
		vo.setContent("hihihi");
		vo.setLocation("Korea");
		vo.setCategoryNumber(10);
		vo.setModelCode("zzzz");
		vo.setTitle("경우짱");
		vo.setUploadFile("C://");
		Assert.assertTrue(pushMessageService.insertPushMessage(vo));

		PushMessageVO vo2 = new PushMessageVO();
		vo2.setContent("hihihi222");
		vo2.setLocation("Korea2222");
		vo2.setCategoryNumber(10);
		vo2.setModelCode("zzzz");
		vo2.setTitle("경우짱2222");
		vo2.setUploadFile("C://2222");
		Assert.assertTrue(pushMessageService.insertPushMessage(vo2));

		PushMessageVO vo3 = new PushMessageVO();
		vo3.setContent("hihihi3333");
		vo3.setLocation("Korea3333");
		vo3.setCategoryNumber(10);
		vo3.setModelCode("zzzz");
		vo3.setTitle("경우짱33333");
		vo3.setUploadFile("C://3333");
		Assert.assertTrue(pushMessageService.insertPushMessage(vo3));

	}

	@Test
	public void updatePushMessage() {
		PushMessageVO vo = new PushMessageVO();
		vo.setMessageNumber(2);
		vo.setContent("jesus");
		vo.setLocation("Korea 업데이트");
		vo.setCategoryNumber(10);
		vo.setModelCode("kkwZzang 업데이트");
		vo.setTitle("경우짱 업데이트");
		vo.setUploadFile("C:// 업데이트");
		Assert.assertTrue(pushMessageService.updatePushMessage(vo));

	}

	@Test
	public void deletePushMessage() {
		Assert.assertTrue(pushMessageService.deletePushMessage(3));
	}

	// 전체 PUSHMESSAGE를 가지고오는 메소드
	@Test
	public void getPushMessageList() {
		List<PushMessageVO> list = pushMessageService.getPushMessageList();

		Assert.assertEquals(3, list.size());
	}


	@Test
	public void getPushMessage() {
		PushMessageVO vo = pushMessageService.getPushMessage();
		System.out.println(vo);
	}
}
