package com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.exceptions;

public class StudentNotEligible  extends Exception{
	
	
	public String getMessage()
	{
		return "your intermidiate percentage is less than 70 so your are not eligibel for these college Admissions";
		
	}

}
