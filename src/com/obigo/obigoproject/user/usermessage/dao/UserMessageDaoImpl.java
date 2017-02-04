package com.obigo.obigoproject.user.usermessage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.user.usermessage.vo.UserMessageVO;

@Repository("userMessageDao")
public class UserMessageDaoImpl implements UserMessageDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertUserMessage(UserMessageVO vo) {
		return sqlSession.insert("obigoproject.UserMessage.insertUserMessage", vo);
	}

	@Override
	public int updateUserMessage(UserMessageVO vo) {
		return sqlSession.update("obigoproject.UserMessage.updateUserMessage", vo);
	}

	@Override
	public int deleteUserMessage(int userMessageNumber) {
		return sqlSession.delete("obigoproject.UserMessage.deleteUserMessage", userMessageNumber);
	}
	
	//특정 유저의 Message List를 가져오는 메소드
	@Override
	public List<UserMessageVO> getUserMessageListByUserId(String userId) {
		return sqlSession.selectList("obigoproject.UserMessage.selectUserMessageByUserId", userId);
	}

}
