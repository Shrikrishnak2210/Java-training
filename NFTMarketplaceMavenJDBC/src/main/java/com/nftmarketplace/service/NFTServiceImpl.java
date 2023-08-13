package com.nftmarketplace.service;

import java.util.List;
import java.util.stream.Collectors;
import com.nftmarketplace.model.NFT;
import com.nftmarketplace.dao.INFTDao;
import com.nftmarketplace.dao.NFTDaoImpl;
import com.nftmarketplace.exceptions.NFTNotFoundException;

public class NFTServiceImpl implements INFTService {

	INFTDao nftDao = new NFTDaoImpl();

	@Override
	public void addNFT(NFT nft) {
		nftDao.addNFT(nft);
	}

	@Override
	public void updateNFTPrice(String address, double price) {
		nftDao.updateNFTPrice(address, price);
	}

	@Override
	public void deleteNFT(String address) {
		nftDao.deleteNFT(address);
	}

	@Override
	public List<NFT> getAllNFTs() {
		return nftDao.findAllNFTs();
	}

	@Override
	public List<NFT> getByCategory(String category) throws NFTNotFoundException {
		List<NFT> nfts = nftDao.findByCategory(category);
		//check for empty List
		if (nfts.isEmpty())
			throw new NFTNotFoundException("NFT by category not found");
		return nfts.stream().sorted((nft1, nft2) -> nft1.getNftName().compareTo(nft2.getNftName()))
				.collect(Collectors.toList());
	}

	@Override
	public List<NFT> getByCreator(String creator) throws NFTNotFoundException {
		List<NFT> nfts = nftDao.findByCreator(creator);
		//check for empty List
		if (nfts.isEmpty())
			throw new NFTNotFoundException("NFT by creator not found");
		return nfts.stream().sorted((nft1, nft2) -> nft1.getNftName().compareTo(nft2.getNftName()))
				.collect(Collectors.toList());
	}

	@Override
	public void addNFTToCart(String address) {
		nftDao.addNFTToCart(address);
	}

	@Override
	public List<NFT> getAllNFTsFromCart() {
		return nftDao.findAllNFTsFromCart();
	}

	@Override
	public void deleteFromCart(String address) {
		nftDao.deleteFromCart(address);
	}

	@Override
	public double buy() {
		double total = nftDao.buy();
		//check for NFTs in Cart
		if (total == 0) {
			System.out.println("Cart is empty\n");
		}
		return total;
	}


	@Override
	public List<NFT> getAllNFTsFromCollection() {
		return nftDao.findAllNFTsFromCollection();
	}

	@Override
	public void addBalance(double balance) {
		nftDao.addBalance(balance);
	}

	@Override
	public double showBalance() {
		return nftDao.showBalance();
	}

	@Override
	public String sell(String address) {
		return nftDao.sell(address);
	}

}
