package net.bingo.vote.service.group;

import net.bingo.vote.model.group.Group;

public interface GroupService {
	/**
	 * 增
	 * 
	 * @param vo
	 * @return
	 */
	public void insertGroup(Group vo);

	/**
	 * 删
	 * 
	 * @param vo
	 * @return
	 */
	public void deleteGroup(String id);

	/**
	 * 查
	 * 
	 * @param vo
	 * @return
	 */
	public Group selectGroup(Group vo);

	/**
	 * 改
	 * 
	 * @param vo
	 * @return
	 */
	public void updateGroup(Group vo);
}
