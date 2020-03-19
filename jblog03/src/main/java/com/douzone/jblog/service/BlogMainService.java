package com.douzone.jblog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogMainRepository;
import com.douzone.jblog.repository.UserRepository;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;
import com.douzone.jblog.vo.UserVo;


@Service
public class BlogMainService {
	@Autowired
	BlogMainRepository blogMainRepository;
	

	public List<CategoryVo> findCategory(String id) {

		return blogMainRepository.findCategory(id);
	}


	public PostVo findPostview(Long no) {
		return blogMainRepository.findPostview(no);
	}


	public List<PostVo> findPostList(Long no) {
		return blogMainRepository.findPostList(no);
	}

	public Long findPost(Long no) {
		PostVo vo = blogMainRepository.findPost(no);
		return vo.getNo();
	}

}
