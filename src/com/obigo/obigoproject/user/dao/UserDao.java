package com.obigo.obigoproject.user.dao;

import java.util.List;
import java.util.Map;

import com.obigo.obigoproject.vo.UsersVO;

public interface UserDao {

	public int insertUser(UsersVO vo);

	public int updateUser(UsersVO vo);

	public int deleteUser(String userId);

	public List<UsersVO> getUserList();

	public List<UsersVO> getAdminList();

	// ID 검색을 통한 Login 통계를 출력할 때 대상에 해당하는 User ID의 목록을 출력하기 위함
	public List<UsersVO> getLoginUserList(String userId);

	// 해당 유저의 USERVEHICLE 찾기위함
	public UsersVO getUser(String userId);

	// LOCATION에 따른 PUSH메시지를 전송하기 위해 REGISTRATION_ID를 추출
	public List<String> getRegistrationIdByLocation(String location);

	// VEHICLE_NAME에 따른 PUSH메시지를 전송하기 위해 REGISTRATION_ID를 추출
	public List<String> getRegistrationByModelCode(String modelCode);

	public int getUserCount();
	
	public int getMonthUserCount(Map map);
}
