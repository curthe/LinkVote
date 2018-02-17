package net.bingo.vote.controller.users;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import net.bingo.vote.common.JsonData;
import net.bingo.vote.model.group.Group;
import net.bingo.vote.model.optionTemplate.Template3;
import net.bingo.vote.model.user.User;
import net.bingo.vote.model.users.JspModel;
import net.bingo.vote.service.users.UserServiceDemo;

@Controller
public class UserControllerDemo {

	@Resource
	UserServiceDemo userServiceDemo;

	@ResponseBody
	@RequestMapping("/users")
	public net.bingo.vote.model.users.JspModel getAllUsers() {

		return JspModel.success().add("userList", userServiceDemo.getUsers());
	}

	@ResponseBody
	@RequestMapping("/users3")
	public void getData(String key) {
		JSONObject.parse(key);
		JSONObject mapTypes2 = JSON.parseObject(key);
		System.out.println("这个是用JSON类的parseObject来解析JSON字符串!!!");
		System.out.println(mapTypes2);
		System.out.println(key);

	}

	@ResponseBody
	@RequestMapping("/users2")
	public User getMessage(String key) {

		/*
		 * String str =
		 * "{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}";
		 * //第一种方式 Map maps = (Map)JSON.parse(str);
		 * System.out.println("这个是用JSON类来解析JSON字符串!!!"); for (Object map :
		 * maps.entrySet()){
		 * System.out.println(((Map.Entry)map).getKey()+"     " +
		 * ((Map.Entry)map).getValue()); } //第二种方式 Map mapTypes =
		 * JSON.parseObject(str);
		 * System.out.println("这个是用JSON类的parseObject来解析JSON字符串!!!"); for (Object
		 * obj : mapTypes.keySet()){
		 * System.out.println("key为："+obj+"值为："+mapTypes.get(obj)); } //第三种方式
		 * Map mapType = JSON.parseObject(str,Map.class);
		 * System.out.println("这个是用JSON类,指定解析类型，来解析JSON字符串!!!"); for (Object obj
		 * : mapType.keySet()){
		 * System.out.println("key为："+obj+"值为："+mapType.get(obj)); } //第四种方式
		 *//**
			 * JSONObject是Map接口的一个实现类
			 */
		/*
		 * Map json = (Map) JSONObject.parse(str);
		 * System.out.println("这个是用JSONObject类的parse方法来解析JSON字符串!!!"); for
		 * (Object map : json.entrySet()){
		 * System.out.println(((Map.Entry)map).getKey()+"  "+((Map.Entry)map).
		 * getValue()); } //第五种方式
		 *//**
			 * JSONObject是Map接口的一个实现类
			 */
		/*
		 * JSONObject jsonObject = JSONObject.parseObject(str);
		 * System.out.println("这个是用JSONObject的parseObject方法来解析JSON字符串!!!"); for
		 * (Object map : json.entrySet()){
		 * System.out.println(((Map.Entry)map).getKey()+"  "+((Map.Entry)map).
		 * getValue()); } //第六种方式
		 *//**
			 * JSONObject是Map接口的一个实现类
			 *//*
			 * Map mapObj = JSONObject.parseObject(str,Map.class);
			 * System.out.println(
			 * "这个是用JSONObject的parseObject方法并执行返回类型来解析JSON字符串!!!"); for (Object
			 * map: json.entrySet()){
			 * System.out.println(((Map.Entry)map).getKey()+"  "+((Map.Entry)map
			 * ).getValue()); } String strArr =
			 * "{{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"},"
			 * +
			 * "{\"00\":\"zhangsan\",\"11\":\"lisi\",\"22\":\"wangwu\",\"33\":\"maliu\"}}";
			 * // JSONArray.parse() System.out.println(json);
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 */
		// 第二种方式

		// String
		// str="{\"userId\":\"c8bebb2e-ab8c-45fd-8658-ae845587f53a\",\"projectId\":\"528f8efa-9a66-4c64-8403-a9ced26ad683\",\"clubName\":\"羽毛球俱乐部\",\"clubTitle\":\"羽毛球俱乐部第六届活动地点投票\",\"startTime\":\"2117-08-1022:31:53\",\"endTime\":\"2117-08-1122:31:53\",\"location\":[{\"id\":\"1\"},{\"name\":\"泰山\"},{\"desc\":\"泰山是中国五岳之首，古名岱山，又称岱宗，位于山东省中部，泰安市境内，矗立在鲁中群山间；主峰玉皇顶，海拔1532.7米\"},{\"url\":\"https://zh.wikipedia.org/wiki/%E6%B3%B0%E5%B1%B1\"},{\"picture1\":\"https://zh.wikipedia.org/wiki/File:%E6%B3%B0%E5%B1%B1_%E5%8D%97%E5%A4%A9%E9%97%A8.jpg\"},{\"picture2\":\"https://zh.wikipedia.org/wiki/File:China_Northern_Plain_relief_location_map.png\"}]}";

	//	String key = "{\"project\":[{\"id\":\"null\",\"startTime\":\"2117-08-10 22:31:53\",\"title\":\"hjj\",\"description\":\"hghghh\",\"isGroup\":\"G\",\"isMulti\":\"G\",\"endTime\":\"2117-08-11 22:31:53\",\"isAnonymous\":\"G\"}],\"tempate3\":[{\"id\":\"null\",\"title\":\"ghgh\",\"content\":\"hgghghg\",\"content2\":\"ghghghg\",\"picture\":\"undefined\"},{\"id\":\"null\",\"title\":\"asasa\",\"content\":\"asas\",\"content2\":\"undefined\",\"picture\":\"undefined\"},{\"id\":\"null\",\"title\":\"sdsd\",\"content\":\"sdsd\",\"content2\":\"undefined\",\"picture\":\"undefined\"}],\"user\":[{\"id\":\"null\"}]}";
		JSONObject.parse(key);
		JSONObject mapTypes2 = JSON.parseObject(key);
		System.out.println("这个是用JSON类的parseObject来解析JSON字符串!!!");
	//	System.out.println(key);
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
							System.out.println("key为：" + lo + "值" + i + "为：" + loss.get(lo));
							break;
						case "title":
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							break;
						case "description":
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							break;
						case "startTime":
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							break;
						case "endTime":
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							break;
						case "isGroup":
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							break;
						case "isMulti":
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							break;
						case "isAnonymous":
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							break;
						default:
							break;
						}
					}
				}

			}
				break;
			case "user": {
				JSONArray arry = mapTypes2.getJSONArray("user");
				int i = arry.size();
				while (i > 0) {
					i--;
					JSONObject loss = arry.getJSONObject(i);
				//	System.out.println(loss);
					for (Object lo : loss.keySet()) {
						switch ((String) lo) {
						case "id":
							System.out.println("key为：" + lo + "值" + i + "为：" + loss.get(lo));
							break;
						case "name":
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							break;
						case "deptName":
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							break;
						case "phone":
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
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
				//System.out.println(arry);
				while (i > 0) {
					System.out.println("--------------------------");
					i--;
					JSONObject loss = (JSONObject) arry.get(i);
					for (Object lo : loss.keySet()) {
						switch ((String) lo) {
						case "id":
							System.out.println("key为：" + lo + "值" + i + "为：" + loss.get(lo));
							break;
						case "title":
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							break;
						case "content":
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							break;
						case "content2":
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							break;
						case "picture":
							System.out.println("key为：" + lo + "值" + i + "为" + loss.get(lo));
							break;
						default:
							break;
						}
					}
					System.out.println("--------------------------");

				}

			}
				break;
			default:
				System.out.println("default");
				break;

			}
		}


		User user = new User();
		user.setName("王世展");
		user.setPhone("18608986927");
		user.setEmail("849061491@qq.com");
		user.setId("9527");
		JsonData json2 = new JsonData();
		try {
			// System.out.println(key);
			System.out.println(key);
			// {"startTime":"2117-08-10
			// 22:31:53","projectId":"528f8efa-9a66-4c64-8403-a9ced26ad683","endTime":"2117-08-11
			// 22:31:53","clubName":"羽毛球俱乐部","location":[{"id":"1"},{"name":"泰山"},{"desc":"泰山是中国五岳之首，古名岱山，又称岱宗，位于山东省中部，泰安市境内，矗立在鲁中群山间；主峰玉皇顶，海拔1532.7米"},{"url":"https:\/\/zh.wikipedia.org\/wiki\/%E6%B3%B0%E5%B1%B1"},{"picture1":"https:\/\/zh.wikipedia.org\/wiki\/File:%E6%B3%B0%E5%B1%B1_%E5%8D%97%E5%A4%A9%E9%97%A8.jpg"},{"picture2":"https:\/\/zh.wikipedia.org\/wiki\/File:China_Northern_Plain_relief_location_map.png"}],"clubTitle":"羽毛球俱乐部第六届活动地点投票","userId":"c8bebb2e-ab8c-45fd-8658-ae845587f53a"}
			// {"orgId":"e45b774a-9e2d-4c22-8d66-645167ae8fcf","picture":"https:\/\/www.bingolink.biz\/uam\/ui\/upload?action=download&filepath=Avatar\/c8bebb2e-ab8c-45fd-8658-ae845587f53a.jpg","loginId":"ougj","sCode":"bingo","email":"ougj@bingosoft.net","userId":"c8bebb2e-ab8c-45fd-8658-ae845587f53a","userName":"欧关俊","orgName":"运营监控部","telephone":"18271891051","picture_local":null}
			json2.setSuccess(true);
			json2.setMsg("添加成功");
			json2.setData(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 上传文件
	 * 
	 * @param file,上传文件名
	 * @param request
	 * @return
	 * @throws Exception
	 */
	// @ResponseBody
	// @RequestMapping(name="/upload")
	// public void fileUpLoad(@RequestParam(value="file")CommonsMultipartFile
	// file,HttpServletRequest request) throws Exception{
	// 拿到服务器下工程下的images文件夹
	// String path = request.getServletContext().getRealPath("/images");
	// //拿到文件名称
	// String fileName = file.getOriginalFilename();

	// 组合文件路径
	// String imagePath = path+File.separator+fileName;
	// 完成上传
	// file.transferTo(new File(imagePath));
	// 将文件的存储路径发给前端页面
	// return JspModel.success().add("path", imagePath);

	// 将路径存储到数据库

	// }

}
