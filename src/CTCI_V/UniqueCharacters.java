package CTCI_V;

import java.util.Scanner;

/*1.1 Implement an algorithm to determine if a string has all unique characters. What if you cannot use extra data structures?*/

public class UniqueCharacters {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String str = scan.next();

		Boolean res = checkIfUnique(str);
		if (res) {
			System.out.println(str + " has unique characters!");
		} else {
			System.out.println(str + " does not have unique characters!");
		}
	}

	public static Boolean checkIfUnique(String str) {
		int len = str.length();

		if (len == 0 || null == str) {
			System.out.println("Empty string!");
			System.exit(0);
		}

		if (len > 256) {
			return false;
		}

		boolean[] charfound = new boolean[256];

		for (int i = 0; i < len; i++) {
			int num = str.charAt(i);
			if (charfound[num]) {
				return false;
			} else {
				charfound[num] = true;
			}
		}

		return true;
	}
}