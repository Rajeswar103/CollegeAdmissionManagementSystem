package com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="student_admin_records")
public class Student {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="admin_id")
	private  Integer admissionId;
	@Size(max = 15,message = "plz enter your first name below 15 letters")
	@Column(name="firstname")
	private String firstName;
	@Size(max = 15,message = "plz enter your last name below 15 letters")
	@Column(name="lastname")
	private String lastName;
	@Size(max = 25,message = "plz enter your fathername below 15 letters")
	@Column(name="fathername")
	private String fatherName;
	@Size(max = 25,message = "plz enter your mothername below 15 letters")
	@Column(name="mothername")
	private String motherName;
	@Pattern(regexp = "[7-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]",message = "plz enter your mobile number in these format +91**********")
	@Column(name="mobilenumber")
	private String mobileNumber;
	@Column(name="eamil")
	private String email;
	@Min(value = 2,message = "plz enter your percentage Integer format")
	@Column(name="marks")
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
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Integer admissionId,
			@Size(max = 15, message = "plz enter your first name below 15 letters") String firstName,
			@Size(max = 15, message = "plz enter your last name below 15 letters") String lastName,
			@Size(max = 25, message = "plz enter your fathername below 15 letters") String fatherName,
			@Size(max = 25, message = "plz enter your mothername below 15 letters") String motherName,
			@Pattern(regexp = "[7-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]", message = "plz enter your mobile number in these format +91**********") String mobileNumber,
			String email,
			@Min(value = 2, message = "plz enter your percentage Integer format") Integer intermiadateMarks) {
		super();
		this.admissionId = admissionId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.intermiadateMarks = intermiadateMarks;
	}
	
	

}
