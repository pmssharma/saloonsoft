package com.saloonsoft.app.dto;

import java.util.Arrays;
import java.util.Date;

public class StaffDTO {

	private String id;
	private String uuid;
	private String firstName;
	private String surName;
	private String iDNumber;
	private Date dateOfBirth;
	private String contactNumber;
	private String email;
	private String staffNumber;
	private Date appointmentDate;
	private String residentialAddress;
	private String postalAddress;
	private String role; 
	private StaffServicesDTO[] staffServicesDTO;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
		return "StaffDTO [id=" + id + ", uuid=" + uuid + ", firstName=" + firstName + ", surName=" + surName
				+ ", iDNumber=" + iDNumber + ", dateOfBirth=" + dateOfBirth + ", contactNumber=" + contactNumber
				+ ", email=" + email + ", staffNumber=" + staffNumber + ", appointmentDate=" + appointmentDate
				+ ", residentialAddress=" + residentialAddress + ", postalAddress=" + postalAddress + ", role=" + role
				+ ", staffServicesDTO=" + Arrays.toString(staffServicesDTO) + "]";
	}
}
