package hashmaps;

import java.util.ArrayList;

class Node<K, V> {
	K key;
	V value;
	Node<K, V> next;

	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}
}

public class Hashmaps<K, V> {
	private ArrayList<Node<K, V>> buckets;
	private int numOfBuckets;
	private int size;
	
	public Hashmaps() {
		buckets = new ArrayList<>();
		numOfBuckets = 20;
		for (int i = 0; i < numOfBuckets; i++) {
			buckets.add(null);
		}
	}

	private int computeHashFunction(K key) {
		int hc = key.hashCode();
		int idx = hc % numOfBuckets;
		return idx;
	}
	
	private void reHash() {	
		ArrayList<Node<K,V>> oldBucket = buckets;
		buckets = new ArrayList<>();
		for(int i=0; i<2*numOfBuckets; i++) {
			buckets.add(null);
		}
		size = 0;
		numOfBuckets = 2*numOfBuckets;
		
		for(int i=0; i<oldBucket.size(); i++) {
			Node<K,V> head = oldBucket.get(i);
			while(head != null) {
				K key = head.key;
				V value = head.value;
				insert(key, value);
				head = head.next;
			}
		}
	}
	
	private void insertHelper(K key, V value, int index) {
		Node<K, V> head = buckets.get(index);
		//if key is present replace with new value
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		head = buckets.get(index);
		Node<K, V> ll = new Node<>(key, value);
		ll.next = head;
		buckets.set(index, ll);
		size++;
		
		double loadFactor = (1.0 * size)/numOfBuckets;
		if(loadFactor > 0.7) {
			reHash();
		}
	}

	private V getHelper(K key, int index) {
		Node<K, V> head = buckets.get(index);
		while(head != null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	private void removeHelper(K key, int index) {
		Node<K, V> head = buckets.get(index);
		Node<K, V> prev = null;
		while(head != null) {
			if(head.key.equals(key)) {
				size--;
				if(prev != null) {
					prev.next = head.next;
				}else {
					buckets.set(index, head.next);
				}
			}
			head = head.next;
		}
		
	}

	private boolean searchHelper(K key, int index) {
		Node<K, V> head = buckets.get(index);
		while(head != null) {
			if(head.key.equals(key)) {
				return true;
			}
			head = head.next;
		}
		return false;
	}
	
	
	public void insert(K key, V value) {
		int index = computeHashFunction(key);
		insertHelper(key, value, index);
	}

	public V get(K key) {
		int index = computeHashFunction(key);
		return getHelper(key, index);
	}

	public void remove(K key) {
		int index = computeHashFunction(key);
		removeHelper(key, index);
	}
	
	public boolean search(K key) {
		int index = computeHashFunction(key);
		return searchHelper(key, index);
	}
	
	public int size() {
		return size;
	}

}
