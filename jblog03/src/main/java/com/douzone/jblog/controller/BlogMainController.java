package com.douzone.jblog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.jblog.service.AdminService;
import com.douzone.jblog.service.BlogMainService;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;

@Controller
@RequestMapping("/{id:(?!assets).*}")
public class BlogMainController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	BlogMainService blogMainService;
	
	@RequestMapping(value= {"/{categoryNo}","/{categoryNo}/{postNo}",""},method = RequestMethod.GET)
	public String index(Model model,@PathVariable("id")Optional<String> id,
			@PathVariable("categoryNo")Optional<Long> categoryNo ,
			@PathVariable("postNo")Optional<Long> postNo) {
		Long no,ptNo;

		if(categoryNo.isPresent()) {
			no = categoryNo.get();
		}else {
			no = adminService.categoryFindOne(id.get());
		}
		if(postNo.isPresent()) {
			ptNo = postNo.get();
		}else {
			ptNo = blogMainService.findPost(no);
		}
		List <CategoryVo> categoryList = blogMainService.findCategory(id.get());
		BlogVo blogVo = adminService.basicFind(id.get());
		
		List <PostVo> postList = blogMainService.findPostList(no);
		PostVo vo = blogMainService.findPostview(ptNo);
		System.out.println(vo);
		
		model.addAttribute("id",id.get());
		model.addAttribute("vo", blogVo);
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("postvo",vo);
		model.addAttribute("postList",postList);
		return "blog/blog-main";
	}
	
	

}
