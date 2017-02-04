package com.obigo.obigoproject.user.uservehicle.dao;

import java.util.List;
import java.util.Map;

import com.obigo.obigoproject.message.pushmessage.vo.PushMessageVO;
import com.obigo.obigoproject.user.uservehicle.vo.UserVehicleVO;

public interface UserVehicleDao {
	public int insertUserVehicle(UserVehicleVO vo);

	public int updateUserVehicle(UserVehicleVO vo);

	public int deleteUserVehicle(int userVehicleNumber);

	// 해당 유저의 USER_VEHICLE을 가져오기 위함
	public List<UserVehicleVO> getUserVehicleList(String userId);

	// 안드로이드에서 상세보기를 할때 차량의 정보를 가져오기 위함
	public UserVehicleVO getUserVehicle(int userVehicleNumber);

	// location 리스트를 가지고와야함
	public List<String> getLocation();

	public List<String> getUserId(PushMessageVO vo);

	public int getUserVehicleCount();

	public List<Map<String, Object>> getCountingByModelName();

	public int checkVinNumber(String vin);
}
