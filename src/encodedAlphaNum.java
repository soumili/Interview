
import java.util.Scanner;

public class encodedAlphaNum {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int num = scan.nextInt();
		
		if(num < 0) {
			System.out.println("Number is negative. Cannot decode....");
			return;
		}
		
		int len = (int) Math.log10(num) + 1;
		int res = 0;
		
		res += decodeEachAlpha(num, len);
		res += decodeFromBeginning(num, len);
		res += decodeFromEnd(num, len);
		
		System.out.println(num + " can be encoded " + res + " number of ways.");
	}
	
	public static int decodeEachAlpha(int num, int len) {	
		StringBuilder sb = new StringBuilder();
		int res;
		
		for(int i = 0; i < len; i++) {
			res = num % 10;
			res -= 1;
			res += 97;
			sb.append((char) res);
			num = num / 10;
		}
		
		sb.reverse();
		System.out.println(sb.toString());
		if(sb.length() > 0)
			return 1;
		else
			return 0;
	}
	
	public static int decodeFromBeginning(int num, int len) {
		StringBuilder sb = new StringBuilder();
		int res, pow, toPow;
		
		while (num != 0) {
			if(len - 2 > 0)
				toPow = len - 2;
			else if(len - 1 > 0)
				toPow = len - 1;
			else
				toPow = 0;
			pow = (int) Math.pow(10, toPow);
			res = (int) num / pow;
			if (res < 26) {
				num -= (res * pow);
				res -= 1;
				res += 97;
				sb.append((char) res);
				if(pow != 1)
					len -= 2;
				else
					len -= 1;
			}
		}
		
		System.out.println(sb.toString());
		if(sb.length() > 0)
			return 1;
		else
			return 0;
	}
	
	public static int decodeFromEnd(int num, int len) {
		StringBuilder sb = new StringBuilder();
		int res;
		
		for(int i = 0; i < len; i++) {
			if(num % 100 < 26) {
				res = num % 100;
				res -= 1;
				res += 97;
				sb.append((char) res);
				num = num / 100;
				i++;
			} else {
				res = num % 10;
				res -= 1;
				res += 97;
				sb.append((char) res);
				num = num / 10;
			}
		}

		sb.reverse();
		System.out.println(sb.toString());
		if(sb.length() > 0)
			return 1;
		else
			return 0;
	}
}