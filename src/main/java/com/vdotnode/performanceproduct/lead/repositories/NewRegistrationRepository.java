package com.vdotnode.performanceproduct.lead.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vdotnode.performanceproduct.lead.domain.NewRegistration;


public interface NewRegistrationRepository extends JpaRepository<NewRegistration, Long> {

	public NewRegistration findByEmailId(String emailId);

	public NewRegistration findByConfirmationCode(String confirmationCode);

	public void deleteNewRegistrationByConfirmationCode(String confirmationCode);

	public NewRegistration findNewRegistrationByCompanyName(String comapnyName);

}
