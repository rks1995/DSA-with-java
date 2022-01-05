package trie;

class TrieNode {
	char data;
	boolean isEndNode;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		this.isEndNode = false;
		this.children = new TrieNode[26];
		this.childCount = 0;
	}
}

public class Trie {

	private TrieNode root;
	private int numWords;

	public Trie() {
		root = new TrieNode('\0');
	}

	private void suffix(String word) {
		String output = "";
		for (int i = word.length() - 1; i >= 0; i--) {
			output = word.charAt(i) + output;
			insertHelper(root, output);
		}
	}

	private void insertHelper(TrieNode root, String word) {

		if (word.length() == 0) {
			root.isEndNode = true;
			return;
		}

		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];

		if (child == null) {
			numWords++;
			root.childCount++;
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
		}
		insertHelper(child, word.substring(1));

	}

	private boolean patternSearch(TrieNode root, String word) {
		if (word.length() == 0) {
			return true;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child == null) {
			return false;
		}
		return patternSearch(child, word.substring(1));
	}

	private void removeHelper(TrieNode root, String word) {

		if (word.length() == 0) {
			root.isEndNode = false;
			return;
		}

		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child == null) {
			return;
		}
		removeHelper(child, word.substring(1));
		if (!child.isEndNode && child.childCount == 0) {
			numWords--;
			root.childCount--;
			root.children[childIndex] = null;
			child = null;
		}
	}

	private boolean searchHelper(TrieNode root, String word) {
		if(word.length() == 0) {
			return root.isEndNode;
		}
		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null) {
			return false;
		}
		return searchHelper(child, word.substring(1));
	}
	
	private void printHelper(TrieNode root, String output) {
		if(root == null) {
			return;
		}
		if(root.isEndNode == true) {
			System.out.println(output);
		}
		for(int i=0; i<root.children.length; i++) {
			TrieNode child = root.children[i];
			if(child != null)
				printHelper(child, output+child.data);
		}
	}
	
	public void autoComplete(String word) {
		String output = "";
		for(int i=0; i<word.length(); i++) {
			int childIndex = word.charAt(i)-'a';
			TrieNode child = root.children[childIndex];
			if(child == null) {
				return;
			}
			output = output + child.data;
			root = child;
			if(i == word.length()-1) {
				printHelper(child, output);
			}
		}
		
	}
	public void print() {
		printHelper(root, "");
	}
	public boolean patternMatching(String word) {
		return patternSearch(root, word);
	}

	public boolean search(String word) {
		return searchHelper(root, word);
	}

	public void insert(String word) {
		//this function will only use if pattern matching is concern
		//suffix(word); 
		insertHelper(root,word);
	}

	public int getChild() {
		return root.childCount;
	}

	public void remove(String word) {
		removeHelper(root, word);
	}

	public int countWords() {
		return numWords;
	}
}