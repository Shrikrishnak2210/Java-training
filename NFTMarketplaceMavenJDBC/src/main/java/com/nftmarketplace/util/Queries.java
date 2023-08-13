package com.nftmarketplace.util;

public class Queries {
	public static final String CREATEQUERY = "create table if not exists nfts(nftName varchar(40) not null,"
			+ "creator varchar(40) not null,category varchar(40) not null,"
			+ "address varchar(40) primary key ,price double);";
	public static final String CREATECARTQUERY = "create table if not exists cart(nftName varchar(40) not null,"
			+ "creator varchar(40) not null,category varchar(40) not null,"
			+ "address varchar(40) primary key ,price double);";
	public static final String CREATECOLLECTIONQUERY = "create table if not exists collection(nftName varchar(40) not null,"
			+ "creator varchar(40) not null,category varchar(40) not null,"
			+ "address varchar(40) primary key ,price double);";
	public static final String CREATEWALLETQUERY = "create table if not exists wallet(id int NOT NULL "
			+ "auto_increment primary key, balance double not null default 0.00);";
	
	public static final String QUERYALL = "select * from nfts;";
	public static final String QUERYBYADDRESS = "select * from collection where address=?;";
	public static final String QUERYBYCATEGORY = "select * from nfts where category = CONCAT(?);";
	public static final String QUERYBYCREATOR = "select * from nfts where creator = CONCAT(?);";
	public static final String QUERYALLCART = "select * from cart;";
	public static final String QUERYALLCOLLECTION = "select * from collection;";
	public static final String QUERYWALLET = "select * from wallet;";
	public static final String QUERYROWS = "select COUNT(*) from wallet;";

	public static final String INSERTQUERY = "insert into nfts(nftName,creator,category,address,price) "
			+ "values(?,?,?,?,?);";
	public static final String INSERTCARTQUERY = "insert into cart(nftName,creator,category,address,price)"
			+ " select * from nfts where address=?;";
	public static final String INSERTCOLLECTIONQUERY = "insert into collection(nftName,creator,category,address,price)"
			+ " select * from cart where address=?;";
	public static final String INSERTBALANCEQUERY = "insert into wallet(balance) values(?);";
	
	public static final String UPDATEPRICEQUERY = "update nfts set price=? where address=?;";
	public static final String ADDBALANCEQUERY = "update wallet set balance = balance + ? where id = 1;";
	public static final String DEDUCTBALANCEQUERY = "update wallet set balance = balance - ? where id = 1;";

	public static final String DELETEQUERY = "delete from nfts where address=?;";
	public static final String DELETEFROMCARTQUERY = "delete from cart where address=?;";
	public static final String DELETEFROMCOLLECTION = "delete from collection where address=?;";

}
