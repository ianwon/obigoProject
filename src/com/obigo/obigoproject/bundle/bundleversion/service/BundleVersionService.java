package com.obigo.obigoproject.bundle.bundleversion.service;

import com.obigo.obigoproject.bundle.bundleversion.vo.BundleVersionVO;

public interface BundleVersionService {
	public boolean insertBundleVersion(BundleVersionVO vo);

	//컬럼 추가 안되면 String bundleVersion으로 받아도 가능예정
	public boolean updateBundleVersion(BundleVersionVO vo);

	public boolean deleteBundleVersion(String bundleVersion);

	public String getBundleVersion();
	
	
}
