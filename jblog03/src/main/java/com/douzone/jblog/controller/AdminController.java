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
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;
import com.douzone.security.Auth;

@Controller
@Auth
@RequestMapping(value="/{id}/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	
	@RequestMapping(value="/basic",method = RequestMethod.GET)
	public String basic(@PathVariable("id")Optional<String> id,Model model) {
		BlogVo blogVo = adminService.basicFind(id.get());
		model.addAttribute("vo", blogVo);
		return "blog/blog-admin-basic";
	}
	@RequestMapping(value="/basic",method = RequestMethod.POST)
	public String basic(@PathVariable("id")Optional<String> id,BlogVo vo,Model model) {
		vo.setId(id.get());
		adminService.basicUpdate(vo);
		model.addAttribute("vo", vo);
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping(value="/category",method = RequestMethod.GET)
	public String category(@PathVariable("id")Optional<String> id,Model model) {
		BlogVo blogVo = adminService.basicFind(id.get());
		List<CategoryVo> list = adminService.categoryFind(id.get());
		model.addAttribute("vo", blogVo);
		model.addAttribute("categoryList",list);
		return "blog/blog-admin-category";
	}
	@RequestMapping(value="/category/delete/{categoryNo}",method = RequestMethod.GET)
	public String categorydelete(@PathVariable("id")Optional<String> id,
			@PathVariable("categoryNo")Optional<Long> no,
			Model model) {
		Long minNo = adminService.categoryFindOne(id.get());
		if (no.get() == minNo) {
			return "redirect:/"+id.get()+"/admin/category/";
		} else{
			adminService.categoryDelete(no.get());			
			return "redirect:/"+id.get()+"/admin/category/";
		}
	}
	
	@RequestMapping(value="/category",method = RequestMethod.POST)
	public String category(@PathVariable("id")Optional<String> id,Model model,CategoryVo categoryVo) {
		categoryVo.setId(id.get());
		adminService.categoryInsert(categoryVo);
		BlogVo blogVo = adminService.basicFind(id.get());
		model.addAttribute("vo", blogVo);
		return "redirect:/"+id.get()+"/admin/category";
	}
	
	
	
	@RequestMapping(value="/write",method = RequestMethod.GET)
	public String write(@PathVariable("id")Optional<String> id,Model model) {
		List<CategoryVo> list = adminService.categoryFind(id.get());
		BlogVo blogVo = adminService.basicFind(id.get());
		model.addAttribute("list",list);
		model.addAttribute("vo", blogVo);
		return "blog/blog-admin-write";
	}
	
	@RequestMapping(value="/write",method = RequestMethod.POST)
	public String write(@PathVariable("id")Optional<String> id,Model model,PostVo vo) {
		BlogVo blogVo = adminService.basicFind(id.get());
		List<CategoryVo> list = adminService.categoryFind(id.get());
		adminService.postWrite(vo);
		model.addAttribute("list",list);
		model.addAttribute("vo", blogVo);
		return "blog/blog-admin-write";
	}

}
