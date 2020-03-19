package com.douzone.jblog.repository;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.UserVo;

@Repository
public class UserRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public boolean join(UserVo vo) {
		if(sqlSession.insert("user.join",vo) == 1) {
			return true;
		}
		return false;
	}
	public boolean joinBlog(UserVo vo) {
		if(sqlSession.insert("user.joinblog",vo) == 1) {
			return true;
		}
		return false;
	}
	public boolean joinCategory(UserVo vo) {
		if(sqlSession.insert("user.joincategory",vo) == 1) {
			return true;
		}
		return false;
	}

	public UserVo login(UserVo vo) {
		return sqlSession.selectOne("user.login", vo);
	}

}
