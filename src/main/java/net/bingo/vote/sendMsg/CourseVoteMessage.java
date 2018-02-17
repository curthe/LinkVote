package net.bingo.vote.sendMsg;

import java.util.HashMap;
import java.util.Map;
/**
 * 模拟发送课程投票的结果
 * @author 初坤
 *
 */
public class CourseVoteMessage {
	
	public  Map<String, String>  SendCourceVoteMessage(){
		
		Map<String, String> map = new HashMap<>();
		map.put("name", "hlr");
		map.put("讲解","100");
		map.put("思路", "80");
		map.put("拓展", "50");
		
		return map;
	}

}
