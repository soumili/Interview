package CTCI_V.Chapter2;

import java.util.LinkedList;
import java.util.Scanner;

/*2.2 Implement an algorithm to find the kth to the last element of a singly linked list*/

/*
 * @author Soumili
 */

public class KthElement {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		createList(list);
		System.out.println(list);
		
		findKthElement(list);
	}

	public static void createList(LinkedList<Integer> list) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements in the list: ");
		int num = scan.nextInt();
		for (int i = 0; i < num; i++) {
			System.out.println("Enter the number: ");
			list.add(scan.nextInt());
		}
	}
	
	public static void findKthElement(LinkedList<Integer> list) {
		if(list.isEmpty() || null == list) {
			System.out.println("Empty list");
			return;
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the position of the element: ");
		int pos = scan.nextInt();
		
		if(pos > list.size()) {
			System.out.println("Position number exceeds list size");
			return;
		}
		
		int size = list.size();
		int pos1 = 0;
		while(pos1 < pos) {
			pos1++;
		}
		
		int pos2 = 0;
		while(pos1 < size) {
			pos1++;
			pos2++;
		}
		
		System.out.println(pos + " position to the last element is: " + list.get(pos2));
	}
}
