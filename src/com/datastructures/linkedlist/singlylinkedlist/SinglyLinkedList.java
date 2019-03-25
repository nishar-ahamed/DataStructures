package com.datastructures.linkedlist.singlylinkedlist;

public class SinglyLinkedList {
    private Node first;

    public void insertFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = first;
        first = newNode;
    }

    public void insertLast(int data) {
        Node current = first;
        while (current.next != null) {
            current = current.next;
        }
        Node newNode = new Node();
        newNode.data = data;
        current.next = newNode;
    }

    public Node deleteFirst() {
        Node temp = first;
        first = first.next;
        return temp;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void printLinkedList() {
        System.out.println("first-------->last");
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
    }

}
