package datastructures.doublylinkedlist;

public class DoublyLinkedList {

    Node head;
    Node tail;
    private int length = 0;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node element;
        if (index >= length / 2) {
            element = head;
            for (int i = 0; i < index; i++) {
                element = element.next;
            }
        } else {
            element = tail;
            for (int i = length - 1; i > index; i--) {
                element = element.prev;
            }
        }
        return element;
    }

    public boolean set(int index, int value) {
        Node replaced = get(index);
        if (replaced == null) return false;
        replaced.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node insertedNode = new Node(value);
        Node prevNode = get(index - 1);
        Node nextNode = prevNode.next;
        insertedNode.prev = prevNode;
        insertedNode.next = nextNode;
        prevNode.next = insertedNode;
        nextNode.prev = insertedNode;
        ++length;
        return true;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        ++length;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        ++length;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();
        Node removed = get(index);
        removed.prev.next = removed.next;
        removed.next.prev = removed.prev;
        removed.prev = null;
        removed.next = null;
        --length;
        return removed;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node removed = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            removed.next = null;
        }
        --length;
        return removed;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node removed = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            removed.prev = null;
        }
        --length;
        return removed;
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void printList() {
        Node temp = head;
        System.out.print("LinkedList: ");
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printAllData() {
        printList();
        getHead();
        getTail();
        getLength();
    }

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }
}
