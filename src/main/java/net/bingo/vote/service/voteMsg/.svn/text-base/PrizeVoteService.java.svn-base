package net.bingo.vote.service.voteMsg;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 模拟发送奖项投票的结果
 * @author 初坤
 *
 */
@Transactional
@Service("prizeVoteService")
public class PrizeVoteService implements VoteMessageService{
	
	public  Map<String, Integer>  SendPrizeVoteMessage(){
		
		Map<String, Integer> map = new HashMap<>();
		map.put("hlr", 80);
		map.put("wsz",100);
		map.put("wind", 80);
		map.put("gy", 82);
		System.out.println("SendPrizeVoteMessage");
		return map;
	}

	@Override
	public void sendMessage() {
		System.out.println("===============================");
		System.out.println("PrizeVoteService.............");
		System.out.println("===============================");
	}

}
