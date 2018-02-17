package net.bingo.vote.service.timer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.bingo.vote.mail.SimpleMailSender;
import net.bingo.vote.model.group.Group;
import net.bingo.vote.model.project.Project;
import net.bingo.vote.model.user.User;
import net.bingo.vote.model.userProject.UserProject;
import net.bingo.vote.service.group.GroupService;
import net.bingo.vote.service.project.ProjectService;
import net.bingo.vote.service.user.UserService;
import net.bingo.vote.service.userProject.UserProjectService;

public class SimpleService {  
	
	@Resource
	private ProjectService projectService;
	@Resource
	private GroupService groupService;
	@Resource
	private UserService userService;
	@Resource
	private UserProjectService userProjectService;
	private List<String> addresses = new ArrayList<>();
    private Project getProjectById(String id){
    	Project project = new Project();
    	project.setId(id);
    	return projectService.selectProject(project);
    }
    
    private Group getGroupId(Project project){
    	Group group = new Group();
    	group.setId(project.getGId());
    	return groupService.selectGroup(group);
    }
    
    private void getLeaderUserAddress(Group group){
    	User user = new User();
    	user.setId(group.getUpId());
    	user = userService.selectUser(user);
    	addresses.add(user.getEmail());
    	
    }
    
    private void getCommonUsers(Project project){
    	User user=null;
    	UserProject vo = new UserProject();
    	vo.setpId(project.getId());
    	List<UserProject> list = userProjectService.listUserProject(vo);
    	for (UserProject userProject : list) {
    		user = new User();
    		user.setId(userProject.getuId());
			user = userService.selectUser(user);
			addresses.add(user.getEmail());
		}
    }
    
    public void testMethod(String triggerName) {  
        // 这里执行定时调度业务  
        System.out.println(triggerName);
        addresses.add("492479702@qq.com");
        Project project = getProjectById("01");
        getLeaderUserAddress(getGroupId(project));
        getCommonUsers(project);
        System.out.println("aaaaa");
        SimpleMailSender ss = new SimpleMailSender();  
        //List<String> tos = new ArrayList<String>(); 
        //tos.add("wangyz@bingosoft.net");
        ss.createMail();  
        ss.setSubject(project.getTitle());  
        //ss.setTo(tos);  
        ss.addContent(project.getDescription());  
        ss.addImage(new File("H:\\JavaDev\\Bingo\\linkVoteApp\\data\\旅游投票.png"));  
        ss.addAttach(new File("H:\\JavaDev\\Bingo\\linkVoteApp\\data\\vote.txt")); 
        ss.addAttach(new File("H:\\JavaDev\\Bingo\\linkVoteApp\\data\\travel.xlsx"));
        ss.sendMail(addresses);  
    }  
  
}