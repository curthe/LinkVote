package net.bingo.vote.model.optionTemplate;

public class Template3 implements Template<String> {

	private String id;
	private String content;// 选项简介
	private String content2;// 选项简介
	private String content3;// 选项简介
	private String title;// 选项标题
	private String orId;// 结果id
	private String otId;// 选项形式id

	private String oId;// '项目选项表id',
	private String picture1;// 选项图片
	private String picture2;
	private String picture3;
	private String picture4;

	@Override
	public String toString() {
		return "Template3 [id=" + id + ", content=" + content + ", content2=" + content2 + ", content3=" + content3
				+ ", title=" + title + ", orId=" + orId + ", otId=" + otId + ", oId=" + oId + ", picture1=" + picture1
				+ ", picture2=" + picture2 + ", picture3=" + picture3 + ", picture4=" + picture4 + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public String getContent3() {
		return content3;
	}

	public void setContent3(String content3) {
		this.content3 = content3;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOrId() {
		return orId;
	}

	public void setOrId(String orId) {
		this.orId = orId;
	}

	public String getOtId() {
		return otId;
	}

	public void setOtId(String otId) {
		this.otId = otId;
	}

	public String getoId() {
		return oId;
	}

	public void setoId(String oId) {
		this.oId = oId;
	}

	public String getPicture1() {
		return picture1;
	}

	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}

	public String getPicture2() {
		return picture2;
	}

	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}

	public String getPicture3() {
		return picture3;
	}

	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}

	public String getPicture4() {
		return picture4;
	}

	public void setPicture4(String picture4) {
		this.picture4 = picture4;
	}

}
