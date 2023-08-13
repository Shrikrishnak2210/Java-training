package com.nftmarketplace.dao;

import java.util.List;

import com.nftmarketplace.exceptions.NFTNotFoundException;
import com.nftmarketplace.model.NFT;

public interface INFTDao {
	void addNFT(NFT nft);

	int updateNFTPrice(String address, double price);

	void deleteNFT(String address);

	List<NFT> findAllNFTs();

	List<NFT> findByCategory(String category) throws NFTNotFoundException;

	List<NFT> findByCreator(String creator) throws NFTNotFoundException;

	void addNFTToCart(String address);

	List<NFT> findAllNFTsFromCart();

	void deleteFromCart(String address);

	double buy();

	List<NFT> findAllNFTsFromCollection();

	void addBalance(double balance);

	double showBalance();
	
	String sell(String address);
}
