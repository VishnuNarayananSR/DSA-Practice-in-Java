package linkedlists;

import java.util.Stack;

public class Palindrome {
    static boolean isPalindrome(SinglyLinkedList list) {
        Node fast = list.head;
        Node slow = list.head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.hasNext()) {
            stack.push(slow.data);
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (stack.pop() != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println(isPalindrome(list));
        list = new SinglyLinkedList(new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1});
        System.out.println(isPalindrome(list));
        list = new SinglyLinkedList(new int[]{1, 2, 3, 4, 4, 3, 2, 1});
        System.out.println(isPalindrome(list));
    }
}
