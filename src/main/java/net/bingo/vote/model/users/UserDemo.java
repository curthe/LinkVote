package net.bingo.vote.model.users;

public class UserDemo {

	private Integer userId;
	private String name;
	private char sex;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", sex=" + sex + "]";
	}

}
