package com.lumen.scan;

import java.util.Scanner;

public class MaxOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxCount = 0;
		int[] count = new int[26];
		char letter = ' ';
		System.out.println("Enter word");
		Scanner scanner = new Scanner(System.in);
		String word = scanner.next();
		for (int i = 0; i < word.length(); i++) {
			count[word.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (count[i] > maxCount) {
				maxCount = count[i];
				letter = (char) (i + 'a');
			}
		}
		System.out.println("The maximum occurrence of " + letter + " is " + maxCount);
		scanner.close();

	}

}
