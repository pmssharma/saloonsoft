package com.saloonsoft.app.dto;

import java.util.Date;

public class ClientDTO {

	private String clientId;
	private String ucid;
	private String firstName;
	private String surName;
	private boolean acceptsMarketting;
	private Date dateOfBirth;
	private String contactNumber;
	private String email;
	private String residentialAddress;
	private String postalAddress;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public String getUcid() {
		return ucid;
	}
	public void setUcid(String ucid) {
		this.ucid = ucid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public boolean isAcceptsMarketting() {
		return acceptsMarketting;
	}
	public void setAcceptsMarketting(boolean acceptsMarketting) {
		this.acceptsMarketting = acceptsMarketting;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getResidentialAddress() {
		return residentialAddress;
	}
	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}
	public String getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
	@Override
	public String toString() {
		return "ClientDTO [clientId=" + clientId + ", ucid=" + ucid + ", firstName=" + firstName + ", surName="
				+ surName + ", acceptsMarketting=" + acceptsMarketting + ", dateOfBirth=" + dateOfBirth
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", residentialAddress=" + residentialAddress
				+ ", postalAddress=" + postalAddress + ", getClientId()=" + getClientId() + ", getUcid()=" + getUcid()
				+ ", getFirstName()=" + getFirstName() + ", getSurName()=" + getSurName() + ", isAcceptsMarketting()="
				+ isAcceptsMarketting() + ", getDateOfBirth()=" + getDateOfBirth() + ", getContactNumber()="
				+ getContactNumber() + ", getEmail()=" + getEmail() + ", getResidentialAddress()="
				+ getResidentialAddress() + ", getPostalAddress()=" + getPostalAddress() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}