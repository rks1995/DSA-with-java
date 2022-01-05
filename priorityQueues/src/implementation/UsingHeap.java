package implementation;

import java.util.ArrayList;

public class UsingHeap {
	/*heap follows two properties
	 * 1. it should be heap
	 * 2. it must follow heap order property
	*/
	private ArrayList<Integer> heap = new ArrayList<>(); // we use array to store as heap. 
	
	private void upHeapify() {
		if(heap.size() == 1) {
			return;
		}
		int childIndex = heap.size()-1;
		int parentIndex = (childIndex-1)/2;
		
		while(childIndex > 0) {
			int parent = heap.get(parentIndex);
			int child = heap.get(childIndex);
			if(parent > child) {
				heap.set(parentIndex, child);
				heap.set(childIndex, parent);
				childIndex = parentIndex;
				parentIndex = (childIndex-1)/2;
				
			}else {
				return;
			}
		}
		
	}
	
	private void downHeapify() {
		int parentIndex = 0;
		
		while(2*parentIndex+1 < heap.size() && 2*parentIndex+2 < heap.size()) {
			int parent = heap.get(parentIndex);
			int lc = heap.get(2*parentIndex+1);
			int rc = heap.get(2*parentIndex+2);
			if(parent > lc && (lc < rc)) {
				heap.set(2*parentIndex+1, parent);
				heap.set(parentIndex, lc);
				parentIndex = 2*parentIndex+1;
			}
			else {
				heap.set(2*parentIndex+2, parent);
				heap.set(parentIndex, rc);
				parentIndex = 2*parentIndex+2;
			}
		}
		
		if(2*parentIndex + 1 < heap.size()) {
			int parent = heap.get(parentIndex);
			int lc = heap.get(2*parentIndex+1);
			int lcIndex = 2*parentIndex+1;
			if(parent > lc) {
				heap.set(parentIndex, lc);
				heap.set(lcIndex, parent);
			}
		}
		
	}
	private void buildMinHeap(int size) {
		int pi = 0;
		
		while(2*pi+1 < size && 2*pi+2 < size) {
			int parent = heap.get(pi);
			int lc = heap.get(2*pi+1);
			int rc = heap.get(2*pi+2);
			if(parent > lc && (lc < rc)) {
				heap.set(2*pi+1, parent);
				heap.set(pi, lc);
				pi = 2*pi+1;
			}
			else {
				heap.set(2*pi+2, parent);
				heap.set(pi, rc);
				pi = 2*pi+2;
			}
		}
		if(2*pi + 1 < size) {
			int parent = heap.get(pi);
			int lc = heap.get(2*pi+1);
			int lcIndex = 2*pi+1;
			if(parent > lc) {
				heap.set(pi, lc);
				heap.set(lcIndex, parent);
			}
		}
	}
	public void heapSort() throws PriorityQueueException {
		int j = heap.size()-1;
		while(j >= 0) {
			int min = getMin();
			heap.set(0, heap.get(j));
			heap.set(j, min);
			j--;
			buildMinHeap(j);
		}
	}
	
	public void printHeap() {
		for(int i: heap) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public void insert(int val) {
		heap.add(val);
		upHeapify();
	}
	
	public int getMin() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}
	
	public int removeMin() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		int min = getMin(); //2
		int lastElement = heap.get(heap.size()-1); //3
		heap.set(0, lastElement); 
		heap.set(heap.size()-1, min);
		heap.remove(heap.size()-1); // 3-->7
		downHeapify();
		return min;
	}
	
	public int size() {
		return heap.size();
	}
	
	public boolean isEmpty() {
		if(size() == 0) {
			return true;
		}
		return false;
	}
}
