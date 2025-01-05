package problems.linkedListCycle;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. Linked List Cycle
 * <p>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node
 * that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = new ListNode(2);

        System.out.println(hasCycle(head));
    }

    static boolean hasCycle(ListNode head) {
        Set<ListNode> nodeValues = new HashSet<>();
        boolean isTail = false;

        if (head == null) {
            return false;
        }

        ListNode node = head;
        nodeValues.add(node);

        while (!isTail) {
            if (node.next == null) {
                isTail = true;
                continue;
            }
            node = node.next;
            if (nodeValues.contains(node)) {
                return true;
            } else {
                nodeValues.add(node);
            }
        }
        return false;
    }
}
