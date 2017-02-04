package com.obigo.obigoproject.bundle.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.vo.BundleVO;

/*
 * Bundle DB에서 번들 데이터를 입력, 수정, 삭제, 리스트 호출등
 * Bundle DB와 접근하기 위한 Bundle Class  
 */
@Repository("bundleDao")
public class BundleDaoImpl implements BundleDao {

	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertBundle(BundleVO vo) {
		return sqlSession.insert("obigoproject.Bundle.insertBundle", vo);
	}

	@Override
	public int updateBundle(BundleVO vo) {
		return sqlSession.update("obigoproject.Bundle.updateBundle", vo);
	}

	@Override
	public int deleteBundle(String bundleVersion) {
		return sqlSession.delete("obigoproject.Bundle.deleteBundle", bundleVersion);
	}

	// 전체 Bundle 리스트를 가져오기 위한 메소드
	@Override
	public List<BundleVO> getBundleList() {
		return sqlSession.selectList("obigoproject.Bundle.selectBundleList");
	}

	// Primary Key인 bundleVersion을 통해 특정 Bundle 정보를 가져오기 위한 메소드
	@Override
	public BundleVO getBundleBybundleVersion(String bundleVersion) {
		return sqlSession.selectOne("obigoproject.Bundle.selectBundleBybundleVersion", bundleVersion);
	}

	// BundleKey를 통해 특정 Bundle 정보를 가져오기 위한 메소드
	@Override
	public BundleVO getBundleBybundleKey(String bundleKey) {
		return sqlSession.selectOne("obigoproject.Bundle.selectBundleBybundleKey", bundleKey);
	}

}
