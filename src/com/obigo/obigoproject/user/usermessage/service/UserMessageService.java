package com.obigo.obigoproject.user.usermessage.service;

import java.util.List;

import com.obigo.obigoproject.user.usermessage.vo.UserMessageVO;

public interface UserMessageService {
	public boolean insertUserMessage(UserMessageVO vo);

	public boolean updateUserMessage(UserMessageVO vo);

	public boolean deleteUserMessage(int userMessageNumber);

	public List<UserMessageVO> getUserMessageList(String userId);
}
