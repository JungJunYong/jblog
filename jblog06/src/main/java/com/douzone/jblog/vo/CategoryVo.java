package com.douzone.jblog.vo;

public class CategoryVo {
	private Long no;
	private String id;
	private String name;
	private Long count;
	private String description;
	private String regDate;
	
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", id=" + id + ", name=" + name + ", description=" + description
				+ ", regDate=" + regDate + "]";
	}
	

}
