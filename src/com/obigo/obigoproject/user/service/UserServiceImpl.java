package com.obigo.obigoproject.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obigo.obigoproject.user.dao.UserDao;
import com.obigo.obigoproject.vo.UsersVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	// user 등록
	@Override
	public boolean insertUser(UsersVO vo) {
		int resultcount = userDao.insertUser(vo);
		if (resultcount == 1)
			return true;
		else
			return false;
	}

	// user 정보 수정
	@Override
	public boolean updateUser(UsersVO vo) {
		int resultcount = userDao.updateUser(vo);
		if (resultcount == 1)
			return true;
		else
			return false;
	}

	// user 삭제
	@Override
	public boolean deleteUser(String userId) {
		int resultcount = userDao.deleteUser(userId);
		if (resultcount == 1)
			return true;
		else
			return false;
	}

	// userList 가져오기
	@Override
	public List<UsersVO> getUserList() {
		return userDao.getUserList();
	}

	// adminList 가져오기
	@Override
	public List<UsersVO> getAdminList() {
		return userDao.getAdminList();
	}

	// userId 로 usersvo 가져오기
	@Override
	public UsersVO getUser(String userId) {
		return userDao.getUser(userId);
	}

	// GCM용///location으로 registrationid가져오기
	@Override
	public List<String> getRegistrationByLocation(String location) {
		return userDao.getRegistrationIdByLocation(location);
	}

	// GCM용///modelcode로 registrationid가져오기
	@Override
	public List<String> getRegistrationByModelCode(String modelCode) {
		return userDao.getRegistrationByModelCode(modelCode);
	}

	// id 중복체크 //중복이면 false 가능하면 true
	// 로그인 id체크
	@Override
	public boolean idCheck(String userId) {
		if (null == userDao.getUser(userId))
			return true;
		else
			return false;
	}

	@Override
	public boolean passwordCheck(String userId, String password) {
		if (!idCheck(userId)) {
			if (password.equals(userDao.getUser(userId).getPassword()))
				return true; // 둘다맞음
			else
				return false; // 패스워드가 틀림
		} else
			return false; // 아이디가 틀림
	}

	@Override
	public int getUserCount() {
		return userDao.getUserCount();
	}
}
