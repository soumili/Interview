import java.util.Scanner;

/*
 * @author Soumili
 */

public class TrinaryTree {

	private static class Node {
		private Node left;
		private Node right;
		private Node center;
		private int item;

		public Node(int num) {
			this.item = num;
		}
	}

	private Node node;

	public TrinaryTree(Node node) {
		this.node = node;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of nodes in the tree: ");
		int num = scan.nextInt();
		TrinaryTree root = new TrinaryTree(null);

		if (num <= 0) {
			System.out.println("No elements to enter in the tree");
			return;
		}

		for (int i = 0; i < num; i++) {
			root.node = insertTree(scan.nextInt(), root.node);
		}

		System.out.println("Initial tree");
		printTree(root.node);

		System.out.println("\nEnter node to delete: ");
		deleteNode(scan.nextInt(), root.node);

		System.out.println("Tree after deletion");
		printTree(root.node);
	}

	public static Node insertTree(int num, Node root) {
		if (root == null) {
			Node node = new Node(num);
			root = node;
			return root;
		}

		if (root.item == num) {
			Node node = new Node(num);
			root.center = node;
			return root;
		}

		if (num < root.item) {
			root.left = insertTree(num, root.left);
		} else {
			root.right = insertTree(num, root.right);
		}

		return root;
	}

	public static Node deleteNode(int value, Node root) {

		if (null == root) {
			System.out.println(value + " does not exist in the tree");
			return null;
		}

		if (value < root.item) {
			root.left = deleteNode(value, root.left);
		} else if (value > root.item) {
			root.right = deleteNode(value, root.right);
		} else {
			if (root.left != null && root.right != null) {
				Node min = getMin(root.right);

				root.item = min.item;
				if (root.center != null) {
					root.center.item = min.item;
				}

				root.right = deleteNode(min.item, root.right);
			} else if (root.left != null) {
				root = root.left;
				return root;
			} else if (root.right != null) {
				root = root.right;
				return root;
			} else {
				return null;
			}
		}

		return root;
	}

	public static Node getMin(Node root) {

		if (null == root) {
			return null;
		}

		if (root.left == null) {
			return root;
		}

		return getMin(root.left);
	}

	public static void printTree(Node root) {
		if (root == null) {
			return;
		}

		printTree(root.left);
		System.out.print(root.item + " ");
		if (root.center != null)
			System.out.print(root.center.item + " ");
		printTree(root.right);
	}
}
