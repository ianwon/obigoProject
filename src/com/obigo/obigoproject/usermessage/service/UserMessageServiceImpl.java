package com.obigo.obigoproject.usermessage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obigo.obigoproject.usermessage.dao.UserMessageDao;
import com.obigo.obigoproject.vo.UserMessageVO;

@Service("userMessageService")
public class UserMessageServiceImpl implements UserMessageService {
	@Autowired
	UserMessageDao userMessageDao;

	@Override
	public boolean insertUserMessage(UserMessageVO vo) {
		int resultcount = userMessageDao.insertUserMessage(vo);
		if (resultcount == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateUserMessage(UserMessageVO vo) {
		int resultcount = userMessageDao.updateUserMessage(vo);
		if (resultcount == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteUserMessage(int userMessageNumber) {
		int resultcount = userMessageDao.deleteUserMessage(userMessageNumber);
		if (resultcount == 1)
			return true;
		else
			return false;
	}

	@Override
	public List<UserMessageVO> getUserMessageList(String userId) {
		return userMessageDao.getUserMessageListByUserId(userId);
	}

}
