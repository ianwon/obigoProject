package com.obigo.obigoproject.pushmessage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.vo.PushMessageVO;

@Repository("pushMessageDao")
public class PushMessageDaoImpl implements PushMessageDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertPushMessage(PushMessageVO vo) {
		return sqlSession.insert("obigoproject.PushMessage.insertPushMessage", vo);
	}

	@Override
	public int updatePushMessage(PushMessageVO vo) {
		return sqlSession.update("obigoproject.PushMessage.updatePushMessage", vo);
	}

	@Override
	public int deletePushMessage(int messageNumber) {
		return sqlSession.delete("obigoproject.PushMessage.deletePushMessage", messageNumber);
	}

	@Override
	public List<PushMessageVO> getPushMessageList() {
		return sqlSession.selectList("obigoproject.PushMessage.selectPushMessageList");
	}

	@Override
	public List<PushMessageVO> getPushMessageListByCategory(int categoryNumber) {
		return sqlSession.selectList("obigoproject.PushMessage.selectPushMessageByCategory", categoryNumber);
	}

	@Override
	public List<PushMessageVO> getPushMessageList(String userId) {
		return sqlSession.selectList("obigoproject.PushMessage.selectPushMessageByUserid", userId);
	}

	@Override
	public PushMessageVO getPushMessage() {
		return sqlSession.selectOne("obigoproject.PushMessage.selectPushMessage");
	}

	@Override
	public List<Map<String, Integer>> getCategoryName() {
		return sqlSession.selectList("obigoproject.PushMessage.groupByCategoryName");
	}

	@Override
	public List<PushMessageVO> getPushMessageListBy(String by, String select) {
		if (by.equals("categoryNumber"))
			return sqlSession.selectList("obigoproject.PushMessage.selectPushMessageListByCategory", Integer.parseInt(select));
		else if (by.equals("location"))
			return sqlSession.selectList("obigoproject.PushMessage.selectPushMessageListByLocation", select);
		else if (by.equals("modelCode"))
			return sqlSession.selectList("obigoproject.PushMessage.selectPushMessageListByModelCode", select);
		return null;
	}

}
