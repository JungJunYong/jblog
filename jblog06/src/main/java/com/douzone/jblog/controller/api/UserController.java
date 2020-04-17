package com.douzone.jblog.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.jblog.dto.JsonResult;
import com.douzone.jblog.service.AdminService;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.security.Auth;


@Auth
@RestController("UserApiController")
@RequestMapping("/{id}/api/category")
public class UserController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/list")
	public JsonResult list(@PathVariable("id")Optional<String> id) {
		List<CategoryVo> list = adminService.categoryFind(id.get());
		return JsonResult.success(list);
	}
	
	@PostMapping("/list/add")
	public JsonResult addCategory(@PathVariable("id")Optional<String> id,@RequestBody CategoryVo vo) {
		System.out.println(vo);
		adminService.categoryInsert(vo);
		return JsonResult.success(vo);
	}
	

	@DeleteMapping("/list/delete/{no}")
	public JsonResult deleteCategory(@PathVariable("id")Optional<String> id,@PathVariable("no") Long no) {
		adminService.categoryDelete(no);
		return JsonResult.success(no);
	}
	

//		jsonResult.setMessage("");

//		Map<String, Object> map = new HashMap<>();
//		map.put("result", exist ? "exist" : "not exist");
//		return jsonResult;
}
