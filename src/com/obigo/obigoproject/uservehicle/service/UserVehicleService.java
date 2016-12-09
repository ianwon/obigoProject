package com.obigo.obigoproject.uservehicle.service;

import java.util.List;

import com.obigo.obigoproject.vo.UserVehicleVO;

public interface UserVehicleService {
	public boolean insertUserVehicle(UserVehicleVO vo);

	public boolean updateUserVehicle(UserVehicleVO vo);

	public boolean deleteUserVehicle(int userVehicleNumber);

	// 해당 유저의 USER_VEHICLE을 가져오기 위함
	public List<UserVehicleVO> getUserVehicleList(String userId);

	// 안드로이드에서 상세보기를 할때 차량의 정보를 가져오기 위함
	public UserVehicleVO getUserVehicle(int userVehicleNumber);
	
	public List<String> getLocation();
}
