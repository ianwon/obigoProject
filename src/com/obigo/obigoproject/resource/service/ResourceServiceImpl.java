package com.obigo.obigoproject.resource.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.obigo.obigoproject.resource.dao.ResourceDao;
import com.obigo.obigoproject.vo.ResourceVO;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	ResourceDao resourceDao;

	// RESOURCE 등록
	@Override
	public boolean insertResource(ResourceVO vo, HttpServletRequest request) {
		int resultCount = 0;

		vo = createFile(vo, request);

		resultCount = resourceDao.insertResource(vo);

		if (resultCount == 1)
			return true;
		else
			return false;

	}

	
	// Resource 파일 저장하는 경로에 필요한 폴더 생성 및 업로드 하는 메서드
	ResourceVO createFile(ResourceVO vo, HttpServletRequest request) {

		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		MultipartFile resourceFile = multiRequest.getFile("resourcePath");
		String saveDir = "/home/ec2-user/obigo/resource/";
		File saveDirFile = new File(saveDir);

		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		String saveRealPath = "";

		if (resourceFile.getOriginalFilename() != null && !"".equals(resourceFile.getOriginalFilename())) {
			saveRealPath = saveDir + File.separator + System.nanoTime() +resourceFile.getOriginalFilename();

			try {
				resourceFile.transferTo(new File(saveRealPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
			vo.setPath(saveRealPath);

		}

			return vo;
	}

	// RESOURCE 수정
	@Override
	public boolean updateResource(ResourceVO vo) {
		int resultCount = 0;

		resultCount = resourceDao.updateResource(vo);

		if (resultCount == 1)
			return true;
		else
			return false;
	}

	// RESOURCE 삭제
	@Override
	public boolean deleteResource(int resourceNumber) {
		int resultCount = 0;

		resultCount = resourceDao.deleteResource(resourceNumber);

		if (resultCount == 1)
			return true;
		else
			return false;

	}

	// 선택된 BUNDLE의 RESOURCE 목록을 얻어온다
	@Override
	public List<ResourceVO> getResourceListBybundleKey(String bundleKey) {
		return resourceDao.getResourceListBybundleKey(bundleKey);
	}

	// 선택된 BUNDLE 중 선태한 한개의 RESOURCE를 얻어온다
	@Override
	public ResourceVO getResource(int resourceNumber) {
		return resourceDao.getResource(resourceNumber);
	}

	@Override
	public List<ResourceVO> getResourceList() {
		return resourceDao.getResourceList();
	}

}
