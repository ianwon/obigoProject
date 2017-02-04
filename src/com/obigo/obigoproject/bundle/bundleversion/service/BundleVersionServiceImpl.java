package com.obigo.obigoproject.bundle.bundleversion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obigo.obigoproject.bundle.bundle.dao.BundleDao;
import com.obigo.obigoproject.bundle.bundleversion.dao.BundleVersionDao;
import com.obigo.obigoproject.bundle.bundleversion.vo.BundleVersionVO;

@Service("bundleVersionService")
public class BundleVersionServiceImpl implements BundleVersionService {
	@Autowired
	BundleDao bundleDao;
	@Autowired
	BundleVersionDao bundleVersionDao;

	@Override
	public boolean insertBundleVersion(BundleVersionVO vo) {
		int result = bundleVersionDao.insertBundleVersion(vo);
		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateBundleVersion(BundleVersionVO vo) {
		int result = bundleVersionDao.updateBundleVersion(vo);
		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteBundleVersion(String bundleVersion) {
		int result = bundleVersionDao.deleteBundleVersion(bundleVersion);
		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public String getBundleVersion() {
		return bundleVersionDao.getBundleVersion();
	}

}
