package net.bingo.vote.mail;

import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public abstract class AbstractMailSender {
 
    private static Properties props = new Properties(); //创建 Session 实例时需要传递的基本参数  
  
    protected static Session session;  
    protected Message message;  
  
     
    static{
		//服务器认证开启
		props.setProperty("mail.smtp.auth", "true");
		//开启服务器的SMTP服务
		props.setProperty("mail.transport.protocol", "smtp");
		//使用SSL，企业邮箱必需！
	   //开启安全协议  77 MailSSLSocketFactory sf = null;
		 
//		MailSSLSocketFactory sf=null;
//		try {
//		  sf = new MailSSLSocketFactory();
//		  sf.setTrustAllHosts(true);
//		  } catch (GeneralSecurityException e1) {
//		              e1.printStackTrace();
//		          }
//		//qq授权码登录
//		props.put("mail.smtp.ssl.enable", "true");
//		props.put("mail.smtp.ssl.socketFactory", sf);
		session = Session.getInstance(props);
		session.setDebug(true);
		
    }
  
    /** 
     * 创建邮件即创建 java mail 的 session 和 message实例 
     */  
    public void createMail() {   
        message = new MimeMessage(session);  
        try {  
            //设置邮件发送地址  
        	message.setFrom(new InternetAddress("chukun1126@sina.com")); 
        } catch (AddressException e) {  
            e.printStackTrace();  
        } catch (MessagingException e) {
			e.printStackTrace();
		} 
    }  
  
    /** dhrfxuyvmhxucabg
     * 发送邮件 
     */  
    abstract void sendMail(List<String> toAddresses);
}

