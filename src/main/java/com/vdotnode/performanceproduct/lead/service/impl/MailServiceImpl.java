package com.vdotnode.performanceproduct.lead.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.vdotnode.performanceproduct.lead.domain.MailSend;
import com.vdotnode.performanceproduct.lead.services.MailService;


@Service
public class MailServiceImpl implements MailService{
	
private static final Logger logger=Logger.getLogger(MailServiceImpl.class);


	
	@Autowired
	private JavaMailSenderImpl mailSender;
	@Autowired
	InternalResourceViewResolver internalResourceViewResolver;
	
	@Value("${from}")
	private String from;

	@Value("${subject}")
	private String subject;
	
	
	


@Override
public MailSend mailSend(MailSend mail) {
	
	logger.debug("Request mail service recieved for mail");
	System.out.println(from+"from propereties");
	//System.out.println(subject+"subject propereties");
	//System.out.println(body+"body propereties");
	
	MimeMessage mm=mailSender.createMimeMessage();
	try { 
		MimeMessageHelper message = new MimeMessageHelper(mm, false, "UTF-8");   //file copy util concept or file wala krna hai
		
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("email.html");
		String result = IOUtils.toString(in, StandardCharsets.UTF_8);
	
		result=result.toString();
		String userName=mail.getFirstName()+mail.getLastName();
		result = result.replaceAll("\\{([^}]*)\\}",userName); 
		
		message.setTo(mail.getEmailId());
		message.setFrom(from);
		message.setSubject(subject);
		message.setText(result, true);
		mailSender.send(mm);
		
	}catch(MessagingException e) {
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
}
	
	

}
