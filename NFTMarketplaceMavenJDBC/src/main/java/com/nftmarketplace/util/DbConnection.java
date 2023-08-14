package com.nftmarketplace.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {
	static Connection connection;

	public static Connection openConnection() {
		String url = "jdbc:mysql://localhost:3306/mysql";
		String username = "root";
		String password = "admin@123";

		try {
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement createQuery = connection.prepareStatement(Queries.CREATEQUERY);
			PreparedStatement createCart = connection.prepareStatement(Queries.CREATECARTQUERY);
			PreparedStatement createWallet = connection.prepareStatement(Queries.CREATEWALLETQUERY);
			PreparedStatement createCollection = connection.prepareStatement(Queries.CREATECOLLECTIONQUERY);
			createQuery.execute();
			createCart.execute();
			createCollection.execute();
			createWallet.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
