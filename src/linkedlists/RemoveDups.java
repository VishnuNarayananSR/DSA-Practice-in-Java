package linkedlists;

import java.util.HashSet;

public class RemoveDups {
    /*
    Remove duplicates from an unsorted linked lists.
     */

    public static void removeDups(Node head) {
        HashSet<Integer> hashSet = new HashSet<>();
        Node prev = null;
        while (head != null) {
            if (hashSet.contains(head.data)) {
                prev.next = head.next;
            } else {
                hashSet.add(head.data);
                prev = head;
            }
            head = head.next;
        }
    }

    /*
    If additional space is not allowed, this can be solved in O(N^2) time.
     */
    public static void removeDupsWithoutAdditionalSpace(Node head) {
        while (head != null) {
            Node runner = head;
            while (runner.next != null) {
                if (runner.next.data == head.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();
        ll.append(1);
        ll.append(3);
        ll.append(4);
        ll.append(4);
        ll.append(1);
        ll.append(5);
        ll.append(3);
        System.out.println("Removing duplicates (using additional space):");
        ll.print();
        removeDups(ll.head);
        ll.print();

        SinglyLinkedList ll2 = new SinglyLinkedList();
        ll2.append(1);
        ll2.append(3);
        ll2.append(4);
        ll2.append(4);
        ll2.append(1);
        ll2.append(5);
        ll2.append(3);
        System.out.println("Removing duplicates (without using additional space):");
        ll2.print();
        removeDupsWithoutAdditionalSpace(ll2.head);
        ll2.print();
    }
}
