package com.obigo.obigoproject.messagecategory.service;

import java.util.List;
import java.util.Map;

import com.obigo.obigoproject.vo.MessageCategoryVO;

public interface MessageCategoryService {
	public boolean insertMessageCategory(MessageCategoryVO vo);

	public boolean updateMessageCategory(MessageCategoryVO vo);

	public boolean deleteMessageCategory(int categoryNumber);

	public List<MessageCategoryVO> getMessageCategoryList();

	public Map<String, String> getMessageCategoryMap();

	// 생각하샘
}
