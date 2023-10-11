package linkedlists;

public class KthLastElement {
    /*
    Find the kth to the last element in a singly linked list.
     */
    public static Node kthLast(Node head, int k) {
        Node p1 = head;
        Node p2 = head;

        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    /*
    Solution using recursion, but value is just printed without returning the node.
     */
    public static void kthLastUsingRecursion(Node head, int k) {
        recurse(head, k);
    }

    private static int recurse(Node node, int k) {
        if (node == null) {
            return 0;
        }
        int index = recurse(node.next, k) + 1;
        if (k == index) {
            System.out.println(node.data);
        }
        return index;
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7});
        Node result = kthLast(linkedList.head, 3);
        assert result != null;
        System.out.println(result.data);    // 5
        result = kthLast(linkedList.head, 7);
        assert result != null;
        System.out.println(result.data);    // 1
        result = kthLast(linkedList.head, 1);
        assert result != null;
        System.out.println(result.data);    // 7
        result = kthLast(linkedList.head, 0);
        System.out.println(result); // null
        result = kthLast(linkedList.head, 8);
        System.out.println(result); // null

        System.out.println();
        kthLastUsingRecursion(linkedList.head, 3); // 5
        kthLastUsingRecursion(linkedList.head, 7); // 1
        kthLastUsingRecursion(linkedList.head, 1); // 7
        kthLastUsingRecursion(linkedList.head, 0);
        kthLastUsingRecursion(linkedList.head, 8);
    }
}
