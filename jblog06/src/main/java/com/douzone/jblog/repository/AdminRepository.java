package com.douzone.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;

@Repository
public class AdminRepository {
	
	@Autowired
	private SqlSession sqlSession;

	public BlogVo basicFind(String id) {
		return sqlSession.selectOne("admin.basicfind",id);
		
	}

	public void basicUpdate(BlogVo vo) {
		 sqlSession.update("admin.basicupdate", vo);
	}

	public void categoryInsert(CategoryVo categoryVo) {
		sqlSession.insert("admin.categoryinsert",categoryVo);
		
	}
	
	public List<CategoryVo> categoryFind(String id) {
		return sqlSession.selectList("admin.categoryfind",id);
		
	}

	public void postWrite(PostVo vo) {
		sqlSession.insert("admin.postwrite",vo);
		
	}

	public int categoryDelete(Long no) {
		return sqlSession.delete("admin.categorydelete",no);
		
	}

	public Long categoryFindOne(String id) {
		Long no = sqlSession.selectOne("admin.categoryfindone", id);
		return no;
	}
	

}
