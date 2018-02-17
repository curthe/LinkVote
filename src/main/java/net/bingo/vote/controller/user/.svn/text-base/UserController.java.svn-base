package net.bingo.vote.controller.user;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.bingo.vote.common.Pagination;
import net.bingo.vote.model.user.User;
import net.bingo.vote.model.users.JspModel;
import net.bingo.vote.service.user.UserService;

@Controller
@RequestMapping("/userController")
public class UserController {

	private final static Logger log = Logger.getLogger(UserController.class);

	@Autowired(required = false)
	private UserService userService;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Pagination list() throws Exception {

		return new Pagination();
	}

	/**
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/isRegister")
	@ResponseBody
	public Pagination isRegister(String key) throws Exception {
		if (3 > 1) {
			index(key, 10, 1);
		} else {
			register();

		}
		return new Pagination();
	}

	/**
	 * 执行新增用户操作
	 */
	public Pagination register() throws Exception {

		return new Pagination();
	}

	// 主页数据
	/**
	 * @param rows
	 *            页面显示多少行
	 * @param currentPage
	 *            当前页
	 */
	private Pagination index(String Data, int rows, int currentPage) {
		return userService.findList(Data, rows, currentPage);
	}

	/**
	 * 新增
	 */
	@RequestMapping("/insertUser")
	public void insertUser() {
		System.out.println("dddddddddd");
		User vo = new User();
		vo.setId("ssds-dsds-vfvc");
		vo.setName("王世展");
		vo.setEmail("849061491@qq.com");
		vo.setPicture("sss");
		vo.setPhone("s32323");
		System.out.println(vo);
		userService.insertUser(vo);
		System.out.println(vo);
	}

	/**
	 * 修改
	 */
	@RequestMapping("/updateUser")
	public void updateUser() {
		User vo = new User();
		vo.setId("ssds-dsds-vfvc");
		vo.setName("王世展2");
		userService.updateUser(vo);
		System.out.println(vo);
	}

	/**
	 * 查询
	 */
	@RequestMapping("/selectUser")
	public void selectUser() {
		User vo = new User();
		vo.setId("ssds-dsds-vfvc");
		vo.setName("王世展");
		vo.setEmail("849061491@qq.com");
		userService.selectUser(vo);
		System.out.println(vo);
	}

	/**
	 * 删除
	 */
	@RequestMapping("/deleteUser")
	public void deleteUser() {
		String id="ssds-dsds-vfvc";
		userService.deleteUser(id);
	}
	
	@ResponseBody
	@RequestMapping("/users")
	public JspModel listAllUser(){
		return JspModel.success().add("users",userService.listAllUsers());
	}

}