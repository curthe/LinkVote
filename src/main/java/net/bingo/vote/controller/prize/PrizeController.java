package net.bingo.vote.controller.prize;

import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import net.bingo.vote.common.JsonData;
import net.bingo.vote.common.Pagination;
import net.bingo.vote.model.group.Group;
import net.bingo.vote.model.option.Option;
import net.bingo.vote.model.optionResult.OptionResult;
import net.bingo.vote.model.optionTemplate.Template3;
import net.bingo.vote.model.project.Project;
import net.bingo.vote.model.result.VoteResult;
import net.bingo.vote.model.user.User;
import net.bingo.vote.model.userProject.UserProject;
import net.bingo.vote.service.group.GroupService;
import net.bingo.vote.service.option.OptionService;
import net.bingo.vote.service.optionResult.OptionResultService;
import net.bingo.vote.service.optionTemplate.impl.OptionTemplate3Imlp;
import net.bingo.vote.service.project.ProjectService;
import net.bingo.vote.service.user.UserService;
import net.bingo.vote.service.userProject.UserProjectService;
@CrossOrigin
@Controller
@RequestMapping("/prizeController")
public class PrizeController {

	private final static Logger log = Logger.getLogger(PrizeController.class);

	@Autowired
	private ProjectService projectService;

	@Autowired
	private GroupService groupService;

	@Autowired
	private UserProjectService userProjectService;

	// @Autowired
	// private UserService userService;

	@Autowired
	private OptionTemplate3Imlp template3Service;

	@Autowired
	private OptionService optionService;

	@Autowired
	OptionResultService optionResultService;

	private Project project;

	private Group group;

	// private User user;

	private Template3 template3;

	private UserProject userProject;

	private Option option;

