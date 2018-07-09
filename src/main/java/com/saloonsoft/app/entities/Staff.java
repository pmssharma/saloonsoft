package com.saloonsoft.app.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.saloonsoft.app.dto.StaffServicesDTO;

@Document(collection = "Staff")
public class Staff {

	@Id
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
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
	
	
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
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
	public String getiDNumber() {
		return iDNumber;
	}
	public void setiDNumber(String iDNumber) {
		this.iDNumber = iDNumber;
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
	public String getStaffNumber() {
		return staffNumber;
	}
	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getResidentialaddress() {
		return residentialaddress;
	}
	public void setResidentialaddress(String residentialaddress) {
		this.residentialaddress = residentialaddress;
	}
	public String getPostaladdress() {
		return postaladdress;
	}
	public void setPostaladdress(String postaladdress) {
		this.postaladdress = postaladdress;
	}
	public String getRole() {
		return role;
	}
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
