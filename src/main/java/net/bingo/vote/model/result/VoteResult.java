package net.bingo.vote.model.result;

/**
 * 投票结果封装类
 * @author 初坤
 *
 */
public class VoteResult {
	//表头信息
    //投票名称
	private String voteName;
	//投票数量
	private Integer voteNum;

	public VoteResult() {
		super();
	}

	public VoteResult(String voteName, Integer voteNum) {
		super();
		this.voteName = voteName;
		this.voteNum = voteNum;
	}

	public String getVoteName() {
		return voteName;
	}

	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}

	public Integer getVoteNum() {
		return voteNum;
	}

	public void setVoteNum(Integer voteNum) {
		this.voteNum = voteNum;
	}

	@Override
	public String toString() {
		return "VoteResult [voteName=" + voteName + ", voteNum=" + voteNum + "]";
	}
	
	

}
