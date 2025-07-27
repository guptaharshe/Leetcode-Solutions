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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0);  // new sorted list head
        ListNode curr = head;

        while (curr != null) {
            ListNode prev = dummy;

            // Find the right place to insert curr node
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Insert curr between prev and prev.next
            ListNode nextTemp = curr.next;
            curr.next = prev.next;
            prev.next = curr;

            curr = nextTemp;
        }

        return dummy.next;
        
    }
}