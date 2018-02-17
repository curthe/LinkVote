package net.bingo.vote.service.voteMsg;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 模拟发送课程投票的结果
 * @author 初坤
 *
 */
@Transactional
@Service("courseVoteService")
public class CourseVoteService implements VoteMessageService {
	
	public  Map<String, String>  SendCourceVoteMessage(){
		
		Map<String, String> map = new HashMap<>();
		map.put("name", "hlr");
		map.put("讲解","100");
		map.put("思路", "80");
		map.put("拓展", "50");
		
		return map;
	}

	@Override
	public void sendMessage() {
		System.out.println("===============================");
		System.out.println("courseVoteMessage.............");
		System.out.println("===============================");
	}

}
