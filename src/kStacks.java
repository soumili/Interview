import java.util.Scanner;

public class kStacks {
	private static int numStack, stackSize, size;
	public static void main (String args[]) {
		int choice;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of stacks: ");
		numStack = scan.nextInt();
		
		System.out.println("Enter the stack size: ");
		stackSize = scan.nextInt();
		
		size = numStack * stackSize;
		int array[] = new int[size];
		int num, stackNum;
		Boolean key = true;
		
		do {
			System.out.println("....MENU....");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Display stack");
			System.out.println("Choose your option: ");
			choice = scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the stack number: ");
				stackNum = scan.nextInt();
				System.out.println("Enter the number to be added: ");
				num = scan.nextInt();
				
				array = push(num, stackNum, array);
				break;
			case 2:
				System.out.println("Enter the stack number: ");
				stackNum = scan.nextInt();
				
				array = pop(stackNum, array);
				break;
			case 3:
				display(array);
				break;
			default:
				System.out.println("Incorrect option chosen.");
				break;
			}
			System.out.println("Continue? true/false");
			key = scan.nextBoolean();
		} while(key);
	}
	
	public static int[] push(int num, int stackNum, int array[]) {
		if(stackNum < 0) {
			System.out.println("Stack number cannot be negative. Aborting push()....");
			return array;
		}
		
		int calc = (stackNum - 1) * stackSize;
		if(calc > array.length) {
			System.out.println("Incorrect stack number. Aborting push()....");
			return array;
		}
		
		int tempSize = 0;
		while(tempSize < stackSize && calc < size) {
			if(array[calc] == 0) {
				array[calc] = num;
				break;
			}
			tempSize++;
			calc++;
		}
		return array;
	}
	
	public static int[] pop(int stackNum, int array[]) {
		if(stackNum < 0) {
			System.out.println("Stack number cannot be negative. Aborting pop()....");
			return array;
		}
		
		int calc = (stackNum - 1) * stackSize;
		if(calc > array.length) {
			System.out.println("Incorrect stack number. Aborting pop()....");
			return array;
		}
		
		int tempSize = 0, flash = 0;
		if (!(array[calc] == 0)) {
			while (tempSize < stackSize && calc < size) {
				if (array[calc + 1] == 0) {
					System.out.println(array[calc] + "popped");
					array[calc] = 0;
					flash = 1;
					break;
				}
				tempSize++;
				calc++;
			}
		}
		
		if(flash == 0) {
			System.out.println("Empty stack. Nothing was popped.");
		}
		return array;
	}
	
	public static void display(int array[]) {
		for(int i = 0; i < size; i++) {
			System.out.print(array[i]);
		}
	}
}