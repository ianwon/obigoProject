package com.obigo.obigoproject.bundle.dao;

import java.util.List;

import com.obigo.obigoproject.vo.BundleVO;

public interface BundleDao {

	public int insertBundle(BundleVO vo);

	public int updateBundle(BundleVO vo);

	public int deleteBundle(String bundleVersion);

	public List<BundleVO> getBundleList();

	// 번들 한개 가져오는것도 필요할 것 같아서 만들어봤어.
	public BundleVO getBundleBybundleVersion(String bundleVersion);
	
	public BundleVO getBundleBybundleKey(String bundleKey);

}
