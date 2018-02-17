package net.bingo.vote.service.timer;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import net.bingo.vote.service.voteMsg.CourseVoteService;
import net.bingo.vote.service.voteMsg.PrizeVoteService;
import net.bingo.vote.service.voteMsg.TravelVoteService;
import net.bingo.vote.service.voteMsg.VoteMessageService;

public class BaseQuartzJobBean extends QuartzJobBean {

	public static  String BaseName="courseVoteService";
	VoteMessageService voteService=null;

	@Override
	protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException { 
        if(null!=BaseName && !BaseName.equals("")){
        	switch (BaseName) {
			case "courseVoteService":
				voteService = getApplicationContext(jobExecutionContext).getBean("courseVoteService",  
		                VoteMessageService.class);  
				break;
			case "prizeVoteService":
				voteService = getApplicationContext(jobExecutionContext).getBean("prizeVoteService",  
						VoteMessageService.class);  
				break;
			case "travelVoteService":
				 voteService = getApplicationContext(jobExecutionContext).getBean("travelVoteService",  
						 VoteMessageService.class);  
				break;
			default:
				break;
			}
        } 
        voteService.sendMessage();
	}

	private ApplicationContext getApplicationContext(JobExecutionContext jobExecutionContext) {
		try {  
            return (ApplicationContext) jobExecutionContext.getScheduler().getContext().get("applicationContextKey");  
        } catch (SchedulerException e) {  
            throw new RuntimeException(e);  
        }
	}

}
