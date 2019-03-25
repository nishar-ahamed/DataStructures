package com.datastructures.heap;

public class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        this.heap = new int[capacity];
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        return heap[0];
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public int getChildIndex(int index, boolean isLeft) {
        return (2 * index + (isLeft ? 1 : 2));
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }
        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    private void fixHeapAbove(int index) {
        int newValue = heap[index];
        while (index > 0 && newValue > heap[getParentIndex(index)]) {
            heap[index] = heap[getParentIndex(index)];
            index = getParentIndex(index);
        }
        heap[index] = newValue;
    }

    public int delete(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        int deletedValue = heap[index];
        int parent = getParentIndex(index);
        heap[index] = heap[size - 1];
        if (index == 0 || heap[index] < heap[parent]) {
            fixHeapBelow(index, size - 1);
        } else {
            fixHeapAbove(index);
        }
        size--;
        return deletedValue;
    }

    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap = 0;
        while (index <= lastHeapIndex) {
            int leftChild = getChildIndex(index, true);
            int rightChild = getChildIndex(index, false);
            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }
                if (heap[index] < heap[childToSwap]) {
                    int tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                } else {
                    break;
                }
                index = childToSwap;
            } else {
                break;
            }

        }
    }

    public void sort() {
        int lastHeapIndex = size - 1;
        for (int i = 0; i < lastHeapIndex; i++) {
            int tmp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = tmp;

            fixHeapBelow(0, lastHeapIndex - i - 1);
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.print();

        //heap.delete(1);
        heap.sort();
        heap.print();
    }

}
