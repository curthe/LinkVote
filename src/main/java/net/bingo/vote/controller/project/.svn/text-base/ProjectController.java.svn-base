package net.bingo.vote.controller.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import net.bingo.vote.common.DateFormateUtils;
import net.bingo.vote.common.JsonData;
import net.bingo.vote.common.Pagination;
import net.bingo.vote.model.group.Group;
import net.bingo.vote.model.option.Option;
import net.bingo.vote.model.optionTemplate.Template3;
import net.bingo.vote.model.project.Project;
import net.bingo.vote.model.userProject.UserProject;
import net.bingo.vote.service.group.GroupService;
import net.bingo.vote.service.option.OptionService;
import net.bingo.vote.service.optionTemplate.OptionTemplateService;
import net.bingo.vote.service.project.ProjectService;
import net.bingo.vote.service.userProject.UserProjectService;

@CrossOrigin
@Controller
@RequestMapping("/projectController")
public class ProjectController {

	private final static Logger log = Logger.getLogger(ProjectController.class);

	@Autowired
	private ProjectService projectService;

	// @Autowired
	private GroupService groupService;

	// @Autowired
	private OptionTemplateService template3Service;

	// @Autowired
	private OptionService optionService;

	@Autowired
	private UserProjectService userProjectService;

	/**
	 * 新增
	 */
	// @RequestMapping("/insertProject")
	public void insertProject(Object[] dataArray) {
		Template3 template3 = new Template3();
		Option option = new Option();
		Group group = new Group();
		Project vo = new Project();
		vo.setId("ddddd");
		vo.setTitle("问卷调处");
		vo.setDescription("少时诵诗书是");
		vo.setStartTime(new Date());
		vo.setEndTime(new Date());
		System.out.println(vo);
		projectService.insertProject(vo);

		System.out.println(vo);

		// 课程投票模块
		if (null != dataArray[0] && !dataArray[0].equals("")) {
			if (dataArray[0].equals("course")) {

				// 初始化project
				String projectId = UUID.randomUUID().toString();
				vo.setId(projectId);
				vo.setTitle(dataArray[1].toString());
				vo.setDescription(dataArray[2].toString());
				vo.setStartTime(DateFormateUtils.fromStringToDate("yyyy-mm-dd", dataArray[3].toString()));
				vo.setEndTime(DateFormateUtils.fromStringToDate("yyyy-mm-dd", dataArray[4].toString()));

				/**
				 * 若为公开投票 ，id为gongkaiqunzu的v_group表已初始化
				 */
				// vo.setGId("gongkaiqunzu");

				/**
				 * 组群投票
				 */
				String groupId = UUID.randomUUID().toString();
				vo.setGId(groupId);

				// 保存项目
				projectService.insertProject(vo);

				// 初始化group ,若公开投票，则这个不用初始化，只要在project对应的p_id那里
				// 使用id为gongkaiqunzu的就行了
				group.setId(groupId);
				group.setpId(projectId);
				group.setGroupName("pingfenzu");
				group.setUpId(dataArray[5].toString());
				group.setGroupLeader(dataArray[6].toString());

				// 更新组
				groupService.insertGroup(group);

				// 初始化option
				String optionId = UUID.randomUUID().toString();
				option.setId(optionId);
				option.setpId(projectId);
				option.setOtId("pingfen");
				option.setOtId("3");

				// 插入option
				optionService.insertOption(option);

				// 初始化template3Id
				String template3Id = UUID.randomUUID().toString();
				template3.setId(template3Id);
				template3.setContent(dataArray[7].toString());
				template3.setContent2(dataArray[8].toString());
				template3.setPicture1(dataArray[9].toString());
				template3.setOtId("pingfen");
				template3.setoId(optionId);
				template3.setOrId("3");

				// 插入模板
				template3Service.insertOptionTemplate(template3);

			}
		}
	}

	/**
	 * 修改,根据主键
	 */
	@RequestMapping("/updateProject")
	public void updateProject() {

		Project vo = new Project();
		vo.setId("ddddd");
		vo.setTitle("问卷调处sd");
		vo.setDescription("少时诵诗书是sd");
		projectService.updateProject(vo);

	}

	/**
	 * 
	 * 首页查询 开始页面加载、下拉刷新
	 * 
	 * @param
	 * 
	 * @return JSONObject
	 * 
	 */
	@ResponseBody
	@RequestMapping("/selectStartProjectById")
	public JsonData selectStartProjectById(JSONArray args, int page, int pageSize, String userId) {
		// System.out.println(userId+" 0000000000000");
		// System.out.println(args+" 00"+page+ " userId "+userId );
		UserProject up = new UserProject();
		up.setuId(userId);

		JsonData json = new JsonData();
		Pagination pagination = new Pagination();
		pagination.setPageNo(page);
		pagination.setPageSize(pageSize);

		List<Map> startList = projectService.selectStartProjectById(pagination, userId);
		int i = startList.size();
		for (int j = 0; j < i; j++) {
			HashMap oneUserProject = (HashMap) startList.get(j);
			String pId = (String) oneUserProject.get("vp_id");
			up.setpId(pId);
			up.setuId(userId);
			UserProject up1 = userProjectService.selectUserProject(up);
			// 没有投过的就是null
			if (null == up1) {
				oneUserProject.put("participation", "0");
			} else {
				String up1pa = up1.getParticipation();
				oneUserProject.put("participation", up1pa);
			}
		}

		// List list2=projectService.selectProjectPublic(pagination);

		// System.out.println(list+" 0000000000000000000000");
		json.setMsg("ok");
		json.setData(startList);

		return json;
	}

	@ResponseBody
	@RequestMapping("/selectEndProjectById")
	public JsonData selectEndProjectById(JSONArray args, int page, int pageSize, String userId) {
		// System.out.println(userId+" 0000000000000");
		// System.out.println(args+" 00"+page+ " userId "+userId );
		JsonData json = new JsonData();
		Pagination pagination = new Pagination();
		pagination.setPageNo(page);
		pagination.setPageSize(pageSize);

		List endList = projectService.selectEndProjectById(pagination, userId);
		// List list2=projectService.selectProjectPublic(pagination);

		// System.out.println(list+" 0000000000000000000000");
		json.setMsg("ok");
		json.setData(endList);

		return json;
	}

	/**
	 * 删除
	 */
	// @RequestMapping("/deleteProject")
	public void deleteProject() {

		Project vo = new Project();
		vo.setId("ddddd");
		projectService.deleteProject(vo.getId());

	}

	/**
	 * 进行投票页面
	 * 
	 * @param userId
	 *            projectId
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/enterVoting")
	public JsonData enterVoting(String pId, String uId, String participation, String otId) {
		List list = null;
		String tableName = null;
		if ("1".equals(participation)) {
			// 已投票,数据回显
			switch (otId) {
			case "pingfen":
				// System.out.println("1");
				tableName = "v_option_introduction_one";
				break;
			case "didian":
				// System.out.println("2");
				tableName = "v_option_introduction_one";
				break;
			case "jushou":
				System.out.println("3");
				tableName = "v_option_introduction_one";
				break;
			case "jiangxiang":
				// System.out.println("4 奖项类");
				tableName = "v_option_introduction_three";
				list = this.projectService.view4Voting(pId, uId);
				break;
			case "danxuan":
				// System.out.println("5");
				tableName = "v_option_introduction_one";
				break;
			case "duoxuan":
				// System.out.println("6");
				tableName = "v_option_introduction_one";
				break;
			default:
				// System.out.println("未定义");
				tableName = "v_option_introduction_one";
				break;
			}
		} else {
			// 未投票
			list = projectService.enterVoting(pId, uId);
		}
		JsonData json = new JsonData();
		json.setSuccess(true);
		json.setMsg("ok");
		json.setData(list);
		return json;

	}

	/**
	 * 用户发起投票,即选哪个
	 * 
	 * @param userId
	 *            oiId
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/postVoting")
	public JsonData postVoting(String pId, String uId, String otId, String result) {
		// result与oiId一致
		String tableName = null;
			// 已投票标识 0未投票,1已投票
			// 进来的都是未投票过的
			switch (otId) {
			case "pingfen":
				// System.out.println("1");
				tableName = "v_option_introduction_one";
				break;
			case "didian":
				// System.out.println("2");
				tableName = "v_option_introduction_one";
				break;
			case "jushou":
				System.out.println("3");
				tableName = "v_option_introduction_one";
				break;
			case "jiangxiang":
				// System.out.println("4 奖项类");
				tableName = "v_option_introduction_three";
				this.projectService.post4Voting(pId, uId, result);
				break;
			case "danxuan":
				// System.out.println("5");
				tableName = "v_option_introduction_one";
				break;
			case "duoxuan":
				// System.out.println("6");
				tableName = "v_option_introduction_one";
				break;
			default:
				// System.out.println("未定义");
				tableName = "v_option_introduction_one";
				break;

			}
		
		JsonData json = new JsonData();
		json.setSuccess(true);
		json.setMsg("ok");
		return json;
	}
	
	@ResponseBody
	@RequestMapping("/getVotedResult")
	public JsonData getVotedResult(String pId,String uId, String otId) {
		// result与oiId一致
		List<Object> list=null;
		String tableName = null;
			// 已投票标识 0未投票,1已投票
			// 进来的都是未投票过的
			switch (otId) {
			case "pingfen":
				// System.out.println("1");
				tableName = "v_option_introduction_one";
				break;
			case "didian":
				// System.out.println("2");
				tableName = "v_option_introduction_one";
				break;
			case "jushou":
				System.out.println("3");
				tableName = "v_option_introduction_one";
				break;
			case "jiangxiang":
				// System.out.println("4 奖项类");
				tableName = "v_option_introduction_three";
				list=this.projectService.getVotedResult(pId);
				break;
			case "danxuan":
				// System.out.println("5");
				tableName = "v_option_introduction_one";
				break;
			case "duoxuan":
				// System.out.println("6");
				tableName = "v_option_introduction_one";
				break;
			default:
				// System.out.println("未定义");
				tableName = "v_option_introduction_one";
				break;

			}
		Project project=new Project();
		//project.setId(pId);
		project.setId(pId);
		Project p=projectService.selectProject(project);
		JsonData json = new JsonData();
		json.setSuccess(true);
		json.setData(list);
		json.setObj(p);
		json.setMsg("ok");
		return json;
	}
}