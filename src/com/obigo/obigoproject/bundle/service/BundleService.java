package com.obigo.obigoproject.bundle.service;

import java.util.List;

import com.obigo.obigoproject.vo.BundleVO;

public interface BundleService {

	public boolean insertBundle(BundleVO vo);

	public boolean updateBundle(BundleVO vo);

	public boolean deleteBundle(String bundleVersion);

	public List<BundleVO> getBundleList();

	// 번들 한개 가져오는것도 필요할 것 같아서 만들어봤어.
	public BundleVO getBundle(String bundleVersion);
	

}
