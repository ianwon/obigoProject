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
import com.obigo.obigoproject.util.obigoUtils;
import com.obigo.obigoproject.vo.BundleVO;

@Service("bundleService")
public class BundleServiceImpl implements BundleService {

	@Autowired
	BundleDao bundleDao;

	@Override
	public boolean insertBundle(BundleVO vo, HttpServletRequest request) {

		vo = createFile(vo, request);
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

	// 전체 Bundle 리스트를 가져오기 위한 메소드
	@Override
	public List<BundleVO> getBundleList() {
		return bundleDao.getBundleList();
	}

	// Primary Key인 bundleVersion을 통해 특정 Bundle 정보를 가져오기 위한 메소드
	@Override
	public BundleVO getBundleBybundleVersion(String bundleVersion) {
		return bundleDao.getBundleBybundleVersion((bundleVersion));
	}

	// BundleKey를 통해 특정 Bundle 정보를 가져오기 위한 메소드
	@Override
	public BundleVO getBundleBybundleKey(String bundleKey) {
		return bundleDao.getBundleBybundleKey(bundleKey);
	}

	// Bundle 파일 저장하는 경로에 필요한 폴더 생성 및 업로드 하는 메서드
	BundleVO createFile(BundleVO vo, HttpServletRequest request) {

		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		MultipartFile bundleFile = multiRequest.getFile("bundleFile");
		String saveDir = obigoUtils.getPath() + "bundle" + File.separator;
		File saveDirFile = new File(saveDir);

		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		String fileName = null;
		if (bundleFile.getOriginalFilename() != null && !"".equals(bundleFile.getOriginalFilename())) {
			fileName = System.nanoTime() + bundleFile.getOriginalFilename();
			try {
				bundleFile.transferTo(new File(saveDir + File.separator + fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
			vo.setFileUpload(fileName);
		}

		return vo;
	}

}