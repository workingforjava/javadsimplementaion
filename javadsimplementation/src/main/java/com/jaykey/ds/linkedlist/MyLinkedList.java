package com.jaykey.ds.linkedlist;

public class MyLinkedList {
    Node head;
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
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
        if (this.head == null) return;

        if (this.head.next == null) {
            this.head = null;
            return;
        }

        Node currentNode = this.head;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = null;

    }

    private void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    private void traversal() {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data);
            currNode = currNode.next;
        }
        System.out.println();
    }

    private void addFirst(int data) {

        if (head == null) {
            head = new Node(data);
            return;
        }

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }

    private void addLast(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node newNode = new Node(data);
        Node lastNode = getLastNode();
        lastNode.next = newNode;

    }

    private Node getLastNode() {
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        return lastNode;
    }
}
