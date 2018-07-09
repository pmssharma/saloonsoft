package com.saloonsoft.app.dto;

import java.util.Date;

public class StaffDTO {

	private String UUID;
	private String firstName;
	private String surName;
	private String iDNumber;
	private Date dateOfBirth;
	private String contactNumber;
	private String email;
	private String staffNumber;
	private Date appointmentDate;
	private String residentialaddress;
	private String postaladdress;
	private String role; 
	private StaffServicesDTO[] staffServicesDTO;
	
	
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
	 * @return the uUID
	 */
	public String getUUID() {
		return UUID;
	}
	/**
	 * @param uUID the uUID to set
	 */
	public void setUUID(String uUID) {
		UUID = uUID;
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
	 * @return the iDNumber
	 */
	public String getiDNumber() {
		return iDNumber;
	}
	/**
	 * @param iDNumber the iDNumber to set
	 */
	public void setiDNumber(String iDNumber) {
		this.iDNumber = iDNumber;
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
	 * @return the staffNumber
	 */
	public String getStaffNumber() {
		return staffNumber;
	}
	/**
	 * @param staffNumber the staffNumber to set
	 */
	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}
	/**
	 * @return the appointmentDate
	 */
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	/**
	 * @param appointmentDate the appointmentDate to set
	 */
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	/**
	 * @return the postaladdress
	 */
	public String getPostaladdress() {
		return postaladdress;
	}
	/**
	 * @param postaladdress the postaladdress to set
	 */
	public void setPostaladdress(String postaladdress) {
		this.postaladdress = postaladdress;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	public StaffServicesDTO[] getStaffServicesDTO() {
		return staffServicesDTO;
	}
	public void setStaffServicesDTO(StaffServicesDTO[] staffServicesDTO) {
		this.staffServicesDTO = staffServicesDTO;
	}
	
}
