package LinkedList;

import java.util.Scanner;

public class LinkListUse {
	static Scanner s = new Scanner(System.in);

	static LinkedListNode<Integer> takeInput() {
		int data = s.nextInt();
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		while (data != -1) {
			LinkedListNode<Integer> node = new LinkedListNode<Integer>(data);
			if (head == null) {
				head = node;
				tail = node;
			} else {
				tail.next = node;
				tail = tail.next;
			}
			data = s.nextInt();
		}
		return head;
	}

	static void print(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	static void printRec(LinkedListNode<Integer> head) {
		if (head == null)
			return;
		System.out.print(head.data + " ");
		printRec(head.next);
	}

	static LinkedListNode<Integer> insertRec(LinkedListNode<Integer> head, int data, int index) {

		if (head == null && index != 0)
			return null;
		if (index == 0) {
			LinkedListNode<Integer> node = new LinkedListNode<Integer>(data);
			node.next = head;
			head = node;
			return head;
		}
		head.next = insertRec(head.next, data, index - 1);
		return head;
	}

	static LinkedListNode<Integer> deleteRec(LinkedListNode<Integer> head, int data) {
		if (head.data == data) {
			return head.next;
		}

		head.next = deleteRec(head.next, data);
		return head;
	}

	public static void main(String[] args) {
		LinkedListNode<Integer> head = takeInput();
		printRec(head);
		// System.out.println();
		// head = insertRec(head, 20, 4);
		// printRec(head);
		// System.out.println();
		// head = deleteRec(head, 1);
		// printRec(head);

	}

}
