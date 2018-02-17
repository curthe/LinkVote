package net.bingo.vote.mail;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.sun.mail.util.MimeUtil;

public class SimpleMailSender extends AbstractMailSender {

	private Multipart multipart; // java mail 中用于存放不同部分邮件内容的容器
	private Transport transport;
	// 目前qq没有调试通过
	//private static final String ClIENT_CODE = "dhrfxuyvmhxucabg";

	/**
	 * 构造函数，初始化 multipart 实例
	 */
	public SimpleMailSender() {
		multipart = new MimeMultipart();
	}

	@Override
	public void sendMail(List<String> toAddresses) {
		Address[] addr = new Address[toAddresses.size()];
		for (int i = 0; i < addr.length; i++) {
			try {
				addr[i] = new InternetAddress(toAddresses.get(i));
			} catch (AddressException e) {
				e.printStackTrace();
			}
		}
		try {
			// 设置邮件内容
			message.setContent(multipart);
			message.setSentDate(new Date());
			// 发送邮件
			transport = session.getTransport();
			transport.connect("smtp.sina.com", 25, "chukun1126@sina.com", "ck492479702");
			transport.sendMessage(message, addr);
			// for(int i=0;i<toAddresses.size();i++){
			// transport.sendMessage(message, new Address[]{new
			// InternetAddress(toAddresses.get(i))});
			// }
		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
			try {
				if (transport != null) {
					transport.close();
					transport = null;
				}
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 设置邮件标题
	 * 
	 * @param subject
	 *            String
	 */
	public void setSubject(String subject) {
		try {
			message.setSubject(subject);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 在邮件内容中增加文本
	 * 
	 * @param content
	 *            String
	 */
	public void addContent(String content) {
		try {
			BodyPart bodyPart = new MimeBodyPart();
			bodyPart.setText(content);
			multipart.addBodyPart(bodyPart);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 在邮件内容中增加附件（邮件中添加需要在邮件中显示的图片时使用）
	 * 
	 * @param attach
	 *            File 附件
	 * @param header
	 *            String Content-ID
	 */
	private void addAttach(File attach, String header) {
		try {
			BodyPart bodyPart = new MimeBodyPart();
			DataSource dataSource = new FileDataSource(attach);
			bodyPart.setDataHandler(new DataHandler(dataSource));
			try {
				bodyPart.setFileName(MimeUtility.decodeText(attach.getName()));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if (header != null) {
				bodyPart.setHeader("Content-ID", "<" + header + ">");
			}
			multipart.addBodyPart(bodyPart);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 在邮件内容中增加附件（邮件中单独添加附件时使用）
	 * 
	 * @param attach
	 *            File 附件
	 */
	public void addAttach(File attach) {
		addAttach(attach, null);
	}

	/**
	 * 在邮件中添加 html 代码
	 * 
	 * @param html
	 *            String
	 */
	public void addHtml(String html) {
		try {
			BodyPart bodyPart = new MimeBodyPart();
			bodyPart.setContent(html, "text/html;charset=utf8");
			multipart.addBodyPart(bodyPart);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 在邮件中添加可以显示的图片
	 * 
	 * @param image
	 *            File 图片
	 */
	public void addImage(File image) {
		try {
			String header = UUID.randomUUID().toString();
			String img = "<img src=\"cid:" + header + "\">";
			addHtml(img);
			addAttach(image, header);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}