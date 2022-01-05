package implementation;

import java.util.ArrayList;

public class UsingHeap1<T> {

	private ArrayList<Element<T>> heap;

	public UsingHeap1() {
		heap = new ArrayList<>();
	}

	private void heapify(int pi, int ei) {
		int i = pi;
		int li = 2 * i + 1;
		int ri = 2 * i + 2;

		if (li < ei && heap.get(li).priority < heap.get(pi).priority) {
			pi = li;
		}
		if (ri < ei && heap.get(ri).priority < heap.get(pi).priority) {
			pi = ri;
		}
		if (pi != i) {
			Element<T> temp = heap.get(i);
			heap.set(i, heap.get(pi));
			heap.set(pi, temp);
			heapify(pi, ei);
		} else {
			return;
		}
	}

	public void insert(T data, int priority) {
		if (isEmpty()) {
			Element<T> ele = new Element<T>(data, priority);
			heap.add(ele);
		} else {
			Element<T> ele = new Element<T>(data, priority);
			heap.add(ele);
			int n = size();
			for (int i = n / 2 - 1; i >= 0; i--) {
				heapify(i, n);
			}
		}
	}

	public void heapSort() {
//		1.build the heap
//		2.swap last element with the first, and then build the heap upto the last elementIndex-1 and repeat;
		int n = heap.size();
		for (int i = n - 1; i >= 0; i--) {
			Element<T> min = heap.get(0);
			heap.set(0, heap.get(i));
			heap.set(i, min);
			heapify(0, i);
		}
	}

	public T removeMin() throws PriorityQueueException {
		if (isEmpty()) {
			throw new PriorityQueueException();
		}
		Element<T> min = heap.get(0);
		int j = heap.size() - 1;
		// swap
		heap.set(0, heap.get(j));
		heap.set(j, min);
		heap.remove(j);
		heapify(0, j);
		return min.data;
	}

	public void printHeap() {
		for (Element<T> ele : heap) {
			System.out.println(ele.data + " " + ele.priority);
		}
	}

	public T getMin() throws PriorityQueueException {
		if (isEmpty()) {
			throw new PriorityQueueException();
		}
		return heap.get(0).data;
	}

	public int size() {
		return heap.size();
	}

	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}
}
