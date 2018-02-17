package net.bingo.vote.model.optionType;

public class OptionType {
	private String id; // varchar(32) comment '选项形式表id', -- 主表
	private String optionType; // int comment '选项形式 1:有结果 2：有简介、结果的
								// 3：有简介、图片、结果的',

	@Override
	public String toString() {
		return "OptionType [id=" + id + ", optionType=" + optionType + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

}
