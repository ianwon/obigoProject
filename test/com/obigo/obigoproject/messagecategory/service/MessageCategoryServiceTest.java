package com.obigo.obigoproject.messagecategory.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.message.messagecategory.service.MessageCategoryService;
import com.obigo.obigoproject.message.messagecategory.vo.MessageCategoryVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class MessageCategoryServiceTest {
	
	@Autowired
	MessageCategoryService messageCategoryService;
	
	@Test
	public void insertMessageCategoryServiceTest(){
		
		
		MessageCategoryVO vo=new MessageCategoryVO();
		
		vo.setCategoryName("car1");
		vo.setCategoryNumber(1);
		
		Assert.assertTrue(messageCategoryService.insertMessageCategory(vo));
		
	}
	
	
	@Test
	public void updateMessageCategoryServiceTest() {
		MessageCategoryVO vo = new MessageCategoryVO();
		vo.setCategoryName("carrrrr");
		vo.setCategoryNumber(1);
		Assert.assertTrue(messageCategoryService.updateMessageCategory(vo));
	}

	@Test
	public void deleteMessageCategoryServiceTest() {
		Assert.assertTrue(messageCategoryService.deleteMessageCategory(1));
	}

	
	

}
