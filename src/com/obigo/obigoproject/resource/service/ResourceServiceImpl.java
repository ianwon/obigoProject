package com.obigo.obigoproject.resource.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obigo.obigoproject.resource.dao.ResourceDao;
import com.obigo.obigoproject.vo.ResourceVO;


@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	ResourceDao resourceDao;
	
	// RESOURCE 등록
	@Override
	public boolean insertResource(ResourceVO vo) {
		int resultCount=0;
		
		resultCount=resourceDao.insertResource(vo);
		
		if(resultCount==1)
			return true;
		else
			return false;
		
	}

	// RESOURCE 수정
	@Override
	public boolean updateResource(ResourceVO vo) {
		int resultCount=0;
		
		resultCount=resourceDao.updateResource(vo);
		
		if(resultCount==1)
			return true;
		else
			return false;
	}

	// RESOURCE 삭제
	@Override
	public boolean deleteResource(int resourceNumber) {
		int resultCount=0;
		
		resultCount=resourceDao.deleteResource(resourceNumber);
		
		if(resultCount==1)
			return true;
		else
			return false;
		
	}

	// 선택된 BUNDLE의 RESOURCE 목록을 얻어온다
	@Override
	public List<ResourceVO> getResourceList(String bundleKey) {
		return resourceDao.getResourceList(bundleKey);
	}

	// 선택된 BUNDLE 중 선태한 한개의 RESOURCE를 얻어온다 
	@Override
	public ResourceVO getResource(int resourceNumber) {
		return resourceDao.getResource(resourceNumber);
	}

}
