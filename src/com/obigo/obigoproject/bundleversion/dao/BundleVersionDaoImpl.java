package com.obigo.obigoproject.bundleversion.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.vo.BundleVersionVO;

/*
 * BundleVersion DB에서 번들버전 데이터를 입력, 수정, 삭제, 리스트 호출등
 * BundleVersion DB와 접근하기 위한 BundleVersion Class  
 */
@Repository("bundleVerionDao")
public class BundleVersionDaoImpl implements BundleVersionDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertBundleVersion(BundleVersionVO vo) {
		return sqlSession.insert("obigoproject.BundleVersion.insertBundleVersion", vo);
	}

	@Override
	public int updateBundleVersion(BundleVersionVO vo) {
		return sqlSession.update("obigoproject.BundleVersion.updateBundleVersion", vo);
	}

	@Override
	public int deleteBundleVersion(String bundleVersion) {
		return sqlSession.delete("obigoproject.BundleVersion.deleteBundleVersion", bundleVersion);
	}

	@Override
	public String getBundleVersion() {
		return sqlSession.selectOne("obigoproject.BundleVersion.selectBundleVersion");
	}

}