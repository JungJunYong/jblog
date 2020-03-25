package com.douzone.jblog.vo;

import org.springframework.web.multipart.MultipartFile;

public class BlogVo {
	private String id;
	private String title;
	private String logo;
	private MultipartFile multipartFile;

	
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
	@Override
	public String toString() {
		return "BlogVo [id=" + id + ", title=" + title + ", logo=" + logo + "]";
	}

}
