package com.vdotnode.performanceproduct.lead.services;

import com.vdotnode.performanceproduct.lead.domain.MailSend;

public interface MailService {
	
	public MailSend mailSend(MailSend mail);
//public Lead findmailSender(String emailId) throws  MessagingException;

}
