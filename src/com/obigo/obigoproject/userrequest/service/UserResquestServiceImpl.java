package com.obigo.obigoproject.userrequest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obigo.obigoproject.userrequest.dao.UserRequestDao;
import com.obigo.obigoproject.uservehicle.dao.UserVehicleDao;
import com.obigo.obigoproject.vo.UserRequestVO;
import com.obigo.obigoproject.vo.UserVehicleVO;

@Service("userRequestService")
public class UserResquestServiceImpl implements UserRequestService {
	@Autowired
	UserRequestDao userRequestDao;
	@Autowired
	UserVehicleDao userVehicleDao;

	@Override
	public boolean insertUserRequest(UserRequestVO vo) {
		int resultcount = userRequestDao.insertUserRequest(vo);
		if (resultcount == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateUserRequest(UserRequestVO vo) {
		int resultcount = userRequestDao.updateUserRequest(vo);
		if (resultcount == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteUserRequest(int userRequestNumber) {
		int resultcount = userRequestDao.deleteUserRequest(userRequestNumber);
		if (resultcount == 1)
			return true;
		else
			return false;
	}

	// 유저의 요청 전부를 가져오는 메서드
	@Override
	public List<UserRequestVO> getUserRequestList() {

		return userRequestDao.getUserRequestList();
	}

	// 유저 차량 등록 요청을 수락하면
	// 유저 차량 객체를 만들어서 DB에 저장하고
	// 해당 UserRequest를 db에서 삭제한다. DAMN
	@Override
	public boolean acceptUserRequest(int userRequestNumber) {
		UserRequestVO vo = userRequestDao.getUserRequest(userRequestNumber);

		UserVehicleVO userVehicleVO = new UserVehicleVO();

		userVehicleVO.setColor(vo.getColor());
		userVehicleVO.setLocation(vo.getLocation());
		userVehicleVO.setModelCode(vo.getModelCode());
		userVehicleVO.setUserId(vo.getUserId());
		userVehicleVO.setVin(vo.getVin());
		userVehicleVO.setUserVehicleNumber(0);
		userVehicleVO.setActiveDtcCount(0);

		// 유저 요청 정보를 USER_VEHICLE DB에 등록해준다.
		int resultUserVehicle = userVehicleDao.insertUserVehicle(userVehicleVO);

		// USER_VEHICLE DB에 정보가 제대로 등록되면 true를 return
		if (resultUserVehicle == 1) {
			userRequestDao.deleteUserRequest(vo.getUserRequestNumber());
			return true;
		} else
			return false;

	}

}
