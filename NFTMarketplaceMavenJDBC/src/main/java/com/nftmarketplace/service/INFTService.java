package com.nftmarketplace.service;

import java.util.List;

import com.nftmarketplace.exceptions.NFTNotFoundException;
import com.nftmarketplace.model.NFT;

public interface INFTService {
	void addNFT(NFT nft);

	void updateNFTPrice(String address, double price);

	void deleteNFT(String address);

	List<NFT> getAllNFTs();

	List<NFT> getByCategory(String category) throws NFTNotFoundException;

	List<NFT> getByCreator(String creator) throws NFTNotFoundException;

	void addNFTToCart(String address);

	List<NFT> getAllNFTsFromCart();

	void deleteFromCart(String address);

	double buy();

	List<NFT> getAllNFTsFromCollection();

	void addBalance(double balance);
	
	String sell(String address);
	
	double showBalance();
}
