package com.vdotnode.performanceproduct.lead.web.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vdotnode.performanceproduct.lead.domain.Lead;
import com.vdotnode.performanceproduct.lead.domain.MailSend;
import com.vdotnode.performanceproduct.lead.services.LeadService;
import com.vdotnode.performanceproduct.lead.services.MailService;

@RestController
@RequestMapping(value = "/lead")
public class LeadController {

	private static final Logger logger = Logger.getLogger(LeadController.class);

	@Autowired
	private LeadService leadService;

	@Autowired
	private MailService mailService;

	/**
	 * @Autowired called to service
	 * 
	 * 
	 *            Retrival all lead
	 * 
	 * @return
	 */
	// ------------findAll------

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Lead>> listAll() {
		logger.debug("inside lead controler");

		List<Lead> lead = this.leadService.listAll();

		if (lead.isEmpty()) {
			return new ResponseEntity<List<Lead>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Lead>>(lead, HttpStatus.OK);

	}
/*
 
 @RequestMapping(method = RequestMethod.POST)
 	
 	public ResponseEntity<Lead> createLead(@RequestBody Lead lead) {
 		logger.debug("createcontroler");
 		logger.debug("Request recieved for campaginChannel");
 		Lead  create_Lead= this.leadService.createLead(lead);
 	
 		if(null != create_Lead){
 		logger.debug("Creating  a campaginChannel");
 			return new ResponseEntity<Lead>(create_Lead,HttpStatus.CREATED);
 		}
 		return new ResponseEntity<Lead>(HttpStatus.CONFLICT);
 	}
 	
 */
	/* MailService Controller
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Lead> mailSender(@RequestBody Lead lead) throws MessagingException {
		logger.debug("RequestrecievedforLead");

		// Lead send_mail =
		// this.mailService.findmailSender(lead.getEmail_id());

		if (null != lead) {
			logger.debug("sending  a mail");

			System.out.println("emailId is :-" + lead.getEmail_id());
			this.mailService.findmailSender(lead.getEmail_id());
			// System.out.println("emailId is :-"+ lead.getEmail_id());

			Lead c_Lead = this.leadService.createLead(lead);
			return new ResponseEntity<Lead>(c_Lead, HttpStatus.CREATED);
		}

		return new ResponseEntity<Lead>(HttpStatus.CONFLICT);

	}*/

	@RequestMapping(method =RequestMethod.POST)
	public ResponseEntity<Lead> mailSend(@RequestBody Lead lead){
		
		logger.debug("Request recieved for MailSend::");
		logger.debug("Request recieved for Lead");
		
		MailSend sendMail=new MailSend();
		//Lead send_mail = this.mailService.findmailSenderr(lead.getEmail_id());

		if (null != lead) {
			logger.debug("sending  a mail");
			
			 System.out.println("emailId is :-"+ lead.getEmail_id());
			
			// System.out.println("emailId is :-"+ lead.getEmail_id());

			Lead createLead = this.leadService.createLead(lead);
			
			sendMail.setFirstName(lead.getFirst_name());
			sendMail.setLastName(lead.getLast_name());
			sendMail.setEmailId(lead.getEmail_id());
			
			// this.mailService.findmailSenderr(sendMail);
			 this.mailService.mailSend(sendMail);
			return new ResponseEntity<Lead>(createLead,HttpStatus.CREATED);
		}
		
		return new ResponseEntity<Lead>( HttpStatus.CONFLICT);
	}
	
	
	// -update-----------------------

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Lead> update(@RequestBody Lead lead) {

		logger.debug("Request recieved for campaginChannel");
		// Lead currentLead = this.leadService.findLeadById(lead.getId());
		Lead currentLead = this.leadService.findById(lead.getId());
		if (currentLead == null) {
			logger.error("No campaginChannel found");
			return new ResponseEntity<Lead>(HttpStatus.NOT_FOUND);
		}

		currentLead = this.leadService.updateLead(lead);
		logger.debug("Updating for single campaginChannel");
		return new ResponseEntity<Lead>(currentLead, HttpStatus.OK);
	}

	// -Delete----------------

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Lead> deleteNewRegistration(@PathVariable("id") Long id) {
		logger.debug("Request recieved for campaginChannels");
		// System.out.println("Fetching & Deleting User with id " + id);

		Lead campaignChannel = this.leadService.findById(id);
		if (campaignChannel == null) {
			logger.error("No campaginChannel found");
			return new ResponseEntity<Lead>(HttpStatus.NOT_FOUND);
		}

		this.leadService.deleteLeadById(id);
		logger.debug("Deleting for single campaginChannel");
		return new ResponseEntity<Lead>(campaignChannel, HttpStatus.OK);
	}

}