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
import com.obigo.obigoproject.vo.ResourceVO;

@Service("bundleService")
public class BundleServiceImpl implements BundleService {

	@Autowired
	BundleDao bundleDao;

	@Override
	public boolean insertBundle(BundleVO vo, HttpServletRequest request) {

		createFile(vo, request);
		int result = bundleDao.insertBundle(vo);

		if (result == 1)
			return true;
		else
			return false;
	}

	// Bundle 파일 저장하는 경로에 필요한 폴더 생성 및 업로드 하는 메서드
	BundleVO createFile(BundleVO vo, HttpServletRequest request) {

		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		MultipartFile bundleFile = multiRequest.getFile("bundleFile");
		String saveDir = "c:\\obigo\\bundle";
		File saveDirFile = new File(saveDir);

		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		String saveRealPath = "";

		if (bundleFile.getOriginalFilename() != null && !"".equals(bundleFile.getOriginalFilename())) {
			saveRealPath = saveDir + File.separator + bundleFile.getOriginalFilename();

			try {
				bundleFile.transferTo(new File(saveRealPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
			vo.setFileUpload(saveRealPath);

		}

		return vo;
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
