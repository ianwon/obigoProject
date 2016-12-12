package com.obigo.obigoproject.uservehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obigo.obigoproject.uservehicle.dao.UserVehicleDao;
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

}
