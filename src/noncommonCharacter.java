import java.util.HashSet;
import java.util.Scanner;

public class noncommonCharacter {
	public static void main(String args[]) {
		String word1, word2;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the first word: ");
		word1 = scan.next();
		System.out.println("Enter the second word: ");
		word2 = scan.next();
		
		findNoncommon(word1, word2);
	}
	
	public static void findNoncommon(String word1, String word2) {
		HashSet<Character> h1 = new HashSet<Character>();
		HashSet<Character> h2 = new HashSet<Character>();
		
		for(int i = 0; i < word1.length(); i++) {
			h1.add(word1.charAt(i));
		}
		
		for(int i = 0; i < word2.length(); i++) {
			h2.add(word2.charAt(i));
		}
		
		char[] w1, w2;
		w1 = word1.toCharArray();
		w2 = word2.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for(char i : w1) {
			if(!h2.contains(i))
				sb.append(i);
		}
		for(char i : w2) {
			if(!h1.contains(i))
				sb.append(i);
		}
		
		System.out.println(sb.toString());
	}
}