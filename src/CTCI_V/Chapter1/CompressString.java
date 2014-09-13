package CTCI_V.Chapter1;

/*1.5 Implement a method to perform basic string compression using the counts of the repeated characters. For example aabccccaaa will become a2b1c4a3.
 If the length of the result string is not smaller than original string return original string.*/

/*
 * @author Soumili
 */

import java.util.Scanner;

public class CompressString {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String str = scan.next();

		str = compressedString(str);
		System.out.println("Compressed string: " + str);
	}

	public static String compressedString(String str) {
		if (null == str) {
			System.out.println("Empty String!");
			System.exit(0);
		}

		if (str.length() == 1) {
			return str;
		}
		int len = str.length();
		int count = 0;

		String res = new String();
		res += str.charAt(0);
		count++;
		for (int i = 1; i < len; i++) {
			if (str.charAt(i) != str.charAt(i - 1)) {
				res = res + count + str.charAt(i);
				count = 1;
			} else {
				count++;
			}
		}
		res += count;
		if (res.length() < str.length()) {
			return res;
		} else {
			return str;
		}
	}
}
