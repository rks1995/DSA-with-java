import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {
	
	public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot) {
		if(isRoot) {
			System.out.println("Enter root data: ");
		}
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		
		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		System.out.println("Enter left child of: " + rootData);
		BinaryTreeNode<Integer> leftChild = takeTreeInputBetter(false);
		System.out.println("Enter right child of: " + rootData);
		BinaryTreeNode<Integer> rightChild = takeTreeInputBetter(false);
		
		root.left = leftChild;
		root.right = rightChild;
		return root;
	}
	
	public static BinaryTreeNode<Integer> takeTreeInput() {
		System.out.println("Enter root data: ");
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		
		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		System.out.println("Enter left child of: " + rootData);
		BinaryTreeNode<Integer> leftChild = takeTreeInput();
		System.out.println("Enter right child of: " + rootData);
		BinaryTreeNode<Integer> rightChild = takeTreeInput();
		
		root.left = leftChild;
		root.right = rightChild;
		return root;
	}
	
	public static void printTree1(BinaryTreeNode<Integer> root) {
		if(root == null)
			return;
		System.out.println(root.data);
		printTree1(root.left);
		printTree1(root.right);
	}
	
	public static void printTree2(BinaryTreeNode<Integer> root) {
		if(root == null)
			return;
		System.out.print("Root " +root.data + ":");
		if(root.left != null) {
			System.out.print("L" +root.left.data + ",");
		}
		if(root.right != null) {
			System.out.print("R" + root.right.data);
		}
		System.out.println();
		printTree2(root.left);
		printTree2(root.right);
	}
	
	public static int numberOfNodes(BinaryTreeNode<Integer> root) {
		if(root == null)
			return 0;
		
		int leftNodes = numberOfNodes(root.left);
		int rightNodes = numberOfNodes(root.right);
		int ans = 1 + leftNodes + rightNodes;
		return ans;
	}
	
	public static int largest(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		
		int largestLeft = largest(root.left);
		int largestRight = largest(root.right);
		int currentLargest = Math.max(largestLeft, largestRight);
		return Math.max(root.data, currentLargest);
	}
	
	public static int numOfLeafs(BinaryTreeNode<Integer> root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		
		int leftLeafs = numOfLeafs(root.left);
		int rightLeafs = numOfLeafs(root.right);
		return leftLeafs + rightLeafs;
	}
	
	public static BinaryTreeNode<Integer> removeLeafs(BinaryTreeNode<Integer> root) {
		if(root == null)
			return null;
		if(root.left == null && root.right == null)
			return null;
		
		root.left = removeLeafs(root.left);
		root.right = removeLeafs(root.right);
		return root;
	}
	
	public static int height(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	public static BinaryTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root) {
		if(root == null) {
			BinaryTreeReturn ans = new BinaryTreeReturn(0, true);
			return ans;
		}
		
		BinaryTreeReturn leftTree = isBalancedBetter(root.left);
		BinaryTreeReturn rightTree = isBalancedBetter(root.right);
		boolean isBal = true;
		int height = 1 + Math.max(leftTree.height, rightTree.height);
		
		if(Math.abs(leftTree.height - rightTree.height) > 1) {
			isBal = false;
		}
		if(!leftTree.isBalanced || !rightTree.isBalanced) {
			isBal = false;
		}
		
		BinaryTreeReturn ans = new BinaryTreeReturn(height, isBal);
		return ans;
		
	}
	
	public static boolean isBalanced(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return true;
		}
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		if(Math.abs(leftHeight - rightHeight) > 1) {
			return false;
		}
		
		boolean isLeftBalanced = isBalanced(root.left);
		boolean isRightBalanced = isBalanced(root.right);
		
		return (isLeftBalanced && isRightBalanced);
	}
	
	public static DiameterReturn findDiameter(BinaryTreeNode<Integer> root) {
		if(root == null) {
			int height = 0;
			int diameter = 0;
			DiameterReturn ans = new DiameterReturn();
			ans.height = height;
			ans.diameter = diameter;
			return ans;
		}
		
		DiameterReturn leftTree = findDiameter(root.left);
		DiameterReturn rightTree = findDiameter(root.right);
		
		int height = 1 + Math.max(leftTree.height, rightTree.height);
		int diameter = Math.max(leftTree.height + rightTree.height, Math.max(leftTree.diameter, rightTree.diameter));
		
		DiameterReturn ans = new DiameterReturn();
		ans.height = height;
		ans.diameter = diameter;
		return ans;
		
	}
	
	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root Data");
		int rootData = s.nextInt();
		
		if(rootData == -1) {
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		q.add(root);
		
		while(!q.isEmpty()) {
			BinaryTreeNode<Integer> front = q.poll();
			System.out.println("Enter left child: " + front.data);
			int left = s.nextInt();
			if(left != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(left);
				front.left = leftChild;
				q.add(leftChild);
			}
			System.out.println("Enter right child: " + front.data);
			int right = s.nextInt();
			if(right != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(right);
				front.right = rightChild;
				q.add(rightChild);
			}
		}
		return root;
		
	}
	
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		q.add(root);
		while(!q.isEmpty()) {
			BinaryTreeNode<Integer> front= q.poll();
			System.out.print("Root "+front.data + ":");
			if(front.left != null) {
				System.out.print("L"+front.left.data+",");
				q.add(front.left);
			}
			if(front.right != null) {
				System.out.print("R"+front.right.data);
				q.add(front.right);
			}
			System.out.println();
		}
	}
	
	public static BinaryTreeNode<Integer> helperPreIn(int[] pre, int[] in, int siPre, int eiPre, int siIn, int eiIn) {
		if(siPre > eiPre) {
			return null;
		}
		int rootData = pre[siPre];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		
		int rootIdx = -1;
		for(int i=siIn; i<=eiIn; i++) {
			if(in[i] == rootData) {
				rootIdx = i;
				break;
			}
		}
		
		int siPreLeft = siPre + 1;
		int siInLeft = siIn;
		int eiInLeft = rootIdx-1;
		int eiPreRight = eiPre;
		int siInRight = rootIdx+1;
		int eiInRight = eiIn;
		int eiPreLeft = eiInLeft - siInLeft + siPreLeft;
		int siPreRight = eiPreLeft+1;
		
		BinaryTreeNode<Integer> leftTree = helperPreIn(pre, in, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
		BinaryTreeNode<Integer> rightTree = helperPreIn(pre, in, siPreRight, eiPreRight, siInRight, eiInRight);
		
		root.left = leftTree;
		root.right = rightTree;
		return root;
	}
	
	public static BinaryTreeNode<Integer> buildTreePreIn(int[] pre, int[] in) {
		BinaryTreeNode<Integer> root = helperPreIn(pre, in, 0, pre.length-1, 0, in.length-1);
		return root;
	}
	
	public static boolean searchBST(BinaryTreeNode<Integer> root, int data) {
		if(root == null) {
			return false;
		}
		
		if(root.data == data) {
			return true;
		}
		if(root.data > data) {
			return searchBST(root.left, data);
		}
		return searchBST(root.right, data);
	}
	
	public static void printInRangeK1K2(BinaryTreeNode<Integer>root, int k1, int k2) {
		if(root == null) {
			return;
		}
		if(root.data < k1) {
			printInRangeK1K2(root.right, k1, k2);
		}
		else if(root.data > k2) {
			printInRangeK1K2(root.left, k1, k2);
		}
		else {
			printInRangeK1K2(root.left, k1, k2);
			System.out.print(root.data+ " ");
			printInRangeK1K2(root.right, k1, k2);
		}
	}
	
	public static BinaryTreeNode<Integer> constructBST(int[] arr, int si, int ei) {
		if(si > ei) {
			return null;
		}
		int mid = (si+ei)/2;
		int rootData = arr[mid];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		
		BinaryTreeNode<Integer> leftTree = constructBST(arr, si, mid-1);
		BinaryTreeNode<Integer> rightTree = constructBST(arr, mid+1, ei);
		
		root.left = leftTree;
		root.right = rightTree;
		return root;
	}
	
	public static int minimum(BinaryTreeNode<Integer>root ) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		int leftMin = minimum(root.left);
		int rightMin = minimum(root.right);
		
		return Math.min(root.data, Math.min(leftMin, rightMin));
		
	}
	
	public static boolean isBST1(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return true;
		}
		int leftMax = largest(root.left);
		if(leftMax >= root.data) {
			return false;
		}
		int rightMin = minimum(root.right);
		if(rightMin < root.data) {
			return false;
		}
		
		boolean isLeftBST = isBST1(root.left);
		boolean isRightBST = isBST1(root.right);
		return isLeftBST && isRightBST;
	}
	
	public static IsBstReturn isBST2(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			IsBstReturn ans = new IsBstReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
			return ans;
		}

		IsBstReturn leftTree = isBST2(root.left);
		IsBstReturn rightTree = isBST2(root.right);
		boolean isBst = true;
		int min = Math.min(root.data, Math.min(leftTree.min, rightTree.min));
		int max = Math.max(root.data, Math.max(leftTree.max,  rightTree.max));
		
		if(leftTree.max >= root.data || rightTree.min < root.data) {
			isBst = false;
		}
		if(!leftTree.isBst || !rightTree.isBst) {
			isBst = false;
		}
		
		IsBstReturn ans = new IsBstReturn(min,max, isBst);
		return ans;
	}
	
	public static boolean isBST3(BinaryTreeNode<Integer>root, int minRange, int maxRange) {
		if(root == null) {
			return true;
		}
		if(root.data < minRange || root.data > maxRange) {
			return false;
		}
		
		boolean isLeftWithinRange = isBST3(root.left, minRange, root.data-1);
		boolean isRightWithinRange = isBST3(root.right, root.data, maxRange);
		
		return isLeftWithinRange && isRightWithinRange;
	}
	
	public static LL<Integer> constructLLNode(BinaryTreeNode<Integer> root) {
		if(root == null) {
			LL<Integer> dummyNode = new LL<Integer>(-1);
			return dummyNode;
		}
		LL<Integer> leftNode = constructLLNode(root.left);
		LL<Integer> tail = leftNode;
		while(tail.next != null) {
			tail = tail.next;
		}
		LL<Integer> rootData = new LL<Integer>(root.data);
		tail.next = rootData;
		LL<Integer> rightNode = constructLLNode(root.right);
		rootData.next = rightNode;
		if(leftNode.data == -1)
			leftNode = leftNode.next;
		if(rightNode.data == -1)
			rootData.next = null;
		return leftNode;
	}
	
	public static void printLL(LL<Integer> Head) {
		while(Head != null) {
			System.out.println(Head.data);
			Head = Head.next;
		}
	}
	
	public static int getLCA(BinaryTreeNode<Integer>root, int a, int b) {
		if(root == null) {
			return -1;
		}
		if(a==root.data || b==root.data) {
			return root.data;
		}
		if(a < root.data && b >= root.data) {
			boolean isA = searchBST(root.left, a);
			boolean isB = searchBST(root.right, b);
			if(isA && isB) {
				return root.data;
			}
			return -1;
		}
		if(a < root.data && b < root.data) {
			int ans = getLCA(root.left, a, b);
			if(ans != -1) {
				return ans;
			}
		}
		if(a >= root.data && b >= root.data) {
			int ans = getLCA(root.right, a, b);
			if(ans != -1) {
				return ans;
			}
		}
		return -1;
	}
	
	public static LLReturn constructLLNodeBetter(BinaryTreeNode<Integer> root) {
		if(root == null) {
			LLReturn pair = new LLReturn();
			return pair;
		}
		
		LL<Integer> rootNode = new LL<Integer>(root.data);
		LLReturn left = constructLLNodeBetter(root.left);
		LLReturn right = constructLLNodeBetter(root.right);
		LLReturn pair = new LLReturn();
		if(left.tail != null) {
			left.tail.next = rootNode;
		}
		
		rootNode.next = right.head;
		if(left.head != null) {
			pair.head = left.head;
		}
		else {
			pair.head = rootNode;
		}
		if(right.tail != null) {
			pair.tail = right.tail;
		}
		else {
			pair.tail = rootNode;
		}
		return pair;
	}
	
	public static void main(String[] args) {		
//		BinaryTreeNode<Integer> root = takeTreeInputBetter(true);
//		int[] pre = {4,2,1,3,6,5,10};
//		int[] ino = {1,2,3,4,5,6,10};
//		BinaryTreeNode<Integer> root = buildTreePreIn(pre,ino);
		int arr[] = {1,2,3,4,5,6,7};
		BinaryTreeNode<Integer> root = constructBST(arr, 0, arr.length-1);
		printLevelWise(root);
		LLReturn Head = constructLLNodeBetter(root);
		
//		LL<Integer> head = constructLLNode(root);
		printLL(Head.head);
//		System.out.println(getLCA(root, 3,7));
//		System.out.println(searchBST(root, 30));
//		printInRangeK1K2(root, 3, 6);
//		IsBstReturn ans = isBST2(root);
//		System.out.println(ans.min + " " + ans.max + " " + ans.isBst);
//		System.out.println(isBST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
//		System.out.println("NumOfNodes " + numberOfNodes(root));
//		System.out.println("Largest " + largest(root));
//		System.out.println("numOfLeafs " + numOfLeafs(root));
////		BinaryTreeNode<Integer> newRoot = removeLeafs(root);
////		printTree2(newRoot);
//		System.out.println("Height: " + height(root));
//		System.out.println("Is Balanced " + isBalanced(root));
//		BinaryTreeReturn ans = isBalancedBetter(root);
//		System.out.println("isBalanced " +ans.isBalanced);
//		System.out.println("Largest diameter "+ findDiameter(root).diameter);
//		
	}

}
