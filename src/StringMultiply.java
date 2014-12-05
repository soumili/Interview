import java.util.Scanner;

/*Input two numbers as strings, multiply and display answer*/

/*
 * @author Soumili
 */

public class StringMultiply {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number1: ");
		String num1 = scan.next();
		System.out.println("Enter number2: ");
		String num2 = scan.next();
		
		boolean isInt1, isInt2;
		isInt1 = isInteger(num1);
		isInt2= isInteger(num2);
		long n1, n2;
		
		if(!isInt1 || !isInt2) {
			System.out.println("The strings entered are not numeric.");
			System.exit(0);
		}
		n1 = Integer.parseInt(num1);
		n2 = Integer.parseInt(num2);
		
		multiply(n1, n2);
	}
	
	public static boolean isInteger(String num) {
		try {
			Integer.parseInt(num);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static void multiply(long num1, long num2) {
		System.out.println(num1 + " * " + num2 + " = " + num1*num2);
	}
}
