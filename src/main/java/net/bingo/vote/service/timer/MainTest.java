package net.bingo.vote.service.timer;

import java.util.Date;

import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

import net.bingo.vote.common.DateFormateUtils;
import net.bingo.vote.model.project.Project;
import net.bingo.vote.service.project.ProjectService;

public class MainTest {  
  
    /** 
     * @param args 
     * @throws SchedulerException 
     */  
    public static void main(String[] args) throws SchedulerException {  
  
        @SuppressWarnings("resource")
		ApplicationContext springContext = new ClassPathXmlApplicationContext(new String[] {  
                "classpath:applicationContext.xml","classpath:applicationContext-quartz.xml","classpath:springmvc.xml" });  
        SchedulerService schedulerService = springContext.getBean("schedulerService", SchedulerService.class);  
        // 执行业务逻辑...  
      
        //ProjectService  projectService = springContext.getBean("projectService",ProjectService.class);
       
        // 设置高度任务  
        // 每10秒中执行调试一次  
        //schedulerService.schedule("0/10 * * ? * * *"); 
        
//        Project project = new Project();
//        project.setId("01");
//        project= projectService.selectProject(project);
//        
//        Date startTime =  project.getEndTime();  
        
        //Date endTime = parse("2017-08-16 22:12:00");  
  
        
//         Date date = new Date();
//         if(date.compareTo(startTime)<0){
//         schedulerService.schedule(startTime);  
//         }
         
        //测试指定的bean
        BaseQuartzJobBean.BaseName="prizeVoteService";
        schedulerService.schedule(DateFormateUtils.fromStringToDate("yyyy-MM-dd hh:mm:ss", "2017-08-17 14:14:00"));
        // 2017-08-15 16:33:00开始执行调度，2017-08-16 21:10:00结束执行调试  
        //schedulerService.schedule(startTime, endTime);  
  
        // 2017-08-16 16:33:00开始执行调度，执行5次结束  
        //schedulerService.schedule(startTime,null, 5);  
  
        // 2017-08-16 16:33:00开始执行调度，每隔20秒执行一次，执行5次结束  
        //schedulerService.schedule(startTime,null, 5, 20);  
  
    }  
}