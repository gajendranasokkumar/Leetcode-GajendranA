class MyCircularDeque {
    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor to initialize deque with a maximum size of k
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.deque = new int[k];
        this.front = 0; 
        this.rear = k - 1;  // Initialize rear to the last index of the array
        this.size = 0;
    }

    // Insert an element at the front of the deque
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity; // Move front backward
        deque[front] = value;
        size++;
        return true;
    }

    // Insert an element at the rear of the deque
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % capacity; // Move rear forward
        deque[rear] = value;
        size++;
        return true;
    }

    // Delete an element from the front of the deque
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity; // Move front forward
        size--;
        return true;
    }

    // Delete an element from the rear of the deque
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity; // Move rear backward circularly
        size--;
        return true;
    }

    // Get the front element of the deque
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deque[front];
    }

    // Get the last element of the deque
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return deque[rear];
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the deque is full
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */