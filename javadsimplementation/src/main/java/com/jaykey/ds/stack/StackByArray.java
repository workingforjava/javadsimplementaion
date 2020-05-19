package com.jaykey.ds.stack;

import java.util.NoSuchElementException;

public class StackByArray {

	private int[] myStack;
	private int top;

	public StackByArray(int capacity) {
		myStack = new int[capacity];
		top = -1;
	}

	public static void main(String[] args) {
		StackByArray myStack = new StackByArray(3);
		myStack.push(4);
		myStack.push(2);
		myStack.push(5);

		System.out.println(myStack.peek()); // 5
		System.out.println(myStack.pop()); // 5
		System.out.println(myStack.peek()); // 2

		System.out.println(myStack.size()); // 2
		System.out.println(myStack.isEmpty()); // false
		System.out.println(myStack.isFull()); // false
	}

	private boolean isFull() {

		return top == myStack.length - 1;
	}

	private boolean isEmpty() {
		return top == -1;
	}

	private int size() {

		return top + 1;
	}

	private int pop() {

		if (isEmpty())
			throw new NoSuchElementException();

		return myStack[top--];
	}

	private int peek() {
		if (isEmpty())
			throw new NoSuchElementException();

		return myStack[top];
	}

	private void push(int i) {
		if (isFull()) {
			throw new IllegalStateException();
		}

		myStack[++top] = i;

	}

}