	/**
	 * 
	 */
	/**
	 * @param uId
	 * @param project
	 * @param data
	 * @param usersId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/insertPrize")
	public JsonData insertPrize(String uId, String project, String data,String usersId) {
		JsonData jsonData = new JsonData();
		Project p = new Project();
		Group group = new Group();
		Template3 template3 = new Template3();
		UserProject userProject = new UserProject();
		Option option = new Option();

		String pId = UUID.randomUUID().toString();
		String uPId = UUID.randomUUID().toString();
		String gId = UUID.randomUUID().toString();

		String tempate3Id = null;
		Date dateString = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		{
			JSONObject projectData = JSON.parseObject(project);
			
			//pId为null
			p.setId(pId);
			p.setTitle(projectData.get("title").toString());
			p.setDescription(projectData.get("description").toString());
			// startTime默认为当时
			try {
				dateString = formatter.parse(projectData.get("endTime").toString());
				p.setEndTime(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (projectData.get("isGroup").toString().equals("1")) {
				// 如果为1，则为群组关系，要维护group,和每个user与userProject
				// 在project插入之后
				//group.setId(gId);
				//group.setGroupLeader(uId);
				//group.setpId(pId);
				//group.setUpId(uPId);
			}else if(projectData.get("isGroup").toString().equals("0")){
				// 如果为1，则为群组关系，groupId固定的，不再插入
				p.setGId("0");
			}
			if (projectData.get("isAnonymous").toString().equals("1")) {
				// 如果为0，则为非匿名(默认)。如果为1，则为匿名
			}
			// 现在插入***************************************************************************	
			projectService.insertProject(p);
			if (projectData.get("isGroup").toString().equals("1")) {
				groupService.insertGroup(group);
			}
			// 在project、optionType插入之后
			option.setOtId("jiangxiang");
			option.setId(UUID.randomUUID().toString());
			option.setpId(pId);
			optionService.insertOption(option);
			// 现在插入***************************************************************************
			
			// 在option、optionType插入之后
			template3.setoId(option.getId());
			template3.setOtId(option.getOtId());
			
		}
		{
			// 在user、project插入之后
		//	userProject.setId(UUID.randomUUID().toString());
		//	userProject.setpId(pId);
		//	userProject.setuId(uId);
		//	userProjectService.insertUserProject(userProject);
		}
		{
			System.out.println(data);
			JSONArray datas= JSON.parseArray(data);
			int i=datas.size();
			for(int j=0;j<i;j++){
				JSONObject d=datas.getJSONObject(j);
				tempate3Id = UUID.randomUUID().toString();
				template3.setId(tempate3Id);
				template3.setTitle(d.get("title").toString());
				template3.setContent(d.get("content").toString());
				template3.setContent2(d.get("content2").toString());
				
				//template3.setPicture1(d.get("picture").toString());
			/*	String base64=(String) d.get("picture");
//		      	去掉base64数据头部data:image/png;base64,和尾部的” " “  
		        String[] ww= base64.split(",");  
		        base64 = ww[1];  
		        String[] aa = base64.split("\"");  
		        base64 = aa[0];  
		        template3.setPicture1(base64);*/
			        
				
				template3Service.insertOptionTemplate(template3);
			}
		}
		
		{

			jsonData.setSuccess(true);
			jsonData.setMsg("OK");
			return jsonData;
		}
	}

	/**
	 * 新增
	 */
	@ResponseBody
	@RequestMapping("/insertPrize2")
	public void insertPrize(String key) {

		Project project = new Project();

		Group group = new Group();

		// User user=new User();

		Template3 template3 = new Template3();

		UserProject userProject = new UserProject();

		Option option = new Option();

		String pId = UUID.randomUUID().toString();
		//////////////////////////////////// userId
		// String uId = UUID.randomUUID().toString();;
		String uId = null;
		String uPId = UUID.randomUUID().toString();
		String gId = UUID.randomUUID().toString();
		String tempate3Id = null;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateString;

		// String key =
		// "{\"project\":[{\"id\":\"null\",\"startTime\":\"2117-08-10
		// 22:31:53\",\"title\":\"金鸡奖\",\"description\":\"金鸡奖源远流长\",\"isGroup\":\"G\",\"isMulti\":\"G\",\"endTime\":\"2117-08-11
		// 22:31:53\",\"isAnonymous\":\"G\"}],\"tempate3\":[{\"id\":\"null\",\"title\":\"王世展\",\"content\":\"开发部\",\"content2\":\"技术大牛\",\"picture\":\"undefined\"},{\"id\":\"null\",\"title\":\"初坤\",\"content\":\"研发部\",\"content2\":\"技术大咖\",\"picture\":\"undefined\"},{\"id\":\"null\",\"title\":\"何立然\",\"content\":\"部署实施\",\"content2\":\"技术很牛\",\"picture\":\"undefined\"}],\"user\":[{\"id\":\"null\"}]}";
		JSONObject.parse(key);
		JSONObject mapTypes2 = JSON.parseObject(key);
		System.out.println("这个是用JSON类的parseObject来解析JSON字符串!!!");
		System.out.println(key);
		for (Object obj : mapTypes2.keySet()) {
			// System.out.println("key为："+obj+"值为："+mapTypes2.get(obj));

			switch ((String) obj) {
			case "project": {
				JSONArray arry = mapTypes2.getJSONArray("project");
				int i = arry.size();
				while (i > 0) {
					i--;
					JSONObject loss = arry.getJSONObject(i);
					for (Object lo : loss.keySet()) {
						switch ((String) lo) {
						case "id":
							// System.out.println("key为：" + lo + "值" + i + "为："
							// + loss.get(lo));
							// pId=loss.get(lo).toString();////////////////////////////////////////////////////////////
							project.setId(pId);
							break;
						case "title":
							// System.out.println("key为：" + lo + "值" + i + "为" +
							// loss.get(lo));
							project.setTitle(loss.get(lo).toString());
							break;
						case "description":
							// System.out.println("key为：" + lo + "值" + i + "为" +
							// loss.get(lo));
							project.setDescription(loss.get(lo).toString());
							break;
						case "startTime":
							// System.out.println("key为：" + lo + "值" + i + "为" +
							// loss.get(lo));
							try {
								dateString = formatter.parse(loss.get(lo).toString());
								project.setStartTime(dateString);
							} catch (ParseException e) {
								e.printStackTrace();
							}
							break;
						case "endTime":
							// System.out.println("key为：" + lo + "值" + i + "为" +
							// loss.get(lo));
							try {
								dateString = formatter.parse(loss.get(lo).toString());
								project.setEndTime(dateString);
							} catch (ParseException e) {
								e.printStackTrace();
							}
							break;
						case "isGroup"://///////////////// 如果为1，则为群组关系，要维护user
										/////////////////// grouop。如果为0，则为公开关系(默认)
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));

							break;
						case "isMulti"://///////////////// 如果为0，则为单选(默认)。如果为1，则为多选，要维护有多少张选票
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							break;
						case "isAnonymous"://///////////////// 如果为0，则为非匿名(默认)。如果为1，则为匿名
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							break;
						default:
							break;
						}
					}
				}
				/**
				 * 现在插入***************************************************************************
				 */
				project.setGId(gId);
				projectService.insertProject(project);
				/**
				 * 在project、optionType插入之后
				 */
				option.setOtId("jiangxiang");/////////////////
				option.setId(UUID.randomUUID().toString());
				option.setpId(pId);
				optionService.insertOption(option);
				/**
				 * 现在插入***************************************************************************
				 */

				/**
				 * 在option、optionType插入之后
				 */
				template3.setoId(option.getId());
				template3.setOtId(option.getOtId());

			}
				break;
			case "user": {
				JSONArray arry = mapTypes2.getJSONArray("user");
				int i = arry.size();
				while (i > 0) {
					i--;
					JSONObject loss = arry.getJSONObject(i);
					System.out.println(loss + "   pppppppppppppppppppppppppppppp");
					for (Object lo : loss.keySet()) {
						switch ((String) lo) {
						case "id":
							// System.out.println("key为：" + lo + "值" + i + "为："
							// + loss.get(lo));
							// user.setId(loss.get(lo).toString());
							System.out.println("key为：" + lo + "值" + i + "为：" + loss.get(lo) + " 3333333333333333");
							uId = loss.get(lo).toString();
							// user.setId(uId);
							break;
						case "name":
							// System.out.println("key为：" + lo + "值" + i + "为" +
							// loss.get(lo));
							// user.setName(loss.get(lo).toString());
							break;
						case "deptName"://///////////////////////// 这里的deptName在template3那里
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							break;
						case "phone":
							// System.out.println("key为：" + lo + "值" + i + "为" +
							// loss.get(lo));
							// user.setPhone(loss.get(lo).toString());
							break;
						default:
							break;
						}
					}
				}

			}
				break;
			case "tempate3": {
				JSONArray arry = mapTypes2.getJSONArray("tempate3");
				int i = arry.size();
				// System.out.println(arry);
				while (i > 0) {
					i--;
					JSONObject loss = (JSONObject) arry.get(i);
					for (Object lo : loss.keySet()) {
						switch ((String) lo) {
						case "id":
							System.out.println("key为：" + lo + "值" + i + "为：" + loss.get(lo));
							tempate3Id = UUID.randomUUID().toString();
							template3.setId(tempate3Id);
							break;
						case "title":////////////// 姓名
							// System.out.println("key为：" + lo + "值" + i + "为" +
							// loss.get(lo));
							template3.setTitle(loss.get(lo).toString());
							break;
						case "content":////////////// 部门
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							template3.setContent(loss.get(lo).toString());
							break;
						case "content2":////////////// 介绍
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							template3.setContent2(loss.get(lo).toString());
							break;
						case "picture":////////////// 图片
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							template3.setPicture1(loss.get(lo).toString());
							break;
						default:
							break;
						}
					}
					
					/**
					 * 在option、optionType插入之后
					 */
					// template3.setoId(option.getId());
					// template3.setOtId(option.getOtId());
					template3Service.insertOptionTemplate(template3);

				}

			}
				break;
			default:
				System.out.println("default");
				break;

			}
		}

		/**
		 * 在project插入之后
		 */
		group.setId(gId);
		group.setGroupLeader(uId);
		// group.setGroupName("");
		group.setpId(pId);
		group.setUpId(uPId);
		groupService.insertGroup(group);

		/**
		 * 测试
		 */
		// userService.insertUser(user);
		/**
		 * 在user、project插入之后
		 */
		userProject.setId(UUID.randomUUID().toString());
		userProject.setpId(pId);
		userProject.setuId(uId);
		userProjectService.insertUserProject(userProject);
	}

	/**
	 * 修改,根据主键
	 */
	// @RequestMapping("/updateProject")
	/*
	 * public void updatePrize() {
	 * 
	 * Project vo = new Project(); vo.setId("ddddd"); vo.setTitle("问卷调处sd");
	 * vo.setDescription("少时诵诗书是sd"); projectService.updateProject(vo);
	 * 
	 * }
	 */

	/**
	 * 
	 */
	@RequestMapping("/selectProject")

	public void selectPrize(String uId) {
		System.out.println("1111");
		// projectService.selectProject(vo);

	}

	/**
	 * 删除
	 */
	// @RequestMapping("/deleteProject")
	/*
	 * public void deletePrize() {
	 * 
	 * Project vo = new Project(); vo.setId("ddddd");
	 * projectService.deleteProject(vo.getId());
	 * 
	 * }
	 */
	@ResponseBody
	@RequestMapping("/prizeVoteResult")
	public JsonData returnPrizeVoteResult(String key){
		project = new Project();
		project.setId(key);
		project.setTitle("个人进步奖");
		project.setDescription("奖励在工作中积极进取的员工");
		List<Object> listPrizeResult = new ArrayList<>();
		VoteResult result = new VoteResult();
		result.setVoteName("王世展");
		result.setVoteNum(100);
		VoteResult result2 = new VoteResult();
		result2.setVoteName("何立然");
		result2.setVoteNum(80);
		List<VoteResult> voteResults = new ArrayList<>();
		voteResults.add(result);
		voteResults.add(result2);
		listPrizeResult.add(project);
		listPrizeResult.add(voteResults);
		JsonData jsonData =new JsonData();
		jsonData.setMsg("ok");
		jsonData.setObj(listPrizeResult);
		return jsonData;
	}
	
}