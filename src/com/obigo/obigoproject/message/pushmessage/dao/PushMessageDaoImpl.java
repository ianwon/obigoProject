package com.obigo.obigoproject.message.pushmessage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.message.pushmessage.vo.PushMessageVO;

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
	public List<PushMessageVO> getPushMessageList(String userId) {
		return sqlSession.selectList("obigoproject.PushMessage.selectPushMessageByUserid", userId);
	}

	@Override
	public PushMessageVO getPushMessage() {
		return sqlSession.selectOne("obigoproject.PushMessage.selectPushMessage");
	}

	@Override
	public List<Map<String, Object>> getCategoryName() {
		return sqlSession.selectList("obigoproject.PushMessage.groupByCategoryName");
	}

	// 선택한 category, location, model에 따라 Pushmessage List를 불러옴
	@Override
	public List<PushMessageVO> getPushMessageListBy(Map<String, Object> map) {
		return sqlSession.selectList("obigoproject.PushMessage.selectPushMessageListByAll", map);
	}

}
