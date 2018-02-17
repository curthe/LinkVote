package net.bingo.vote.dao.userProject;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.bingo.vote.model.userProject.UserProject;

public interface UserProjectDao {

	/**
	 * 查找user
	 * 
	 * @param vo
	 * @return
	 */
	public UserProject selectUserProject(@Param(value = "vo") UserProject vo);

	/**
	 * 删除user
	 * 
	 * @param vo
	 * @return
	 */
	public void deleteUserProject(@Param(value = "id") String id);

	/**
	 * 新增user
	 * 
	 * @param vo
	 * @return
	 */
	public void insertUserProject(@Param(value = "vo") UserProject vo);

	/**
	 * 修改user
	 * 
	 * @param vo
	 * @return
	 */
	public void updateUserProject(@Param(value = "vo") UserProject vo);

	public List<UserProject> listUserProject(UserProject vo);

}
