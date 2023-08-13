package com.nftmarketplace.exceptions;

public class NFTNotFoundException extends RuntimeException {

	public NFTNotFoundException() {
		super();
	}

	public NFTNotFoundException(String message) {
		super(message);
	}
	
}
