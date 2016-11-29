package com.obigo.obigoproject.messagecategory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obigo.obigoproject.messagecategory.dao.MessageCategoryDao;
import com.obigo.obigoproject.vo.MessageCategoryVO;

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

}
