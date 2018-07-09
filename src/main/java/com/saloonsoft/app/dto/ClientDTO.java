package com.saloonsoft.app.dto;

import java.util.Date;

public class ClientDTO {

	private String UCID;
	private String firstName;
	private String surName;
	private boolean acceptsMarketting;
	private Date dateOfBirth;
	private String contactNumber;
	private String email;
	private String residentialaddress;
	private String postalAddress;

	
	/**
	 * @return the uCID
	 */
	public String getUCID() {
		return UCID;
	}
	/**
	 * @param uCID the uCID to set
	 */
	public void setUCID(String uCID) {
		UCID = uCID;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the surName
	 */
	public String getSurName() {
		return surName;
	}
	/**
	 * @param surName the surName to set
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}
	/**
	 * @return the acceptsMarketting
	 */
	public boolean isAcceptsMarketting() {
		return acceptsMarketting;
	}
	/**
	 * @param acceptsMarketting the acceptsMarketting to set
	 */
	public void setAcceptsMarketting(boolean acceptsMarketting) {
		this.acceptsMarketting = acceptsMarketting;
	}
	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}
	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the residentialaddress
	 */
	public String getResidentialaddress() {
		return residentialaddress;
	}
	/**
	 * @param residentialaddress the residentialaddress to set
	 */
	public void setResidentialaddress(String residentialaddress) {
		this.residentialaddress = residentialaddress;
	}
	/**
	 * @return the postalAddress
	 */
	public String getPostalAddress() {
		return postalAddress;
	}
	/**
	 * @param postalAddress the postalAddress to set
	 */
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
	
}
