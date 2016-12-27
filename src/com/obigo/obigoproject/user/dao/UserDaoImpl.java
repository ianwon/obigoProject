package com.obigo.obigoproject.user.dao;

import java.util.List;

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

	@Override
	public List<String> getRegistrationIdByLocation(String location) {
		return sqlsession.selectList("obigoproject.User.selectRegistrationIdByLocation", location);
	}

	@Override
	public List<String> getRegistrationByModelCode(String modelCode) {
		return sqlsession.selectList("obigoproject.User.selectRegistrationIdByModelCode", modelCode);
	}

	@Override
	public int getUserCount() {
		return sqlsession.selectOne("obigoproject.User.selectUserCount");
	}

	@Override
	public List<UsersVO> getLoginUserList(String userId){
		return sqlsession.selectList("obigoproject.User.selectLoginUserList", userId);
	}

}
