package net.bingo.vote.service.userProject;

import java.util.List;

import net.bingo.vote.model.userProject.UserProject;

public interface UserProjectService {
	/**
	 * 增
	 * 
	 * @param vo
	 * @return
	 */
	public void insertUserProject(UserProject vo);

	/**
	 * 删
	 * 
	 * @param vo
	 * @return
	 */
	public void deleteUserProject(String id);

	/**
	 * 查
	 * 
	 * @param vo
	 * @return
	 */
	public UserProject selectUserProject(UserProject vo);

	/**
	 * 改
	 * 
	 * @param vo
	 * @return
	 */
	public void updateUserProject(UserProject vo);
	
	public List<UserProject> listUserProject(UserProject vo);

}
