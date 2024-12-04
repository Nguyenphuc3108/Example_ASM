package org.example;

public class ArrayQueue {
    private final int[] queue;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    // Corrected constructor to initialize the queue array internally
    public ArrayQueue(int capacity) {
        this.queue = new int[capacity];
        this.capacity = capacity;
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = element;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int element = queue[front];
        front = (front + 1) % capacity;
        size--;
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    public static void main(String[] args) {
        System.out.println("Array-Based Queue Example:");
        ArrayQueue supportQueue = new ArrayQueue(5);

        // Students submit support requests
        supportQueue.enqueue(101); // Student ID: 101
        supportQueue.enqueue(102); // Student ID: 102
        supportQueue.enqueue(103); // Student ID: 103

        // Process requests
        System.out.println("Serving student: " + supportQueue.dequeue()); // Output: 101
        System.out.println("Serving student: " + supportQueue.dequeue()); // Output: 102

        // More students join the queue
        supportQueue.enqueue(104); // Student ID: 104
        supportQueue.enqueue(105); // Student ID: 105

        // Check the next student to be served
        System.out.println("Next student to be served: " + supportQueue.peek()); // Output: 103

        System.out.println("\nLinkedList-Based Queue Example:");
        LinkedListQueue linkedQueue = new LinkedListQueue();

        // Students submit support requests
        linkedQueue.enqueue(201); // Student ID: 201
        linkedQueue.enqueue(202); // Student ID: 202
        linkedQueue.enqueue(203); // Student ID: 203

        // Process requests
        System.out.println("Serving student: " + linkedQueue.dequeue()); // Output: 201
        System.out.println("Serving student: " + linkedQueue.dequeue()); // Output: 202

        // Check the next student to be served
        System.out.println("Next student to be served: " + linkedQueue.peek()); // Output: 203
    }

}
