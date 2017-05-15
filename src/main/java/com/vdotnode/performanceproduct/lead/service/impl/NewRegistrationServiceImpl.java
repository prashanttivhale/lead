package com.vdotnode.performanceproduct.lead.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vdotnode.performanceproduct.lead.domain.NewRegistration;
import com.vdotnode.performanceproduct.lead.repositories.NewRegistrationRepository;
import com.vdotnode.performanceproduct.lead.services.NewRegistrationService;



@Service
public class NewRegistrationServiceImpl implements NewRegistrationService {

	@Autowired
	private NewRegistrationRepository newRegistrationRepository;

	private static final Logger logger = Logger.getLogger(NewRegistrationServiceImpl.class);

	@Value("${expTime}")
	private long expiryTime;

	@Transactional
	@Override
	public List<NewRegistration> findAllNewRegistration() {
		logger.info("All NewRegistration found");
		return this.newRegistrationRepository.findAll();
	}

	@Transactional
	@Override
	public NewRegistration createNewRegistration(NewRegistration newRegistration) {
		NewRegistration savedNewRegistration = null;
		if (null != newRegistration) {

		//	newRegistration.setConfirmationCode(TokenGenerator.generateToken(newRegistration.getEmailId()));

			newRegistration.setCreatedOn(new Date());
			savedNewRegistration = this.newRegistrationRepository.save(newRegistration);
			logger.debug(" NewRegistration created");
		}
		return savedNewRegistration;
	}

	@Transactional
	@Override
	public NewRegistration findNewRegistrationById(Long id) {
		if (null != id) {
			logger.info("find NewRegistration By Id");
			return this.newRegistrationRepository.findOne(id);
		}
		logger.error("NOT found NewRegistration");
		return null;
	}

	@Transactional
	@Override
	public NewRegistration updateNewRegistration(NewRegistration newRegistration) {
		if (null != newRegistration) {

			logger.info("Update NewRegistration By Id");
			//newRegistration.setConfirmationCode(TokenGenerator.generateToken(newRegistration.getEmailId()));

			return this.newRegistrationRepository.save(newRegistration);
		}
		logger.error("NOT found NewRegistration");
		return null;
	}

	@Override
	public void deleteRegistrationbyId(Long id) {
		// TODO Auto-generated method stub
		if(null!=id)
		{
			this.newRegistrationRepository.delete(id);
		}
		
	}








	

}
