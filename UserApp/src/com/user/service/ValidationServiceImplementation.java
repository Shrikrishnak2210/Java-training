package com.user.service;

import com.user.exception.NameExistException;
import com.user.exception.TooLongException;
import com.user.exception.TooShortException;

public class ValidationServiceImplementation implements IValidationService {
	String[] usernames = { "Tony", "John", "Peter" };

	@Override
	public boolean validateUsername(String username) throws NameExistException {
		for (String name : usernames) {
			if (name.equals(username))
				throw new NameExistException("Name already exists");
		}
		return true;
	}

	@Override
	public boolean validatePassword(String password) throws TooShortException, TooLongException {
		if (password.length() < 8)
			throw new TooShortException("Password length should be more than 8");
		else if (password.length() > 16) {
			throw new TooLongException("Password length should be less than 16");
		} else
			return true;
	}

}
