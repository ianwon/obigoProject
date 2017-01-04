package com.obigo.obigoproject.pushmessage.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.obigo.obigoproject.vo.PushMessageVO;

public interface PushMessageService {

	// PUSHMESSAGE 등록
	public boolean insertPushMessage(PushMessageVO vo);

	// PUSHMESSAGE 수정
	public boolean updatePushMessage(PushMessageVO vo);

	// PUSHMESSAGE 삭제
	public boolean deletePushMessage(int messageNumber);

	// 전체 PUSHMESSAGE를 가지고오는 메소드
	public List<PushMessageVO> getPushMessageList();

	public List<PushMessageVO> getPushMessageListBy(String by, String select);

	// 특정 아이디의 pushmessage를 인덱싱하여 가지고오는 메소드
	public List<PushMessageVO> getPushMessageList(String userId);

	// 특정 카테고리의 PUSHMESSAGE를 가지고오는 메소드
	public List<PushMessageVO> getPushMessageListByCategory(int categoryNumber);

	// 정기적으로 통계리포트 생성 및 등록된 이메일로 발송 (pdf로 출력하기 기능)
	public boolean sendEmail(List<PushMessageVO> list);

	// GCM 서버로 푸시 메시지 전송
	public boolean sendPushMessageToGcm(PushMessageVO vo, HttpServletRequest request) throws IOException;

	// GCM 서버로 User Request Accept 또는 Reject 응답에 대한 푸시 메시지 전송
	public boolean sendUserReqeustPushMessage(String userId, String flag) throws IOException;

	public PushMessageVO getPushMessage();

	public List<HashMap> getCategoryName();
}
