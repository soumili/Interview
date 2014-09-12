package CTCI_V;

import java.util.Scanner;

/*1.2 Implement a function void reverse(char* str) which reverses a null terminated string.*/

public class ReverseString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String str = scan.next();

		reverse(str);
	}

	public static void reverse(String str) {
		if (str.length() == 0 || null == str) {
			System.out.println("Empty string!");
			System.exit(0);
		}

		StringBuilder sb = new StringBuilder(str);
		int end = str.length() - 1;
		int start = 0;
		while (start <= end) {
			char temp = str.charAt(start);
			sb.setCharAt(start, str.charAt(end));
			sb.setCharAt(end, temp);
			start++;
			end--;
		}
		System.out.println("Reversed string: " + sb.toString());
	}
}
