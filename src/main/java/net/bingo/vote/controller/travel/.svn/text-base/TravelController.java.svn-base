package net.bingo.vote.controller.travel;

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
@RequestMapping("/travelController")
public class TravelController {

	@ResponseBody
	@RequestMapping("/travelVoteResult")
	public JsonData returnPrizeVoteResult(String key){
		Project project = new Project();
		project.setId(key);
		project.setTitle("旅游类型");
		project.setDescription("由大家投票决定，选择比较合适的运动类型");
		List<Object> listPrizeResult = new ArrayList<>();
		VoteResult result = new VoteResult();
		result.setVoteName("登山");
		result.setVoteNum(100);
		VoteResult result2 = new VoteResult();
		result2.setVoteName("游泳");
		result2.setVoteNum(75);
		VoteResult result3 = new VoteResult();
		result3.setVoteName("跑步");
		result3.setVoteNum(45);
		VoteResult result4 = new VoteResult();
		result4.setVoteName("足球");
		result4.setVoteNum(88);
		VoteResult result5 = new VoteResult();
		result5.setVoteName("骑车");
		result5.setVoteNum(92);
		List<VoteResult> voteResults = new ArrayList<>();
		voteResults.add(result);
		voteResults.add(result2);
		voteResults.add(result3);
		voteResults.add(result4);
		voteResults.add(result5);
		listPrizeResult.add(project);
		listPrizeResult.add(voteResults);
		JsonData jsonData =new JsonData();
		jsonData.setMsg("ok");
		jsonData.setObj(listPrizeResult);
		String json = JSONArray.toJSON(jsonData).toString();
		System.out.println(json);
		return jsonData;
	}
}
