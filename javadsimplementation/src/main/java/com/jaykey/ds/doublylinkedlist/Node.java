package com.jaykey.ds.doublylinkedlist;

public class Node {

	Node previous;
	Node next;
	int data;

	Node(Node pre, int val, Node nxt) {

		this.previous = pre;
		this.data = val;
		this.next = nxt;

		if (previous != null)
			previous.next = this;

		if (next != null)
			next.previous = this;

	}

}
