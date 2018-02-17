package net.bingo.vote.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.bingo.vote.common.Pagination;
import net.bingo.vote.model.user.User;

public interface UserDao {
	
	public Pagination findList(String Data, int rows, int currentPage);

	/**
	 * 查找user
	 * 
	 * @param vo
	 * @return
	 */
	public User selectUser(@Param(value = "vo") User vo);

	/**
	 * 删除user
	 * 
	 * @param vo
	 * @return
	 */
	public void deleteUser(@Param(value = "id") String id);

	/**
	 * 新增user
	 * 
	 * @param vo
	 * @return
	 */
	public void insertUser(@Param(value = "vo") User vo);

	/**
	 * 修改user
	 * 
	 * @param vo
	 * @return
	 */
	public void updateUser(@Param(value = "vo") User vo);
	
	//查询所有的人的信息
	public List<User> selectForList();

}
