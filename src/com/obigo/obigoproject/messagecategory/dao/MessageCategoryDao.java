package com.obigo.obigoproject.messagecategory.dao;

import java.util.List;

import com.obigo.obigoproject.vo.MessageCategoryVO;

public interface MessageCategoryDao {

	public int insertMessageCategory(MessageCategoryVO vo);

	public int updateMessageCategory(MessageCategoryVO vo);

	public int deleteMessageCategory(int categoryNumber);

	public List<MessageCategoryVO> getMessageCategoryList();
	// 생각하셈
}
