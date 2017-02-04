package com.obigo.obigoproject.bundle.bundleversion.dao;

import com.obigo.obigoproject.bundle.bundleversion.vo.BundleVersionVO;

public interface BundleVersionDao {
	public int insertBundleVersion(BundleVersionVO vo);

	public int updateBundleVersion(BundleVersionVO vo);

	public int deleteBundleVersion(String BundleVersion);

	public String getBundleVersion();
	
	

}
