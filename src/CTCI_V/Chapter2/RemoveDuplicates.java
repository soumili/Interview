package CTCI_V.Chapter2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*2.1 Write a code to remove duplicates from a unsorted linked list. FOLLOW UP - How would you solve if temporary buffer is not allowed*/

/*
 * @author Soumili
 */

public class RemoveDuplicates {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		createList(list);
		System.out.println(list);

		removeDuplicates(list);
		System.out.println("After removal of duplicates: " + list);
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

	public static void removeDuplicates(LinkedList<Integer> list)
    {
        int size = list.size();
        int i = 0;
        
        while(i < size)
        {
            int j = i + 1;
            while(j < size)
            {
                if(list.get(i) == list.get(j))
                {
                    list.remove(j);
                    size = list.size();
                }
                j++;
            }
            i++;
        }
    }
}
