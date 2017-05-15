package com.vdotnode.performanceproduct.lead.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the new_registration database table.
 * 
 */
@Entity
@Table(name = "new_registration")
@NamedQuery(name = "NewRegistration.findAll", query = "SELECT n FROM NewRegistration n")
public class NewRegistration extends BaseModel {
	private static final long serialVersionUID = 1L;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "confirmation_code")
	private String confirmationCode;

	@Column(name = "country_id")
	private Long countryId;

	@Column(name = "created_on")
	private Date createdOn;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "newsletter_enabled")
	private Boolean newsletterEnabled;

	@Column(name = "primary_contact_number")
	private String primaryContactNumber;

	@Column(name = "service_package")
	private int servicePackage;

	@Column(name = "tnc_accepted")
	private Boolean tncAccepted;

	public NewRegistration() {
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getConfirmationCode() {
		return this.confirmationCode;
	}

	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

	public Long getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getNewsletterEnabled() {
		return this.newsletterEnabled;
	}

	public void setNewsletterEnabled(Boolean newsletterEnabled) {
		this.newsletterEnabled = newsletterEnabled;
	}

	public String getPrimaryContactNumber() {
		return this.primaryContactNumber;
	}

	public void setPrimaryContactNumber(String primaryContactNumber) {
		this.primaryContactNumber = primaryContactNumber;
	}

	public int getServicePackage() {
		return this.servicePackage;
	}

	public void setServicePackage(int servicePackage) {
		this.servicePackage = servicePackage;
	}

	public Boolean getTncAccepted() {
		return this.tncAccepted;
	}

	public void setTncAccepted(Boolean tncAccepted) {
		this.tncAccepted = tncAccepted;
	}

	@Override
	public String toString() {
		return "NewRegistration [companyName=" + companyName + ", confirmationCode=" + confirmationCode + ", countryId="
				+ countryId + ", createdOn=" + createdOn + ", emailId=" + emailId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", newsletterEnabled=" + newsletterEnabled + ", primaryContactNumber="
				+ primaryContactNumber + ", servicePackage=" + servicePackage + ", tncAccepted=" + tncAccepted + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewRegistration other = (NewRegistration) obj;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		return true;
	}

}