package com.obigo.obigoproject.resource.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.obigo.obigoproject.vo.ResourceVO;

public interface ResourceService {

	// RESOURCE 등록
	public boolean insertResource(ResourceVO vo, HttpServletRequest request);

	// RESOURCE 수정
	public boolean updateResource(ResourceVO vo);

	// RESOURCE 삭제
	public boolean deleteResource(int resourceNumber);

	// 선택된 BUNDLE의 RESOURCE 목록을 얻어온다
	public List<ResourceVO> getResourceListBybundleKey(String bundleKey);

	// Resource 전체 리스트
	public List<ResourceVO> getResourceList();

	// 선택된 BUNDLE 중 선태한 한개의 RESOURCE를 얻어온다
	public ResourceVO getResource(int resourceNumber);
}
