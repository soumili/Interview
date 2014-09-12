package CTCI_V;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*1.3 Given two strings, write a method to decide if one is the permutation of the other.*/

public class StringPermutation {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string1: ");
		String str1 = scan.next();
		System.out.println("Enter the string2: ");
		String str2 = scan.next();

		boolean res = checkPermutation(str1, str2);
		if (res) {
			System.out.println(str2 + " is a permutation of " + str1);
		} else {
			System.out.println(str2 + " is not a permutation of " + str1);
		}
	}

	public static boolean checkPermutation(String str1, String str2) {
		if (null == str1 || null == str2 || str1.isEmpty() || str2.isEmpty()) {
			return false;
		}
		if (str1.length() != str2.length()) {
			return false;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		int len = str1.length() - 1;
		while (len >= 0) {
			if (map.containsKey(str1.charAt(len))) {
				Integer val = map.get(str1.charAt(len)) + 1;
				map.put(str1.charAt(len), val);
			} else {
				map.put(str1.charAt(len), 0);
			}
			len--;
		}

		len = str2.length() - 1;
		while (len >= 0) {
			if (!map.containsKey(str2.charAt(len))) {
				return false;
			}
			len--;
		}
		return true;
	}
}
