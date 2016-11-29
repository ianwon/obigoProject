package com.obigo.obigoproject.api.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.vo.ApiVO;

@Repository("apiDao")
public class ApiDaoImpl implements ApiDao {

	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertApi(ApiVO vo) {
		return sqlSession.insert("obigoproject.Api.insertApi", vo);
	}

	@Override
	public int updateApi(ApiVO vo) {
		return sqlSession.update("obigoproject.Api.updateApi", vo);
	}

	@Override
	public int deleteApi(String apiName) {
		return sqlSession.delete("obigoproject.Api.deleteApi", apiName);
	}

	@Override
	public List<ApiVO> getApiList() {
		return sqlSession.selectList("obigoproject.Api.selectApiList");
	}

	@Override
	public ApiVO getApi(String apiName) {
		return sqlSession.selectOne("obigoproject.Api.selectApi", apiName);
	}

}