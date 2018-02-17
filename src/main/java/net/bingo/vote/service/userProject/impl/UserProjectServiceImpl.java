package net.bingo.vote.service.userProject.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bingo.vote.dao.userProject.UserProjectDao;
import net.bingo.vote.model.userProject.UserProject;
import net.bingo.vote.service.userProject.UserProjectService;

@Transactional
@Service("UserProjectService")
public class UserProjectServiceImpl implements UserProjectService {

	@Autowired
	private UserProjectDao userProjectDao;

	@Override
	public void insertUserProject(UserProject vo) {
		userProjectDao.insertUserProject(vo);
		
	}

	@Override
	public void deleteUserProject(String id) {
		userProjectDao.deleteUserProject(id);
		
	}

	@Override
	public UserProject selectUserProject(UserProject vo) {
		
		return userProjectDao.selectUserProject(vo);
	}

	@Override
	public void updateUserProject(UserProject vo) {
		userProjectDao.updateUserProject(vo);
		
	}

	@Override
	public List<UserProject> listUserProject(UserProject vo) {
		
		return userProjectDao.listUserProject(vo);
	}

}
