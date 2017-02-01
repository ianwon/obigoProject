package com.obigo.obigoproject.pushmessage.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;
import com.obigo.obigoproject.pushmessage.dao.PushMessageDao;
import com.obigo.obigoproject.registrationid.dao.RegistrationidDao;
import com.obigo.obigoproject.uservehicle.dao.UserVehicleDao;
import com.obigo.obigoproject.util.obigoUtils;
import com.obigo.obigoproject.vo.PushMessageVO;

import net.sf.json.JSONArray;

@Service("pushMessageService")
public class PushMessageServiceImpl implements PushMessageService {

	@Autowired
	PushMessageDao pushMessageDao;

	@Autowired
	UserVehicleDao uservehicleDao;

	@Autowired
	RegistrationidDao registrationidDao;

	// PUSHMESSAGE 등록
	@Override
	public boolean insertPushMessage(PushMessageVO vo) {
		int resultCount = 0;

		resultCount = pushMessageDao.insertPushMessage(vo);

		if (resultCount == 1)
			return true;
		else
			return false;

	}

	// PUSHMESSAGE 수정
	@Override
	public boolean updatePushMessage(PushMessageVO vo) {
		int resultCount = 0;

		resultCount = pushMessageDao.updatePushMessage(vo);

		if (resultCount == 1)
			return true;
		else
			return false;
	}

	// PUSHMESSAGE 삭제
	@Override
	public boolean deletePushMessage(int messageNumber) {
		int resultCount = 0;

		resultCount = pushMessageDao.deletePushMessage(messageNumber);

		if (resultCount == 1)
			return true;
		else
			return false;
	}

	// 전체 PUSHMESSAGE를 가지고오는 메소드
	@Override
	public List<PushMessageVO> getPushMessageList() {
		return pushMessageDao.getPushMessageList();
	}

	// 특정 PUSHMESSAGE를 가지고오는 메소드
	@Override
	public List<PushMessageVO> getPushMessageListBy(Map<String, Object> map) {
		return pushMessageDao.getPushMessageListBy(map);
	}

	// GCM 서버로 푸시 메시지 전송
	@Override
	public boolean sendPushMessageToGcm(PushMessageVO vo, HttpServletRequest request) throws IllegalArgumentException, IOException {
		if (((MultipartHttpServletRequest) request).getFile("messageFile") != null)
			pushMessageDao.insertPushMessage(createFile(vo, request));
		else
			pushMessageDao.insertPushMessage(vo);

		PushMessageVO pushmessage = pushMessageDao.getPushMessage();
		List<String> userIdList = uservehicleDao.getUserId(pushmessage);

		for (String userId : userIdList) {
			List<String> registrationidList = registrationidDao.getRegistrationidListByuserId(userId);
			String MESSAGE_ID = String.valueOf(Math.random() % 100 + 1); // 메시지
																			// 고유
			boolean SHOW_ON_IDLE = false; // 옙 활성화 상태일때 보여줄것인지
			int LIVE_TIME = 1; // 옙 비활성화 상태일때 FCM가 메시지를 유효화하는 시간
			int RETRY = 2; // 메시지 전송실패시 재시도 횟수
			String simpleApiKey = "AIzaSyAugaUfy_TbAFpMsr91f4_M8cTvePi0now";
			Sender sender = new Sender(simpleApiKey);
			try {
				Message message = new Message.Builder().collapseKey(MESSAGE_ID).delayWhileIdle(SHOW_ON_IDLE).timeToLive(LIVE_TIME).addData("content", vo.getContent()).addData("upload", vo.getUploadFile()).addData("title", vo.getTitle()).build();
				MulticastResult result1 = sender.send(message, registrationidList, RETRY);
			} catch (IllegalArgumentException e) {

			}
		}

		return true;
	}

	@Override
	public boolean sendUserReqeustPushMessage(String userId, String flag) throws IOException {

		List<String> registrationidList = registrationidDao.getRegistrationidListByuserId(userId);

		String content = null;
		String title = null;

		title = "<<Vehicle registration : " + userId + ">>";
		if ("accept".equals(flag)) {
			content = "Your request Accepted";
		} else {
			content = "Your request Rejected";
		}
		String MESSAGE_ID = String.valueOf(Math.random() % 100 + 1); // 메시지
		// 고유
		boolean SHOW_ON_IDLE = false; // 옙 활성화 상태일때 보여줄것인지
		int LIVE_TIME = 1; // 옙 비활성화 상태일때 FCM가 메시지를 유효화하는 시간
		int RETRY = 2; // 메시지 전송실패시 재시도 횟수
		String simpleApiKey = "AIzaSyAugaUfy_TbAFpMsr91f4_M8cTvePi0now";
		Sender sender = new Sender(simpleApiKey);
		try {
			Message message = new Message.Builder().collapseKey(MESSAGE_ID).delayWhileIdle(SHOW_ON_IDLE).timeToLive(LIVE_TIME).addData("content", content).addData("title", title).build();
			MulticastResult result = sender.send(message, registrationidList, RETRY);

		} catch (IllegalArgumentException e) {

			return false;
		}

		return true;
	}

	// 특정 아이디의 pushmessage를 인덱싱하여 가지고오는 메소드
	@Override
	public List<PushMessageVO> getPushMessageList(String userId) {
		return pushMessageDao.getPushMessageList(userId);
	}

	@Override
	public PushMessageVO getPushMessage() {
		return pushMessageDao.getPushMessage();
	}

	@Override
	public JSONArray getCategoryName() {
		JSONArray jArray = new JSONArray();
		JSONObject jobj = new JSONObject();
		List<Map<String, Object>> list = pushMessageDao.getCategoryName();

		for (int i = 0; i < list.size(); i++) {
			jobj.put("name", list.get(i).get("CATEGORY_NAME"));
			jobj.put("y", list.get(i).get("COUNTING"));
			jArray.add(i, jobj);
		}
		return jArray;
	}

	PushMessageVO createFile(PushMessageVO vo, HttpServletRequest request) {

		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		MultipartFile messageFile = multiRequest.getFile("messageFile");
		String saveDir = obigoUtils.path + "pushmessage" + File.separator;
		File saveDirFile = new File(saveDir);

		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		String fileName = null;
		if (messageFile.getOriginalFilename() != null && !"".equals(messageFile.getOriginalFilename())) {
			fileName = System.nanoTime() + messageFile.getOriginalFilename();
			try {
				messageFile.transferTo(new File(saveDir + fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
			vo.setUploadFile(fileName);
		}

		return vo;
	}
}
