package net.bingo.vote.controller.club;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import net.bingo.vote.common.JsonData;
import net.bingo.vote.model.group.Group;
import net.bingo.vote.model.option.Option;
import net.bingo.vote.model.optionTemplate.Template3;
import net.bingo.vote.model.optionType.OptionType;
import net.bingo.vote.model.project.Project;
import net.bingo.vote.model.user.User;
import net.bingo.vote.model.userProject.UserProject;
import net.bingo.vote.service.group.GroupService;
import net.bingo.vote.service.option.OptionService;
import net.bingo.vote.service.optionTemplate.OptionTemplateService;
import net.bingo.vote.service.project.ProjectService;
import net.bingo.vote.service.project.impl.ProjectServiceImpl;

public class ClubLocationController {

	public ClubLocationController() {
		/**
		 * 数据库有
		 */
		// optionType.setId("didian");
		// optionType.setOptionType("2");
		/**
		 * 这里初始化
		 */
		option.setOtId("didian");
	}

	public JsonData createVote(String data) {

		processData(data);

		ProjectService projectService = new ProjectServiceImpl();

		return projectService.createVote(data);

	}

	// @Autowired
	private ProjectService projectService;

	// @Autowired
	private GroupService groupService;

	// @Autowired
	private OptionTemplateService template3Service;

	// @Autowired
	private OptionService optionService;

	private Project project;
	private Group group;
	private User user;
	private Template3 template3;
	private UserProject userProject;
	private Option option;
	private OptionType optionType;
	
	public void processData(String data) {
		Template3 template3 = new Template3();
		UserProject userProject = new UserProject();
		Option option = new Option();

		// OptionType optionType = new OptionType();

		String pId = UUID.randomUUID().toString();
		String uId = null;
		String uPId = UUID.randomUUID().toString();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateString;

		JSONObject mapTypes2 = JSON.parseObject(data);
		System.out.println("这个是用JSON类的parseObject来解析JSON字符串!!!");

		for (Object key : mapTypes2.keySet()) {
			switch ((String) key) {
			case "userId":
				// System.out.println("key为：" + key + "值为：" +
				// mapTypes2.get(key));
				uId = mapTypes2.get(key).toString();
				user.setId(uId);

				break;
			case "projectId":
				// System.out.println("key为：" + key + "值为：" +
				// mapTypes2.get(key));
				project.setId(pId);
				break;
			case "clubName":
				// System.out.println("key为：" + key + "值为：" +
				// mapTypes2.get(key));
				project.setTitle(mapTypes2.get(key).toString());
				break;
			case "clubTitle":
				// System.out.println("key为：" + key + "值为：" +
				// mapTypes2.get(key));
				project.setDescription(mapTypes2.get(key).toString());
				break;
			case "startTime":
				// System.out.println("key为：" + key + "值为：" +
				// mapTypes2.get(key));
				try {
					dateString = formatter.parse(mapTypes2.get(key).toString());
					project.setStartTime(dateString);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case "endTime":
				System.out.println("key为：" + key + "值为：" + mapTypes2.get(key));
				try {
					dateString = formatter.parse(mapTypes2.get(key).toString());
					project.setEndTime(dateString);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case "locations": {
				JSONArray arry = mapTypes2.getJSONArray("locations");
				int i = arry.size();
				while (i > 0) {
					i--;
					JSONObject loss = arry.getJSONObject(i);
					for (Object lo : loss.keySet()) {
						switch ((String) lo) {
						case "id":
							// System.out.println("key为：" + lo + "值" + i + "为："
							// + loss.get(lo));
							template3.setId(UUID.randomUUID().toString());
							break;
						case "name":
							// System.out.println("key为：" + lo + "值" + i + "为" +
							// loss.get(lo));
							template3.setTitle(loss.get(lo).toString());
							break;
						case "desc":
							// System.out.println("key为：" + lo + "值" + i + "为" +
							// loss.get(lo));
							template3.setContent((loss.get(lo).toString()));
							break;
						case "url":
							// System.out.println("key为：" + lo + "值" + i + "为" +
							// loss.get(lo));
							template3.setContent2((loss.get(lo).toString()));
							break;
						case "pictures":
							JSONArray pictures = mapTypes2.getJSONArray("pictures");
							int j = pictures.size();
							while (j > 0) {
								j--;
								JSONObject p = pictures.getJSONObject(j);
								for (Object p1 : p.keySet()) {
									switch ((String) p1) {
									case "picture1":
										template3.setPicture1(p.get(p1).toString());
										break;
									case "picture2":
										template3.setPicture2(p.get(p1).toString());
										break;
									case "picture3":
										template3.setPicture3(p.get(p1).toString());
										break;
									case "picture4":
										template3.setPicture3(p.get(p1).toString());
										break;
									default:
										break;
									}
								}
							}
							break;
						default:
							break;
						}
					}
				}

			}
				break;
			default:
				System.out.println("default");
				break;
			}
		}

		/**
		 * 
		 */
		option.setId(UUID.randomUUID().toString());
		option.setpId(pId);

		/**
		 * 
		 */
		userProject.setId(UUID.randomUUID().toString());
		userProject.setIsCreateItem("0");
		userProject.setpId(pId);
		userProject.setuId(uId);

		/**
		 * 
		 */
		group.setId(UUID.randomUUID().toString());
		group.setGroupLeader(uId);
		group.setGroupName("");
		group.setpId(pId);
		group.setUpId(uPId);

	}

}
