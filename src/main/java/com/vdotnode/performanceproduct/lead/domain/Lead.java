package com.vdotnode.performanceproduct.lead.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "lead")
// @NamedQuery(name = "Lead.findAll", query = "SELECT n FROM Lead n")
public class Lead extends BaseModel {
	private static final long serialVersionUID = 1L;

	@Column(name = "status")
	private String status;

	@Column(name = "description")
	private String description;

	@Column(name = "currancy")
	private String currancy;

	@Column(name = "opportunity")
	private String opportunity;

	@Column(name = "source")
	private String source;

	@Column(name = "source_description")
	private String source_description;

	@Column(name = "responsible")
	private String responsible;

	@Column(name = "gender")
	private String gender;

	@Column(name = "salutation")
	private String salutation;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "middle_name")
	private String middle_name;

	@Column(name = "date_of_birth")
	private Date date_of_birth;

	@Column(name = "email_id")
	private String email_id;

	@Column(name = "phone_number")
	private String phone_number;

	@Column(name = "site")
	private String site;

	@Column(name = "company_name")
	private String company_name;

	@Column(name = "position")
	private String position;

	@Column(name = "Address1")
	private String Address1;

	@Column(name = "Address2")
	private String Address2;

	@Column(name = "city")
	private String city;

	@Column(name = "region")
	private String region;

	@Column(name = "state")
	private String state;

	@Column(name = "zip_code")
	private String zip_code;

	@Column(name = "country")
	private String country;

	@Column(name = "create_on")
	private Date create_on;

	@Column(name = "updated_on")
	private Date updated_on;

	@Column(name = "created_by_user")
	private Date created_by_user;

	@Column(name = "updated_by_user")
	private String updated_by_user;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurrancy() {
		return currancy;
	}

	public void setCurrancy(String currancy) {
		this.currancy = currancy;
	}

	public String getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(String opportunity) {
		this.opportunity = opportunity;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource_description() {
		return source_description;
	}

	public void setSource_description(String source_description) {
		this.source_description = source_description;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAddress1() {
		return Address1;
	}

	public void setAddress1(String address1) {
		Address1 = address1;
	}

	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String address2) {
		Address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getCreate_on() {
		return create_on;
	}

	public void setCreate_on(Date create_on) {
		this.create_on = create_on;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}

	public Date getCreated_by_user() {
		return created_by_user;
	}

	public void setCreated_by_user(Date created_by_user) {
		this.created_by_user = created_by_user;
	}

	public String getUpdated_by_user() {
		return updated_by_user;
	}

	public void setUpdated_by_user(String updated_by_user) {
		this.updated_by_user = updated_by_user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
