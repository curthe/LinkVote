package net.bingo.vote.model.option;

public class Option {
	private String id;// varchar(32) comment '项目选项表id', -- 副表
	private String pId;// varchar(32) comment '选项名',
	private String otId;// varchar(32) comment '选项形式id',

	@Override
	public String toString() {
		return "Option [id=" + id + ", pId=" + pId + ", otId=" + otId + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getOtId() {
		return otId;
	}

	public void setOtId(String otId) {
		this.otId = otId;
	}

}
