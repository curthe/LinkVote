package net.bingo.vote.controller.course;

import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.bingo.vote.common.DateFormateUtils;
import net.bingo.vote.model.group.Group;
import net.bingo.vote.model.option.Option;
import net.bingo.vote.model.optionResult.OptionResult;
import net.bingo.vote.model.optionTemplate.Template3;
import net.bingo.vote.model.project.Project;
import net.bingo.vote.model.userProject.UserProject;
import net.bingo.vote.service.group.GroupService;
import net.bingo.vote.service.option.OptionService;
import net.bingo.vote.service.optionResult.OptionResultService;
import net.bingo.vote.service.optionTemplate.impl.OptionTemplate3Imlp;
import net.bingo.vote.service.project.ProjectService;
import net.bingo.vote.service.userProject.UserProjectService;

@Controller
@RequestMapping("/course")
public class CourseVoteController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private GroupService groupService;

	@Autowired
	private UserProjectService userProjectService;

	@Autowired
	private OptionTemplate3Imlp template3Service;

	@Autowired
	private OptionService optionService;

	@Autowired
	OptionResultService optionResultService;

	/**
	 * 新增
	 * var data=
		{
			"user":[{
				"id": "ck18819345930"
			}],
			"project":[{
			"id":"null",
			"title":$("#classname").val(),
			"description": $("#classDesc").val(),
			"startTime": "2117-08-10 22:31:53",
			"endTime": "2117-08-11 22:31:53",
			"isMulti":"G",
			"isAnonymous":"G",
			"isGroup":"G"
			}],
		"tempate3":items
		item="{"+"\"id\""+":"+ "\""+null+"\""+",
		"+"\""+"title"+"\""+":"+"\""+teacherName+"\""+",
		"+"\""+"content"+"\""+":"+"\""+desc+"\""+"}"
		}
	 */
	@RequestMapping("/insertCourse")
	public void createCourseVote(String key) {
		Project project = new Project();

		Group group = new Group();


		Template3 template3 = new Template3();

		UserProject userProject = new UserProject();

		Option option = new Option();

		OptionResult optionResult = new OptionResult();
        //组中关联的用户id
		String groupupId="";
		String pId = UUID.randomUUID().toString();
		//////////////////////////////////// userId
		String uId = UUID.randomUUID().toString();
		String uPId = UUID.randomUUID().toString();
		String gId = UUID.randomUUID().toString();
		String orId = null;
		String tempate3Id = null;
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
							project.setId(loss.get(lo).toString());
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
							Date startTime = DateFormateUtils.fromStringToDate("yyyy-MM-dd HH:mm:ss", loss.get(lo).toString());
							project.setStartTime(startTime);
							
							break;
						case "endTime":
							// System.out.println("key为：" + lo + "值" + i + "为" +
							// loss.get(lo));
							Date endTime = DateFormateUtils.fromStringToDate("yyyy-MM-dd HH:mm:ss", loss.get(lo).toString());
							project.setEndTime(endTime);
							break;
						case "isGroup"://///////////////// 如果为1，则为群组关系，要维护user
										/////////////////// grouop。如果为2，则为公开关系(默认)
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));

							break;
						case "isMulti"://///////////////// 如果为1，则为单选(默认)。如果为2，则为多选，要维护有多少张选票
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							break;
						case "isAnonymous"://///////////////// 如果为1，则为非匿名(默认)。如果为2，则为匿名
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
				option.setOtId("pingfen");/////////////////
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
					System.out.println(loss);
					for (Object lo : loss.keySet()) {
						switch ((String) lo) {
						case "id":
						 groupupId = loss.get(lo).toString();
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
							orId = UUID.randomUUID().toString();
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
							}
					}

					/**
					 * 在option、optionType插入之后
					 */
					// template3.setoId(option.getId());
					// template3.setOtId(option.getOtId());
					template3Service.insertOptionTemplate(template3);

					/**
					 * user、intro之后***
					 */
					optionResult.setId(orId);
					optionResult.setOiId(tempate3Id);
					optionResultService.insertOptionResult(optionResult);

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
		group.setUpId(groupupId);
		groupService.insertGroup(group);

		/**
		 * 在user、project插入之后
		 */
		userProject.setId(UUID.randomUUID().toString());
		userProject.setpId(pId);
		userProject.setuId(uId);
		userProjectService.insertUserProject(userProject);
	}

}
