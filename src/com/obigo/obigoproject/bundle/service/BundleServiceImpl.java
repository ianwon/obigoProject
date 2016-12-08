package com.obigo.obigoproject.bundle.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.obigo.obigoproject.bundle.dao.BundleDao;
import com.obigo.obigoproject.vo.BundleVO;

@Service("bundleService")
public class BundleServiceImpl implements BundleService {

	@Autowired
	BundleDao bundleDao;

	@Override
	public boolean insertBundle(BundleVO vo, HttpServletRequest request) {
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multiRequest.getFile("bundleFile");
		String path = "c:\\obigo\\bundle\\" + file.getOriginalFilename();
		File f = new File(path);
		try {
			file.transferTo(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		vo.setFileUpload(path);
		int result = bundleDao.insertBundle(vo);

		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateBundle(BundleVO vo) {
		int result = bundleDao.updateBundle(vo);

		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteBundle(String bundleVersion) {
		int result = bundleDao.deleteBundle(bundleVersion);

		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public List<BundleVO> getBundleList() {
		return bundleDao.getBundleList();
	}

	@Override
	public BundleVO getBundleBybundleVersion(String bundleVersion) {
		return bundleDao.getBundleBybundleVersion((bundleVersion));
	}

	@Override
	public BundleVO getBundleBybundleKey(String bundleKey) {
		return bundleDao.getBundleBybundleKey(bundleKey);
	}

}
