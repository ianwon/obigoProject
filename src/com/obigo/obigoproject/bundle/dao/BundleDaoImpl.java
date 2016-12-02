package com.obigo.obigoproject.bundle.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.vo.BundleVO;

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

	@Override
	public List<BundleVO> getBundleList() {
		return sqlSession.selectList("obigoproject.Bundle.selectBundleList");
	}

	@Override
	public BundleVO getBundleBybundleVersion(String bundleVersion) {
		return sqlSession.selectOne("obigoproject.Bundle.selectBundleBybundleVersion", bundleVersion);
	}

	@Override
	public BundleVO getBundleBybundleKey(String bundleKey) {
		return sqlSession.selectOne("obigoproject.Bundle.selectBundleBybundleKey", bundleKey);
	}

}
