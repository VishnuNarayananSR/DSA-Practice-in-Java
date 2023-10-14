package linkedlists;

public class SumLists {
    /*
    You have two numbers represented by a linked list,where each node contains a single digit.
    The digits are stored in reverse order,such that the 1's digit is at the head of the list.
    Add the two numbers and returns the sum as a linked list.
    EXAMPLE
        Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
        Output: 2 -> 1 -> 9. That is,912.
     */

    public static SinglyLinkedList sumLists(Node head1, Node head2) {
        int carry = 0;
        SinglyLinkedList res = new SinglyLinkedList();
        while (head1 != null || head2 != null || carry != 0) {
            int val1 = head1 != null ? head1.data : 0;
            int val2 = head2 != null ? head2.data : 0;
            res.append((val1 + val2 + carry) % 10);
            carry = (val1 + val2 + carry) / 10;
            head1 = head1 != null ? head1.next : null;
            head2 = head2 != null ? head2.next : null;
        }
        return res;
    }

    public static void main(String[] args) {
        SinglyLinkedList num1 = new SinglyLinkedList(new int[]{7, 1, 6, 1, 9});
        SinglyLinkedList num2 = new SinglyLinkedList(new int[]{5, 9, 2, 9});
        num1.print();
        num2.print();
        SinglyLinkedList res = sumLists(num1.head, num2.head);
        res.print();
    }
}