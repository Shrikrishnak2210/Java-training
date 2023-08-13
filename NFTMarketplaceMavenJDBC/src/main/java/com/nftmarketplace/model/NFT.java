package com.nftmarketplace.model;

public class NFT {
	private String address;
	private String nftName;
	private String creator;
	private String category;
//	private double balance;
	private double price;

	public NFT() {
		super();
	}

	public NFT( String nftName, String creator, String category, double price) {
		super();
		this.nftName = nftName;
		this.creator = creator;
		this.category = category;
//		this.balance = balance;
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNftName() {
		return nftName;
	}

	public void setNftName(String nftName) {
		this.nftName = nftName;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

//	public double getBalance() {
//		return balance;
//	}
//
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "NFT [address=" + address + ", nftName=" + nftName + ", creator=" + creator + ", category=" + category
				+ ", price=" + price + " ETH]";
	}

//	@Override
//	public String toString() {
//		return "NFT [address=" + address + ", nftName=" + nftName + ", creator=" + creator + ", category=" + category
//				+ ", balance=" + balance + ", price=" + price + "]";
//	}
	
	

}
