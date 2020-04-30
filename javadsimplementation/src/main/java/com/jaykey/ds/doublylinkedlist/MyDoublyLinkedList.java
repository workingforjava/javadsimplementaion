package com.jaykey.ds.doublylinkedlist;

public class MyDoublyLinkedList {
	public Node head;
	public Node tail;

	public static void main(String[] args) {
		MyDoublyLinkedList myLinkedList = new MyDoublyLinkedList();
		myLinkedList.addLast(2);
		myLinkedList.addLast(6);
		myLinkedList.addFirst(9);
		myLinkedList.traversal();

		myLinkedList.removeFirst();
		myLinkedList.traversal();

		myLinkedList.removeLast();

		myLinkedList.traversal();

	}

	private void removeLast() {

		if (this.head == null)
			return;

		if (this.head.next == null) {
			this.head = null;
			this.tail = null;

		}

		Node oldTail = tail.previous;
		oldTail.next = null;
		this.tail = oldTail;

	}

	private void removeFirst() {

		if (head == null)
			return;

		this.head = this.head.next;

		if (this.head == null)// if actual list contain only one item
			this.tail = null;

		this.head.previous = null;// should always be null

	}

	private void traversal() {

		Node currentNode = this.head;

		while (currentNode != null) {
			System.out.print(" " + currentNode.data);
			currentNode = currentNode.next;
		}
		System.out.println();
	}

	private void addFirst(int data) {

		Node node = new Node(null, data, this.head); // create a node with current head as next
		this.head = node;

		if (tail == null)
			this.tail = this.head;

	}

	private void addLast(int data) {

		Node node = new Node(this.tail, data, null);
		this.tail = node;

		if (this.head == null)
			this.head = this.tail;

	}

}
