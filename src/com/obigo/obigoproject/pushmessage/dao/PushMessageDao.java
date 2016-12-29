package com.obigo.obigoproject.pushmessage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.obigo.obigoproject.vo.PushMessageVO;

public interface PushMessageDao {

	public int insertPushMessage(PushMessageVO vo);

	public int updatePushMessage(PushMessageVO vo);

	public int deletePushMessage(int messageNumber);

	// 전체 PUSHMESSAGE를 가지고오는 메소드
	public List<PushMessageVO> getPushMessageList();

	// 특정 아이디의 pushmessage를 인덱싱하여 가지고오는 메소드
	public List<PushMessageVO> getPushMessageList(String userId);

	// 특정 카테고리의 PUSHMESSAGE를 가지고오는 메소드
	public List<PushMessageVO> getPushMessageListByCategory(int categoryNumber);

	public PushMessageVO getPushMessage();

	public List<Map<String, Integer>> getCategoryName();

}
