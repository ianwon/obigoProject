package com.obigo.obigoproject.pushmessage.dao;

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
	public List<PushMessageVO> getPushMessageList(Map map) {
		return sqlSession.selectList("obigoproject.PushMessage.indexingPushMessageList",map);
	}

}
