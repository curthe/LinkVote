package net.bingo.vote.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.bingo.vote.controller.user.UserController;
import net.bingo.vote.model.user.User;
import net.bingo.vote.model.users.JspModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:springmvc.xml","classpath:applicationContext-quartz.xml"})
public class UserTest extends AbstractJUnit4SpringContextTests {

	@Resource
	UserController userController;
	@Test
	public void testListUsers() {
		JspModel jspmodel= userController.listAllUser();
		System.out.println(jspmodel);
		
	}

}
