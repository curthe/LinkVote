package net.bingo.vote.model.optionResult;

public class OptionResult {
	private String id;// varchar(32) comment '选项结果表id ',
	private String result;// varchar(32) comment '选项结果结果',
	private String uId;// varchar(32) comment '用户id',
	private String oiId;// varchar(32) comment '选项详情id',

	@Override
	public String toString() {
		return "OptionResult [id=" + id + ", result=" + result + ", uId=" + uId + ", oiId=" + oiId + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getOiId() {
		return oiId;
	}

	public void setOiId(String oiId) {
		this.oiId = oiId;
	}

}
