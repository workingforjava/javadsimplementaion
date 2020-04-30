package com.jaykey.ds.hashtable;

import java.util.Arrays;
import java.util.Objects;

public class MyHashtable<K, V> {

	private static final int INITIAL_CAPACITY = 16;
	private static final float LOAD_FACTOR = 0.75f;
	private int size = 0;

	Entry<K, V>[] entryList;

	@SuppressWarnings("unchecked")
	public MyHashtable(int capacity) {
		entryList = (Entry<K, V>[]) new Entry[capacity];

	}

	@SuppressWarnings("unchecked")
	public MyHashtable() {
		entryList = (Entry<K, V>[]) new Entry[INITIAL_CAPACITY];

	}

	public static void main(String[] args) {
		MyHashtable<String, Integer> myHashtable = new MyHashtable<>(2);
		myHashtable.put("k1", 1);
		myHashtable.put("k2", 2);
		myHashtable.put("k2", 2);
		myHashtable.put("k3", 3);
		Arrays.stream(myHashtable.entryList).forEach(e -> {

			if (Objects.nonNull(e)) {
				System.out.printf("%s=%d%s", e.key, e.value, System.lineSeparator());
			}

		});

		System.out.println(myHashtable.size());

		System.out.println(myHashtable.get("k2"));

		System.out.println(myHashtable.remove("k1"));

		System.out.println(myHashtable.get("k1"));

		System.out.println(myHashtable.size());
	}

	private V remove(K key) {

		int index = hashFunction(key);

		Entry<K, V> curr = entryList[index];
		Entry<K, V> prev = null;

		while (Objects.nonNull(curr)) {
			if (Objects.equals(curr.key, key))
				break;

			prev = curr;
			curr = curr.next;

		}

		if (Objects.isNull(curr))
			return null;

		//Nullifying the current node 
		
		if (Objects.isNull(prev)) {
			entryList[index] = curr.next;
		} else {
			prev.next = curr.next;
		}

		size--;

		return curr.value;
	}

	private V get(K key) {

		int index = hashFunction(key);

		Entry<K, V> curr = entryList[index];

		while (Objects.nonNull(curr)) {
			if (Objects.equals(curr.key, key))
				return curr.value;

			curr = curr.next;
		}

		return null;
	}

	private int size() {
		return size;
	}

	private V put(K key, V value) {

		int index = hashFunction(key);

		Entry<K, V> head = entryList[index];
		Entry<K, V> curr = head;

		// check if the key available in the linked list

		while (Objects.nonNull(curr)) {
			if (Objects.equals(curr.key, key)) {
				return curr.value;
			}
			curr = curr.next;
		}

		// add the new entry as a first item in the linked list

		Entry<K, V> newNode = new Entry<>(key, value);

		newNode.next = head;
		entryList[index] = newNode;

		size++;

		reSize(); // to check the load factor

		return null;

	}

	public static class Entry<K, V> {

		K key;
		V value;
		Entry<K, V> next;

		Entry(K key, V value) {

			this.key = key;
			this.value = value;

		}

	}

	// internal method for hash/index computation

	private int hashFunction(K key) {

		int hashCode = key.hashCode();

		return hashCode % entryList.length;
	}

	@SuppressWarnings("unchecked")
	private void reSize() {
		if (size <= LOAD_FACTOR * entryList.length)
			return;

		Entry<K, V>[] currentEntries = entryList;

		entryList = (Entry<K, V>[]) new Entry[entryList.length * 2];

		rehash(currentEntries);

	}

	private void rehash(Entry<K, V>[] currentEntries) {
		size = 0;

		for (Entry<K, V> e : currentEntries) {

			while (Objects.nonNull(e)) {

				this.put(e.key, e.value);
				e = e.next;

			}
		}

	}

}
