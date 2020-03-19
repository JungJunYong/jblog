package com.douzone.jblog.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.jblog.repository.AdminRepository;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepository;
	
	private static final String SAVE_PATH = "/Users/jun/jblog-uploads";
	private static final String URL = "/assets/upimages";
	
	public BlogVo basicFind(String id) {
		return adminRepository.basicFind(id);

	}

	
	
	public String basicUpdate(BlogVo vo) {
		String url = "";
		try {
			MultipartFile multipartFile = vo.getMultipartFile();
		if(multipartFile.isEmpty()) {
			vo.setLogo(adminRepository.basicFind(vo.getId()).getId());
			adminRepository.basicUpdate(vo);
			return url;
		}
		
		String originFilename = multipartFile.getOriginalFilename();
		String extName = originFilename.substring(originFilename.lastIndexOf('.') + 1);
		
		String saveFilename = generateSeaveFilename(extName);
		long fileSize = multipartFile.getSize();
		
	
		byte[] fileData = multipartFile.getBytes();
		OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
		os.write(fileData);
		os.close();
		url = URL + "/" + saveFilename;
		vo.setLogo(url);
		adminRepository.basicUpdate(vo);
		
	}catch(IOException ex) {
		throw new RuntimeException("file upload error:" + ex);
	}
		return url;
}

	private String generateSeaveFilename(String extName) {
		String filename = "";
		Calendar calendar = Calendar.getInstance();
		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += ("."+extName);
		return filename;
	}

	public List<CategoryVo> categoryFind(String id){
		return adminRepository.categoryFind(id);
	}
	
	public void categoryInsert(CategoryVo categoryVo) {
		adminRepository.categoryInsert(categoryVo);
		
	}



	public void postWrite(PostVo vo) {
		adminRepository.postWrite(vo);
		
	}



	public void categoryDelete(Long no) {
		adminRepository.categoryDelete(no);
		
	}



	public Long categoryFindOne(String id) {
		return adminRepository.categoryFindOne(id);
	}

}
