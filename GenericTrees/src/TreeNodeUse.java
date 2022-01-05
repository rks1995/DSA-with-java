import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeNodeUse {

	public static void printTree1(TreeNode<Integer> root) {
		if(root ==  null) {
			return;
		}
		System.out.print(root.data+ " ");
		for(int i=0; i<root.children.size(); i++) {
			printTree1(root.children.get(i));
		}
	}
	public static void printTree2(TreeNode<Integer> root) {
		if(root ==  null) {
			return;
		}
		System.out.print(root.data+ ":");
		for(int i=0; i<root.children.size(); i++) {
			System.out.print(root.children.get(i).data+",");
		}
		System.out.println();
		for(int i=0; i<root.children.size(); i++) {
			printTree2(root.children.get(i));
		}
	}
	
	public static void printLevelWise(TreeNode<Integer>root) {
		if(root == null) {
			return;
		}
		Queue<TreeNode<Integer>>q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			TreeNode<Integer> front = q.poll();
			if(front == null && !q.isEmpty()) {
				q.add(null);
				System.out.println();
				continue;
			}
			else if(front == null && q.isEmpty()) {
				break;
			}
			System.out.print(front.data + " ");
			for(int i=0; i<front.children.size(); i++) {
				q.add(front.children.get(i));
			}
		}
}
	
	public static int numOfNodes(TreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int ans = 0;
		for(int i=0; i<root.children.size(); i++) {
			ans += numOfNodes(root.children.get(i));
		}
		return 1 + ans;
	}
	
	public static int sumOfNodes(TreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int sum = root.data;
		for(int i=0; i<root.children.size(); i++) {
			int childSum = sumOfNodes(root.children.get(i));
			sum += childSum;
		}
		return sum;
	}
	
	public static TreeNode<Integer> takeInputRecursive() {
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		System.out.println("Enter number of child for "+root.data);
		int child = s.nextInt();
		for(int i=0; i<child; i++) {
			System.out.println("Enter child of "+ root.data);
			TreeNode<Integer>childNode = takeInputRecursive();
			root.children.add(childNode);
		}
		return root;
	}
	
	public static TreeNode<Integer> takeInputLevelWise() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data: ");
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		TreeNode<Integer>root = new TreeNode<Integer>(rootData);
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode<Integer> front = q.poll();
			System.out.println("Enter number of children for "+front.data);
			int num = s.nextInt();
			for(int i=0; i<num; i++) {
				int childData = s.nextInt();
				TreeNode<Integer> childNode = new TreeNode<Integer>(childData);
				q.add(childNode);
				front.children.add(childNode);
			}
		}
		return root;
	}
	
	public static int numOfNodesGreater(TreeNode<Integer> root, int x) {
		if(root == null) {
			return 0;
		}
		int ans = 0;
		for(int i=0; i<root.children.size(); i++) {
			int output = numOfNodesGreater(root.children.get(i), x);
			ans += output;
		}
		if(root.data > x) {
			return 1 + ans;
		}
		return ans;
	}
	
	public static int getHeight(TreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int height = 0;
		for(int i=0; i<root.children.size(); i++) {
			int childHeight = getHeight(root.children.get(i));
			height = Math.max(height, childHeight);
		}
		return 1 + height;
	}
	
	public static void main(String[] args) {
//		TreeNode<Integer> root = new TreeNode<Integer>(4);
//		TreeNode<Integer> node1 = new TreeNode<Integer>(2);
//		TreeNode<Integer> node2 = new TreeNode<Integer>(3);
//		TreeNode<Integer> node3 = new TreeNode<Integer>(5);
//		TreeNode<Integer> node4 = new TreeNode<Integer>(6);
//		TreeNode<Integer> node5 = new TreeNode<Integer>(7);
//		
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
//		
//		node2.children.add(node4);
//		node2.children.add(node5);
		//printTree1(root);
		TreeNode<Integer> root = takeInputLevelWise();
		printLevelWise(root);
		System.out.println(numOfNodes(root));
		System.out.println(sumOfNodes(root));
		System.out.println(numOfNodesGreater(root, 3));

	}

}
