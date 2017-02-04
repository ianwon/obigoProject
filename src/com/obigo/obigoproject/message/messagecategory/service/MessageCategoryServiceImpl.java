package com.obigo.obigoproject.message.messagecategory.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obigo.obigoproject.message.messagecategory.dao.MessageCategoryDao;
import com.obigo.obigoproject.message.messagecategory.vo.MessageCategoryVO;

@Service("messageCategoryService")
public class MessageCategoryServiceImpl implements MessageCategoryService {

	@Autowired
	MessageCategoryDao messageCategoryDao;

	@Override
	public boolean insertMessageCategory(MessageCategoryVO vo) {
		int resultCount = 0;

		resultCount = messageCategoryDao.insertMessageCategory(vo);

		if (resultCount == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateMessageCategory(MessageCategoryVO vo) {

		int resultCount = 0;

		resultCount = messageCategoryDao.updateMessageCategory(vo);

		if (resultCount == 1)
			return true;
		else
			return false;

	}

	@Override
	public boolean deleteMessageCategory(int categoryNumber) {

		int resultCount = 0;

		resultCount = messageCategoryDao.deleteMessageCategory(categoryNumber);

		if (resultCount == 1)
			return true;
		else
			return false;

	}

	@Override
	public List<MessageCategoryVO> getMessageCategoryList() {
		return messageCategoryDao.getMessageCategoryList();
	}

	// Message Category를 Map형식으로 받아오는 메소드
	// Map<key="CategoryNumber", value="CategoryName">
	@Override
	public Map<String, String> getMessageCategoryMap() {
		Map<String, String> map = new HashMap<>();
		List<MessageCategoryVO> list = messageCategoryDao.getMessageCategoryList();
		for (int i = 0; i < list.size(); i++) {
			map.put("category" + list.get(i).getCategoryNumber(), list.get(i).getCategoryName());
		}
		return map;
	}

}
