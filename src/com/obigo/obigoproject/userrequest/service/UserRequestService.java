package com.obigo.obigoproject.userrequest.service;

import java.util.List;

import com.obigo.obigoproject.vo.UserRequestVO;

public interface UserRequestService {
	public boolean insertUserRequest(UserRequestVO vo);

	public boolean updateUserRequest(UserRequestVO vo);

	public boolean deleteUserRequest(int userRequestNumber);

	// 유저의 요청 전부를 가져오는 메서드
	public List<UserRequestVO> getUserRequestList();

	public boolean acceptUserRequest(int userRequestNumber);
}
