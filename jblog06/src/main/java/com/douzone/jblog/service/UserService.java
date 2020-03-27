package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.UserRepository;
import com.douzone.jblog.vo.UserVo;


@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public boolean join(UserVo vo) {
		userRepository.join(vo);
		userRepository.joinBlog(vo);
		return userRepository.joinCategory(vo);
		
	}

	public UserVo login(UserVo vo) {
		return userRepository.login(vo);
		
	}

}
