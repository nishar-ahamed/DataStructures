package com.datastructures.linkedlist.circularlinkedlist;


public class App {
    public static void main(String args[]) {
        CircularLinkedList linkedList = new CircularLinkedList();
        linkedList.insertFirst(1222);
        linkedList.insertFirst(4551);
        linkedList.insertFirst(144);
        linkedList.insertFirst(2222);
        linkedList.printLinkedList();

        linkedList.deleteFirst();
        linkedList.printLinkedList();

        linkedList.insertLast(99999);
        linkedList.printLinkedList();
    }
}
