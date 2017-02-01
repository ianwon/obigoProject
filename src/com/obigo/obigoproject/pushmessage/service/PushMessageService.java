package com.obigo.obigoproject.pushmessage.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.obigo.obigoproject.vo.PushMessageVO;

import net.sf.json.JSONArray;

public interface PushMessageService {

	// PUSHMESSAGE 등록
	public boolean insertPushMessage(PushMessageVO vo);

	// PUSHMESSAGE 수정
	public boolean updatePushMessage(PushMessageVO vo);

	// PUSHMESSAGE 삭제
	public boolean deletePushMessage(int messageNumber);

	// 전체 PUSHMESSAGE를 가지고오는 메소드
	public List<PushMessageVO> getPushMessageList();

	// 선택한 category, location, model에 따라 Pushmessage List를 불러옴
	public List<PushMessageVO> getPushMessageListBy(Map<String, Object> map);

	// 특정 아이디의 pushmessage를 인덱싱하여 가지고오는 메소드
	public List<PushMessageVO> getPushMessageList(String userId);

	// GCM 서버로 푸시 메시지 전송
	public boolean sendPushMessageToGcm(PushMessageVO vo, HttpServletRequest request) throws IOException;

	// GCM 서버로 User Request Accept 또는 Reject 응답에 대한 푸시 메시지 전송
	public boolean sendUserReqeustPushMessage(String userId, String flag) throws IOException;

	public PushMessageVO getPushMessage();

	public JSONArray getCategoryName();
}
