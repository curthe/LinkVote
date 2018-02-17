package net.bingo.vote.service.user;

import java.util.List;

import net.bingo.vote.common.Pagination;
import net.bingo.vote.model.user.User;

public interface UserService {
	public Pagination findList(String Data, int rows, int currentPage);

	/**
	 * 增
	 * 
	 * @param vo
	 * @return
	 */
	public void insertUser(User vo);

	/**
	 * 删
	 * 
	 * @param vo
	 * @return
	 */
	public void deleteUser(String id);

	/**
	 * 查
	 * 
	 * @param vo
	 * @return
	 */
	public User selectUser(User vo);

	/**
	 * 改
	 * 
	 * @param vo
	 * @return
	 */
	public void updateUser(User vo);
	
	public List<User> listAllUsers();

}
