package net.bingo.vote.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import net.bingo.vote.mail.SimpleMailSender;

public class MailTest {

	 /**
	  * yanzf@bingosoft.net
	  * helr@bingosoft.net
	  * wangshizhan@bingosoft.net
	  * wanglx@bingosoft.net
	  * moxj@bingosoft.net
	  * wangyz@bingosoft.net
	  * wangshihui@bingosoft.net
	  * 
	  * 测试群发邮件的功能，但是好像被当做垃圾邮件，所以用了新浪邮箱，测试通过
	  */
	@Test
	public void test() {
      
		SimpleMailSender ss = new SimpleMailSender();  
        List<String> tos = new ArrayList<String>();  
        tos.add("yanzf@bingosoft.net");
        tos.add("helr@bingosoft.net");
        tos.add("wangshizhan@bingosoft.net");
        tos.add("wanglx@bingosoft.net");
        //tos.add("moxj@bingosoft.net");
        //tos.add("492479702@qq.com");
        //tos.add("13572812375@163.com");  
        ss.createMail();  
        ss.setSubject("投票测试的邮件");  
        //ss.setTo(tos);  
        ss.addContent("旅游投票的邮件,这是旅游投票的简单发送结果的邮件");  
        ss.addImage(new File("H:\\JavaDev\\Bingo\\linkVoteApp\\data\\旅游投票.png"));  
        ss.addAttach(new File("H:\\JavaDev\\Bingo\\linkVoteApp\\data\\vote.txt")); 
        ss.addAttach(new File("H:\\JavaDev\\Bingo\\linkVoteApp\\data\\travel.xlsx"));
        ss.sendMail(tos);  
    }
	}

