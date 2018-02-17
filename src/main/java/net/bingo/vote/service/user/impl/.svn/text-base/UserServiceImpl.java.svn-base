package net.bingo.vote.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bingo.vote.common.Pagination;
import net.bingo.vote.dao.user.UserDao;
import net.bingo.vote.model.user.User;
import net.bingo.vote.service.user.UserService;

/**
 * 
 * @author wshzh 单个用户增删查改
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public Pagination findList(String Data, int rows, int currentPage) {

		return userDao.findList(Data, rows, currentPage);
	}

	@Override
	public User selectUser(User vo) {
		return userDao.selectUser(vo);
	}

	@Override
	public void insertUser(User vo) {
		 userDao.insertUser(vo);
	}

	@Override
	public void deleteUser(String id) {
		 userDao.deleteUser(id);
	}

	@Override
	public void updateUser(User vo) {
		 userDao.updateUser(vo);
	}

	@Override
	public List<User> listAllUsers() {
		return userDao.selectForList();
	}
}
