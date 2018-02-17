package net.bingo.vote.service.users;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.bingo.vote.dao.users.UserDaoDemo;
import net.bingo.vote.model.users.UserDemo;


@Service
public class UserServiceDemo {
	
	@Resource
	UserDaoDemo  userDaoDemo;
	
	public List<UserDemo> getUsers(){
		return userDaoDemo.selectUser();
	}

}
