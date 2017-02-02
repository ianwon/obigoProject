package com.obigo.obigoproject.api.service;

import java.util.List;

import com.obigo.obigoproject.vo.ApiVO;

public interface ApiService {

	public boolean insertApi(ApiVO vo);

	public boolean updateApi(ApiVO vo);

	public boolean deleteApi(String url);

	// 전체 API 가져오는 메소드
	public List<ApiVO> getApiList();

	// 특정 API를 가져오는 메소드
	public ApiVO getApi(String url);
}
