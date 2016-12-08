package com.obigo.obigoproject.resource.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.vo.ResourceVO;

@Repository("resourceDao")
public class ResourceDaoImpl implements ResourceDao {

	@Autowired
	SqlSession sqlsession;

	@Override
	public int insertResource(ResourceVO vo) {
		return sqlsession.insert("obigoproject.Resource.insertResource", vo);
	}

	@Override
	public int updateResource(ResourceVO vo) {
		return sqlsession.update("obigoproject.Resource.updateResource", vo);
	}

	@Override
	public int deleteResource(int resourceNumber) {
		return sqlsession.delete("obigoproject.Resource.deleteResource", resourceNumber);
	}

	@Override
	public List<ResourceVO> getResourceListBybundleKey(String bundleKey) {
		return sqlsession.selectList("obigoproject.Resource.selectResourceListBybundleKey", bundleKey);
	}

	@Override
	public ResourceVO getResource(int resourceNumber) {
		return sqlsession.selectOne("obigoproject.Resource.selectResource", resourceNumber);
	}

	@Override
	public List<ResourceVO> getResourceList() {
		return sqlsession.selectList("obigoproject.Resource.selectResourceList");
	}

}
