package com.obigo.obigoproject.user.userrequest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.user.userrequest.vo.UserRequestVO;

@Repository("userRequestDao")
public class UserRequestDaoImpl implements UserRequestDao {
	@Autowired
	SqlSession sqlSession;

	// 유저의 요청을 USER_REQUEST DB에 등록
	@Override
	public int insertUserRequest(UserRequestVO vo) {
		return sqlSession.insert("obigoproject.UserRequest.insertUserRequest", vo);
	}

	@Override
	public int updateUserRequest(UserRequestVO vo) {
		return sqlSession.update("obigoproject.UserRequest.updateUserRequest", vo);
	}

	// 유저의 요청을 USER_REQUEST DB에서 삭제
	@Override
	public int deleteUserRequest(int userRequestNumber) {
		return sqlSession.delete("obigoproject.UserRequest.deleteUserRequest", userRequestNumber);
	}

	// 유저의 요청 리스트 전부를 USER_REQUEST DB에서 가져오기 위함
	@Override
	public List<UserRequestVO> getUserRequestList() {
		return sqlSession.selectList("obigoproject.UserRequest.selectUserRequestList");
	}

	// 특정 유저 요청을 DB에서 가져오기 위함
	@Override
	public UserRequestVO getUserRequest(int userRequestNumber) {

		return sqlSession.selectOne("obigoproject.UserRequest.selectUserRequest", userRequestNumber);
	}

}
