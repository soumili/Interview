import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayHopper {
	private static final String FAIL = "failure";

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		String input;

		try {
			while (!(input = scan.nextLine()).equals("")) {
				int num = Integer.parseInt(input);
				if (num < 0) {
					System.out.println(FAIL);
					return;
				}
				list.add(num);
			}
		} catch (NoSuchElementException e) {
			// e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println(FAIL);
			return;
		}

		if (list.size() <= 0) {
			System.out.println(FAIL);
			return;
		}

		Integer arr[] = new Integer[list.size()];
		arrayHopper(list.toArray(arr));
	}

	public static void arrayHopper(Integer arr[]) {
		if (null == arr || arr.length == 0)
			return;

		int dp[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				dp[0] = 0;
			} else {
				dp[i] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] + j >= i) {
					dp[i] = Math.min(dp[i], dp[j] + 1);
					break;
				}
			}
		}

		if (dp[arr.length - 1] == Integer.MAX_VALUE) {
			System.out.println("failure");
			return;
		}

		int prev = dp[arr.length - 1];
		int old = arr.length - 1;
		int i = arr.length - 1;
		List<Integer> hops = new ArrayList<Integer>();

		while (i >= 0) {
			hops.add(old);
			int newOld = 0;

			while (i >= 0 && (dp[i] == prev)) {
				i--;
			}
			while (i >= 0 && dp[i] == prev - 1) {
				if (arr[i] + i >= old) {
					newOld = i;
				}
				i--;
			}
			old = newOld;
			prev = prev - 1;
		}

		hops.add(old);

		printHops(hops);
	}

	public static void printHops(List<Integer> hops) {
		for (int i = hops.size() - 1; i >= 0; i--) {
			System.out.print(hops.get(i) + ", ");
		}
		System.out.print("out");
	}
}