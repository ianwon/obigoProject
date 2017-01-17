package com.obigo.obigoproject.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.vo.UsersVO;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	SqlSession sqlsession;

	@Override
	public int insertUser(UsersVO vo) {
		return sqlsession.insert("obigoproject.User.insertUser", vo);
	}

	@Override
	public int updateUser(UsersVO vo) {
		return sqlsession.update("obigoproject.User.updateUser", vo);
	}

	@Override
	public int deleteUser(String userId) {
		return sqlsession.delete("obigoproject.User.deleteUser", userId);
	}

	@Override
	public List<UsersVO> getUserList() {
		return sqlsession.selectList("obigoproject.User.selectUserList");
	}

	@Override
	public List<UsersVO> getAdminList() {
		return sqlsession.selectList("obigoproject.User.selectAdminList");
	}

	@Override
	public UsersVO getUser(String userId) {
		return sqlsession.selectOne("obigoproject.User.selectUser", userId);
	}

	// 특정 location 차량 가지고 있는 user의 RegistrationId List를 가져오는 메소드
	@Override
	public List<String> getRegistrationIdByLocation(String location) {
		return sqlsession.selectList("obigoproject.User.selectRegistrationIdByLocation", location);
	}

	// 특정 차량 model을 가지고 있는 user의 RegistrationId List를 가져오는 메소드
	@Override
	public List<String> getRegistrationByModelCode(String modelCode) {
		return sqlsession.selectList("obigoproject.User.selectRegistrationIdByModelCode", modelCode);
	}

	@Override
	public int getUserCount() {
		return sqlsession.selectOne("obigoproject.User.selectUserCount");
	}

	// 유저 검색시 유저 목록을 가져오기 위한 메소드
	@Override
	public List<UsersVO> getLoginUserList(String userId) {
		return sqlsession.selectList("obigoproject.User.selectLoginUserList", userId);
	}

	// 특정 년, 월 별 회원가입 수 카운드하는 메소드
	@Override
	public int getMonthUserCount(Map map) {
		return sqlsession.selectOne("obigoproject.User.selectMonthUserCount", map);
	}
	
	// 사용자가 ID/PW를 찾고자 할 때 요청한 이름과 email 주소를 검증후, email 주소로 ID/PW를 전송 
	@Override
	public UsersVO findIDPW(Map<String, String> map){
		return sqlsession.selectOne("obigoproject.User.selectIDPW", map);
	}

	// 사용자가 비밀번호를 변경
	@Override
	public int updatePassword(Map<String, String> map) {
		return sqlsession.update("obigoproject.User.updatePassword", map);
	}

}
