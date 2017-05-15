package com.vdotnode.performanceproduct.lead.services;

import java.util.List;

import com.vdotnode.performanceproduct.lead.domain.Lead;
import com.vdotnode.performanceproduct.lead.domain.NewRegistration;

public interface LeadService {

	public List<Lead> listAll();
	
	public Lead createLead(Lead lead);
	
	public Lead updateLead(Lead lead);
	
	public Lead findById(Long id);
	
	public Lead deleteLeadById(Long id);
	
	
	

}
