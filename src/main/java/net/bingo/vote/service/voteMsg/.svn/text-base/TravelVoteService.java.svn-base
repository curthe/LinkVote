package net.bingo.vote.service.voteMsg;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 模拟发送旅游投票的结果
 * @author 初坤
 *
 */
@Transactional
@Service("travelVoteService")
public class TravelVoteService implements VoteMessageService{
	
	public  Map<String, Integer>  SendTravelVoteMessage(){
		
		Map<String, Integer> map = new HashMap<>();
		map.put("华山", 100);
		map.put("黄山", 80);
		map.put("白云山", 48);
		
		return map;
	}

	@Override
	public void sendMessage() {
		
	}

}
