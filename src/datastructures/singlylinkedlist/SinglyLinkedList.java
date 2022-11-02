package datastructures.singlylinkedlist;

public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int length = 0;

    public SinglyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node element = head;
        for (int i = 0; i < index; i++) {
            element = element.next;
        }
        return element;
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

    public boolean set(int index, int value) {
        Node element = get(index);
        if (element != null) {
            element.value = value;
            return true;
        }
        return false;
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
        insertedNode.next = prevNode.next;
        prevNode.next = insertedNode;
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
        }
        tail = newNode;
        ++length;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();
        Node prev = get(index - 1);
        Node deleted = prev.next;
        prev.next = deleted.next;
        deleted.next = null;
        --length;
        return deleted;
    }

    public Node removeFirst() {
        if (length == 0) return null;

        Node deleted = head;
        head = head.next;
        deleted.next = null;
        --length;

        if (length == 0) tail = null;

        return deleted;
    }

    public Node removeLast() {
        switch (length) {
            case 0:
                return null;
            case 1:
                Node deleted = tail;
                head = null;
                tail = null;
                length = 0;
                return deleted;
            default:
                Node deleted2 = tail;
                Node temp = head;
                while (temp.next != tail) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
                --length;
                return deleted2;
        }
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}