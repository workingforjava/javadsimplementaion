package com.jaykay.ds.queue;

import java.util.NoSuchElementException;

public class MyQueue {

	int[] queue;
	int front;
	int rear;

	public MyQueue(int capacity) {
		queue = new int[capacity];
		front = 0;
		rear = 0;

	}

	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue(3);
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);

		System.out.println(myQueue.front()); // 1
		System.out.println(myQueue.dequeue()); // 1
		System.out.println(myQueue.front()); // 2

		System.out.println(myQueue.size()); // 2
		System.out.println(myQueue.isEmpty()); // false
		System.out.println(myQueue.isFull()); // false

	}

	private boolean isEmpty() {
		// TODO Auto-generated method stub
		return rear == front;
	}

	private int size() {
		return rear - front;
	}

	private int dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return queue[front++];
	}

	private int front() {
		if (isEmpty()) {
            throw new NoSuchElementException();
        }
		return queue[front];
	}

	private void enqueue(int i) {
		if (isFull()) {
			throw new IllegalStateException();
		}
		queue[rear++] = i;
	}

	private boolean isFull() {
		return rear == queue.length;
	}

}
