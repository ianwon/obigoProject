package com.obigo.obigoproject.usermessage.dao;

import java.util.List;

import com.obigo.obigoproject.vo.UserMessageVO;

public interface UserMessageDao {

	public int insertUserMessage(UserMessageVO vo);

	public int updateUserMessage(UserMessageVO vo);

	public int deleteUserMessage(int userMessageNumber);

	public List<UserMessageVO> getUserMessageListByUserId(String userId);
	
}
