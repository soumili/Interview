import java.util.Scanner;

/*
 * @author Soumili
 */

public class StringToLong {

	public static void main(String[] args) {
		test();
	}

	public static long stringToLong(String num) {
		if (null == num || num.length() == 0) {
			System.out.println("Empty entry.");
			return -1;
		}
		
		Boolean res = checkIfNum(num);
		if (!res) {
			return -1;
		}
		
		int len = num.length();
		int i = 0;
		Boolean neg = false;
		long result = 0;
		
		while (i < len) {
			if (i == 0 && num.charAt(i) == '-') {
				neg = true;
			} else {
				result = result * 10 + (num.charAt(i) - '0');
			}
			i++;
		}
		if (neg) {
			result *= (-1);
		}

		return result;
	}

	/*checks if the input string has only digits or not*/
	public static Boolean checkIfNum(String num) {
		return num.matches("[-+]?\\d*\\d+");
	}

	/*Result is -1 if the input is non-numeric*/
	public static void test() {
		String num;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number: ");
		num = scan.next();
		System.out.println("NUMBER IS: " + stringToLong(num));
	}
}
