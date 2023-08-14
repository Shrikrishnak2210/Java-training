package com.nftmarketplace.dao;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.nftmarketplace.exceptions.InsufficientBalanceException;
import com.nftmarketplace.exceptions.NFTNotFoundException;
import com.nftmarketplace.model.NFT;
import com.nftmarketplace.util.DbConnection;
import com.nftmarketplace.util.Queries;

public class NFTDaoImpl implements INFTDao {
	private static final String CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	@Override
	public void addNFT(NFT nft) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement insertStatement = connection.prepareStatement(Queries.INSERTQUERY);) {
			// generate unique random address
			SecureRandom random = new SecureRandom();
			StringBuilder address = new StringBuilder();
			String hashAddress = "";
			for (int i = 0; i < 16; i++) {
				int randomIndex = random.nextInt(CHARS.length());
				char randomChar = CHARS.charAt(randomIndex);
				address.append(randomChar);
			}
			hashAddress = "0x" + address.toString();

			// set the properties to add to nfts table
			insertStatement.setString(1, nft.getNftName());
			insertStatement.setString(2, nft.getCreator());
			insertStatement.setString(3, nft.getCategory());
			insertStatement.setString(4, hashAddress);
			insertStatement.setDouble(5, nft.getPrice());
			insertStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int updateNFTPrice(String address, double price) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement updatePrice = connection.prepareStatement(Queries.UPDATEPRICEQUERY);) {
			updatePrice.setDouble(1, price);
			updatePrice.setString(2, address);
			updatePrice.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public void deleteNFT(String address) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement deleteStatement = connection.prepareStatement(Queries.DELETEQUERY);) {
			deleteStatement.setString(1, address);
			deleteStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<NFT> findAllNFTs() {
		List<NFT> nfts = new ArrayList<>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement getAllNFTs = connection.prepareStatement(Queries.QUERYALL);) {
			ResultSet result = getAllNFTs.executeQuery();
			while (result.next()) {
				NFT nft = new NFT();

				// get the properties from nfts table and set to NFT object to display on
				// console
				String name = result.getString("nftName");
				String creator = result.getString("creator");
				String category = result.getString("category");
				String address = result.getString("address");
				double price = result.getDouble("price");
				nft.setNftName(name);
				nft.setCreator(creator);
				nft.setCategory(category);
				nft.setAddress(address);
				nft.setPrice(price);
				nfts.add(nft);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nfts;
	}

	@Override
	public List<NFT> findByCategory(String category) throws NFTNotFoundException {
		List<NFT> nfts = new ArrayList<>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement getByCategory = connection.prepareStatement(Queries.QUERYBYCATEGORY);) {
			// find NFTs based on category
			getByCategory.setString(1, category);
			ResultSet result = getByCategory.executeQuery();
			while (result.next()) {
				NFT nft = new NFT();

				// get the properties from nfts table and set to NFT object to display on
				// console
				String name = result.getString("nftName");
				String creator = result.getString("creator");
				String address = result.getString("address");
				double price = result.getDouble("price");
				nft.setNftName(name);
				nft.setCreator(creator);
				nft.setCategory(category);
				nft.setAddress(address);
				nft.setPrice(price);
				nfts.add(nft);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nfts;
	}

	@Override
	public List<NFT> findByCreator(String creator) throws NFTNotFoundException {
		List<NFT> nfts = new ArrayList<>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement getByCreator = connection.prepareStatement(Queries.QUERYBYCREATOR);) {
			// find NFTs based on creator
			getByCreator.setString(1, creator);
			ResultSet result = getByCreator.executeQuery();
			while (result.next()) {
				NFT nft = new NFT();

				// get the properties from nfts table and set to NFT object to display on
				// console
				String name = result.getString("nftName");
				String category = result.getString("category");
				String address = result.getString("address");
				double price = result.getDouble("price");
				nft.setNftName(name);
				nft.setCreator(creator);
				nft.setCategory(category);
				nft.setAddress(address);
				nft.setPrice(price);
				nfts.add(nft);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nfts;
	}

	@Override
	public void addNFTToCart(String address) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement insertStatement = connection.prepareStatement(Queries.INSERTCARTQUERY);) {
			// add NFT to cart based on address
			insertStatement.setString(1, address);
			insertStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<NFT> findAllNFTsFromCart() {
		List<NFT> nfts = new ArrayList<>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement getNFTsFromCart = connection.prepareStatement(Queries.QUERYALLCART);) {
			ResultSet result = getNFTsFromCart.executeQuery();
			while (result.next()) {
				NFT nft = new NFT();

				// get the properties from cart table and set to NFT object to display on
				// console
				String name = result.getString("nftName");
				String creator = result.getString("creator");
				String category = result.getString("category");
				String address = result.getString("address");
				double price = result.getDouble("price");
				nft.setNftName(name);
				nft.setCreator(creator);
				nft.setCategory(category);
				nft.setAddress(address);
				nft.setPrice(price);
				nfts.add(nft);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nfts;
	}

	@Override
	public void deleteFromCart(String address) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement deleteFromCart = connection.prepareStatement(Queries.DELETEFROMCARTQUERY);) {
			// delete NFT from cart table based on address
			deleteFromCart.setString(1, address);
			deleteFromCart.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public double buy() {
		double totalCost = 0;
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement getAllFromCart = connection.prepareStatement(Queries.QUERYALLCART);
				PreparedStatement getBalance = connection.prepareStatement(Queries.QUERYWALLET);
				PreparedStatement deductStatement = connection.prepareStatement(Queries.DEDUCTBALANCEQUERY);
				PreparedStatement insertStatement = connection.prepareStatement(Queries.INSERTCOLLECTIONQUERY);
				PreparedStatement deleteFromCart = connection.prepareStatement(Queries.DELETEFROMCARTQUERY);
				PreparedStatement deleteStatement = connection.prepareStatement(Queries.DELETEQUERY);) {
			// get all NFTs from cart table
			ResultSet result = getAllFromCart.executeQuery();
			while (result.next()) {
				// get total price to buy from cart
				double price = result.getDouble("price");
				totalCost += price;
				
				// get balance from wallet table and check for insufficient balance
				ResultSet resultSet = getBalance.executeQuery();
				double balance = 0;
				if (resultSet.next()) // change this;
					balance = resultSet.getDouble("balance");
				if (totalCost > balance) {
					throw new InsufficientBalanceException();
				}

				// deduct balance from wallet
				deductStatement.setDouble(1, totalCost);
				deductStatement.executeUpdate();

				// delete NFT from MintSpace
				String address = result.getString("address");
				deleteStatement.setString(1, address);
				deleteStatement.execute();

				// add NFT to collection table based on address
				insertStatement.setString(1, address);
				insertStatement.execute();
				
				// delete NFT from cart table based on address
				deleteFromCart.setString(1, address);
				deleteFromCart.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCost;
	}

	@Override
	public List<NFT> findAllNFTsFromCollection() {
		List<NFT> nfts = new ArrayList<>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement getAllFromCollection = connection.prepareStatement(Queries.QUERYALLCOLLECTION);) {
			ResultSet result = getAllFromCollection.executeQuery();
			while (result.next()) {
				NFT nft = new NFT();

				// get the properties from collection table and set to NFT object to display on
				// console
				String name = result.getString("nftName");
				String creator = result.getString("creator");
				String category = result.getString("category");
				String address = result.getString("address");
				double price = result.getDouble("price");
				nft.setNftName(name);
				nft.setCreator(creator);
				nft.setCategory(category);
				nft.setAddress(address);
				nft.setPrice(price);
				nfts.add(nft);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nfts;
	}

	@Override
	public void addBalance(double balance) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement getAll = connection.prepareStatement(Queries.QUERYWALLET);
				PreparedStatement updateStatement = connection.prepareStatement(Queries.ADDBALANCEQUERY);
				PreparedStatement countRow = connection.prepareStatement(Queries.QUERYROWS);
				PreparedStatement insertStatement = connection.prepareStatement(Queries.INSERTBALANCEQUERY);) {

			// count row to check if balance exists
			ResultSet countResultSet = countRow.executeQuery();
			countResultSet.next();
			int rowCount = countResultSet.getInt(1);
			if (rowCount == 0) { // if balance doesn't exist then insert balance
				insertStatement.setDouble(1, balance);
				insertStatement.executeUpdate();
			} else {
				// else update balance
				ResultSet resultSet = getAll.executeQuery();
				resultSet.next();
				updateStatement.setDouble(1, balance);
				updateStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public double showBalance() {
		double balance = 0;
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement getBalance = connection.prepareStatement(Queries.QUERYWALLET);) {
			// get balance from wallet table
			ResultSet result = getBalance.executeQuery();
			while (result.next()) {
				balance = result.getDouble("balance");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return balance;
	}

	@Override
	public String sell(String address) {
		String name = "";
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement getBalance = connection.prepareStatement(Queries.QUERYWALLET);
				PreparedStatement insertStatement = connection.prepareStatement(Queries.INSERTQUERY);
				PreparedStatement collectionStatement = connection.prepareStatement(Queries.QUERYALLCOLLECTION);
				PreparedStatement creditStatement = connection.prepareStatement(Queries.ADDBALANCEQUERY);
				PreparedStatement getAddressStatement = connection.prepareStatement(Queries.QUERYBYADDRESS);
				PreparedStatement deleteStatement = connection.prepareStatement(Queries.DELETEFROMCOLLECTION);) {

			// get all NFTs from collection
			ResultSet result = collectionStatement.executeQuery();
			while (result.next()) {
				double amount = 0;
				// set the properties to insert in MintSpace
				name = result.getString("nftName");
				String creator = result.getString("creator");
				String category = result.getString("category");
				address = result.getString("address");
				double price = result.getDouble("price");
				getAddressStatement.setString(1, address);
				ResultSet addressSet = getAddressStatement.executeQuery();
				// get balance from wallet table and add the balance after selling NFT
				if (addressSet.next())
					amount = addressSet.getDouble("price");
				getAddressStatement.execute();

				ResultSet resultSet = getBalance.executeQuery();
				resultSet.next();
				creditStatement.setDouble(1, amount);
				creditStatement.executeUpdate();

				// add NFT to MintSpace
				insertStatement.setString(1, name);
				insertStatement.setString(2, creator);
				insertStatement.setString(3, category);
				insertStatement.setString(4, address);
				insertStatement.setDouble(5, price);
				insertStatement.executeUpdate();

				// delete NFT from collection table after selling
				deleteStatement.setString(1, address);
				deleteStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// return name of the NFT that is sold
		return name;
	}
}
