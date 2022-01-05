package trie;

public class TrieUse {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("at");
		trie.insert("ate");
		trie.insert("bed");
		trie.insert("bad");
		trie.insert("bear");
		
		System.out.println(trie.countWords());
		trie.autoComplete("gh");
		

	}

}
