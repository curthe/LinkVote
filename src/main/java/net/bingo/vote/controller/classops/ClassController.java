package net.bingo.vote.controller.classops;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import net.bingo.vote.common.JsonData;
import net.bingo.vote.model.project.Project;
import net.bingo.vote.model.result.VoteResult;
import net.bingo.vote.model.user.User;

@CrossOrigin
@Controller
@RequestMapping("/classController")
public class ClassController {

	
	@ResponseBody
	@RequestMapping("/classVoteResult")
	public JsonData returnPrizeVoteResult(String key){
		Project project = new Project();
		project.setId(key);
		project.setTitle("Linux培训");
		project.setDescription("精通linux内核,具有比较强的实践经验");
		List<Object> listPrizeResult = new ArrayList<>();
		User user = new User();
		user.setName("何立然");
		VoteResult result = new VoteResult();
		result.setVoteName("讲解");
		result.setVoteNum(100);
		VoteResult result2 = new VoteResult();
		result2.setVoteName("扩展");
		result2.setVoteNum(80);
		VoteResult result3 = new VoteResult();
		result3.setVoteName("互动");
		result3.setVoteNum(85);
		VoteResult result4 = new VoteResult();
		result4.setVoteName("练习");
		result4.setVoteNum(75);
		List<VoteResult> voteResults = new ArrayList<>();
		voteResults.add(result);
		voteResults.add(result2);
		voteResults.add(result3);
		voteResults.add(result4);
		listPrizeResult.add(project);
		listPrizeResult.add(user);
		listPrizeResult.add(voteResults);
		JsonData jsonData =new JsonData();
		jsonData.setMsg("ok");
		jsonData.setObj(listPrizeResult);
		String json = JSONArray.toJSON(jsonData).toString();
		System.out.println(json);
		return jsonData;
	}
}
