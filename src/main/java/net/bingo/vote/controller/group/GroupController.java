package net.bingo.vote.controller.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bingo.vote.model.group.Group;
import net.bingo.vote.model.project.Project;
import net.bingo.vote.service.group.GroupService;
import net.bingo.vote.service.project.ProjectService;

@Controller
@RequestMapping("/groupController")
public class GroupController {
	@Autowired
	private GroupService groupService;
	@Autowired
	private ProjectService projectService;
	
	
	/**
	 * 新增
	 */
	@RequestMapping("/insertGroup")
	public void insertGroup() {
		Group vo=new Group();
		Project p=new Project();
		p.setGId("sdsdsd");
		p.setTitle("xiangmu1");
		p.setId("9527");//-----------
		
		vo.setGroupLeader("王小明");
		vo.setGroupName("ccc");
		vo.setpId("9527");//---------------
		vo.setUpId("454");
		vo.setId("465sxas1c3a1cas3c1a");
		//有project才有group
		projectService.insertProject(p);
		groupService.insertGroup(vo);
	}

	/**
	 * 修改,根据主键
	 */
	@RequestMapping("/updateGroup")
	public void updateGroup() {
		Group vo=new Group();
		vo.setGroupLeader("王大明");
		vo.setGroupName("ccc222");
		vo.setpId("9527"); //这个不能随意改
		vo.setUpId("454");
		vo.setId("465sxas1c3a1cas3c1a");
		groupService.updateGroup(vo);
	}

	/**
	 * 查询
	 */
	@RequestMapping("/selectGroup")
	public void selectGroup() {
		Group vo=new Group();
		vo.setGroupLeader("王大明");
		vo.setGroupName("ccc");
		vo.setpId("9527"); //这个不能随意改
		vo.setUpId("454");
		vo.setId("465sxas1c3a1cas3c1a");
		groupService.selectGroup(vo);
		
	}

	/**
	 * 删除
	 */
	@RequestMapping("/deleteGroup")
	public void deleteGroup() {
		
		Group vo=new Group();
		vo.setId("465sxas1c3a1cas3c1a");
		groupService.deleteGroup(vo.getId());

	}
}
