package com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.dto;

public class StudentDto {
	
	
	private  Integer admissionId;
	private String firstName;
	private String lastName;
	private String fatherName;
	private String motherName;
	private String mobileNumber;
	private String email;
	private Integer intermiadateMarks;
	public Integer getAdmissionId() {
		return admissionId;
	}
	public void setAdmissionId(Integer admissionId) {
		this.admissionId = admissionId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getIntermiadateMarks() {
		return intermiadateMarks;
	}
	public void setIntermiadateMarks(Integer intermiadateMarks) {
		this.intermiadateMarks = intermiadateMarks;
	}
	

}
