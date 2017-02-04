package com.obigo.obigoproject.messagecategory.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.vo.MessageCategoryVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class MessageCategoryDaoTest {
	@Autowired
	MessageCategoryDao messageCategoryDao;

	@Test
	public void insertMessageCategoryTest() {
		MessageCategoryVO vo = new MessageCategoryVO();
		vo.setCategoryName("car");
		vo.setCategoryNumber(1);
		Assert.assertEquals(messageCategoryDao.insertMessageCategory(vo), 1);

	}

	@Test
	public void updateMessageCategory() {
		MessageCategoryVO vo = new MessageCategoryVO();
		vo.setCategoryName("carrrrr");
		vo.setCategoryNumber(1);
		Assert.assertEquals(messageCategoryDao.updateMessageCategory(vo), 1);
	}

	@Test
	public void deleteMessageCategory() {
		Assert.assertEquals(messageCategoryDao.deleteMessageCategory(1), 1);
	}

	@Test
	public void selectMessageCategoryList() {
		List<MessageCategoryVO> list = messageCategoryDao.getMessageCategoryList();
		Assert.assertEquals(list.size(), 1);
	}
}
