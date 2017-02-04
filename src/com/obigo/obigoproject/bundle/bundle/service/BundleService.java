package com.obigo.obigoproject.bundle.bundle.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.obigo.obigoproject.bundle.bundle.vo.BundleVO;

public interface BundleService {

	public boolean insertBundle(BundleVO vo, HttpServletRequest request);

	public boolean updateBundle(BundleVO vo);

	public boolean deleteBundle(String bundleVersion);

	public List<BundleVO> getBundleList();

	// 번들 한개 가져오는것도 필요할 것 같아서 만들어봤어.
	public BundleVO getBundleBybundleVersion(String bundleVersion);

	public BundleVO getBundleBybundleKey(String bundleKey);
}
