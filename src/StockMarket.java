import java.util.Scanner;

/*Given the price of gold for n-days, find the best day to buy an ounce and then sell the ounce for greatest profit*/

/*
 * @author Soumili
 */

public class StockMarket {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements in the list: ");
		int num = scan.nextInt();

		System.out
				.println("-----------Enter the price of an ounce of gold on each of the "
						+ num + " days-----------");
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			System.out.println("Enter the price of gold on day " + i + ": ");
			arr[i] = scan.nextInt();
		}

		findBestProfit(arr);

		for (int i = 0; i < num; i++)
			System.out.print(arr[i] + " ");
	}

	public static void findBestProfit(int[] arr) {
		if (null == arr || arr.length <= 0) {
			System.out.println("Empty cost record.");
			return;
		}

		if (arr.length == 1) {
			System.out.println("Best Profit is: " + 0);
			return;
		}

		int min = 0;
		int[] best = new int[2];
		min = arr[0];
		best[0] = arr[0];
		best[1] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}

			if (arr[i] - min > best[1] - best[0]) {
				best[0] = min;
				best[1] = arr[i];
			}
		}
		int profit = best[1] - best[0];
		System.out.println("Best profit is when the gold is bought for "
				+ best[0] + " and sold for " + best[1] + " making a profit of "
				+ profit);
	}
}
