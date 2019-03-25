package com.datastructures.linkedlist.doublylinkedlist;

public class App {
    public static void main(String args[]) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst(11);
        doublyLinkedList.insertFirst(22);
        doublyLinkedList.insertFirst(33);
        doublyLinkedList.insertLast(44);
        doublyLinkedList.insertLast(55);
        doublyLinkedList.insertLast(66);
        doublyLinkedList.displayForward();
        doublyLinkedList.displayBackward();

        doublyLinkedList.deleteFirst();
        doublyLinkedList.displayForward();

        doublyLinkedList.deleteLast();
        doublyLinkedList.displayForward();

        doublyLinkedList.deleteKey(11);
        doublyLinkedList.displayForward();

        doublyLinkedList.insertAfter(44, 999);
        doublyLinkedList.displayForward();
    }
}
