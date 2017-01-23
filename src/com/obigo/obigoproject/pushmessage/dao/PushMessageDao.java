package com.obigo.obigoproject.pushmessage.dao;

import java.util.List;
import java.util.Map;

import com.obigo.obigoproject.vo.PushMessageVO;

public interface PushMessageDao {

	public int insertPushMessage(PushMessageVO vo);

	public int updatePushMessage(PushMessageVO vo);

	public int deletePushMessage(int messageNumber);

	// 전체 PUSHMESSAGE를 가지고오는 메소드
	public List<PushMessageVO> getPushMessageList();

	// 선택한 category, location, model에 따라 Pushmessage List를 불러옴
	public List<PushMessageVO> getPushMessageListBy(Map<String, Object> map);

	// 특정 아이디의 pushmessage를 인덱싱하여 가지고오는 메소드
	public List<PushMessageVO> getPushMessageList(String userId);

	public PushMessageVO getPushMessage();

	public List<Map<String, Object>> getCategoryName();

}
