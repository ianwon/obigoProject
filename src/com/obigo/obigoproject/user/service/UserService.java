package com.obigo.obigoproject.user.service;

import java.util.List;
import java.util.Map;

import com.obigo.obigoproject.vo.UsersVO;

public interface UserService {
	public boolean insertUser(UsersVO vo);

	public boolean updateUser(UsersVO vo);

	public boolean deleteUser(String userId);

	public List<UsersVO> getUserList();
	
	public List<UsersVO> getAdminList();
	
	// ID 검색을 통한 Login 통계를 출력할 때 대상에 해당하는 User ID의 목록을 출력하기 위함
	public List<UsersVO> getLoginUserList(String userId);

	// 해당 유저의 USERVEHICLE 찾기위함
	public UsersVO getUser(String userId);

	// LOCATION에 따른 PUSH메시지를 전송하기 위해 REGISTRATION_ID를 추출
	public List<String> getRegistrationByLocation(String location);

	// VEHICLE_NAME에 따른 PUSH메시지를 전송하기 위해 REGISTRATION_ID를 추출
	public List<String> getRegistrationByModelCode(String modelCode);

	public boolean idCheck(String userId);

	public boolean passwordCheck(String userId, String password);
	
	public int getUserCount();
	
	public List<Integer> getMonthUserCount();

}
