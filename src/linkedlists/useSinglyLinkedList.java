package linkedlists;

public class useSinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();
        ll.append(1);
        ll.append(3);
        ll.append(4);
        ll.append(4);
        ll.append(5);
        ll.print(); // 1 -> 3 -> 4 -> 4 -> 5
        ll.delete(1);
        ll.delete(6);
        ll.delete(4);
        ll.print(); // 3 -> 4 -> 5
        ll.prepend(2);
        ll.prepend(1);
        ll.print(); // 1 -> 2 -> 3 -> 4 -> 5
    }
}
