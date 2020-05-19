package com.jaykay.ds.queue;

import java.util.NoSuchElementException;

public class MyDequeue {
	int[] queue;
	int front;
	int rear;

	public MyDequeue(int capacity) {
		queue = new int[capacity];
		front = 0;
		rear = 0;

	}

	public static void main(String[] args) {

		MyDequeue myQueue = new MyDequeue(3);
		myQueue.enqueueFirst(1);
		myQueue.enqueueLast(2);
		myQueue.enqueueFirst(3);

		System.out.println(myQueue.front()); // 3
		System.out.println(myQueue.dequeueFirst()); // 3
		System.out.println(myQueue.front()); // 1

		System.out.println(myQueue.size()); // 2
		System.out.println(myQueue.isEmpty()); // false
		System.out.println(myQueue.isFull()); // false

	}

	private void enqueueFirst(int x) {
		if (isFull())
			throw new IllegalStateException();
		
		for (int i = rear; i > front; i--) {
			queue[i] = queue[i - 1];
		}

		queue[front] = x;
		rear++;

	}

	private void enqueueLast(int x) {
		if (isFull())
			throw new IllegalStateException();

		queue[rear++] = x;

	}

	private int dequeueFirst() {
		if (isEmpty())
			throw new IllegalStateException();

		return queue[front++];
	}

	public int dequeueLast() {
		if (isEmpty())
			throw new IllegalStateException();

		return queue[rear--];
	}

	public int rear() {
		if (isEmpty())
			throw new NoSuchElementException();

		return queue[rear-1];
	}

	private int front() {
		if (isEmpty())
			throw new NoSuchElementException();

		return queue[front];
	}

	private boolean isFull() {
		return queue.length == rear;
	}

	private boolean isEmpty() {

		return front == rear;
	}

	private int size() {

		return rear - front;
	}

}
