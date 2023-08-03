package com.lumen.scan;

import java.util.Scanner;

public class LongestWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length = 0;
		String longestWord = "";
		System.out.println("Enter sentence");
		Scanner scanner = new Scanner(System.in);
		String sentence = scanner.nextLine();
		String[] words = sentence.split(" ");
		for (String word : words) {
			if (length < word.length()) {
				longestWord = word;
			}
		}
		System.out.println("Longest word is " + longestWord);
		scanner.close();
	}

}
