package com.douzone.jblog.vo;

public class CommentVo {
	private String commentId;
	private String postId;
	private String content;
	private String regDate;
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "CommentVo [commentId=" + commentId + ", postId=" + postId + ", content=" + content + ", regDate="
				+ regDate + "]";
	}
	

}
