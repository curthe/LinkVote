package net.bingo.vote.model.optionTemplate;

public class Template1 implements Template<String> {
	private String otId;
	private String orId;
	private String id;
	private String oId;// 项目选项表id

	@Override
	public String toString() {
		return "Template1 [otId=" + otId + ", orId=" + orId + ", id=" + id + ", oId=" + oId + "]";
	}

	public String getOtId() {
		return otId;
	}

	public void setOtId(String otId) {
		this.otId = otId;
	}

	public String getOrId() {
		return orId;
	}

	public void setOrId(String orId) {
		this.orId = orId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getoId() {
		return oId;
	}

	public void setoId(String oId) {
		this.oId = oId;
	}

}
