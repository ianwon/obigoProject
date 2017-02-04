package com.obigo.obigoproject.usermessage.service;

import java.util.List;

import com.obigo.obigoproject.vo.UserMessageVO;

public interface UserMessageService {
	public boolean insertUserMessage(UserMessageVO vo);

	public boolean updateUserMessage(UserMessageVO vo);

	public boolean deleteUserMessage(int userMessageNumber);

	public List<UserMessageVO> getUserMessageList(String userId);
}
