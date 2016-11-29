package com.obigo.obigoproject.api.dao;

import java.util.List;

import com.obigo.obigoproject.vo.ApiVO;

public interface ApiDao {

	public int insertApi(ApiVO vo);

	public int updateApi(ApiVO vo);

	public int deleteApi(String apiName);

	// 전체 API 가져오는 메소드
	public List<ApiVO> getApiList();

	// 특정 API를 가져오는 메소드
	public ApiVO getApi(String apiName);

}
