package com.douzone.jblog.repository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;
import com.douzone.jblog.vo.UserVo;

@Repository
public class BlogMainRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public boolean join(UserVo vo) {
		if(sqlSession.insert("user.join",vo) == 1) {
			return true;
		}
		return false;
	}

	public UserVo login(UserVo vo) {
		return sqlSession.selectOne("user.login", vo);
	}

	public List<CategoryVo> findCategory(String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		return sqlSession.selectList("blogmain.findcategory",map);
	}

	public PostVo findPostview(Long no) {
		return  sqlSession.selectOne("blogmain.findpostview",no);
	}
	
	public PostVo findPost(Long no) {
		return  sqlSession.selectOne("blogmain.findpostone",no);
	}

	public List<PostVo> findPostList(Long no) {
		return sqlSession.selectList("blogmain.findpostlist", no);
	}

	public boolean findUser(String id) {
		int a = sqlSession.selectOne("blogmain.finduser",id);
		if(a == 1) {
			return false;
		}
		return true;
	}

}
