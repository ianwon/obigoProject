package com.obigo.obigoproject.user.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public boolean idCheck(String userId, String roleName) {
		UsersVO userVO = userDao.getUser(userId);

		if (null == userVO || !roleName.equals(userVO.getRoleName()))
			return true;
		else
			return false;
	}

	@Override
	public boolean passwordCheck(String userId, String password, String roleName) {
		if (!idCheck(userId, roleName)) {
			UsersVO userVO = userDao.getUser(userId);

			if (password.equals(userVO.getPassword()) && roleName.equals(userVO.getRoleName()))
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

	@Override
	public List<UsersVO> getLoginUserList(String userId) {
		return userDao.getLoginUserList(userId);
	}

	@Override
	public List<Integer> getMonthUserCount() {
		List<Integer> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		Calendar cal = Calendar.getInstance();
		map.put("year", cal.get(Calendar.YEAR) - 2000);
		map.put("month", "%");
		int total = userDao.getMonthUserCount(map);
		for (int i = 1; i <= 12; i++) {

			if (i < 10) {
				map.put("month", "0" + i);
			} else {
				map.put("month", i + "");
			}

			list.add((int) (((float) userDao.getMonthUserCount(map) / total) * 100));
		}
		return list;
	}

	// 번들 업데이트 수랑 사용자수 최근 8개월치 비교하기 위해 ... 일단 만듬 이름변경 하고 해야함
	@Override
	public List<Integer> getMonthUserCount2() { // 번들 업데이트 수랑 사용자수 최근 8개월치 비교하기 위해 ... 일단 만듬 이름변경 하고 해야함
		List<Integer> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		Calendar cal = Calendar.getInstance();
		map.put("year", new Integer(cal.get(Calendar.YEAR) - 2000));
		int month = cal.get(Calendar.MONTH) + 1;
		for (int i = 0; i < 8; i++) {
			if (month == 0) {
				map.put("year", new Integer(cal.get(Calendar.YEAR) - 2000 - 1));
				month = 12;
			}
			map.put("month", month);
			list.add(userDao.getMonthUserCount(map));
			month--;
		}
		return list;
	}
	
	@Override
	public List<UsersVO> findIDPW(String name, String email){
		Map<String, String> map=new HashMap<>();
		map.put("name", name);
		map.put("email", email);
		
		return userDao.findIDPW(map);
	}

	@Override
	public boolean updatePassword(String userId, String password, String newpassword) {
		Map<String, String> map = new HashMap<>();
		map.put("userId", userId);
		map.put("password", password);
		map.put("newpassword", newpassword);
		
		int resultcount = userDao.updatePassword(map);
		if (resultcount == 1)
			return true;
		else
			return false;
	}


}