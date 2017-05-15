package com.vdotnode.performanceproduct.lead.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.vdotnode.performanceproduct.lead.domain.Lead;
import com.vdotnode.performanceproduct.lead.domain.NewRegistration;
import com.vdotnode.performanceproduct.lead.repositories.LeadRepository;
import com.vdotnode.performanceproduct.lead.services.LeadService;

@Service
public class LeadServiceImpl implements LeadService{
	

	@Autowired
	private LeadRepository leadRepository;

	
	private static final Logger logger = Logger.getLogger(LeadServiceImpl.class);

	@Override
	public List<Lead> listAll() {
		logger.debug("list of all leads");
		return this.leadRepository.findAll();
	}

	
	
	@Transactional
	@Override
	public Lead createLead(Lead lead) {
		logger.debug("inside crate lead loggggerrr"+lead.getId());
		Lead savedLead = null;
		if (null != lead) {
		
			logger.debug(" Lead created");
			logger.debug("inside if condition loggggerrr");
			lead.setCreate_on(new Date());
			savedLead=this.leadRepository.save(lead);
			logger.debug(" Lead created");
		}
		return savedLead;
		
		// TODO Auto-generated method stub
		//return null;
	}

	@Transactional
	@Override
	public Lead updateLead(Lead lead) {
		if (null != lead) {

			logger.info("Update Lead By Id");
			//newRegistration.setConfirmationCode(TokenGenerator.generateToken(newRegistration.getEmailId()));

			return this.leadRepository.save(lead);
		}
		logger.error("NOT found Lead");
		return null;
	}



	@Override
	public Lead findById(Long id) {
		if(null!=id){
			return this.leadRepository.findOne(id);
		}
		return null;
	}



	@Override
	public Lead deleteLeadById(Long id) {
		// TODO Auto-generated method stub
		
		if(null!=id)
		{
		 this.leadRepository.delete(id);
			
		}
		return null;
		
	}



	



	
}
