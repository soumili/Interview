package CTCI_V.Chapter1;

import java.util.Scanner;

/*1.4 Write a method to replace all spaces in a string with "%20". You may assume string has sufficient space in the end to hold
 *the extra characters and that you're given true length of the string.*/

/*
 * @author Soumili
 */

public class ReplaceSpaces {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String str = scan.nextLine();

		replaceSpace(str);
	}

	public static void replaceSpace(String str) {
		if (null == str) {
			System.out.println("Empty String!");
			System.exit(0);
		}

		String result = new String();
		for (int i = 0; i < str.length(); i++) {
			result += ((str.charAt(i) == ' ') ? "%20" : str.charAt(i));
		}
		System.out.println(result);
	}
}
