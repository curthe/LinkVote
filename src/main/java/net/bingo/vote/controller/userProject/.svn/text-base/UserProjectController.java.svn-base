package net.bingo.vote.controller.userProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bingo.vote.model.project.Project;
import net.bingo.vote.model.user.User;
import net.bingo.vote.model.userProject.UserProject;
import net.bingo.vote.service.project.ProjectService;
import net.bingo.vote.service.user.UserService;
import net.bingo.vote.service.userProject.UserProjectService;

@Controller
@RequestMapping("/userProjectController")
public class UserProjectController {

	@Autowired(required = false)
	private UserProjectService userProjectService;

	@Autowired
	private UserService userService;
	

	@Autowired
	private ProjectService ProjectService;
	/**
	 * 新增
	 */
	@RequestMapping("/insertUserProject")
	public void insertUserProject() {

		UserProject vo = new UserProject();
		vo.setId("5455sdsd");
		vo.setpId("9999");
		vo.setuId("9527");
		
		Project vo1=new Project();
		vo1.setId("9999");;
		vo1.setTitle("呵呵");
		ProjectService.insertProject(vo1);
		
		User vo2=new User();
		vo2.setId("9527");
		userService.insertUser(vo2);
		userProjectService.insertUserProject(vo);
	}

	/**
	 * 修改
	 */
	@RequestMapping("/updateUserProject")
	public void updateUserProject() {

		UserProject vo = new UserProject();
		vo.setId("5455sdsd");
		vo.setpId("9999");
		vo.setuId("9527");
		
		userProjectService.updateUserProject(vo);
	}

	/**
	 * 查询
	 */
	@RequestMapping("/selectUserProject")
	public void selectUserProject() {


		UserProject vo = new UserProject();
		vo.setId("5455sdsd");
		vo.setpId("9999");
		vo.setuId("9527");

		userProjectService.selectUserProject(vo);
	}

	/**
	 * 删除
	 */
	@RequestMapping("/deleteUserProject")
	public void deleteUserProject() {

		UserProject vo = new UserProject();
		vo.setId("5455sdsd");

		userProjectService.deleteUserProject(vo.getId());
	}

}