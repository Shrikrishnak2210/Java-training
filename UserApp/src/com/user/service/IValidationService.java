package com.user.service;

import com.user.exception.NameExistException;
import com.user.exception.TooLongException;
import com.user.exception.TooShortException;

public interface IValidationService {
	boolean validateUsername(String username) throws NameExistException;
	boolean validatePassword(String password) throws TooShortException,TooLongException;
	
}

