
class pair{
	BinaryTreeNode<Integer> newRoot;
	boolean isDeleted;
	
	public pair(BinaryTreeNode<Integer> newRoot, boolean isDeleted) {
		this.newRoot = newRoot;
		this.isDeleted = isDeleted;
	}
}
public class BST {

	private BinaryTreeNode<Integer> root;
	private int size;

	private static boolean isPresentHelper(BinaryTreeNode<Integer> root, int data) {
		if (root == null) {
			return false;
		}
		if (root.data == data) {
			return true;
		}
		if (data < root.data) {
			return isPresentHelper(root.left, data);

		} else {
			return isPresentHelper(root.right, data);

		}
	}

	public boolean isPresent(int x) {
		return isPresentHelper(root, x);
	}

	private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int x) {
		if (root == null) {
			BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(x);
			return node;
		}
		if (root.data > x) {
			BinaryTreeNode<Integer> left = insertHelper(root.left, x);
			root.left = left;
		} else {
			BinaryTreeNode<Integer> right = insertHelper(root.right, x);
			root.right = right;
		}
		return root;

	}

	public void insert(int x) {
		size++;
		root = insertHelper(root, x);
	}
	
	private static int getMin(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return Integer.MAX_VALUE;
		}
		
		int leftMin = getMin(root.left);
		int rightMin = getMin(root.right);
		return Math.min(root.data, Math.min(leftMin, rightMin));
	}

	private static pair deleteHelper(BinaryTreeNode<Integer> root, int x) {
		if(root == null) {
			pair newRoot = new pair(null, false);
			return newRoot;
		}
		pair p = new pair(null, false);
		if(x < root.data) {
			pair leftNewRoot = deleteHelper(root.left, x);
			root.left = leftNewRoot.newRoot;
			p.newRoot = root;
			p.isDeleted = leftNewRoot.isDeleted;
			return p;
		} 
		if(x > root.data){
			pair rightNewRoot = deleteHelper(root.right, x);
			root.right = rightNewRoot.newRoot;
			p.newRoot = root;
			p.isDeleted = rightNewRoot.isDeleted;
			return p;
		}
		//0 child
		if (root.left == null && root.right == null) {
			return new pair(null, true);
		}
		//1child
		if (root.left == null && root.right != null) {
			return new pair(root.right, true);
		}
		if (root.left != null && root.right == null) {
			return new pair(root.left, true);
		} 
		//2 child
		int getRightMin = getMin(root.right);
		root.data = getRightMin;
		pair newRight = deleteHelper(root.right, getRightMin);
		root.right = newRight.newRoot;
		p.newRoot = root;
		p.isDeleted = newRight.isDeleted;

		return p;
	}

	public boolean delete(int x) {
		if (!isPresent(x)) {
			return false;
		}
		size--;
		pair p = deleteHelper(root, x);
		root = p.newRoot;
		return p.isDeleted;
	}

	private static void printBSTHelper(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		System.out.print("Root " + root.data + ":");
		if (root.left != null) {
			System.out.print("L" + root.left.data + ",");
		}
		if (root.right != null) {
			System.out.print("R" + root.right.data);
		}
		System.out.println();
		printBSTHelper(root.left);
		printBSTHelper(root.right);
	}

	public void printBST() {
		printBSTHelper(root);
	}

	public int size() {
		return size;
	}
}
