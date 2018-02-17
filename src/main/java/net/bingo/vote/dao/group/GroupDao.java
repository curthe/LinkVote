package net.bingo.vote.dao.group;

import org.apache.ibatis.annotations.Param;

import net.bingo.vote.model.group.Group;

public interface GroupDao {
	/**
	 * 查找Template3
	 * 
	 * @param vo
	 * @return
	 */
	public Group selectGroup(@Param(value = "vo") Group vo);

	/**
	 * 删除Template3
	 * 
	 * @param vo
	 * @return
	 */
	public void deleteGroup(@Param(value = "id") String id);

	/**
	 * 新增Template3
	 * 
	 * @param vo
	 * @return
	 */
	public void insertGroup(@Param(value = "vo") Group vo);

	/**
	 * 修改Template3
	 * 
	 * @param vo
	 * @return
	 */
	public void updateGroup(@Param(value = "vo") Group vo);

}
