package CTCI_V.Chapter1;

/*1.8 Assume you have a method isSubstring which checks if one word is a substring of the other.
 Given two strings s1 and s2 write a code to check if s2 is a rotation of s1.
 (eg. waterbottle is a rotation os erbottlewat)*/

/*
 * @author Soumili
 */

import java.util.Scanner;

public class CheckRotated {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string1: ");
		String str1 = scan.nextLine();
		System.out.println("Enter the string2: ");
		String str2 = scan.nextLine();

		isSubstring(str1, str2);
	}

	public static void isSubstring(String str1, String str2) {
		if (str1.isEmpty() || str2.isEmpty() || null == str1 || null == str2) {
			System.out
					.println("Cannot perform check, the string(s) entered might be empty");
			System.exit(0);
		}
		
		if (str1.length() != str2.length()) {
			System.out.println(str2 + " is not a rotation of " + str1);
			return;
		}
		
		String joined = str1 + str1;

		if (joined.contains(str2)) {
			System.out.println(str2 + " is a rotation of " + str1);
		} else {
			System.out.println(str2 + " is not a rotation of " + str1);
		}
	}
}
