/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Dummy node to simplify edge cases, points to the head of the resulting list.
        ListNode dummy = new ListNode(-1);
        // prevTail keeps track of the tail of the previous group after reversal.
        ListNode prevTail = dummy;

        // Traverse the list in groups of k.
        while (head != null) {
            // Reverse the current group and get the new head and the next group's head.
            ListNode[] tempRes = reverse(head, k);
            // Connect the previous group's tail to the head of the newly reversed group.
            prevTail.next = tempRes[0];
            // Update prevTail to the current group's original head (now its tail).
            prevTail = head;
            // Move head to the next group's head.
            head = tempRes[1];
        }

        // Return the new head of the list.
        return dummy.next;
    }

    public ListNode[] reverse(ListNode head, int k) {
        // If the list is empty, return the original head and null as there's nothing to reverse.
        if (head == null) return new ListNode[]{head, head};

        // Check if there are at least k nodes available for reversal.
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            if (curr == null) return new ListNode[]{head, null}; // If less than k nodes, return the original head.
            curr = curr.next; // Move to the next node.
        }

        // Initialize pointers for reversal.
        ListNode prev = null;
        ListNode next = null;

        // Reverse k nodes.
        while (k > 0) {
            next = head.next;  // Save the next node.
            head.next = prev;  // Reverse the current node's pointer.
            prev = head;       // Move prev to the current node.
            head = next;       // Move head to the next node.
            k--;               // Decrement the count.
        }

        // Return the new head of the reversed group (prev) and the next group's head (next).
        return new ListNode[]{prev, next};
    }
}
