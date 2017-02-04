package com.obigo.obigoproject.messagecategory.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.vo.MessageCategoryVO;

@Repository("messageCategoryDao")
public class MessageCategoryDaoImpl implements MessageCategoryDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertMessageCategory(MessageCategoryVO vo) {
		return sqlSession.insert("obigoproject.MessageCategory.insertMessageCategory", vo);
	}

	@Override
	public int updateMessageCategory(MessageCategoryVO vo) {
		return sqlSession.update("obigoproject.MessageCategory.updateMessageCategory", vo);
	}

	@Override
	public int deleteMessageCategory(int categoryNumber) {
		return sqlSession.delete("obigoproject.MessageCategory.deleteMessageCategory", categoryNumber);
	}

	@Override
	public List<MessageCategoryVO> getMessageCategoryList() {
		return sqlSession.selectList("obigoproject.MessageCategory.selectMessageCategoryList");
	}

}
