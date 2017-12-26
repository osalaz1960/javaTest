package com.bycle.fdv;

 

public class ValidationException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	private ValidationExceptionCode validationExceptionCode;
	
	public ValidationException(ValidationExceptionCode validationExceptionCode, String message)
	{
		super(message);
		this.validationExceptionCode = validationExceptionCode;
	}

	public ValidationExceptionCode getValidationExceptionCode()
	{
		return validationExceptionCode;
	}


}