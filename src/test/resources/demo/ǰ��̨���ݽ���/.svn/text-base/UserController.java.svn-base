package net.bingo.vote.controller.users;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.bingo.vote.common.JsonData;
import net.bingo.vote.service.users.UserService;
import net.bingo.vote.utils.JspModel;

@Controller
public class UserController {
	
	@Resource
	UserService userService;

	@ResponseBody
	@RequestMapping("/users2")
	public JsonData getMessage(String key){
		
		JsonData json = new JsonData();
		try {
			//System.out.println(key);
			System.out.println(key);
			//{"orgId":"e45b774a-9e2d-4c22-8d66-645167ae8fcf","picture":"https:\/\/www.bingolink.biz\/uam\/ui\/upload?action=download
			json.setSuccess(true);
			json.setMsg("添加成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
}
