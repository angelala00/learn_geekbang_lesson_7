package exercise.day5;
class MyCircularDeque {
    int len;
    int cap;
    Node head;
    Node tail;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.len = 0;
        this.cap = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            Node node = new Node(value);
            if (isEmpty()) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.pre = node;
                head = node;
            }
            len++;
            return true;
        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            Node node = new Node(value);
            if (isEmpty()) {
                head = node;
                tail = node;
            } else {
                node.pre = tail;
                tail.next = node;
                tail = node;
            }
            len++;
            return true;
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            if (len == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            len--;
            return true;
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            if (len == 1) {
                head = null;
                tail = null;
            } else {
                tail = tail.pre;
            }
            len--;
            return true;
        }
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return head.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return len == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return len == cap;
    }
    class Node {
        int val;
        Node next;
        Node pre;
        Node(int value){
            this.val = value;
        }
    }
}
