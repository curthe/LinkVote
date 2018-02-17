package net.bingo.vote.service.group.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bingo.vote.dao.group.GroupDao;
import net.bingo.vote.model.group.Group;
import net.bingo.vote.service.group.GroupService;
@Transactional
@Service("GroupService")
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupDao groupDao;

	@Override
	public void insertGroup(Group vo) {
		groupDao.insertGroup(vo);
	}

	@Override
	public void deleteGroup(String id) {
		groupDao.deleteGroup(id);	
	}

	@Override
	public Group selectGroup(Group vo) {
		return groupDao.selectGroup(vo);
	}

	@Override
	public void updateGroup(Group vo) {
		groupDao.updateGroup(vo);
	}

	
}
