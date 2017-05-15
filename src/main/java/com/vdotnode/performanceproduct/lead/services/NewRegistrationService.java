package com.vdotnode.performanceproduct.lead.services;

import java.util.List;

import com.vdotnode.performanceproduct.lead.domain.NewRegistration;



public interface NewRegistrationService {

	public List<NewRegistration> findAllNewRegistration();

	public NewRegistration createNewRegistration(NewRegistration newRegistration);

	public NewRegistration findNewRegistrationById(Long id);

	public NewRegistration updateNewRegistration(NewRegistration newRegistration);

	public void deleteRegistrationbyId(Long id);
	
}
