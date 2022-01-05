
public class BSTUse {

	public static void main(String[] args) {

		BST b = new BST();
		b.insert(3);
		b.insert(2);
		b.insert(7);
		b.insert(5);
		b.insert(4);
		b.insert(1);
		b.insert(8);

		b.printBST();
		System.out.println(b.size());

		System.out.println(b.isPresent(7));
		b.delete(7);
		System.out.println(b.isPresent(7));

		b.printBST();
		System.out.println(b.size());

	}

}
