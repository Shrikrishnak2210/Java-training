package com.voterapp.service;

import com.voterapp.exception.InValidVoterException;
import com.voterapp.exception.LocalityNotFoundException;
import com.voterapp.exception.NoVoterIdException;
import com.voterapp.exception.UnderAgeException;

public class ElectionBoothImpl implements IElectionBooth {
	String[] localities = { "Panathur", "Bellandur", "Kormangala" };

	@Override
	public boolean checkEligibility(int age, String locality, int voterId) throws InValidVoterException {
		try {
			if (checkAge(age) && checkLocality(locality) && checkVoterId(voterId))
				return true;
		} catch (UnderAgeException | LocalityNotFoundException | NoVoterIdException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	private boolean checkAge(int age) throws UnderAgeException {
		if (age < 18) {
			throw new UnderAgeException("Under Age");
		}
		return true;
	}

	private boolean checkLocality(String locality) throws LocalityNotFoundException {
		boolean check = true;
		for (String local : localities) {
			if (local.equals(locality))
				check = false;
		}
		if (check) {
			throw new LocalityNotFoundException("Locality not found");
		}
		return true;
	}

	private boolean checkVoterId(int vid) throws NoVoterIdException {
		if (vid < 1000 || vid > 9999) {
			throw new NoVoterIdException("Voter ID does not exists");
		}
		return true;
	}

}
