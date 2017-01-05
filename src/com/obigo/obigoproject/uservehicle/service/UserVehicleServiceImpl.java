package com.obigo.obigoproject.uservehicle.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obigo.obigoproject.uservehicle.dao.UserVehicleDao;
import com.obigo.obigoproject.vo.PushMessageVO;
import com.obigo.obigoproject.vo.UserVehicleVO;

@Service("userVehicleService")
public class UserVehicleServiceImpl implements UserVehicleService {
	@Autowired
	UserVehicleDao userVehicleDao;

	@Override
	public boolean insertUserVehicle(UserVehicleVO vo) {
		int resultcount = userVehicleDao.insertUserVehicle(vo);
		if (resultcount == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateUserVehicle(UserVehicleVO vo) {
		int resultcount = userVehicleDao.updateUserVehicle(vo);
		if (resultcount == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteUserVehicle(int userVehicleNumber) {
		int resultcount = userVehicleDao.deleteUserVehicle(userVehicleNumber);
		if (resultcount == 1)
			return true;
		else
			return false;
	}

	@Override
	public List<UserVehicleVO> getUserVehicleList(String userId) {
		return userVehicleDao.getUserVehicleList(userId);
	}

	@Override
	public UserVehicleVO getUserVehicle(int userVehicleNumber) {
		return userVehicleDao.getUserVehicle(userVehicleNumber);
	}

	@Override
	public List<String> getLocation() {
		return userVehicleDao.getLocation();
	}

	@Override
	public List<String> getUserId(PushMessageVO vo) {
		return userVehicleDao.getUserId(vo);
	}

	@Override
	public int getUserVehicleCount() {
		return userVehicleDao.getUserVehicleCount();
	}

	// 차량 모델별 User가 가지고 있는 수를 카운트해서 가져오는 메소드
	@Override
	public List<Map<String, Object>> getCountingByModelName() {
		return userVehicleDao.getCountingByModelName();
	}

}
