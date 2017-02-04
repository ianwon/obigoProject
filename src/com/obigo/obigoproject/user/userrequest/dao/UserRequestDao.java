package com.obigo.obigoproject.user.userrequest.dao;

import java.util.List;

import com.obigo.obigoproject.user.userrequest.vo.UserRequestVO;

public interface UserRequestDao {
	
	// 유저의 요청을 USER_REQUEST DB에 등록
	public int insertUserRequest(UserRequestVO vo);

	public int updateUserRequest(UserRequestVO vo);

	// 유저의 요청을 USER_REQUEST DB에서 삭제
	public int deleteUserRequest(int userRequestNumber);

	// 유저의 요청 리스트 전부를 USER_REQUEST DB에서 가져오기 위함
	public List<UserRequestVO> getUserRequestList();
	
	//특정 유저 요청을 DB에서 가져오기 위함
	public UserRequestVO getUserRequest(int userRequestNumber);
}
