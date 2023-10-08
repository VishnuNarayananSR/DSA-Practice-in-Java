package linkedlists;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public boolean hasNext() {
        return this.next != null;
    }
}

public class SinglyLinkedList {
    Node head;

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.hasNext()) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(int data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void delete(int data) {
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.hasNext()) {
            if (current.next.data == data) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.printf("%d", current.data);
            if (current.hasNext()) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}

