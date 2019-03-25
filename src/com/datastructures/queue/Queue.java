package com.datastructures.queue;

public class Queue {
    private int maxSize;        //initializes the set number slots
    private long[] queueArray;  //slots to main data
    private int front;          //this will be the index position for the element in front
    private int rear;           //going to be the index position for the element at the back of the line
    private int nItems;         //counter to maintain the number of items in our queue

    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new long[size];
        this.front = 0;                 //index position of the first slot of array
        this.rear = -1;                 //there is no item in the array yet to be considered as the last item
        this.nItems = 0;                //we don't have element in the array yet
    }

    public void enqueue(long j) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        rear++;
        queueArray[rear] = j;
        nItems++;
    }

    public long dequeue() {              //remove item from front of queue
        long item = queueArray[front];
        front++;
        if (front == maxSize) {
            front = 0;                  //we can set front back to the 0th index so that we can utilize the entire array again
        }
        nItems--;
        return item;
    }

    public long front() {
        return queueArray[front];
    }

    public long rear() {
        return queueArray[rear];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public void view() {
        //System.out.println("Front: " + front);
        //System.out.println("Rear: " + (rear));
        System.out.print("Queue: [");
        for (int i = front; i < queueArray.length; i++) {
            System.out.print(queueArray[i] + " ");
        }
        System.out.print(queueArray[rear]);
        System.out.print("]\n");
    }
}
