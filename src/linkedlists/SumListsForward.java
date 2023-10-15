package linkedlists;

public class SumListsForward {
    /*
    You have two numbers represented by a linked list,where each node contains a single digit.
    The digits are stored in forward order,such that the 1's digit is at the end of the list.
    Add the two numbers and returns the sum as a linked list.
    EXAMPLE
        Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
        Output: 9 -> 1 -> 2.That is, 912.
     */
    public static SinglyLinkedList sumLists(SinglyLinkedList list1, SinglyLinkedList list2) {
        int l1 = findLength(list1.head);
        int l2 = findLength(list2.head);
        if (l1 < l2) {
            padList(list1, l2 - l1);
        } else {
            padList(list2, l1 - l2);
        }
        list1.print();
        list2.print();
        SinglyLinkedList result = new SinglyLinkedList();
        PartialSum ps = sumListsHelper(list1.head, list2.head, result);
        result.prepend(ps.val);
        if (ps.carry != 0) {
            result.prepend(ps.carry);
        }
        return result;
    }

    static PartialSum sumListsHelper(Node head1, Node head2, SinglyLinkedList result) {
        if (head1 == null || head2 == null) {
            return new PartialSum();
        }
        PartialSum ps = sumListsHelper(head1.next, head2.next, result);
        if (ps.val != null) {
            result.prepend(ps.val);
        }
        int val = head1.data + head2.data + ps.carry;
        ps.val = val % 10;
        ps.carry = val / 10;
        return ps;
    }

    static void padList(SinglyLinkedList list, int padLength) {
        for (int i = 0; i < padLength; i++) {
            list.prepend(0);
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList num1 = new SinglyLinkedList(new int[]{1, 7, 1, 6, 1, 9});
        SinglyLinkedList num2 = new SinglyLinkedList(new int[]{5, 9, 2, 9});
        SinglyLinkedList res = sumLists(num1, num2);
        res.print();
    }

    static int findLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}

class PartialSum {
    Integer val = null;
    int carry = 0;
}
