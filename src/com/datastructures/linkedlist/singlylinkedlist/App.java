package com.datastructures.linkedlist.singlylinkedlist;

public class App {
    public static void main(String args[]) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertFirst(1222);
        singlyLinkedList.insertFirst(4551);
        singlyLinkedList.insertFirst(1444);
        singlyLinkedList.insertFirst(3333);
        singlyLinkedList.printLinkedList();

        singlyLinkedList.deleteFirst();
        singlyLinkedList.printLinkedList();

        singlyLinkedList.insertLast(99999);
        singlyLinkedList.printLinkedList();
    }
}
