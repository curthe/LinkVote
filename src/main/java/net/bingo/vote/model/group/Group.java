package net.bingo.vote.model.group;

public class Group {
	String id;// varchar(32) comment '群组表id',
	String pId;// varchar(32) comment '工程id',
	String groupName;// varchar(32) comment '群组名字',
	String groupLeader;// varchar(32) comment '创建者',
	String upId;// varchar(32) comment '用户id',-- 副表

	@Override
	public String toString() {
		return "Group [id=" + id + ", pId=" + pId + ", groupName=" + groupName + ", groupLeader=" + groupLeader
				+ ", upId=" + upId + "]";
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

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupLeader() {
		return groupLeader;
	}

	public void setGroupLeader(String groupLeader) {
		this.groupLeader = groupLeader;
	}

	public String getUpId() {
		return upId;
	}

	public void setUpId(String upId) {
		this.upId = upId;
	}

}
