package com.obigo.obigoproject.pushmessage.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.message.pushmessage.dao.PushMessageDao;
import com.obigo.obigoproject.message.pushmessage.vo.PushMessageVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class PushMessageDaoTest {
	@Autowired
	PushMessageDao pushMessageDao;

	@Test
	public void insertPushMessage() {
		PushMessageVO vo = new PushMessageVO();
		vo.setContent("hihihi");
		vo.setLocation("Korea");
		vo.setCategoryNumber(1);
		vo.setModelCode("wyhZzang");
		vo.setTitle("원유짱");
		vo.setUploadFile("C://");
		Assert.assertEquals(pushMessageDao.insertPushMessage(vo), 1);
	}

	@Test
	public void updatePushMessage() {
		PushMessageVO vo = new PushMessageVO();
		vo.setMessageNumber(2);
		vo.setContent("LOL");
		vo.setLocation("Korea");
		vo.setCategoryNumber(10);
		vo.setModelCode("wyhZzang");
		vo.setTitle("원유짱");
		vo.setUploadFile("C://");
		Assert.assertEquals(pushMessageDao.updatePushMessage(vo), 1);

	}

	@Test
	public void deletePushMessage() {
		Assert.assertEquals(pushMessageDao.deletePushMessage(2), 1);
	}

	// 전체 PUSHMESSAGE를 가지고오는 메소드
	@Test
	public void getPushMessageList() {
		List<PushMessageVO> list = pushMessageDao.getPushMessageList();

		Assert.assertEquals(list.get(0).getContent(), "LOL");
	}

	@Test
	public void getPushMessage(){
		PushMessageVO vo = pushMessageDao.getPushMessage();
		System.out.println(vo);
	}

}
