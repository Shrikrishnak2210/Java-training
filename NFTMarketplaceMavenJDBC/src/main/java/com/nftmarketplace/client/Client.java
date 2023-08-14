package com.nftmarketplace.client;

import java.util.List;
import java.util.Scanner;
import com.nftmarketplace.exceptions.NFTNotFoundException;
import com.nftmarketplace.model.NFT;
import com.nftmarketplace.service.NFTServiceImpl;
import com.nftmarketplace.service.INFTService;

public class Client {

	public static void main(String[] args) {

		INFTService nftService = new NFTServiceImpl();

		String nftName;
		String creator;
		String category;
		double price;
		double balance;
		String address;
		List<NFT> nfts;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to MintSpace");
		try {
			while (true) {
				System.out.println("1.Search NFTs by creator\n2.Search NFTs by category\n3.View all NFTs\n"
						+ "4.Admin\n5.My Cart\n6.Add to Cart\n7.My Collection\n8.Wallet\n9.Exit\n");
				System.out.println("Enter choice:");
				int option = scanner.nextInt();
				scanner.nextLine();
				switch (option) {
				case 1:
					System.out.println("Enter creator name: ");
					creator = scanner.nextLine();
					try {
						nftService.getByCreator(creator).forEach(System.out::println);
					} catch (NFTNotFoundException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					break;
				case 2:
					System.out.println("Enter category: ");
					category = scanner.nextLine();
					try {
						nftService.getByCategory(category).forEach(System.out::println);
					} catch (NFTNotFoundException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					break;
				case 3:
					nfts = nftService.getAllNFTs();
					System.out.println("\nNFTs available in MintSpace");
					for (NFT book : nfts) {
						System.out.println(book);
					}
					System.out.println();
					break;
				case 4:
					System.out.println("Welcome to Admin Page");
					System.out.println(
							"1.Add NFT\n2.Delete NFT\n3.Update NFT price\n" + "4.Back to Main Menu\n");
					System.out.println("Enter choice:");

					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						scanner.nextLine();
						System.out.println("Enter NFT details");
						System.out.print("NFT name: ");
						nftName = scanner.nextLine();
						System.out.print("Creator: ");
						creator = scanner.nextLine();
						System.out.print("Category: ");
						category = scanner.nextLine();
						System.out.print("Price: ");
						price = scanner.nextDouble();
						nftService.addNFT(new NFT(nftName, creator, category, price));
						System.out.println();
						break;
					case 2:
						System.out.print("Enter NFT address to delete: ");
						address = scanner.next();
						nftService.deleteNFT(address);
						System.out.println();
						break;
					case 3:
						System.out.print("Enter NFT Address to update price: ");
						address = scanner.next();
						System.out.print("Enter new price: ");
						price = scanner.nextDouble();
						nftService.updateNFTPrice(address, price);
						System.out.println();
						break;
					case 4:
						System.out.println();
						break;
					default:
						System.out.println("Invalid choice\n");
						break;
					}
					break;

				case 5:
					System.out.println("My Cart");
					System.out.println(
							"1.Show NFTs in cart\n2.Delete NFT from Cart\n3.Buy from Cart\n" + "4.Back to Main Menu\n");
					System.out.println("Enter choice:");
					choice = scanner.nextInt();
					switch (choice) {
					case 1:
						nfts = nftService.getAllNFTsFromCart();
						System.out.println("\nNFTs in Cart");
						for (NFT nft : nfts) {
							System.out.println(nft);
						}
						System.out.println();
						break;
					case 2:
						System.out.print("Enter NFT address: ");
						address = scanner.next();
						nftService.deleteFromCart(address);
						System.out.println();
						break;
					case 3:
                        double total = nftService.buy();
                        if (total > 0) {
                            System.out.println("Total amount: " + total);
                            System.out.println("NFTs added to your collection\n");
                        }
                        break;
					case 4:
						System.out.println();
						break;
					default:
						System.out.println("Invalid choice\n");
						break;
					}
					break;

				case 6:
					System.out.print("Enter NFT Address to add to cart: ");
					address = scanner.next();
					try {
						nftService.addNFTToCart(address);
					} catch (NFTNotFoundException e) {
						System.out.println(e.getMessage());
					}
					System.out.println("Added to Cart\n");
					break;

				case 7:
					System.out.println("My Collection");
					System.out.println("1.Show NFTs in Collection\n2.Sell NFT\n3.Back to Main Menu\n");
					System.out.println("Enter choice:");
					choice = scanner.nextInt();

					switch (choice) {
					case 1:
						nfts = nftService.getAllNFTsFromCollection();
						System.out.println("\nNFTs in Collection");
						for (NFT nft : nfts) {
							System.out.println(nft);
						}
						System.out.println();
						break;
					case 2:
						System.out.println("Enter address");
						address = scanner.next();
						System.out.println(nftService.sell(address) + " Sold");
						System.out.println();
						break;
					case 3:
						System.out.println();
						break;
					default:
						System.out.println("Invalid choice\n");
						break;
					}

					break;

				case 8:
					System.out.println("My Wallet");
					System.out.println("1.Show balance\n2.Add Balance\n3.Back to Main Menu\n");
					System.out.println("Enter choice:");
					choice = scanner.nextInt();
					switch (choice) {
					case 1:
						System.out.println("\nBalance in Wallet");
						System.out.println(nftService.showBalance() + " ETH");
						System.out.println();
						break;
					case 2:
						System.out.println("Enter amount");
						balance = scanner.nextDouble();
						nftService.addBalance(balance);
						System.out.println("Balance added to your Wallet\n");
						break;
					case 3:
						System.out.println();
						break;
					default:
						System.out.println("Invalid choice\n");
						break;
					}
					break;
				case 9:
					System.out.println("Exited");
					System.exit(0);
				default:
					System.out.println("Invalid choice\n");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
