package com.obigo.obigoproject.api.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.vo.ApiVO;

/*
 * API Document 를 작성하기위한 데이터를 입력, 수정, 삭제, 리스트 호출등
 * API DB와 접근하기 위한 Dao Class  
 */
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
	
	//API 전체 목록을 가져오기 위한 메소드
	@Override
	public List<ApiVO> getApiList() {
		return sqlSession.selectList("obigoproject.Api.selectApiList");
	}

	//특정 API 정보를 가져오기 위한 메소드
	@Override
	public ApiVO getApi(String apiName) {
		return sqlSession.selectOne("obigoproject.Api.selectApi", apiName);
	}

}